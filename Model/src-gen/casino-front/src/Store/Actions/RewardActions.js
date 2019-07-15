import {RewardReducerConstants as C} from ''

const setRewards = (Rewards) => {
	return {
		type: SET_C.RewardS_LIST,
		Rewards
	}
}

export const fetchRewards = () => {
	return dispatch => {
		RewardServices.getRewardList()
		.then(response => {
			dispach( setRewards(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createReward = (rewardInfo) => {
	return dispatch
}
 	
