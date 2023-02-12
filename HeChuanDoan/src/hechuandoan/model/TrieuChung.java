package hechuandoan.model;

import java.io.Serializable;

public class TrieuChung implements Serializable{
	private String maTC,tenTC;

	public String getMaTC() {
		return maTC;
	}

	public void setMaTC(String maTC) {
		this.maTC = maTC;
	}

	public String getTenTC() {
		return tenTC;
	}

	public void setTenTC(String tenTC) {
		this.tenTC = tenTC;
	}

	public TrieuChung(String maTC, String tenTC) {
		super();
		this.maTC = maTC;
		this.tenTC = tenTC;
	}

	public TrieuChung() {
		super();
	}
	
}
