import java.util.Scanner;

import ver03.PhoneBookManager;



public class PhoneBookVer09 {

	//프로그램에서의 입력메뉴 출력
	public static void printMenu() {
		System.out.println("==원하는 메뉴를 선택하세요==");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("메뉴선택>>>");
	}
	
	
	public static void main(String[] args) {
	
		PhoneBookManager manager = new PhoneBookManager(100); //유저 100개까지 저장가능
		
		while (true) {
			
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				manager.dataInput();
				break;
			case 2:
				manager.dataSearch();
				break;
			case 3:
				manager.dataDelete();
				break;
			case 4:
				manager.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			
		}////end of while
	}////end of main
}
