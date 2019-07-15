package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.ArrayList;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.example.mydsl.myDsl.EntityName;
import org.xtext.example.mydsl.myDsl.GeneralEntity;
import org.xtext.example.mydsl.myDsl.JsMethod;
import org.xtext.example.mydsl.myDsl.Json;
import org.xtext.example.mydsl.myDsl.Property;
import org.xtext.example.mydsl.myDsl.Visualizer;

@SuppressWarnings("all")
public class FrontGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String reactDir = "casino-front/";
    String reactSrcDirectory = (reactDir + "src/");
    ArrayList<EntityName> entities = new ArrayList<EntityName>();
    Json jsonFile = ((Json[])Conversions.unwrapArray(IteratorExtensions.<Json>toIterable(Iterators.<Json>filter(resource.getAllContents(), Json.class)), Json.class))[0];
    String _name = jsonFile.getName();
    String _plus = (reactDir + _name);
    String _plus_1 = (_plus + ".json");
    fsa.generateFile(_plus_1, this.compileJsonFile(jsonFile));
    Iterable<Visualizer> visualizerComponents = Iterables.<Visualizer>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Visualizer.class);
    final Iterable<Visualizer> _converted_visualizerComponents = (Iterable<Visualizer>)visualizerComponents;
    Visualizer customVisualizer = ((Visualizer[])Conversions.unwrapArray(_converted_visualizerComponents, Visualizer.class))[1];
    for (final Visualizer v : visualizerComponents) {
      {
        QualifiedName _fullyQualifiedName = this._iQualifiedNameProvider.getFullyQualifiedName(v);
        String _plus_2 = ("Vis component" + _fullyQualifiedName);
        System.out.println(_plus_2);
        boolean _equals = this._iQualifiedNameProvider.getFullyQualifiedName(v).equals("componentCustomVisualizer");
        if (_equals) {
          customVisualizer = v;
        }
      }
    }
    Iterable<EntityName> _filter = Iterables.<EntityName>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), EntityName.class);
    for (final EntityName e : _filter) {
      entities.add(e);
    }
    fsa.generateFile((reactSrcDirectory + "/Store/Constants.js"), this.compileConstants(entities));
    Iterable<EntityName> _filter_1 = Iterables.<EntityName>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), EntityName.class);
    for (final EntityName uiComp : _filter_1) {
      {
        String _name_1 = uiComp.getName();
        String _plus_2 = ((reactSrcDirectory + "UI/") + _name_1);
        String _plus_3 = (_plus_2 + "/");
        String _name_2 = uiComp.getName();
        String _plus_4 = (_plus_3 + _name_2);
        String _plus_5 = (_plus_4 + ".js");
        fsa.generateFile(_plus_5, 
          this.compileUiComponent(uiComp, customVisualizer));
        String _name_3 = uiComp.getName();
        String _plus_6 = ((reactSrcDirectory + "Store/Actions/") + _name_3);
        String _plus_7 = (_plus_6 + "Actions.js");
        fsa.generateFile(_plus_7, 
          this.compileActionComponent(uiComp));
        String _name_4 = uiComp.getName();
        String _plus_8 = ((reactSrcDirectory + "Store/Reducers/") + _name_4);
        String _plus_9 = (_plus_8 + "Reducer.js");
        fsa.generateFile(_plus_9, 
          this.compileReducers(uiComp));
        String _name_5 = uiComp.getName();
        String _plus_10 = ((reactSrcDirectory + "Services/") + _name_5);
        String _plus_11 = (_plus_10 + "Services.js");
        fsa.generateFile(_plus_11, 
          this.compileService(uiComp));
        String _name_6 = uiComp.getName();
        String _plus_12 = ((reactSrcDirectory + "Containers/") + _name_6);
        String _plus_13 = (_plus_12 + "Container.js");
        fsa.generateFile(_plus_13, 
          this.compileContainer(uiComp));
      }
    }
    Iterable<GeneralEntity> _filter_2 = Iterables.<GeneralEntity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), GeneralEntity.class);
    for (final GeneralEntity uiComp_1 : _filter_2) {
      String _name_1 = uiComp_1.getName().getName();
      String _plus_2 = ((reactSrcDirectory + "UI/") + _name_1);
      String _plus_3 = (_plus_2 + "/");
      String _name_2 = uiComp_1.getName().getName();
      String _plus_4 = (_plus_3 + _name_2);
      String _plus_5 = (_plus_4 + "Form.js");
      fsa.generateFile(_plus_5, 
        this.compileUiForm(uiComp_1));
    }
  }
  
  public CharSequence compileUiForm(final GeneralEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import React from \'react\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class ");
    String _name = e.getName().getName();
    _builder.append(_name);
    _builder.append("Form extends React.Component{");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("constructor(props){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super(props);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("handleSubmit(e){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("e.preventDefault();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.props.form.validateFieldsAndScroll((err, values) => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("if(!err){");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("const ");
    String _name_1 = e.getName().getName();
    _builder.append(_name_1, "\t\t\t\t");
    _builder.append("Info = {");
    _builder.newLineIfNotEmpty();
    {
      EList<Property> _properties = e.getProperties();
      for(final Property p : _properties) {
        {
          if (((!Objects.equal(p.getName(), "createdAt")) && (!Objects.equal(p.getName(), "updatedAt")))) {
            _builder.append("\t\t\t\t              \t\t");
            String _name_2 = p.getName();
            _builder.append(_name_2, "\t\t\t\t              \t\t");
            _builder.append(": values.");
            String _name_3 = p.getName();
            _builder.append(_name_3, "\t\t\t\t              \t\t");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("\t\t\t\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("this.props.create");
    String _name_4 = e.getName().getName();
    _builder.append(_name_4, "\t\t\t\t");
    _builder.append("(");
    String _name_5 = e.getName().getName();
    _builder.append(_name_5, "\t\t\t\t");
    _builder.append("Info);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("else{");
    _builder.newLine();
    _builder.append("\t\t\t    ");
    _builder.append("ErrorMsg(\'Incomplete Info\');");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("render(){");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return(");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("export default Form.create()(");
    String _name_6 = e.getName().getName();
    _builder.append(_name_6, "\t");
    _builder.append("Form)");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileUiComponent(final EntityName e, final Visualizer v) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(" \t");
    _builder.append("import react, {Component} from \'react\'");
    _builder.newLine();
    _builder.append(" \t  \t");
    _builder.newLine();
    _builder.append("class ");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append(" extends Component{");
    _builder.newLineIfNotEmpty();
    {
      EList<JsMethod> _methods = v.getMethods();
      for(final JsMethod method : _methods) {
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        int i = 0;
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String args = "";
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        while ((i < ((Object[])Conversions.unwrapArray(method.getArguments(), Object.class)).length)) {
          {
            int _length = ((Object[])Conversions.unwrapArray(method.getArguments(), Object.class)).length;
            boolean _lessThan = (i < _length);
            if (_lessThan) {
              String _args = args;
              String _name_1 = method.getArguments().get(i).getName();
              args = (_args + _name_1);
            } else {
              String _args_1 = args;
              String _name_2 = method.getArguments().get(i).getName();
              String _plus = (_name_2 + ",");
              args = (_args_1 + _plus);
            }
            i = (i + 1);
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        String _name_1 = method.getName();
        _builder.append(_name_1, "\t");
        _builder.append("( ");
        _builder.append(args, "\t");
        _builder.append(" ){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("return default ");
    String _name_2 = e.getName();
    _builder.append(_name_2);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence compileActionComponent(final EntityName e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import {");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ReducerConstants as C} from \'\'");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const set");
    String _name_1 = e.getName();
    _builder.append(_name_1);
    _builder.append("s = (");
    String _name_2 = e.getName();
    _builder.append(_name_2);
    _builder.append("s) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("type: SET_C.");
    String _name_3 = e.getName();
    _builder.append(_name_3, "\t\t");
    _builder.append("S_LIST,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    String _name_4 = e.getName();
    _builder.append(_name_4, "\t\t");
    _builder.append("s");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const fetch");
    String _name_5 = e.getName();
    _builder.append(_name_5);
    _builder.append("s = () => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return dispatch => {");
    _builder.newLine();
    _builder.append("\t\t");
    String _name_6 = e.getName();
    _builder.append(_name_6, "\t\t");
    _builder.append("Services.get");
    String _name_7 = e.getName();
    _builder.append(_name_7, "\t\t");
    _builder.append("List()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append(".then(response => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("dispach( set");
    String _name_8 = e.getName();
    _builder.append(_name_8, "\t\t\t");
    _builder.append("s(response.data));");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".catch(err => {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("})");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export const create");
    String _name_9 = e.getName();
    _builder.append(_name_9);
    _builder.append(" = (");
    String _lowerCase = e.getName().toLowerCase();
    _builder.append(_lowerCase);
    _builder.append("Info) => {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return dispatch");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append(" \t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileReducers(final EntityName e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import {");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("ReducerConstants as C} from \'\'");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("const initialState = {");
    _builder.newLine();
    _builder.append("\t  \t\t");
    String _lowerCase = e.getName().toLowerCase();
    _builder.append(_lowerCase, "\t  \t\t");
    _builder.append("s: [],");
    _builder.newLineIfNotEmpty();
    _builder.append("\t  \t");
    _builder.append("};");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default function ");
    String _name_1 = e.getName();
    _builder.append(_name_1);
    _builder.append("Reducer(state = initialState, action){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("switch(action.type){");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("case C.SET_");
    String _upperCase = e.getName().toUpperCase();
    _builder.append(_upperCase, "\t\t");
    _builder.append("_LIST:");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("...state,");
    _builder.newLine();
    _builder.append("  \t\t\t\t\t");
    String _lowerCase_1 = e.getName().toLowerCase();
    _builder.append(_lowerCase_1, "  \t\t\t\t\t");
    _builder.append("s: action.");
    String _lowerCase_2 = e.getName().toLowerCase();
    _builder.append(_lowerCase_2, "  \t\t\t\t\t");
    _builder.append("s");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return state;");
    _builder.newLine();
    _builder.append("  \t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileService(final EntityName e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import request from \'./RequestWrapper\';");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function create");
    String _name = e.getName();
    _builder.append(_name);
    _builder.append("(");
    String _name_1 = e.getName();
    _builder.append(_name_1);
    _builder.append("Info){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("function get");
    String _name_2 = e.getName();
    _builder.append(_name_2);
    _builder.append("List(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("export default{");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("};");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileContainer(final EntityName e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import {} from \'\'");
    _builder.newLine();
    _builder.newLine();
    _builder.append("const mapStateToProps = (state) => {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("const mapDispatchToProps = (dispatch) => {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return{");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("};");
    _builder.newLine();
    _builder.append("} \t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("export default connect(mapStateToProps, mapDispatchToProps)();");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileConstants(final ArrayList<EntityName> entities) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final EntityName e : entities) {
        _builder.append("export const ");
        String _name = e.getName();
        _builder.append(_name);
        _builder.append("ReducerConstants={");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.newLine();
        _builder.append("};");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileJsonFile(final Json file) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"name\": \"casino-front\",");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"version\": \"0.1.0\",");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"private\": true,");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"dependencies\": {},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"scripts\": {},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"eslintConfig\": {},");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\"browserslist\": {}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
