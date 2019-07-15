/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Dom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.RelationDom#getSource <em>Source</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.RelationDom#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRelationDom()
 * @model
 * @generated
 */
public interface RelationDom extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.EntityName}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRelationDom_Source()
   * @model containment="true"
   * @generated
   */
  EList<EntityName> getSource();

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.EntityName}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRelationDom_Target()
   * @model containment="true"
   * @generated
   */
  EList<EntityName> getTarget();

} // RelationDom
