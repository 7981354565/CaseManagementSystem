package com.cis.security;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cis.entity.UsersEntity;
import com.cis.repository.UsersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {

	@Autowired
	private UsersRepository userRepository;
	
	public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629566787";
	
	public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


	
	public String generateToken(UserDetails userDetails) {
		
		String username = userDetails.getUsername();
		Map<String, Object> claims=new HashMap<>();
		List<String> userRoles = Arrays.asList("ROLE_USER","ROLE_ADMIN");
		boolean isFirstLogin = false;
		
		Optional<UsersEntity> userOpt = userRepository.findByUserName(username);
	    if (userOpt.isPresent()) {
	        Boolean isFirstLoginValue = userOpt.get().getIsFirstLogin();
	        if (isFirstLoginValue != null) {
	            isFirstLogin = isFirstLoginValue.booleanValue();
	        }
	    }
		
		return createToken(claims,userDetails,userRoles,isFirstLogin);
//		return createToken(claims,userDetails,userRoles)
	}

	private String createToken(Map<String, Object> claims, UserDetails userDetails,List<String> userRoles,boolean isFirstLogin) {
		 List<String> roles = userDetails.getAuthorities().stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.toList());
		
		return Jwts.builder()
				.setClaims(claims) 
				.setSubject(userDetails.getUsername())
				.claim("roles", roles)
				.claim("isFirstLogin", isFirstLogin)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60))
				.signWith(getSignKey(),SignatureAlgorithm.HS256).compact();
	}
    
    
//    public static String generateToken(UserDetails userDetails) {
//        List<String> roles = userDetails.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .claim("roles", roles)
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
//                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
////                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(StandardCharsets.UTF_8))
//                .compact();
//    }

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	
}
