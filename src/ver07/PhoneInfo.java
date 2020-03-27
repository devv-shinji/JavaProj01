package ver07;

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

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phone.hashCode();
		
//		System.out.println(hc1+" "+hc2);
		int result = hc1 + hc2;
		
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		
		PhoneInfo comparePhoneInfo = (PhoneInfo)obj;
		
		//자동호출되는지 확인
		System.out.println("오버라이딩한 equals()메소드 호출 증거다!");
		
		if(comparePhoneInfo.name==this.name) {
			return true;
		}
		else {
			return false;
		}
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
	
	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		int hc2 = phone.hashCode();
		
//		System.out.println(hc1+" "+hc2);
		int result = hc1 + hc2;
		
		return result;
	}
}