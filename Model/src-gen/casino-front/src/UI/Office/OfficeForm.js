import React from 'react';

class OfficeForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const OfficeInfo = {
				              		idOffice: values.idOffice
				              		name: values.name
				              		address: values.address
				              		city: values.city
				};
				this.props.createOffice(OfficeInfo);
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
		
	export default Form.create()(OfficeForm)
