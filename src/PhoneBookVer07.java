import java.util.InputMismatchException;
import java.util.Scanner;

import ver07.PhoneBookManager;
import ver07.MenuItem;
import ver07.MenuSelectException;


public class PhoneBookVer07 implements MenuItem{

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
	
	public static void main(String[] args)  {
	
		PhoneBookManager manager = new PhoneBookManager(); //유저 100개까지 저장가능
		
		while (true) {
			printMenu();
			Scanner scan = new Scanner(System.in);
			
			try {
				int choice = scan.nextInt();
				
				try {
					if(choice<1 || choice>5) {
						MenuSelectException menuEx = new MenuSelectException();
						throw menuEx;
					}
				}
				catch(MenuSelectException e) {
					System.out.println("예외메세지:"+ e.getMessage());
				}
				
				switch (choice) {
				case INPUT:
					manager.dataInput();
					break;
				case SEARCH:
					manager.dataSearch();
					break;
				case DELETE:
					manager.dataDelete();
					break;
				case SHOW:
					manager.dataAllShow();
					break;
				case EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}
			}
			catch (InputMismatchException e){
				System.out.println("숫자를 입력해야 합니다.");
			}
		}////end of while
	}////end of main
}
