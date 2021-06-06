package Entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hoadon")
public class Hoadon implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maHoadon;
	
	private int soluong;
	private double tongtienThue;
	private Date ngaythue;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "manv") private Nhanvien manv;
	 */
	@ManyToOne
	@JoinColumn(name = "makh")
	private Khachhang makh;

	public Hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hoadon(int maHoadon, int soluong, double tongtienThue, Date ngaythue) {
		super();
		this.maHoadon = maHoadon;
		this.soluong = soluong;
		this.tongtienThue = tongtienThue;
		this.ngaythue = ngaythue;
	}

	/*
	 * public Hoadon(int maHoadon, int soluong, double tongtienThue, LocalDate
	 * ngaythue, Nhanvien manv, Khachhang makh) { super(); this.maHoadon = maHoadon;
	 * this.soluong = soluong; this.tongtienThue = tongtienThue; this.ngaythue =
	 * ngaythue; this.manv = manv; this.makh = makh; }
	 */

	public Hoadon(int soluong, double tongtienThue, Date ngaythue, Khachhang makh) {
		super();
		this.soluong = soluong;
		this.tongtienThue = tongtienThue;
		this.ngaythue = ngaythue;
		this.makh = makh;
	}

	public Hoadon(int maHoadon, int soluong, double tongtienThue, Date ngaythue, Khachhang makh) {
		super();
		this.maHoadon = maHoadon;
		this.soluong = soluong;
		this.tongtienThue = tongtienThue;
		this.ngaythue = ngaythue;
		this.makh = makh;
	}

	public int getMaHoadon() {
		return maHoadon;
	}

	public void setMaHoadon(int maHoadon) {
		this.maHoadon = maHoadon;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getTongtienThue() {
		return tongtienThue;
	}

	public void setTongtienThue(double tongtienThue) {
		this.tongtienThue = tongtienThue;
	}

	public Date getNgaythue() {
		return ngaythue;
	}

	public void setNgaythue(Date ngaythue) {
		this.ngaythue = ngaythue;
	}

	/*
	 * public Nhanvien getManv() { return manv; }
	 * 
	 * public void setManv(Nhanvien manv) { this.manv = manv; }
	 */

	public Khachhang getMakh() {
		return makh;
	}

	public void setMakh(Khachhang makh) {
		this.makh = makh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maHoadon;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hoadon other = (Hoadon) obj;
		if (maHoadon != other.maHoadon)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hoadon [maHoadon=" + maHoadon + ", soluong=" + soluong + ", tongtienThue=" + tongtienThue
				+ ", ngaythue=" + ngaythue + ", makh=" + makh + "]";
	}

	
	
	
	
}
