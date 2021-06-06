package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class ChitietDattruocID implements Serializable{

	private int Dattruoc;
	private int Tieude;
	public ChitietDattruocID(int dattruoc, int tieude) {
		super();
		Dattruoc = dattruoc;
		Tieude = tieude;
	}
	public ChitietDattruocID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getDattruoc() {
		return Dattruoc;
	}
	public void setDattruoc(int dattruoc) {
		Dattruoc = dattruoc;
	}
	public int getTieude() {
		return Tieude;
	}
	public void setTieude(int tieude) {
		Tieude = tieude;
	}
	@Override
	public String toString() {
		return "ChitietDattruocID [Dattruoc=" + Dattruoc + ", Tieude=" + Tieude + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Dattruoc;
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
		ChitietDattruocID other = (ChitietDattruocID) obj;
		if (Dattruoc != other.Dattruoc)
			return false;
		return true;
	}
	
	
}
