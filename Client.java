package buccaneers.bank;

public class Client {

	private int id;
	private String name;
	private int capHit;
	private int baseSalary;
	private int signingBonus;
	
	public Client() {
		super();
	}

	public Client(int id, String name, int capHit, int baseSalary, int signingBonus) {
		super();
		this.id = id;
		this.name = name;
		this.capHit = capHit;
		this.baseSalary = baseSalary;
		this.signingBonus = signingBonus;
	}

	public Client(int id2, String name2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapHit() {
		return capHit;
	}

	public void setCapHit(int capHit) {
		this.capHit = capHit;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	public int getSigningBonus() {
		return signingBonus;
	}

	public void setSigningBonus(int signingBonus) {
		this.signingBonus = signingBonus;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", capHit=" + capHit + ", baseSalary=" + baseSalary
				+ ", signingBonus=" + signingBonus + "]";
	}
	
	
	
	
}
