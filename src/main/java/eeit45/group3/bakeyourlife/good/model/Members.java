package eeit45.group3.bakeyourlife.good.model;

public class Members {

	private String memberName;
	private String gender;
	private int age;
	private String gender1;

	public Members() {
	}

	public Members(String memberName, String gender, int age) {
		this.memberName = memberName;
		this.gender = gender;
		this.age = age;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender1() {
		return gender1;
	}

	public void setGender1(String gender1) {
		this.gender1 = gender1;
	}

}
