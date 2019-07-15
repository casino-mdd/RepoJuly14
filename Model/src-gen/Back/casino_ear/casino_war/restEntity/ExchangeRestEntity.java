
package mdd.casino.rest.entity;

public class ExchangeRes  extends AbstractRest<Exchange> {
	    @Context
	    private UriInfo context;
	    
	    ExchangeFacade facade = BeanUtil.lookupFacadeBean(ExchangeFacade.class);
	    
	       public  ExchangeRest() {
	            super( Exchange.class);
	        }
	    
	        @Override
	        public  ExchangeFacade getFacade() {
	            return facade;
	        }
}

