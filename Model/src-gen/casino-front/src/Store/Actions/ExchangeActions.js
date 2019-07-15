import {ExchangeReducerConstants as C} from ''

const setExchanges = (Exchanges) => {
	return {
		type: SET_C.ExchangeS_LIST,
		Exchanges
	}
}

export const fetchExchanges = () => {
	return dispatch => {
		ExchangeServices.getExchangeList()
		.then(response => {
			dispach( setExchanges(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createExchange = (exchangeInfo) => {
	return dispatch
}
 	
