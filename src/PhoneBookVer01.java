import ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {

		PhoneInfo p1 = new PhoneInfo("토니스타크", "010-0000-0000", "70-01-01");
		PhoneInfo p2 = new PhoneInfo("브루스배너", "010-1111-1111");
		
		p1.showPhoneInfo();
		p2.showPhoneInfo(); //생년월일 입력되지 않음
		
	}

}
