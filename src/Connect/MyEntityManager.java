package Connect;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance =null;
	private EntityManager em;
	
	public MyEntityManager() {
		em = Persistence.createEntityManagerFactory("XDPMDemo").createEntityManager();
	}

	public synchronized static MyEntityManager getInstance() {
		if(instance==null) {
			instance = new MyEntityManager();
		}
		return instance;
	}

	public EntityManager getEm() {
		return em;
	}
	

}
