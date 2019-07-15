import React from 'react';

class EmployeeForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const EmployeeInfo = {
				              		idEmployee: values.idEmployee
				              		age: values.age
				              		gender: values.gender
				              		name: values.name
				              		surname: values.surname
				              		email: values.email
				              		phone: values.phone
				              		indentificationNumber: values.indentificationNumber
				              		idOffice: values.idOffice
				              		position: values.position
				              		admitionDate: values.admitionDate
				};
				this.props.createEmployee(EmployeeInfo);
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
		
	export default Form.create()(EmployeeForm)
