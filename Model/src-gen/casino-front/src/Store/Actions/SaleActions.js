import {SaleReducerConstants as C} from ''

const setSales = (Sales) => {
	return {
		type: SET_C.SaleS_LIST,
		Sales
	}
}

export const fetchSales = () => {
	return dispatch => {
		SaleServices.getSaleList()
		.then(response => {
			dispach( setSales(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createSale = (saleInfo) => {
	return dispatch
}
 	
