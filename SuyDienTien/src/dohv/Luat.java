package dohv;

public class Luat {
	String vt,vp;
	public Luat(String vt,String vp) {
		this.vp=vp;
		this.vt=vt;
	}
	public Luat() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return (this.vt+" -> "+this.vp);
	}
	
}
