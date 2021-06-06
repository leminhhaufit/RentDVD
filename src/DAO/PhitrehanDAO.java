package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;
import Entity.Phitrehan;


public class PhitrehanDAO {
private EntityManager em;
	
	public PhitrehanDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	public List<Phitrehan> getAllPhitrehan()throws Exception{
		return em.createNativeQuery("select * from Phitrehan",Phitrehan.class).getResultList();
	}
	public List<Phitrehan> getAllPhitrehanBymaKH(int makh)throws Exception{
		return em.createNativeQuery("select * from Phitrehan where makh="+makh+"",Phitrehan.class).getResultList();
	}
	
	public Phitrehan getPhitrehanbyID(int maphitrehan) throws Exception{
		return em.find(Phitrehan.class, maphitrehan);
	}
	public int demsoluongpth() throws Exception{
		
		return (int) em.createNativeQuery("select COUNT(*) from Phitrehan").getSingleResult();
	}
	public boolean addPhitrehan(Phitrehan pth) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(pth);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updatePhitrehan(Phitrehan pth) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(pth);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deletePhitrehan(Phitrehan pth) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Phitrehan.class, pth.getMaPhitrehan()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
