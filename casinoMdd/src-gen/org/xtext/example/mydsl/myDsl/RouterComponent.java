/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Router Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.RouterComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.RouterComponent#getType <em>Type</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.RouterComponent#getRoute <em>Route</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRouterComponent()
 * @model
 * @generated
 */
public interface RouterComponent extends AbstractFrontElement, UIComponent
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRouterComponent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.RouterComponent#getName <em>Name</em>}' attribute.
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
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRouterComponent_Type()
   * @model
   * @generated
   */
  AbstractFrontElement getType();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.RouterComponent#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(AbstractFrontElement value);

  /**
   * Returns the value of the '<em><b>Route</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Route</em>' reference.
   * @see #setRoute(UIComponent)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getRouterComponent_Route()
   * @model
   * @generated
   */
  UIComponent getRoute();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.RouterComponent#getRoute <em>Route</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Route</em>' reference.
   * @see #getRoute()
   * @generated
   */
  void setRoute(UIComponent value);

} // RouterComponent
