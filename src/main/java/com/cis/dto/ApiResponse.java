package com.cis.dto;

import org.springframework.http.HttpStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ApiResponse {
	
	private HttpStatus status;
	private Object data;
	private String Message;
	
	public ApiResponse(HttpStatus ok,String msg) {
		this.status=ok;
		this.Message=msg;
	}
	
	public ApiResponse(Object msg,HttpStatus ok) {
		this.data=msg;
		this.status=ok;
	}
	
	public ApiResponse(HttpStatus ok,String data,String msg) {
		this.status=ok;
		this.data=(Object)data;
		this.Message=msg;
	}
	public ApiResponse(HttpStatus ok,Object msg,String nodata) {
		this.status=ok;
		this.data=msg;
		this.Message=nodata;
	}

	
}
