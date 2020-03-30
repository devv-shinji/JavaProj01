package ver09;

import java.util.Scanner;


abstract class PhoneInfo {
	
	String name;
	String phone;
	String birth;
	
	public PhoneInfo(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	
	public void dataAllShow() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phone);
		System.out.println("생일: "+ birth);
	}
	
}

class User extends PhoneInfo {
	public User(String name, String phone, String birth) {
		super(name, phone, birth);
	}
	
	@Override
	public void dataAllShow() {
		System.out.println("==전체정보==");
		super.dataAllShow();
	}
}
