import {UserAccReducerConstants as C} from ''

const initialState = {
	  		useraccs: [],
	  	};

export default function UserAccReducer(state = initialState, action){
	switch(action.type){
		case C.SET_USERACC_LIST:
		return {
		...state,
  					useraccs: action.useraccs
		}
		default:
			return state;
  			}
	  	}

