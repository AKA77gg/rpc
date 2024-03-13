package com.dxfx.user.remote;

import java.util.List;
import com.dxfx.user.remote.User;


public interface UserRemote {
	public Object saveUser(User user);
	public Object saveUsers(List<User> userlist);
}
