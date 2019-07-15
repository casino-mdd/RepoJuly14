
package mdd.casino.jpa.entity.pojo;

public class Client{

		Integer idClient;
		Integer age;
		String gender;
		String name;
		String surname;
		String email;
		Integer phone;
		Integer indentificationNumber;
		Date createdAt;
		Date updatedAt;
		
		//Get Set
		public void setIdClient(Integer idClient){
			this.idClient=idClient;
			  }
			 public Integer getIdClient(){
			 	return this.idClient;
			 }
		public void setAge(Integer age){
			this.age=age;
			  }
			 public Integer getAge(){
			 	return this.age;
			 }
		public void setGender(String gender){
			this.gender=gender;
			  }
			 public String getGender(){
			 	return this.gender;
			 }
		public void setName(String name){
			this.name=name;
			  }
			 public String getName(){
			 	return this.name;
			 }
		public void setSurname(String surname){
			this.surname=surname;
			  }
			 public String getSurname(){
			 	return this.surname;
			 }
		public void setEmail(String email){
			this.email=email;
			  }
			 public String getEmail(){
			 	return this.email;
			 }
		public void setPhone(Integer phone){
			this.phone=phone;
			  }
			 public Integer getPhone(){
			 	return this.phone;
			 }
		public void setIndentificationNumber(Integer indentificationNumber){
			this.indentificationNumber=indentificationNumber;
			  }
			 public Integer getIndentificationNumber(){
			 	return this.indentificationNumber;
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

