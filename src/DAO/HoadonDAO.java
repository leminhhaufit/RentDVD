package DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;
import Entity.Hoadon;

public class HoadonDAO {
	private EntityManager em;
	
	public HoadonDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	
	public List<Hoadon> getAllHoadon()throws Exception{
		return em.createNativeQuery("select * from hoadon",Hoadon.class).getResultList();
	}
	public List<Hoadon> getHoadonbyMaKH(int makh)throws Exception{
		return em.createNativeQuery("select * from hoadon where makh="+makh+"",Hoadon.class).getResultList();
	}
	public int getMaHD(int makh,Date ngaythue,String tongtien) throws Exception{
		
		return (int) em.createNativeQuery("select maHoadon from Hoadon where makh="+makh+" and ngaythue='"+ngaythue+"' and tongtienThue='"+tongtien+"' ").getSingleResult();
	}
	public Hoadon getHoadonbyID(int maHoadon) throws Exception{
		return em.find(Hoadon.class, maHoadon);
	}
	public int demsoluongHoadon() throws Exception{
		
		return (int) em.createNativeQuery("select COUNT(*) from hoadon").getSingleResult();
	}
	public boolean addHoadon(Hoadon Hoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(Hoadon);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateHoadon(Hoadon Hoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(Hoadon);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteHoadon(Hoadon Hoadon) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Hoadon.class, Hoadon.getMaHoadon()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
