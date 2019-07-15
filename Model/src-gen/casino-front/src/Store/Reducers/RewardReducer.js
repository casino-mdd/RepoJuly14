import {RewardReducerConstants as C} from ''

const initialState = {
	  		rewards: [],
	  	};

export default function RewardReducer(state = initialState, action){
	switch(action.type){
		case C.SET_REWARD_LIST:
		return {
		...state,
  					rewards: action.rewards
		}
		default:
			return state;
  			}
	  	}

