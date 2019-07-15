/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Front</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.ServiceFront#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.ServiceFront#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.ServiceFront#getMethod <em>Method</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.ServiceFront#getRequests <em>Requests</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getServiceFront()
 * @model
 * @generated
 */
public interface ServiceFront extends AbstractFrontElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getServiceFront_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.ServiceFront#getName <em>Name</em>}' attribute.
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
   * @see #setType(JsModule)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getServiceFront_Type()
   * @model
   * @generated
   */
  JsModule getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.ServiceFront#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JsModule value);

  /**
   * Returns the value of the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method</em>' attribute.
   * @see #setMethod(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getServiceFront_Method()
   * @model
   * @generated
   */
  String getMethod();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.ServiceFront#getMethod <em>Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method</em>' attribute.
   * @see #getMethod()
   * @generated
   */
  void setMethod(String value);

  /**
   * Returns the value of the '<em><b>Requests</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.AxiosRequest}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Requests</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getServiceFront_Requests()
   * @model containment="true"
   * @generated
   */
  EList<AxiosRequest> getRequests();

} // ServiceFront
