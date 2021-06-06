package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;
import Entity.Taikhoan;


public class TaikhoanDAO {
	
	private EntityManager em;
	
	public TaikhoanDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	
	public List<Taikhoan> getAllTaikhoan()throws Exception{
		return em.createNativeQuery("select * from taikhoan",Taikhoan.class).getResultList();
	}
	
	public Taikhoan getTaikhoanbyID(String tendangnhap) throws Exception{
		return em.find(Taikhoan.class, tendangnhap);
	}
	
	
	public boolean addTaikhoan(Taikhoan Taikhoan) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(Taikhoan);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateTaikhoan(Taikhoan Taikhoan) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(Taikhoan);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteTaikhoan(Taikhoan Taikhoan) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Taikhoan.class, Taikhoan.getTenDangnhap()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
