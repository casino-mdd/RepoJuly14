
package mdd.casino.jpa.entity.pojo;

public class Office{

		Integer idOffice;
		String name;
		String address;
		String city;
		Date createdAt;
		Date updatedAt;
		
		//Get Set
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
		public void setAddress(String address){
			this.address=address;
			  }
			 public String getAddress(){
			 	return this.address;
			 }
		public void setCity(String city){
			this.city=city;
			  }
			 public String getCity(){
			 	return this.city;
			 }
		public void setCreatedAt(Date createdAt){
			this.createdAt=createdAt;
			  }
			 public Date getCreatedAt(){
			 	return this.createdAt;
			 }
		public void setUpdatedAt(Date updatedAt){
			this.updatedAt=updatedAt;
			  }
			 public Date getUpdatedAt(){
			 	return this.updatedAt;
			 }
		
}

