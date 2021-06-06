package Entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "khachhang")
public class Khachhang implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maKH;
	@Nationalized
	private String tenKH;
	private String sdt;
	@Nationalized
	private String diachi;
	
	
	@OneToMany(mappedBy = "makh",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Hoadon> DShoadon;
	@OneToMany(mappedBy = "makh",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Dattruoc> DSDattruoc;
	@OneToMany(mappedBy = "makh",fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Phitrehan> DSPhitrehan;
	
	public Khachhang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Khachhang(int maKH, String tenKH, String sdt, String diachi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diachi = diachi;
		
	}
	public Khachhang( String tenKH, String sdt, String diachi) {
		super();
		
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public int getMaKH() {
		return maKH;
	}
	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maKH;
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
		Khachhang other = (Khachhang) obj;
		if (maKH != other.maKH)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Khachhang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", diachi=" + diachi + "]";
	}
	
	
	
}
