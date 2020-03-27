package ver06;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookManager implements SubMenuItem{

	private PhoneInfo[] phoneInfo;
	private int numOfPhoneInfo;
	
	public PhoneBookManager(int num) {
		phoneInfo = new PhoneInfo[num];
		numOfPhoneInfo = 0;
	}
	
	public void dataInput() {
		Scanner scan1 = new Scanner(System.in);
		String iName, iPhone, iMajor, iCompany;
		int iGrade, iChoice;
		
		try {
			System.out.println("1.일반, 2.동창, 3.회사");
			iChoice = scan1.nextInt();
			
			System.out.println("이름:");
			iName = scan1.next();
			
			System.out.println("전화번호:");
			iPhone = scan1.next();
			
			switch (iChoice) {
			case NORMAL:
				User user1 = new User(iName, iPhone);
				phoneInfo[numOfPhoneInfo++] = user1;
				break;
			case SCHOOL:
				System.out.println("전공:");
				iMajor = scan1.next();
				System.out.println("학년:");
				iGrade = scan1.nextInt();
				PhoneSchoolInfo user2 = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
				phoneInfo[numOfPhoneInfo++] = user2;
				break;
			case COMPANY:
				System.out.println("회사:");
				iCompany = scan1.next();
				PhoneCompanyInfo user3 = new PhoneCompanyInfo(iName, iPhone, iCompany);
				phoneInfo[numOfPhoneInfo++] = user3;
				break;
			}
			System.out.println("데이터 입력이 완료되었습니다.");
		}
		catch(InputMismatchException e) {
			System.out.println("1~3 사이 숫자를 입력해주세요.");
		}
	}
	
	public void dataSearch() {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for (int i=0; i<numOfPhoneInfo; i++) {
			if(searchName.compareTo(phoneInfo[i].name)==0) {
				System.out.println("검색중인이름: "+ phoneInfo[i].name);
				phoneInfo[i].dataAllShow();
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
			if (deleteName.compareTo(phoneInfo[i].name)==0) {
				phoneInfo[i] = null;
				deleteIndex = i;
				numOfPhoneInfo--;
			}
		}
		if (deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			for (int i=deleteIndex; i<numOfPhoneInfo; i++) {
				phoneInfo[i] = phoneInfo[i+1];
			}
			System.out.println("==데이터("+ deleteIndex +"번)가 삭제되었습니다.==");
		}
	}
	
	public void dataAllShow() {
		for (int i=0; i<numOfPhoneInfo; i++) {
			phoneInfo[i].dataAllShow();
		}
		System.out.println("전체정보가 출력되었습니다.");
	}

}
