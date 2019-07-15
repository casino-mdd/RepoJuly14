
package mdd.casino.jpa.entity.pojo;

public class Points{

		Integer idPoint;
		Integer idSale;
		Integer totalPoints;
		Date expDate;
		Date createdAt;
		
		//Get Set
		public void setIdPoint(Integer idPoint){
			this.idPoint=idPoint;
			  }
			 public Integer getIdPoint(){
			 	return this.idPoint;
			 }
		public void setIdSale(Integer idSale){
			this.idSale=idSale;
			  }
			 public Integer getIdSale(){
			 	return this.idSale;
			 }
		public void setTotalPoints(Integer totalPoints){
			this.totalPoints=totalPoints;
			  }
			 public Integer getTotalPoints(){
			 	return this.totalPoints;
			 }
		public void setExpDate(Date expDate){
			this.expDate=expDate;
			  }
			 public Date getExpDate(){
			 	return this.expDate;
			 }
		public void setCreatedAt(Date createdAt){
			this.createdAt=createdAt;
			  }
			 public Date getCreatedAt(){
			 	return this.createdAt;
			 }
		
}

