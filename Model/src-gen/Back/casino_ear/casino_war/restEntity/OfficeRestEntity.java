
package mdd.casino.rest.entity;

public class OfficeRes  extends AbstractRest<Office> {
	    @Context
	    private UriInfo context;
	    
	    OfficeFacade facade = BeanUtil.lookupFacadeBean(OfficeFacade.class);
	    
	       public  OfficeRest() {
	            super( Office.class);
	        }
	    
	        @Override
	        public  OfficeFacade getFacade() {
	            return facade;
	        }
}

