package Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Chitiethoadon")
@IdClass(ChitiethoadonID.class)
public class Chitiethoadon implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name = "mahd")
	private Hoadon hoadon;
	@Id
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "madvd")
	private DVD dvd;
	@Nationalized
	private String tenTieude;
	
	private double giaThue;
	private int hanthue;
	private Date ngayhethan;
	private Date ngaytraDVD;
	@Nationalized
	private String trangthai;
	public Chitiethoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Chitiethoadon(Hoadon hoadon, DVD dvd, String tenTieude, double giaThue, int hanthue, Date ngayhethan,
			Date ngaytraDVD, String trangthai) {
		super();
		this.hoadon = hoadon;
		this.dvd = dvd;
		this.tenTieude = tenTieude;
		this.giaThue = giaThue;
		this.hanthue = hanthue;
		this.ngayhethan = ngayhethan;
		this.ngaytraDVD = ngaytraDVD;
		this.trangthai = trangthai;
	}



	public Chitiethoadon(Hoadon hoadon, DVD dvd, String tenTieude, double giaThue, int hanthue) {
		super();
		this.hoadon = hoadon;
		this.dvd = dvd;
		this.tenTieude = tenTieude;
		this.giaThue = giaThue;
		this.hanthue = hanthue;
	}



	public Hoadon getHoadon() {
		return hoadon;
	}
	public void setHoadon(Hoadon hoadon) {
		this.hoadon = hoadon;
	}
	public DVD getDvd() {
		return dvd;
	}
	public void setDvd(DVD dvd) {
		this.dvd = dvd;
	}
	
	public String getTenTieude() {
		return tenTieude;
	}

	public void setTenTieude(String tenTieude) {
		this.tenTieude = tenTieude;
	}

	
	public Date getNgayhethan() {
		return ngayhethan;
	}



	public void setNgayhethan(Date ngayhethan) {
		this.ngayhethan = ngayhethan;
	}



	public Date getNgaytraDVD() {
		return ngaytraDVD;
	}



	public void setNgaytraDVD(Date ngaytraDVD) {
		this.ngaytraDVD = ngaytraDVD;
	}



	public String getTrangthai() {
		return trangthai;
	}



	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}



	public double getGiaThue() {
		return giaThue;
	}
	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}
	public int getHanthue() {
		return hanthue;
	}
	public void setHanthue(int hanthue) {
		this.hanthue = hanthue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hoadon == null) ? 0 : hoadon.hashCode());
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
		Chitiethoadon other = (Chitiethoadon) obj;
		if (hoadon == null) {
			if (other.hoadon != null)
				return false;
		} else if (!hoadon.equals(other.hoadon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chitiethoadon [hoadon=" + hoadon + ", dvd=" + dvd + ", tenTieude=" + tenTieude + ", giaThue=" + giaThue
				+ ", hanthue=" + hanthue + "]";
	}

	
	
	
}
