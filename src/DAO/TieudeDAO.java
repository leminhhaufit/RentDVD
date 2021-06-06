package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Connect.MyEntityManager;
import Entity.Khachhang;
import Entity.Tieude;

public class TieudeDAO {
	
	private EntityManager em;
	
	public TieudeDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	

	public List<Tieude> getAllTieude()throws Exception{
		return em.createNativeQuery("select * from tieude",Tieude.class).getResultList();
	}
	public List<Tieude> getTieudebyTen(String ten)throws Exception{

		return em.createNativeQuery("select * from tieude where tenTieude like N'"+ten+"'", Tieude.class).getResultList();
	}
	public List<Tieude> getTieudebyTenGangiong(String ten)throws Exception{

		return em.createNativeQuery("select * from tieude where tenTieude like N'%"+ten+"%'", Tieude.class).getResultList();
	}
	public Tieude getTieudebyID(int maTieude) throws Exception{
		return em.find(Tieude.class, maTieude);
	}
	public int demsoluongDVD(String tentd) throws Exception{
		
		return (int) em.createNativeQuery("select COUNT(*) from dvd d join Tieude td on d.tieude=td.maTieude where td.tenTieude=N'"+tentd+"'").getSingleResult();
	}
	public boolean addTieude(Tieude Tieude) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(Tieude);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateTieude(Tieude Tieude) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(Tieude);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteTieude(Tieude Tieude) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Tieude.class, Tieude.getMaTieude()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
