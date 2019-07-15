import {UserAccReducerConstants as C} from ''

const setUserAccs = (UserAccs) => {
	return {
		type: SET_C.UserAccS_LIST,
		UserAccs
	}
}

export const fetchUserAccs = () => {
	return dispatch => {
		UserAccServices.getUserAccList()
		.then(response => {
			dispach( setUserAccs(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createUserAcc = (useraccInfo) => {
	return dispatch
}
 	
