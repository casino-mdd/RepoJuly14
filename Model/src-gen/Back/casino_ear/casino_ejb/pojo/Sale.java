
package mdd.casino.jpa.entity.pojo;

public class Sale{

		Integer idSale;
		Integer idEmployee;
		Integer idClient;
		Integer idOffice;
		Integer token;
		Integer cost;
		String paymentMethod;
		Date createdAt;
		
		//Get Set
		public void setIdSale(Integer idSale){
			this.idSale=idSale;
			  }
			 public Integer getIdSale(){
			 	return this.idSale;
			 }
		public void setIdEmployee(Integer idEmployee){
			this.idEmployee=idEmployee;
			  }
			 public Integer getIdEmployee(){
			 	return this.idEmployee;
			 }
		public void setIdClient(Integer idClient){
			this.idClient=idClient;
			  }
			 public Integer getIdClient(){
			 	return this.idClient;
			 }
		public void setIdOffice(Integer idOffice){
			this.idOffice=idOffice;
			  }
			 public Integer getIdOffice(){
			 	return this.idOffice;
			 }
		public void setToken(Integer token){
			this.token=token;
			  }
			 public Integer getToken(){
			 	return this.token;
			 }
		public void setCost(Integer cost){
			this.cost=cost;
			  }
			 public Integer getCost(){
			 	return this.cost;
			 }
		public void setPaymentMethod(String paymentMethod){
			this.paymentMethod=paymentMethod;
			  }
			 public String getPaymentMethod(){
			 	return this.paymentMethod;
			 }
		public void setCreatedAt(Date createdAt){
			this.createdAt=createdAt;
			  }
			 public Date getCreatedAt(){
			 	return this.createdAt;
			 }
		
}

