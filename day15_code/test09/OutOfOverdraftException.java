package com.atguigu.test09;

public class OutOfOverdraftException extends AccountException{

	public OutOfOverdraftException() {
		super();
	}

	public OutOfOverdraftException(String message) {
		super(message);
	}

}
