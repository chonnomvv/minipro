package mini_project;

public class Friend {

	private String name;
	private String hp;
	private String company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public Friend(String name, String hp, String company) {
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	public Friend() {
	}
	
	public void showInfo() {
		System.out.println("이름: " +name + " 핸드폰: " + hp + " 회사: " +company);
	}
	
	
	
}
