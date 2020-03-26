import java.util.Scanner;

import ver04.PhoneBookManager;

public class PhoneBookVer04 {

	//프로그램에서의 입력메뉴 출력
	public static void printMenu() {
		System.out.println("\n==원하는 메뉴를 선택하세요==");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴선택>>>\n");
	}
	
	
	public static void main(String[] args) {
	
		PhoneBookManager manager = new PhoneBookManager(100); //유저 100개까지 저장가능
		
		while (true) {
			
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				manager.addUser();
				break;
			case 2:
				manager.searchUser();
				break;
			case 3:
				manager.deleteUser();
				break;
			case 4:
				manager.showAllData();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}////end of while
	}////end of main
}
