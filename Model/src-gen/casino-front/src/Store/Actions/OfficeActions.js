import {OfficeReducerConstants as C} from ''

const setOffices = (Offices) => {
	return {
		type: SET_C.OfficeS_LIST,
		Offices
	}
}

export const fetchOffices = () => {
	return dispatch => {
		OfficeServices.getOfficeList()
		.then(response => {
			dispach( setOffices(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createOffice = (officeInfo) => {
	return dispatch
}
 	
