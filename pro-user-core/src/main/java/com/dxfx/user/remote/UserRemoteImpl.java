package com.dxfx.user.remote;

import java.util.List;

import javax.annotation.Resource;

import com.dxfx.netty.annotation.Remote;
import com.dxfx.netty.util.Response;
import com.dxfx.netty.util.ResponseUtil;
import com.dxfx.user.model.User;
import com.dxfx.user.service.UserService;



@Remote
public class UserRemoteImpl implements UserRemote{
	
	@Resource
	private UserService service;
	
	public Object saveUser(User user){
		service.saveUSer(user);
		Response response = ResponseUtil.createSuccessResponse(user);
		
		return response;
	}
	
	public Object saveUsers(List<User> userlist){
		service.saveUSerList(userlist);
		Response response = ResponseUtil.createSuccessResponse(userlist);
		
		return response;
	}
}
