package DAO;

import java.util.List;
import java.util.Queue;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


import Connect.MyEntityManager;
import Entity.Khachhang;

public class KhachhangDAO {
	private EntityManager em;
	
	public KhachhangDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	public List<Khachhang> getAllKhachhang()throws Exception{
		return em.createNativeQuery("select * from khachhang",Khachhang.class).getResultList();
	}
	public List<Khachhang> getKhachhangbySDT(String sdt)throws Exception{
		return em.createNativeQuery("select * from khachhang where sdt='"+sdt+"'", Khachhang.class).getResultList();
	}
	public Khachhang getKhachhangbyID(int makh) throws Exception{
		return em.find(Khachhang.class, makh);
	}
	public int demsoluongKH() throws Exception{
		
		return (int) em.createNativeQuery("select COUNT(*) from khachhang").getSingleResult();
	}
	public boolean addKhachhang(Khachhang kh) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(kh);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateKhachhang(Khachhang kh) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(kh);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteKhachhang(Khachhang kh) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Khachhang.class, kh.getMaKH()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	
	
	

}
