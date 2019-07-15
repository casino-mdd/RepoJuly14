/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visualizer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Visualizer#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Visualizer#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Visualizer#getMethods <em>Methods</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVisualizer()
 * @model
 * @generated
 */
public interface Visualizer extends AbstractFrontElement, UIComponent
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVisualizer_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Visualizer#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(AbstractFrontElement)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVisualizer_Type()
   * @model
   * @generated
   */
  AbstractFrontElement getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Visualizer#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(AbstractFrontElement value);

  /**
   * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.JsMethod}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Methods</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getVisualizer_Methods()
   * @model containment="true"
   * @generated
   */
  EList<JsMethod> getMethods();

} // Visualizer