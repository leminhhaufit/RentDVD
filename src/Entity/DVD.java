package Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "DVD")
public class DVD implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDVD;

	@Nationalized
	private String trangthai;
	@ManyToOne
	@JoinColumn(name = "tieude")
	private Tieude tieude;
	
	
	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public DVD(String trangthai, Tieude tieude) {
		super();
		this.trangthai = trangthai;
		this.tieude = tieude;
	}


	public DVD(int maDVD, String trangthai, Tieude tieude) {
		super();
		this.maDVD = maDVD;
		this.trangthai = trangthai;
		this.tieude = tieude;
	}


	public String getTrangthai() {
		return trangthai;
	}





	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}





	public Tieude getTieude() {
		return tieude;
	}
	public void setTieude(Tieude tieude) {
		this.tieude = tieude;
	}
	public int getMaDVD() {
		return maDVD;
	}
	public void setMaDVD(int maDVD) {
		this.maDVD = maDVD;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maDVD;
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
		DVD other = (DVD) obj;
		if (maDVD != other.maDVD)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "DVD [maDVD=" + maDVD + ", trangthai=" + trangthai + ", tieude=" + tieude + "]";
	}


	
	
	
	
}
