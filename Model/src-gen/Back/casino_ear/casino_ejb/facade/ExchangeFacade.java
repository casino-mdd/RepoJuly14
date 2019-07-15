
package mdd.casino.jpa.entity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import mdd.casino.jpa.entity.pojo.Exchange;

@Stateless
public class ExchangeFacade extends AbtractFacade{


	    @PersistenceUnit
	    private EntityManagerFactory emf;

	    @Override
	    protected EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	    public ExchangeFacade() {
	        super(Exchange.class);
	    }
	    

}	
