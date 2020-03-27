package ver06;

import java.util.Scanner;


abstract class PhoneInfo {
	
	String name;
	String phone;
	String birth;
	
	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void dataAllShow() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phone);
	}
	
}
//일반친구
class User extends PhoneInfo {
	public User(String name, String phone) {
		super(name, phone);
	}
	
	@Override
	public void dataAllShow() {
		System.out.println("-----일반친구-----");
		super.dataAllShow();
	}
}