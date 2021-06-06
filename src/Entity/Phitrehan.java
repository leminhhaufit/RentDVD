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
@Table(name = "phitrehan")
public class Phitrehan implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhitrehan;
	private double Tongtienphi;
	private double tienphidatra;
	private Date ngaytraphi;
	@ManyToOne
	@JoinColumn(name = "makh")
	private Khachhang makh;
	public Phitrehan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Phitrehan(int maPhitrehan, double tongtienphi, double tienphidatra, Date ngaytraphi, Khachhang makh) {
		super();
		this.maPhitrehan = maPhitrehan;
		Tongtienphi = tongtienphi;
		this.tienphidatra = tienphidatra;
		this.ngaytraphi = ngaytraphi;
		this.makh = makh;
	}

	public Phitrehan(double tongtienphi, double tienphidatra, Date ngaytraphi, Khachhang makh) {
		super();
		Tongtienphi = tongtienphi;
		this.tienphidatra = tienphidatra;
		this.ngaytraphi = ngaytraphi;
		this.makh = makh;
	}
	public int getMaPhitrehan() {
		return maPhitrehan;
	}
	public void setMaPhitrehan(int maPhitrehan) {
		this.maPhitrehan = maPhitrehan;
	}
	public double getTongtienphi() {
		return Tongtienphi;
	}
	public void setTongtienphi(double tongtienphi) {
		Tongtienphi = tongtienphi;
	}
	public double getTienphidatra() {
		return tienphidatra;
	}
	public void setTienphidatra(double tienphidatra) {
		this.tienphidatra = tienphidatra;
	}
	public Date getNgaytraphi() {
		return ngaytraphi;
	}
	public void setNgaytraphi(Date ngaytraphi) {
		this.ngaytraphi = ngaytraphi;
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
		result = prime * result + maPhitrehan;
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
		Phitrehan other = (Phitrehan) obj;
		if (maPhitrehan != other.maPhitrehan)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phitrehan [maPhitrehan=" + maPhitrehan + ", Tongtienphi=" + Tongtienphi + ", tienphidatra="
				+ tienphidatra + ", ngaytraphi=" + ngaytraphi + ", makh=" + makh + "]";
	}
	
	

}
