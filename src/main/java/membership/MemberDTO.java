package membership;

public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private String regidate;
	
		
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDTO(String id, String pass, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
	}
	
	// 맴버 변수별 게터와 세터
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	
}
