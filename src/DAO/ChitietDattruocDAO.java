package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;

import Entity.ChitietDattruoc;

public class ChitietDattruocDAO {
	private EntityManager em;
	
	public ChitietDattruocDAO() {
		em= MyEntityManager.getInstance().getEm();
	}
	
	public List<ChitietDattruoc> getAllChitietDattruoc()throws Exception{
		return em.createNativeQuery("select * from chitietdattruoc",ChitietDattruoc.class).getResultList();
	}
	public List<ChitietDattruoc> getAllChitietDattruocbyMH(int mahd)throws Exception{
		return em.createNativeQuery("select * from ChitietDattruoc where mahd="+mahd+"",ChitietDattruoc.class).getResultList();
	}
	public List<ChitietDattruoc> getAllChitietDattruocbymaTieude(int matd)throws Exception{
		return em.createNativeQuery("select * from ChitietDattruoc where matieude="+matd+"",ChitietDattruoc.class).getResultList();
	}
	public List<ChitietDattruoc> getAllChitietDattruocbyID(int madattruoc)throws Exception{
		return em.createNativeQuery("select * from ChitietDattruoc where madattruoc="+madattruoc+"",ChitietDattruoc.class).getResultList();
	}
	public ChitietDattruoc getChitietHDbymatieude(int matieude)throws Exception{
		return (ChitietDattruoc) em.createNativeQuery("select * from ChitietDattruoc where matieude="+matieude+" and trangthai=N'Đang đặt'",ChitietDattruoc.class).getSingleResult();
	}
	public ChitietDattruoc getChitietHDbymatieudeandMaHD(int madattruoc,int matieude)throws Exception{
		return (ChitietDattruoc) em.createNativeQuery("select * from ChitietDattruoc ct join Dattruoc h on ct.madattruoc=h.madattruoc where madattruoc="+madattruoc+" and matieude="+matieude+"",ChitietDattruoc.class).getSingleResult();
	}
	public ChitietDattruoc getChitietDattruocbyID(int madattruoc) throws Exception{
		return em.find(ChitietDattruoc.class, madattruoc);
	}
	public boolean addChitietDattruoc(ChitietDattruoc ChitietDattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(ChitietDattruoc);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updateChitietDattruoc(ChitietDattruoc ChitietDattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(ChitietDattruoc);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deleteChitietDattruoc(ChitietDattruoc ChitietDattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(ChitietDattruoc.class, ChitietDattruoc.getDattruoc().getMaDattruoc()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
