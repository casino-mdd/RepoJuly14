
package mdd.casino.jpa.entity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import mdd.casino.jpa.entity.pojo.Points;

@Stateless
public class PointsFacade extends AbtractFacade{


	    @PersistenceUnit
	    private EntityManagerFactory emf;

	    @Override
	    protected EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	    public PointsFacade() {
	        super(Points.class);
	    }
	    

}	
