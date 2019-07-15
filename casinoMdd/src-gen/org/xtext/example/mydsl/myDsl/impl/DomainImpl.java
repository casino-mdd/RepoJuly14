/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.myDsl.Domain;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.RelationDom;
import org.xtext.example.mydsl.myDsl.Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.DomainImpl#getTypes <em>Types</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.DomainImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.DomainImpl#getRelations <em>Relations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DomainImpl extends MinimalEObjectImpl.Container implements Domain
{
  /**
   * The cached value of the '{@link #getTypes() <em>Types</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTypes()
   * @generated
   * @ordered
   */
  protected EList<Type> types;

  /**
   * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModules()
   * @generated
   * @ordered
   */
  protected EList<org.xtext.example.mydsl.myDsl.Module> modules;

  /**
   * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRelations()
   * @generated
   * @ordered
   */
  protected EList<RelationDom> relations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DomainImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return MyDslPackage.Literals.DOMAIN;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Type> getTypes()
  {
    if (types == null)
    {
      types = new EObjectContainmentEList<Type>(Type.class, this, MyDslPackage.DOMAIN__TYPES);
    }
    return types;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<org.xtext.example.mydsl.myDsl.Module> getModules()
  {
    if (modules == null)
    {
      modules = new EObjectContainmentEList<org.xtext.example.mydsl.myDsl.Module>(org.xtext.example.mydsl.myDsl.Module.class, this, MyDslPackage.DOMAIN__MODULES);
    }
    return modules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<RelationDom> getRelations()
  {
    if (relations == null)
    {
      relations = new EObjectContainmentEList<RelationDom>(RelationDom.class, this, MyDslPackage.DOMAIN__RELATIONS);
    }
    return relations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN__TYPES:
        return ((InternalEList<?>)getTypes()).basicRemove(otherEnd, msgs);
      case MyDslPackage.DOMAIN__MODULES:
        return ((InternalEList<?>)getModules()).basicRemove(otherEnd, msgs);
      case MyDslPackage.DOMAIN__RELATIONS:
        return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN__TYPES:
        return getTypes();
      case MyDslPackage.DOMAIN__MODULES:
        return getModules();
      case MyDslPackage.DOMAIN__RELATIONS:
        return getRelations();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN__TYPES:
        getTypes().clear();
        getTypes().addAll((Collection<? extends Type>)newValue);
        return;
      case MyDslPackage.DOMAIN__MODULES:
        getModules().clear();
        getModules().addAll((Collection<? extends org.xtext.example.mydsl.myDsl.Module>)newValue);
        return;
      case MyDslPackage.DOMAIN__RELATIONS:
        getRelations().clear();
        getRelations().addAll((Collection<? extends RelationDom>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN__TYPES:
        getTypes().clear();
        return;
      case MyDslPackage.DOMAIN__MODULES:
        getModules().clear();
        return;
      case MyDslPackage.DOMAIN__RELATIONS:
        getRelations().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case MyDslPackage.DOMAIN__TYPES:
        return types != null && !types.isEmpty();
      case MyDslPackage.DOMAIN__MODULES:
        return modules != null && !modules.isEmpty();
      case MyDslPackage.DOMAIN__RELATIONS:
        return relations != null && !relations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //DomainImpl