package ver03;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] PhoneInfo;
	private int numOfPhoneInfo;
	
	public PhoneBookManager(int num) {
		PhoneInfo = new PhoneInfo[num];
		numOfPhoneInfo = 0;
	}
	
	public void dataInput() {
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
		PhoneInfo[numOfPhoneInfo++] = user;
	}
	
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for (int i=0; i<numOfPhoneInfo; i++) {
			if(searchName.compareTo(PhoneInfo[i].name)==0) {
				System.out.println("검색중인이름: "+ PhoneInfo[i].name);
				PhoneInfo[i].dataAllShow();
				System.out.println("요청한 정보를 찾았습니다.");
			}
		}
	}
	
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		int deleteIndex = -1;
		
		for (int i=0; i<numOfPhoneInfo; i++) {
			if (deleteName.compareTo(PhoneInfo[i].name)==0) {
				PhoneInfo[i] = null;
				deleteIndex = i;
				numOfPhoneInfo--;
			}
		}
		if (deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			for (int i=deleteIndex; i<numOfPhoneInfo; i++) {
				PhoneInfo[i] = PhoneInfo[i+1];
			}
			System.out.println("==데이터("+ deleteIndex +"번)가 삭제되었습니다.==");
		}
	}
	
	public void dataAllShow() {
		for (int i=0; i<numOfPhoneInfo; i++) {
			PhoneInfo[i].dataAllShow();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}

}
