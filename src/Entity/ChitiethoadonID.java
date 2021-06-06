package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class ChitiethoadonID implements Serializable{
	private int hoadon;
	private int dvd;
	public ChitiethoadonID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChitiethoadonID(int hoadon, int dvd) {
		super();
		this.hoadon = hoadon;
		this.dvd = dvd;
	}
	public int getHoadon() {
		return hoadon;
	}
	public void setHoadon(int hoadon) {
		this.hoadon = hoadon;
	}
	public int getDvd() {
		return dvd;
	}
	public void setDvd(int dvd) {
		this.dvd = dvd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dvd;
		result = prime * result + hoadon;
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
		ChitiethoadonID other = (ChitiethoadonID) obj;
		if (dvd != other.dvd)
			return false;
		if (hoadon != other.hoadon)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChitiethoadonID [hoadon=" + hoadon + ", dvd=" + dvd + "]";
	}
	
	

}
