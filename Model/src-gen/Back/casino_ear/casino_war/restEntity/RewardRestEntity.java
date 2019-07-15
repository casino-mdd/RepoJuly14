
package mdd.casino.rest.entity;

public class RewardRes  extends AbstractRest<Reward> {
	    @Context
	    private UriInfo context;
	    
	    RewardFacade facade = BeanUtil.lookupFacadeBean(RewardFacade.class);
	    
	       public  RewardRest() {
	            super( Reward.class);
	        }
	    
	        @Override
	        public  RewardFacade getFacade() {
	            return facade;
	        }
}

