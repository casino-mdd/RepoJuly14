import {EmployeeReducerConstants as C} from ''

const setEmployees = (Employees) => {
	return {
		type: SET_C.EmployeeS_LIST,
		Employees
	}
}

export const fetchEmployees = () => {
	return dispatch => {
		EmployeeServices.getEmployeeList()
		.then(response => {
			dispach( setEmployees(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createEmployee = (employeeInfo) => {
	return dispatch
}
 	
