package com.dxfx.pro_basic.service;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.dxfx.client.annotation.RemoteInvoke;
import com.dxfx.user.model.User;
import com.dxfx.user.remote.UserRemote;

@Service
public class BasicService {

	@RemoteInvoke
	private UserRemote userRemote;
	
	public void testSaveUsers() {
		User u = new User();
		u.setId(1);
		u.setName("张三");
	    Object response = userRemote.saveUser(u);
		System.out.println(JSONObject.toJSONString(response));
		
	}
}
