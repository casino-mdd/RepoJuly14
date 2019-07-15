
package mdd.casino.rest.entity;

public class SaleRes  extends AbstractRest<Sale> {
	    @Context
	    private UriInfo context;
	    
	    SaleFacade facade = BeanUtil.lookupFacadeBean(SaleFacade.class);
	    
	       public  SaleRest() {
	            super( Sale.class);
	        }
	    
	        @Override
	        public  SaleFacade getFacade() {
	            return facade;
	        }
}

