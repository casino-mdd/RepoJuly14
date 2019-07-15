
package mdd.casino.rest.entity;

public class ClientRes  extends AbstractRest<Client> {
	    @Context
	    private UriInfo context;
	    
	    ClientFacade facade = BeanUtil.lookupFacadeBean(ClientFacade.class);
	    
	       public  ClientRest() {
	            super( Client.class);
	        }
	    
	        @Override
	        public  ClientFacade getFacade() {
	            return facade;
	        }
}

