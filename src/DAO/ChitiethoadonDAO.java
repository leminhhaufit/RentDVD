package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;

import Entity.Chitiethoadon;

public class ChitiethoadonDAO {
	private EntityManager em;
	
	public ChitiethoadonDAO() {
		em= MyEntityManager.getInstance().getEm();
	}
	
	public List<Chitiethoadon> getAllChitiethoadon()throws Exception{
		return em.createNativeQuery("select * from chitiethoadon",Chitiethoadon.class).getResultList();
	}
	public List<Chitiethoadon> getAllChitiethoadonbyMH(int mahd)throws Exception{
		return em.createNativeQuery("select * from chitiethoadon where mahd="+mahd+"",Chitiethoadon.class).getResultList();
	}
	public Chitiethoadon getChitietHDbyMaDVD(int madvd)throws Exception{
		return (Chitiethoadon) em.createNativeQuery("select * from Chitiethoadon where madvd="+madvd+" and trangthai=N'Đang thuê'",Chitiethoadon.class).getSingleResult();
	}
	public Chitiethoadon getChitietHDbyMaDVDandMaHD(int mahd,int madvd)throws Exception{
		return (Chitiethoadon) em.createNativeQuery("select * from Chitiethoadon ct join Hoadon h on ct.mahd=h.maHoadon where mahd="+mahd+" and madvd="+madvd+"",Chitiethoadon.class).getSingleResult();
	}
	public Chitiethoadon getChitiethoadonbyID(int mahd) throws Exception{
		return em.find(Chitiethoadon.class, mahd);
	}
	public boolean addChitiethoadon(Chitiethoadon Chitiethoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(Chitiethoadon);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateChitiethoadon(Chitiethoadon Chitiethoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(Chitiethoadon);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteChitiethoadon(Chitiethoadon Chitiethoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Chitiethoadon.class, Chitiethoadon.getHoadon()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
