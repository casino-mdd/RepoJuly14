package org.xtext.example.mydsl.generator

import javax.inject.Inject
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.ArrayList
import org.xtext.example.mydsl.myDsl.EntityName
import org.xtext.example.mydsl.myDsl.Json
import org.xtext.example.mydsl.myDsl.Property
import org.xtext.example.mydsl.myDsl.GeneralEntity
import org.xtext.example.mydsl.myDsl.Visualizer

public class FrontGenerator extends AbstractGenerator {
	
	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

		var reactDir = "casino-front/";
		var reactSrcDirectory = reactDir + "src/";
		var entities = new ArrayList<EntityName>();

		var jsonFile = resource.allContents.filter(Json).toIterable().get(0);
		fsa.generateFile(reactDir + jsonFile.name + ".json", jsonFile.compileJsonFile);


		var visualizerComponents = resource.allContents.toIterable.filter(Visualizer);
		var customVisualizer = visualizerComponents.get(1);
		
		for(v : visualizerComponents){
			System.out.println("Vis component" + v.fullyQualifiedName);
			if(v.fullyQualifiedName.equals("componentCustomVisualizer")){
				customVisualizer = v;	
			}
		}
		
		for (e : resource.allContents.toIterable.filter(EntityName))
			entities.add(e);

		fsa.generateFile(reactSrcDirectory + "/Store/Constants.js", compileConstants(entities));

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
				uiComp.compileService
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
				uiComp.compileUiForm
			);

		}

	}
	 
	def compileUiForm(GeneralEntity e) '''
		import React from 'react';
		
		class «e.name.name»Form extends React.Component{
			
			constructor(props){
				super(props);
				
			}
			
			handleSubmit(e){
				e.preventDefault();
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
				
				render(){
					
					return(
					
					);
					
				}
			}
				
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
			
		}
		«ENDFOR»
	}
	
	return default «e.name»
	 '''
	 
    def compileActionComponent(EntityName e)'''
	 import {«e.name»ReducerConstants as C} from ''
	 
	 const set«e.name»s = («e.name»s) => {
	 	return {
	 		type: SET_C.«e.name»S_LIST,
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
	 
 	def compileService(EntityName e)'''
 	 import request from './RequestWrapper';
 	 
 	 function create«e.name»(«e.name»Info){
 	 	
 	 }
 	 
 	 function get«e.name»List(){
 	 	
 	 }
 	 export default{
 	 	
 	 };
 	''' 
 	
 	def compileContainer(EntityName e)'''
	 import {} from ''
	 
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