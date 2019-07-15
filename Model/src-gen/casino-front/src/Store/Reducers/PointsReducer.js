import {PointsReducerConstants as C} from ''

const initialState = {
	  		pointss: [],
	  	};

export default function PointsReducer(state = initialState, action){
	switch(action.type){
		case C.SET_POINTS_LIST:
		return {
		...state,
  					pointss: action.pointss
		}
		default:
			return state;
  			}
	  	}

