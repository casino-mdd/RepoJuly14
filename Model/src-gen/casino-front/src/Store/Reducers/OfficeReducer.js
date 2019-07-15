import {OfficeReducerConstants as C} from ''

const initialState = {
	  		offices: [],
	  	};

export default function OfficeReducer(state = initialState, action){
	switch(action.type){
		case C.SET_OFFICE_LIST:
		return {
		...state,
  					offices: action.offices
		}
		default:
			return state;
  			}
	  	}

