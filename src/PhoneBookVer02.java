import java.io.IOException;
import java.util.Scanner;

import ver02.PhoneInfo;

public class PhoneBookVer02 {

	// 프로그램에서의 입력메뉴 출력
	public static void menuShow() {
		System.out.println("==원하는 메뉴를 선택하세요==");
		System.out.println("1.데이터 입력");
		System.out.println("2.프로그램 종료");
		System.out.print("메뉴선택>>>");
	}

	public static void main(String[] args) throws IOException {

		while (true) {// 무한루프
			// 메뉴출력을 위한 메소드출력
			menuShow();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			String name = "";
			String phoneNumber = "";
			String birthday = "";

			switch (choice) {
			case 1:
				Scanner scan1 = new Scanner(System.in);

				System.out.println("선택:" + choice);

				System.out.println("이름:");
				name = scan1.nextLine();

				System.out.println("전화번호:");
				phoneNumber = scan1.nextLine();

				System.out.println("생년월일:");
				birthday = scan1.nextLine();

				PhoneInfo p1 = new PhoneInfo(name, phoneNumber, birthday);
				p1.showPhoneInfo();
				System.out.println();
				break;
			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}
		} //// end of while
	}
}
