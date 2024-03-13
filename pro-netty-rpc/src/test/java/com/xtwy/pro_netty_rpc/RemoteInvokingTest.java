//@package com.xtwy.pro_netty_rpc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.dxfx.netty.client.ClientRequest;
//import com.dxfx.netty.client.TcpClient;
//import com.dxfx.netty.util.Response;
//import com.dxfx.user.bean.User;
//import com.dxfx.user.remote.UserRemote;
//
//import com.dxfx.netty.annotation.RemoteInvoke;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes=RemoteInvokingTest.class)
//@ComponentScan("com.dxfx")
//public class RemoteInvokingTest {
//	
//	@RemoteInvoke
//	private UserRemote userRemote;
//		
//	@Test
//	public void testSaveUser() {
//		User u = new User();
//		u.setId(1);
//		u.setName("张三");
//		userRemote.saveUser(u);
//	}
//
//	@Test
//	public void testSaveUsers() {
//		List<User> users = new ArrayList<User>();
//		User u = new User();
//		u.setId(1);
//		u.setName("张三");
//		users.add(u);
//		userRemote.saveUsers(users);
//	}
//	
//
//}
