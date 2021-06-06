package DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Connect.MyEntityManager;
import Entity.Dattruoc;


public class DattruocDAO {
	private EntityManager em;
	
	public DattruocDAO() {
		em = MyEntityManager.getInstance().getEm();
	}
	
	public List<Dattruoc> getAlldattruoc()throws Exception{
		return em.createNativeQuery("select * from dattruoc",Dattruoc.class).getResultList();
	}
	
	public List<Dattruoc> getdattruocbyMaKH(int makh)throws Exception{
		return em.createNativeQuery("select * from dattruoc where makh="+makh+"",Dattruoc.class).getResultList();
	}
	public int getMaHD(int makh,Date ngaythue,String tongtien) throws Exception{
		
		return (int) em.createNativeQuery("select madattruoc from dattruoc where makh="+makh+" and ngaythue='"+ngaythue+"' and tongtienThue='"+tongtien+"' ").getSingleResult();
	}
	public Dattruoc getdattruocbyID(int madattruoc) throws Exception{
		return em.find(Dattruoc.class, madattruoc);
	}
	public int demsoluongdattruoc() throws Exception{
		
		return (int) em.createNativeQuery("select COUNT(*) from dattruoc").getSingleResult();
	}
	public boolean adddattruoc(Dattruoc dattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.persist(dattruoc);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean updatedattruoc(Dattruoc dattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.merge(dattruoc);
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}
	public boolean deletedattruoc(Dattruoc dattruoc) throws Exception{
		EntityTransaction tr = em.getTransaction();
		boolean kq= false;
		try {
			tr.begin();
			em.remove(em.find(Dattruoc.class, dattruoc.getMaDattruoc()));
			tr.commit();
			kq=true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		return kq;
	}

}
