import React from 'react';

class RewardForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const RewardInfo = {
				              		idReward: values.idReward
				              		idOffice: values.idOffice
				              		name: values.name
				              		pointNeed: values.pointNeed
				              		isAvailable: values.isAvailable
				};
				this.props.createReward(RewardInfo);
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
		
	export default Form.create()(RewardForm)
