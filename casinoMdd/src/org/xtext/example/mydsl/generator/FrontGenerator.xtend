package org.xtext.example.mydsl1.generator

import javax.inject.Inject
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.ArrayList
import org.xtext.example.mydsl1.myDsl.EntityName
import org.xtext.example.mydsl1.myDsl.Json
import org.xtext.example.mydsl1.myDsl.Property
import org.xtext.example.mydsl1.myDsl.GeneralEntity
import org.xtext.example.mydsl1.myDsl.Visualizer
import org.xtext.example.mydsl1.myDsl.ServiceFront

public class FrontGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

		var reactDir = "casino-front/";
		var reactSrcDirectory = reactDir + "src/";
		var entities = new ArrayList<EntityName>();

		var jsonFile = resource.allContents.filter(Json).toIterable().get(0);
		fsa.generateFile(reactDir + jsonFile.name + ".json", jsonFile.compileJsonFile);


		var visualizerComponents = resource.allContents.toIterable.filter(Visualizer);

		//var mainVisualizer = visualizerComponents.get(0);
		var customVisualizer = resource.allContents.toIterable.filter(Visualizer).get(1);
		var mainVisualizer = resource.allContents.toIterable.filter(Visualizer).get(0);
		var formVisualizer = resource.allContents.toIterable.filter(Visualizer)	.get(2);

		//var formVisualizer = visualizerComponents.get(2);

		for(v : resource.allContents.toIterable.filter(Visualizer)){
			System.out.println("Vis component" + v.name);
			if(v.name.equals("componentMainVisualizer")){
				mainVisualizer = v;
			}
			if(v.name.equals("componentCustomVisualizer")){
				customVisualizer = v;
			}
			if(v.name.equals("componentCustomCreationVisualizer")){
				formVisualizer = v;
			}
		}

		println('form visu' + formVisualizer.name)
		println('main visu' + mainVisualizer.name)
		println('custom visu' + customVisualizer.name)
		for (e : resource.allContents.toIterable.filter(EntityName))
			entities.add(e);

		fsa.generateFile(reactSrcDirectory + "/Store/Constants.js", compileConstants(entities));

		var service = resource.allContents.toIterable.filter(ServiceFront).get(0)

		for (uiComp : resource.allContents.toIterable.filter(EntityName)) {
			fsa.generateFile(reactSrcDirectory + "UI/"+ uiComp.name + "/" + uiComp.name +".js",
				compileUiComponent(uiComp, customVisualizer) );
			fsa.generateFile(
				reactSrcDirectory + "Store/Actions/" + uiComp.name + "Actions.js",
				uiComp.compileActionComponent
			);

			fsa.generateFile(
				reactSrcDirectory + "Store/Reducers/" + uiComp.name + "Reducer.js",
				uiComp.compileReducers
			);
			fsa.generateFile(
				reactSrcDirectory + "Services/" + uiComp.name + "Services.js",
				compileService(uiComp, service)
			);
			fsa.generateFile(
				reactSrcDirectory + "Containers/" + uiComp.name + "Container.js",
				uiComp.compileContainer
			);
		}

		for (uiComp : resource.allContents.toIterable.filter(GeneralEntity)) {

			/*fsa.generateFile(
				reactSrcDirectory + "UI/" + uiComp.name.name + "/" + uiComp.name.name + ".js",
				uiComp.compileUiComponent
			);*/

			fsa.generateFile(
				reactSrcDirectory + "UI/" + uiComp.name.name + "/" + uiComp.name.name + "Form.js",
				compileUiForm(uiComp, formVisualizer)
			);

		}
		fsa.generateFile(reactSrcDirectory+"index.js", compileMainVis(mainVisualizer))
		fsa.generateFile(reactSrcDirectory+"App.js", compileAppJs(mainVisualizer))
	}


 	def compileMainVis(Visualizer v)'''
		import React from 'react';
		import ReactDOM from 'react-dom';
		import {Provider} from 'react-redux';
		import {BrowserRouter} from 'react-router-dom';
		import App from './App';
		import Store from './Store/Store';
		import * as serviceWorker from './serviceWorker'
		ReactDOM.render(
		    <Provider store={Store}>
		        <BrowserRouter>
		            <App/>
		        </BrowserRouter>
		    </Provider>,
		    document.getElementById('root')
		);

		serviceWorker.unregister();
 	'''
 	def compileAppJs(Visualizer v)'''
 	import React from 'react'
 	class App extends React.Component{
 	«FOR method: v.methods»
 		«if(method.type.equals('reactRender')){
 			'''
 			«method.name»(){
 				return(<div></div>);
 			}
 			'''
 		}»
 	«ENDFOR»
 	}
 	export default App;
 	'''

	def compileUiForm(GeneralEntity e, Visualizer v) '''
		import React from 'react';

		class «e.name.name»Form extends React.Component{
			«FOR method: v.methods»

			«var i = 0»
			«var args = ""»

			«while( i < method.arguments.length){
				if(i < method.arguments.length()){
					args += method.arguments.get(i).name
				}
				else{
					args += method.arguments.get(i).name + ","
				}
				i = i+1
			}»
			«method.name»( «args» ){
				«if (method.type.equals('reactConstructor')) "super("+args+")"»
				«if (method.type.equals('reactConstructor')) "this.state={}"»
				«if (method.type.equals('reactRender')) "return(<div></div>);"»
				«if (method.type.equals('customJsMethod')){
					'''
					«args».preventDefault();

					this.props.form.validateFieldsAndScroll((err, values) => {
					if(!err){
						const «e.name.name»Info = {
						              		«FOR p : e.properties»
						              			«IF p.name !='createdAt' && p.name !='updatedAt' »
						              				«p.name»: values.«p.name»
						              			«ENDIF»
											«ENDFOR»
						};
						this.props.create«e.name.name»(«e.name.name»Info);
					}
					else{
					    ErrorMsg('Incomplete Info');
					}
				}
					'''
				} »
			}
			«ENDFOR»
			export default Form.create()(«e.name.name»Form)
	'''

	def compileUiComponent(EntityName e, Visualizer v)'''
 	import react, {Component} from 'react'

	class «e.name» extends Component{
		«FOR method: v.methods»

		«var i = 0»
		«var args = ""»

		«while( i < method.arguments.length){
			if(i < method.arguments.length()){
				args += method.arguments.get(i).name
			}
			else{
				args += method.arguments.get(i).name + ","
			}
			i = i+1
		}»

		«method.name»( «args» ){
			«if (method.type.equals('reactConstructor')) "super("+args+")"»
			«if (method.type.equals('reactConstructor')) "this.state={}"»
		}
		«ENDFOR»
	}

	return default «e.name»
	 '''

    def compileActionComponent(EntityName e)'''
	 import {«e.name»ReducerConstants as C} from ''

	 const set«e.name»s = («e.name»s) => {
	 	return {
	 		type: C.SET_«e.name.toUpperCase»S_LIST,
	 		«e.name»s
	 	}
	 }

	 export const fetch«e.name»s = () => {
	 	return dispatch => {
	 		«e.name»Services.get«e.name»List()
	 		.then(response => {
	 			dispach( set«e.name»s(response.data));
	 		})
	 		.catch(err => {

	 		})
	 	}
	 }

	 export const create«e.name» = («e.name.toLowerCase()»Info) => {
	 	return dispatch
	 }

	'''

	def compileReducers(EntityName e) '''
		import {«e.name»ReducerConstants as C} from ''

		const initialState = {
	  		«e.name.toLowerCase()»s: [],
	  	};

		export default function «e.name»Reducer(state = initialState, action){
			switch(action.type){
				case C.SET_«e.name.toUpperCase()»_LIST:
				return {
				...state,
  					«e.name.toLowerCase()»s: action.«e.name.toLowerCase»s
				}
				default:
					return state;
  			}
	  	}
	 '''

 	def compileService(EntityName e, ServiceFront service)'''
 	 import request from './RequestWrapper';

 	 «FOR request: service.requests»
		«var args = ""»
		«var isPostMethod = false»

 	 	«if (request.axiosRestMethod.equals("postMethod")){
 	 		args = request.data.name
 	 		isPostMethod = true
 	 		''
		}»
  		function «request.axiosRestMethod»«e.name»(«args»){
  			return request({
  				method: "«if(isPostMethod == true)'POST' else 'GET' »",
  				url: "«e.name»/«if(isPostMethod) 'create' + e.name else 'get'+e.name»"
  				«if(isPostMethod){
  					'data: ' + args
  				}»
  			});
  		}
 	 «ENDFOR»

 	 export default{
 	 	«FOR request: service.requests»
 	 		«request.axiosRestMethod»«e.name»,
 	 	«ENDFOR»
 	 };
 	'''

 	def compileContainer(EntityName e)'''
	 import {connect} from 'react-redux';

	 const mapStateToProps = (state) => {
	 	return {

	 	};
	 }

	 const mapDispatchToProps = (dispatch) => {
	 	return{

	 	};
	 }

	 export default connect(mapStateToProps, mapDispatchToProps)();
 	'''

 	def compileConstants(ArrayList<EntityName> entities)'''
 		«FOR e:entities»
 			export const «e.name»ReducerConstants={
 				SET_«e.name.toUpperCase»S_LIST: "SET_«e.name.toUpperCase»S_LIST"
 			};
 		«ENDFOR»

 	'''

 	def compileJsonFile(Json file)'''
	{
		"name": "casino-front",
		"version": "0.1.0",
		"private": true,
		"dependencies": {},
		"scripts": {},
		"eslintConfig": {},
		"browserslist": {}
	}
	'''
}
