import {ExchangeReducerConstants as C} from ''

const initialState = {
	  		exchanges: [],
	  	};

export default function ExchangeReducer(state = initialState, action){
	switch(action.type){
		case C.SET_EXCHANGE_LIST:
		return {
		...state,
  					exchanges: action.exchanges
		}
		default:
			return state;
  			}
	  	}

