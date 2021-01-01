package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class PublicCommon {
	private static EntityManagerFactory emf;
	
	static {
		emf = Persistence.createEntityManagerFactory("oracleDBUse");
	}
	
	public static EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}
	
	public static void close() {
		emf.close();	
	}
}
