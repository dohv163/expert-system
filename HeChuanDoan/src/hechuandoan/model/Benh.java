package hechuandoan.model;

public class Benh {
	private String tenBenh, maBenh;

	public String getTenBenh() {
		return tenBenh;
	}

	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}

	public String getMaBenh() {
		return maBenh;
	}

	public void setMaBenh(String maBenh) {
		this.maBenh = maBenh;
	}

	public Benh(String maBenh, String tenBenh) {
		super();
		this.tenBenh = tenBenh;
		this.maBenh = maBenh;
	}
	
	@Override
	public String toString() {
		return "Benh [tenBenh=" + tenBenh + ", maBenh=" + maBenh + "]";
	}

	public Benh() {
		super();
	}
	
}
