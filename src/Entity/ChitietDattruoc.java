package Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "ChitietDattruoc")
@IdClass(ChitietDattruocID.class)
public class ChitietDattruoc implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name = "madattruoc")
	private Dattruoc Dattruoc;
	@Id
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "matieude")
	private Tieude Tieude;
	@Nationalized
	private String trangthai;
	private int madvd;

	public ChitietDattruoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChitietDattruoc(Dattruoc dattruoc, Tieude tieude, String trangthai) {
		super();
		this.Dattruoc = dattruoc;
		this.Tieude = tieude;
		this.trangthai = trangthai;
	}
	

	

	

	public int getMadvd() {
		return madvd;
	}

	public void setMadvd(int madvd) {
		this.madvd = madvd;
	}

	public ChitietDattruoc(Dattruoc dattruoc, Tieude tieude, String trangthai, int madvd) {
		super();
		Dattruoc = dattruoc;
		Tieude = tieude;
		this.trangthai = trangthai;
		this.madvd = madvd;
	}

	public Dattruoc getDattruoc() {
		return Dattruoc;
	}

	public void setDattruoc(Dattruoc dattruoc) {
		this.Dattruoc = dattruoc;
	}

	public Tieude getTieude() {
		return Tieude;
	}

	public void setTieude(Tieude tieude) {
		this.Tieude = tieude;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	@Override
	public String toString() {
		return "ChitietDattruoc [dattruoc=" + Dattruoc + ", tieude=" + Tieude + ", trangthai=" + trangthai + "]";
	}
	
	
}
