package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Taikhoan")
public class Taikhoan implements Serializable{

	@Id
	private String tenDangnhap;
	private String matkhau;
	public Taikhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taikhoan(String tenDangnhap, String matkhau) {
		super();
		this.tenDangnhap = tenDangnhap;
		this.matkhau = matkhau;
	}
	public String getTenDangnhap() {
		return tenDangnhap;
	}
	public void setTenDangnhap(String tenDangnhap) {
		this.tenDangnhap = tenDangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenDangnhap == null) ? 0 : tenDangnhap.hashCode());
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
		Taikhoan other = (Taikhoan) obj;
		if (tenDangnhap == null) {
			if (other.tenDangnhap != null)
				return false;
		} else if (!tenDangnhap.equals(other.tenDangnhap))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Taikhoan [tenDangnhap=" + tenDangnhap + ", matkhau=" + matkhau + "]";
	}
	
	
	
}
