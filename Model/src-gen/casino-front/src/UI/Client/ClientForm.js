import React from 'react';

class ClientForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const ClientInfo = {
				              		idClient: values.idClient
				              		age: values.age
				              		gender: values.gender
				              		name: values.name
				              		surname: values.surname
				              		email: values.email
				              		phone: values.phone
				              		indentificationNumber: values.indentificationNumber
				};
				this.props.createClient(ClientInfo);
			}
			else{
			    ErrorMsg('Incomplete Info');
			}
		}
		
		render(){
			
			return(
			
			);
			
		}
	}
		
	export default Form.create()(ClientForm)
