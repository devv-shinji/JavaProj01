package ver04;

import java.util.Scanner;


abstract class PhoneInfo {
	
	String name;
	String phone;
	String birth;
	
	public PhoneInfo(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void showAllData() {
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
	public void showAllData() {
		System.out.println("-----일반친구-----");
		super.showAllData();
	}
}
//동창친구
class PhoneSchoolInfo extends PhoneInfo {
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phone, String major, int grade) {
		super(name, phone);
		this.major = major;
		this.grade = grade;
	}
	@Override
	public void showAllData() {
		System.out.println("-----동창친구-----");
		super.showAllData();
		System.out.println("전공: "+ major);
		System.out.println("학년: "+ grade);
	}
}
//회사친구
class PhoneCompanyInfo extends PhoneInfo {
	String company;
	public PhoneCompanyInfo(String name, String phone, String company) {
		super(name, phone);
		this.company = company;
	}
	@Override
	public void showAllData() {
		System.out.println("-----회사친구-----");
		super.showAllData();
		System.out.println("회사: "+ company);
	}
	
}