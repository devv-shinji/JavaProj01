package ver04;

//동창친구
public class PhoneSchoolInfo extends PhoneInfo {
	String major;
	int grade;
	
	public PhoneSchoolInfo(String name, String phone, String major, int grade) {
		super(name, phone);
		this.major = major;
		this.grade = grade;
	}
	@Override
	public void dataAllShow() {
		System.out.println("-----동창친구-----");
		super.dataAllShow();
		System.out.println("전공: "+ major);
		System.out.println("학년: "+ grade);
	}
}

