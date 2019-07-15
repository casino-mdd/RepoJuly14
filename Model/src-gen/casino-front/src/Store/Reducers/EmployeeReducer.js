import {EmployeeReducerConstants as C} from ''

const initialState = {
	  		employees: [],
	  	};

export default function EmployeeReducer(state = initialState, action){
	switch(action.type){
		case C.SET_EMPLOYEE_LIST:
		return {
		...state,
  					employees: action.employees
		}
		default:
			return state;
  			}
	  	}

