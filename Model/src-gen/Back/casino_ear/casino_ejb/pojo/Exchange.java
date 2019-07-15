
package mdd.casino.jpa.entity.pojo;

public class Exchange{

		Integer idExchange;
		Integer idClient;
		Integer idReward;
		Integer idEmployee;
		Date createdAt;
		
		//Get Set
		public void setIdExchange(Integer idExchange){
			this.idExchange=idExchange;
			  }
			 public Integer getIdExchange(){
			 	return this.idExchange;
			 }
		public void setIdClient(Integer idClient){
			this.idClient=idClient;
			  }
			 public Integer getIdClient(){
			 	return this.idClient;
			 }
		public void setIdReward(Integer idReward){
			this.idReward=idReward;
			  }
			 public Integer getIdReward(){
			 	return this.idReward;
			 }
		public void setIdEmployee(Integer idEmployee){
			this.idEmployee=idEmployee;
			  }
			 public Integer getIdEmployee(){
			 	return this.idEmployee;
			 }
		public void setCreatedAt(Date createdAt){
			this.createdAt=createdAt;
			  }
			 public Date getCreatedAt(){
			 	return this.createdAt;
			 }
		
}

