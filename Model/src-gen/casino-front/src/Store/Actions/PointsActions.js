import {PointsReducerConstants as C} from ''

const setPointss = (Pointss) => {
	return {
		type: SET_C.PointsS_LIST,
		Pointss
	}
}

export const fetchPointss = () => {
	return dispatch => {
		PointsServices.getPointsList()
		.then(response => {
			dispach( setPointss(response.data));
		})
		.catch(err => {
			
		})
	}
}

export const createPoints = (pointsInfo) => {
	return dispatch
}
 	
