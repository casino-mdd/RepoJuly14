import React from 'react';

class SaleForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const SaleInfo = {
				              		idSale: values.idSale
				              		idEmployee: values.idEmployee
				              		idClient: values.idClient
				              		idOffice: values.idOffice
				              		token: values.token
				              		cost: values.cost
				              		paymentMethod: values.paymentMethod
				};
				this.props.createSale(SaleInfo);
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
		
	export default Form.create()(SaleForm)
