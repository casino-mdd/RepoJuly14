import {SaleReducerConstants as C} from ''

const initialState = {
	  		sales: [],
	  	};

export default function SaleReducer(state = initialState, action){
	switch(action.type){
		case C.SET_SALE_LIST:
		return {
		...state,
  					sales: action.sales
		}
		default:
			return state;
  			}
	  	}

