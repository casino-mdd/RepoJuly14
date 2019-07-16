package org.xtext.example.mydsl.generator;

import com.google.common.collect.Iterables;
import javax.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.myDsl.Component;
import org.xtext.example.mydsl.myDsl.Epackage;
import org.xtext.example.mydsl.myDsl.JeeProject;
import org.xtext.example.mydsl.myDsl.Layer;
import org.xtext.example.mydsl.myDsl.LayerSegment;
import org.xtext.example.mydsl.myDsl.Property;
import org.xtext.example.mydsl.myDsl.SpecialEntity;
import org.xtext.example.mydsl.myDsl.Subproject;

@SuppressWarnings("all")
public class SpecialEntityGenerator extends AbstractGenerator {
  @Inject
  @Extension
  private IQualifiedNameProvider _iQualifiedNameProvider;
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Component> _filter = Iterables.<Component>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Component.class);
    for (final Component com : _filter) {
      boolean _equals = com.getName().equals("Back");
      if (_equals) {
        EList<Layer> _layer = com.getLayer();
        for (final Layer layer : _layer) {
          if ((layer.getName().equals("Ejb") || layer.getName().equals("War"))) {
            EList<LayerSegment> _layerSegments = layer.getLayerSegments();
            for (final LayerSegment layerS : _layerSegments) {
              Iterable<SpecialEntity> _filter_1 = Iterables.<SpecialEntity>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), SpecialEntity.class);
              for (final SpecialEntity en : _filter_1) {
                Iterable<JeeProject> _filter_2 = Iterables.<JeeProject>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), JeeProject.class);
                for (final JeeProject jee : _filter_2) {
                  EList<Subproject> _subproject = jee.getSubproject();
                  for (final Subproject subp : _subproject) {
                    EList<Epackage> _epackage = subp.getEpackage();
                    for (final Epackage pck : _epackage) {
                      boolean _equals_1 = StringExtensions.toFirstUpper(pck.getName()).equals(layerS.getName());
                      if (_equals_1) {
                        String _name = com.getName();
                        String _plus = (_name + "/");
                        String _name_1 = jee.getName();
                        String _plus_1 = (_plus + _name_1);
                        String _plus_2 = (_plus_1 + "/");
                        String _name_2 = subp.getName();
                        String _plus_3 = (_plus_2 + _name_2);
                        String _plus_4 = (_plus_3 + "/");
                        String _name_3 = pck.getName();
                        String path = (_plus_4 + _name_3);
                        this.selectCompile(path, en, layerS, pck, fsa);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void selectCompile(final String path, final SpecialEntity en, final LayerSegment layerS, final Epackage pck, final IFileSystemAccess2 fsa) {
    boolean _equals = pck.getName().equals("facade");
    if (_equals) {
      String _name = en.getName().getName();
      String _plus = ((path + "/") + _name);
      String _name_1 = layerS.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + ".java");
      fsa.generateFile(_plus_2, this.compileFacade(en));
    }
    boolean _equals_1 = pck.getName().equals("dto");
    if (_equals_1) {
      String _name_2 = en.getName().getName();
      String _plus_3 = ((path + "/") + _name_2);
      String _name_3 = layerS.getName();
      String _plus_4 = (_plus_3 + _name_3);
      String _plus_5 = (_plus_4 + ".java");
      fsa.generateFile(_plus_5, this.compileDto(en));
    }
    boolean _equals_2 = pck.getName().equals("restEntity");
    if (_equals_2) {
      String _name_4 = en.getName().getName();
      String _plus_6 = ((path + "/") + _name_4);
      String _name_5 = layerS.getName();
      String _plus_7 = (_plus_6 + _name_5);
      String _plus_8 = (_plus_7 + ".java");
      fsa.generateFile(_plus_8, this.compileRest(en));
    }
    boolean _equals_3 = pck.getName().equals("pojo");
    if (_equals_3) {
      String _name_6 = en.getName().getName();
      String _plus_9 = ((path + "/") + _name_6);
      String _plus_10 = (_plus_9 + ".java");
      fsa.generateFile(_plus_10, this.compilePojo(en));
    }
  }
  
  public String typeJava(final String type) {
    boolean _equals = type.equals("Num");
    if (_equals) {
      return "Integer";
    }
    return type;
  }
  
  public CharSequence compilePojo(final SpecialEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("package mdd.casino.jpa.entity.pojo;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName().getName();
    _builder.append(_name);
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Property> _properties = e.getProperties();
      for(final Property p : _properties) {
        _builder.append("\t\t");
        String _typeJava = this.typeJava(p.getType().getName());
        _builder.append(_typeJava, "\t\t");
        _builder.append(" ");
        String _name_1 = p.getName();
        _builder.append(_name_1, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//Get Set");
    _builder.newLine();
    {
      EList<Property> _properties_1 = e.getProperties();
      for(final Property p_1 : _properties_1) {
        _builder.append("\t\t");
        _builder.append("public void set");
        String _firstUpper = StringExtensions.toFirstUpper(p_1.getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append("(");
        String _typeJava_1 = this.typeJava(p_1.getType().getName());
        _builder.append(_typeJava_1, "\t\t");
        _builder.append(" ");
        String _name_2 = p_1.getName();
        _builder.append(_name_2, "\t\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t");
        _builder.append("this.");
        String _name_3 = p_1.getName();
        _builder.append(_name_3, "\t\t\t");
        _builder.append("=");
        String _name_4 = p_1.getName();
        _builder.append(_name_4, "\t\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t\t");
        _builder.append("\t ");
        _builder.append("public ");
        String _typeJava_2 = this.typeJava(p_1.getType().getName());
        _builder.append(_typeJava_2, "\t\t\t ");
        _builder.append(" get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p_1.getName());
        _builder.append(_firstUpper_1, "\t\t\t ");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t \t");
        _builder.append("return this.");
        String _name_5 = p_1.getName();
        _builder.append(_name_5, "\t\t\t \t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t");
        _builder.append("\t ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileDto(final SpecialEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("package mdd.casino.jpa.entity.dto;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName().getName();
    _builder.append(_name);
    _builder.append("Dto {");
    _builder.newLineIfNotEmpty();
    {
      EList<Property> _properties = e.getProperties();
      for(final Property p : _properties) {
        _builder.append("\t");
        _builder.append("private ");
        String _typeJava = this.typeJava(p.getType().getName());
        _builder.append(_typeJava, "\t");
        _builder.append(" ");
        String _name_1 = p.getName();
        _builder.append(_name_1, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t\t\t");
    _builder.newLine();
    {
      EList<Property> _properties_1 = e.getProperties();
      for(final Property p_1 : _properties_1) {
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper = StringExtensions.toFirstUpper(p_1.getName());
        _builder.append(_firstUpper, "\t");
        _builder.append("(");
        String _typeJava_1 = this.typeJava(p_1.getType().getName());
        _builder.append(_typeJava_1, "\t");
        _builder.append(" ");
        String _name_2 = p_1.getName();
        _builder.append(_name_2, "\t");
        _builder.append("){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        String _name_3 = p_1.getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("=");
        String _name_4 = p_1.getName();
        _builder.append(_name_4, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t  ");
        _builder.append("}");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("\t ");
        _builder.append("public ");
        String _typeJava_2 = this.typeJava(p_1.getType().getName());
        _builder.append(_typeJava_2, "\t\t ");
        _builder.append(" get");
        String _firstUpper_1 = StringExtensions.toFirstUpper(p_1.getName());
        _builder.append(_firstUpper_1, "\t\t ");
        _builder.append("(){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t \t");
        _builder.append("return this.");
        String _name_5 = p_1.getName();
        _builder.append(_name_5, "\t\t \t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileRest(final SpecialEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("package mdd.casino.rest.entity;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _name = e.getName().getName();
    _builder.append(_name);
    _builder.append("Res  extends AbstractRest<");
    String _name_1 = e.getName().getName();
    _builder.append(_name_1);
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("@Context");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("private UriInfo context;");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.newLine();
    _builder.append("\t    ");
    String _name_2 = e.getName().getName();
    _builder.append(_name_2, "\t    ");
    _builder.append("Facade facade = BeanUtil.lookupFacadeBean(");
    String _name_3 = e.getName().getName();
    _builder.append(_name_3, "\t    ");
    _builder.append("Facade.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.newLine();
    _builder.append("\t       ");
    _builder.append("public  ");
    String _name_4 = e.getName().getName();
    _builder.append(_name_4, "\t       ");
    _builder.append("Rest() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t            ");
    _builder.append("super( ");
    String _name_5 = e.getName().getName();
    _builder.append(_name_5, "\t            ");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("public  ");
    String _name_6 = e.getName().getName();
    _builder.append(_name_6, "\t        ");
    _builder.append("Facade getFacade() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t            ");
    _builder.append("return facade;");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence compileFacade(final SpecialEntity e) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("package mdd.casino.jpa.entity.facade;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import javax.ejb.Stateless;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManager;");
    _builder.newLine();
    _builder.append("import javax.persistence.EntityManagerFactory;");
    _builder.newLine();
    _builder.append("import javax.persistence.PersistenceUnit;");
    _builder.newLine();
    _builder.append("import mdd.casino.jpa.entity.pojo.");
    String _name = e.getName().getName();
    _builder.append(_name);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("@Stateless");
    _builder.newLine();
    _builder.append("public class ");
    String _name_1 = e.getName().getName();
    _builder.append(_name_1);
    _builder.append("Facade extends AbtractFacade{");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@PersistenceUnit");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("private EntityManagerFactory emf;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("@Override");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("protected EntityManager getEntityManager() {");
    _builder.newLine();
    _builder.append("\t        ");
    _builder.append("return emf.createEntityManager();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("public ");
    String _name_2 = e.getName().getName();
    _builder.append(_name_2, "\t    ");
    _builder.append("Facade() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t        ");
    _builder.append("super(");
    String _name_3 = e.getName().getName();
    _builder.append(_name_3, "\t        ");
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}\t");
    _builder.newLine();
    return _builder;
  }
}
