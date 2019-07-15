import {ClientReducerConstants as C} from ''

const initialState = {
	  		clients: [],
	  	};

export default function ClientReducer(state = initialState, action){
	switch(action.type){
		case C.SET_CLIENT_LIST:
		return {
		...state,
  					clients: action.clients
		}
		default:
			return state;
  			}
	  	}

