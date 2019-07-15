
package mdd.casino.jpa.entity.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import mdd.casino.jpa.entity.pojo.Employee;

@Stateless
public class EmployeeFacade extends AbtractFacade{


	    @PersistenceUnit
	    private EntityManagerFactory emf;

	    @Override
	    protected EntityManager getEntityManager() {
	        return emf.createEntityManager();
	    }

	    public EmployeeFacade() {
	        super(Employee.class);
	    }
	    

}	
