import React from 'react';

class PointsForm extends React.Component{
	
	constructor(props){
		super(props);
		
	}
	
	handleSubmit(e){
		e.preventDefault();
		this.props.form.validateFieldsAndScroll((err, values) => {
			if(!err){
				const PointsInfo = {
				              		idPoint: values.idPoint
				              		idSale: values.idSale
				              		totalPoints: values.totalPoints
				              		expDate: values.expDate
				};
				this.props.createPoints(PointsInfo);
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
		
	export default Form.create()(PointsForm)
