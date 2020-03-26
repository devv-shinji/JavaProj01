package ver03;

import java.util.Scanner;


abstract class UserList {
	
	String name;
	String phone;
	String birth;
	
	public UserList(String name, String phone, String birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}
	
	public void showAllData() {
		System.out.println("이름: "+ name);
		System.out.println("전화번호: "+ phone);
		System.out.println("주소: "+ birth);
	}
	
}

class User extends UserList {
	public User(String name, String phone, String birth) {
		super(name, phone, birth);
	}
	
	@Override
	public void showAllData() {
		System.out.println("==전체정보==");
		super.showAllData();
	}
}


public class PhoneBookManager {

	private UserList[] userlist;
	private int numOfUserlist;
	
	public PhoneBookManager(int num) {
		userlist = new UserList[num];
		numOfUserlist = 0;
	}
	
	public void addUser() {
		Scanner scan = new Scanner(System.in);
		String iName, iPhone, iBirth;
		
		System.out.println("이름:");
		iName = scan.nextLine();
		System.out.println("전화번호:");
		iPhone = scan.nextLine();
		System.out.println("생년월일:");
		iBirth = scan.nextLine();
		System.out.println("데이터 입력이 완료되었습니다.");
		
		User user = new User(iName, iPhone, iBirth);
		userlist[numOfUserlist++] = user;
	}
	
	public void searchUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for (int i=0; i<numOfUserlist; i++) {
			if(searchName.compareTo(userlist[i].name)==0) {
				System.out.println("검색중인이름: "+ userlist[i].name);
				userlist[i].showAllData();
				System.out.println("요청한 정보를 찾았습니다.");
			}
		}
	}
	
	public void deleteUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for (int i=0; i<numOfUserlist; i++) {
			if (deleteName.compareTo(userlist[i].name)==0) {
				userlist[i] = null;
				deleteIndex = i;
				numOfUserlist--;
			}
		}
		if (deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			for (int i=deleteIndex; i<numOfUserlist; i++) {
				userlist[i] = userlist[i+1];
			}
			System.out.println("==데이터("+ deleteIndex +"번)가 삭제되었습니다.==");
		}
	}
	
	public void showAllData() {
		for (int i=0; i<numOfUserlist; i++) {
			userlist[i].showAllData();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}

}
