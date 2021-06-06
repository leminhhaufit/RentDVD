package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Tieude")
public class Tieude implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int maTieude;
	@Nationalized
	private String tenTieude;
	private double giaThue;
	private int hanThue;
	private int soluong;
	private double phitrehan;
	private String loaiDVD;
	@Nationalized
	private String mota;
	@Nationalized
	private String trangthai;
	
	@OneToMany(mappedBy = "tieude")
	private List<DVD> DSdvd;

	public Tieude() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Tieude(String tenTieude, double giaThue, int hanThue, int soluong, double phitrehan, String loaiDVD,
			String mota, String trangthai) {
		super();
		this.tenTieude = tenTieude;
		this.giaThue = giaThue;
		this.hanThue = hanThue;
		this.soluong = soluong;
		this.phitrehan = phitrehan;
		this.loaiDVD = loaiDVD;
		this.mota = mota;
		this.trangthai = trangthai;
	}

	


	public Tieude(int maTieude, String tenTieude, double giaThue, int hanThue, int soluong, double phitrehan,
			String loaiDVD, String mota, String trangthai) {
		super();
		this.maTieude = maTieude;
		this.tenTieude = tenTieude;
		this.giaThue = giaThue;
		this.hanThue = hanThue;
		this.soluong = soluong;
		this.phitrehan = phitrehan;
		this.loaiDVD = loaiDVD;
		this.mota = mota;
		this.trangthai = trangthai;
	}


	public double getPhitrehan() {
		return phitrehan;
	}

	public void setPhitrehan(double phitrehan) {
		this.phitrehan = phitrehan;
	}





	public double getGiaThue() {
		return giaThue;
	}





	public void setGiaThue(double giaThue) {
		this.giaThue = giaThue;
	}





	public int getHanThue() {
		return hanThue;
	}





	public void setHanThue(int hanThue) {
		this.hanThue = hanThue;
	}





	public String getLoaiDVD() {
		return loaiDVD;
	}





	public void setLoaiDVD(String loaiDVD) {
		this.loaiDVD = loaiDVD;
	}





	public String getTenTieude() {
		return tenTieude;
	}



	public int getSoluong() {
		return soluong;
	}



	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}



	public void setTenTieude(String tenTieude) {
		this.tenTieude = tenTieude;
	}



	public int getMaTieude() {
		return maTieude;
	}

	public void setMaTieude(int maTieude) {
		this.maTieude = maTieude;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public List<DVD> getDSdvd() {
		return DSdvd;
	}

	public void setDSdvd(List<DVD> dSdvd) {
		DSdvd = dSdvd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maTieude;
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
		Tieude other = (Tieude) obj;
		if (maTieude != other.maTieude)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Tieude [maTieude=" + maTieude + ", tenTieude=" + tenTieude + ", giaThue=" + giaThue + ", hanThue="
				+ hanThue + ", soluong=" + soluong + ", phitrehan=" + phitrehan + ", loaiDVD=" + loaiDVD + ", mota="
				+ mota + ", trangthai=" + trangthai + ", DSdvd=" + DSdvd + "]";
	}





	

	
	
	
	
}
