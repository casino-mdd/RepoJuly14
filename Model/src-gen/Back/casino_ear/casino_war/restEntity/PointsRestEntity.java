
package mdd.casino.rest.entity;

public class PointsRes  extends AbstractRest<Points> {
	    @Context
	    private UriInfo context;
	    
	    PointsFacade facade = BeanUtil.lookupFacadeBean(PointsFacade.class);
	    
	       public  PointsRest() {
	            super( Points.class);
	        }
	    
	        @Override
	        public  PointsFacade getFacade() {
	            return facade;
	        }
}

