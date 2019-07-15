
package mdd.casino.rest.entity;

public class EmployeeRes  extends AbstractRest<Employee> {
	    @Context
	    private UriInfo context;
	    
	    EmployeeFacade facade = BeanUtil.lookupFacadeBean(EmployeeFacade.class);
	    
	       public  EmployeeRest() {
	            super( Employee.class);
	        }
	    
	        @Override
	        public  EmployeeFacade getFacade() {
	            return facade;
	        }
}

