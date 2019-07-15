import {ClientReducerConstants as C} from ''

const setClients = (Clients) => {
	return {
		type: SET_C.ClientS_LIST,
		Clients
	}
}

export const fetchClients = () => {
	return dispatch => {
		ClientServices.getClientList()
		.then(response => {
			dispach( setClients(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createClient = (clientInfo) => {
	return dispatch
}
 	
