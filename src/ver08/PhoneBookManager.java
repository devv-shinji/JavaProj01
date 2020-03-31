package ver08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class PhoneBookManager implements SubMenuItem {

	private int numOfPhoneInfo;
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();
	
	public PhoneBookManager() { 
		numOfPhoneInfo = 0;
	}
	
	public void dataInput() {
		Scanner scan1 = new Scanner(System.in);
		String iName, iPhone, iMajor, iCompany;
		int iGrade, iChoice;
		
		boolean searchFlag = false;
		Iterator<PhoneInfo> itr = set.iterator();
		
		try {
			System.out.println("1.일반, 2.동창, 3.회사");
			iChoice = scan1.nextInt();
			
			System.out.println("이름:");
			iName = scan1.next();
			
			while(itr.hasNext()) {
				PhoneInfo phoneinfo = itr.next();
				if(iName.equals(phoneinfo.name)) {
					System.out.println("동일한 이름이 존재합니다. 계속 진행하시겠습니까? Y:1, N:2");
					int num = scan1.nextInt();
					
					if(num==1) {
						searchFlag = true;
						set.remove(phoneinfo);
					}
					else {
						searchFlag = false;
						return;
					}
				}
			}
			
			System.out.println("전화번호:");
			iPhone = scan1.next();
			
			switch (iChoice) {
			case NORMAL:
				User user1 = new User(iName, iPhone);
				set.add(user1);
				break;
			case SCHOOL:
				System.out.println("전공:");
				iMajor = scan1.next();
				System.out.println("학년:");
				iGrade = scan1.nextInt();
				PhoneSchoolInfo user2 = new PhoneSchoolInfo(iName, iPhone, iMajor, iGrade);
				set.add(user2);
				break;
			case COMPANY:
				System.out.println("회사:");
				iCompany = scan1.next();
				PhoneCompanyInfo user3 = new PhoneCompanyInfo(iName, iPhone, iCompany);
				set.add(user3);
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
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo phoneinfo = itr.next();
			if(searchName.equals(phoneinfo.name)) {
				searchFlag = true;
				phoneinfo.dataAllShow();
				System.out.println("요청한 정보를 찾았습니다.");
			}
		}
		if(searchFlag = false) {
			System.out.println("찾는 정보가 없습니다.");
		}
		
	}
	
	public void dataDelete() {
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		boolean searchFlag = false;
		
		Iterator<PhoneInfo> itr = set.iterator();
		
		while(itr.hasNext()) {
			PhoneInfo phoneinfo = itr.next();
			if(deleteName.equals(phoneinfo.name)) {
				searchFlag = true;
				set.remove(phoneinfo);
				System.out.println("삭제되었습니다.");
			}
		}
		if(searchFlag = false) {
			System.out.println("삭제할 수 없습니다.");
		}
	}
	
	public void dataAllShow() {
		for (PhoneInfo av : set) {
			av.dataAllShow();
		}
		System.out.println("전체정보가 출력되었습니다.");
	}
	
	public void loadData() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(new FileInputStream("src/ver08/phone_book.obj"));
			
			HashSet<PhoneInfo> phoneinfo = (HashSet<PhoneInfo>)in.readObject();
			set = phoneinfo;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try {
			ObjectOutputStream out = 
					new ObjectOutputStream(new FileOutputStream("src/ver08/phone_book.obj"));
			
			out.writeObject(set);
		}
		catch(Exception e){
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
}////end of PhoneBookManager
