
package mdd.casino.jpa.entity.pojo;

public class Reward{

		Integer idReward;
		Integer idOffice;
		String name;
		Integer pointNeed;
		Boolean isAvailable;
		
		//Get Set
		public void setIdReward(Integer idReward){
			this.idReward=idReward;
			  }
			 public Integer getIdReward(){
			 	return this.idReward;
			 }
		public void setIdOffice(Integer idOffice){
			this.idOffice=idOffice;
			  }
			 public Integer getIdOffice(){
			 	return this.idOffice;
			 }
		public void setName(String name){
			this.name=name;
			  }
			 public String getName(){
			 	return this.name;
			 }
		public void setPointNeed(Integer pointNeed){
			this.pointNeed=pointNeed;
			  }
			 public Integer getPointNeed(){
			 	return this.pointNeed;
			 }
		public void setIsAvailable(Boolean isAvailable){
			this.isAvailable=isAvailable;
			  }
			 public Boolean getIsAvailable(){
			 	return this.isAvailable;
			 }
		
}

