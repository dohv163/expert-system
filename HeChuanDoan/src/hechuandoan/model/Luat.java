package hechuandoan.model;

public class Luat {
	private String veTrai,vePhai;

	public String getVeTrai() {
		return veTrai;
	}

	public void setVeTrai(String veTrai) {
		this.veTrai = veTrai;
	}

	public String getVePhai() {
		return vePhai;
	}

	public void setVePhai(String vePhai) {
		this.vePhai = vePhai;
	}

	public Luat(String veTrai, String vePhai) {
		super();
		this.veTrai = veTrai;
		this.vePhai = vePhai;
	}

	public Luat() {
		super();
	}

	@Override
	public String toString() {
		return veTrai + "->" + vePhai;
	}
	
	
	
}
