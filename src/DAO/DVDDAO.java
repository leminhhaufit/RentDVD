package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;
import Entity.DVD;


public class DVDDAO {
	private EntityManager em;
	
	public DVDDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	
	public List<DVD> getAllDVD()throws Exception{
		return em.createNativeQuery("select * from dvd",DVD.class).getResultList();
	}
	
	public DVD getDVDbyID(int madvd) throws Exception{
		return em.find(DVD.class, madvd);
	}
	public boolean addDVD(DVD dvd) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(dvd);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateDVD(DVD dvd) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(dvd);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteDVD(DVD dvd) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(DVD.class, dvd.getMaDVD()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
