package pck1;

public class Product {
	private String maSP;
	private String tenSp;
	private int soLuong;
	private double donGia;
	
	//CONSTRUCTOR
	public Product() {
	}

	public Product(String maSP, String tenSp, int soLuong, double donGia ) {

		this.maSP = maSP;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.donGia = donGia;
		
	}

	//GETTER, SETTER
	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSp() {
		return tenSp;
	}

	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	@Override
	public String toString() {
		
		return maSP + ";" + tenSp + ";" + soLuong + ";" + donGia ;
	}

}
