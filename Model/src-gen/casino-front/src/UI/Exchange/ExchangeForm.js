import React from 'react';

class ExchangeForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const ExchangeInfo = {
				              		idExchange: values.idExchange
				              		idClient: values.idClient
				              		idReward: values.idReward
				              		idEmployee: values.idEmployee
				};
				this.props.createExchange(ExchangeInfo);
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
		
	export default Form.create()(ExchangeForm)
