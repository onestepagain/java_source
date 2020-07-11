package com.atguigu.homework.test05;

public class V1Filter implements Filter{

	@Override
	public void filterUser(User u) {
		u.setType("v1");
	}

}
