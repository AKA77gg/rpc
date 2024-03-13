package com.dxfx.netty.util;

public class ResponseUtil {
	
	public static Response createSucessResponse() {
		return new Response();
		}
	
	public static Response createFailResponse(String code,String msg) {
		Response response = new Response();
		response.setCode(code);
		response.setMsg(msg);
		return response;
		}
	
	public static Response createSuccessResponse(Object content) {
		Response response = new Response();
		response.setResult(content);
		return response;
	}
}
