package Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Dattruoc")
public class Dattruoc implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDattruoc;
	private int soluong;
	private Date ngayDat;
	@ManyToOne
	@JoinColumn(name = "makh")
	private Khachhang makh;
	public Dattruoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dattruoc(int soluong, Date ngayDat, Khachhang makh) {
		super();
		this.soluong = soluong;
		this.ngayDat = ngayDat;
		this.makh = makh;
	}
	public int getMaDattruoc() {
		return maDattruoc;
	}
	public void setMaDattruoc(int maDattruoc) {
		this.maDattruoc = maDattruoc;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Date getNgayDat() {
		return ngayDat;
	}
	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}
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
		result = prime * result + maDattruoc;
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
		Dattruoc other = (Dattruoc) obj;
		if (maDattruoc != other.maDattruoc)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dattruoc [maDattruoc=" + maDattruoc + ", soluong=" + soluong + ", ngayDat=" + ngayDat + ", makh=" + makh
				+ "]";
	}
	
	
	
}
