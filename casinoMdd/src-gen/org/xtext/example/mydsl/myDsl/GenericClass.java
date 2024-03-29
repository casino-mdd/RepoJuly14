/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.GenericClass#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.GenericClass#getMethodClass <em>Method Class</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.GenericClass#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.GenericClass#getAbs <em>Abs</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.GenericClass#getImp <em>Imp</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass()
 * @model
 * @generated
 */
public interface GenericClass extends Eclass
{
  /**
   * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.Attribute}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attribute</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass_Attribute()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttribute();

  /**
   * Returns the value of the '<em><b>Method Class</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.MethodBack}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Class</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass_MethodClass()
   * @model containment="true"
   * @generated
   */
  EList<MethodBack> getMethodClass();

  /**
   * Returns the value of the '<em><b>Annotation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation</em>' reference.
   * @see #setAnnotation(Annotation)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass_Annotation()
   * @model
   * @generated
   */
  Annotation getAnnotation();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.GenericClass#getAnnotation <em>Annotation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation</em>' reference.
   * @see #getAnnotation()
   * @generated
   */
  void setAnnotation(Annotation value);

  /**
   * Returns the value of the '<em><b>Abs</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Abs</em>' reference.
   * @see #setAbs(AbstractClass)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass_Abs()
   * @model
   * @generated
   */
  AbstractClass getAbs();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.GenericClass#getAbs <em>Abs</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Abs</em>' reference.
   * @see #getAbs()
   * @generated
   */
  void setAbs(AbstractClass value);

  /**
   * Returns the value of the '<em><b>Imp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imp</em>' reference.
   * @see #setImp(Einterface)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getGenericClass_Imp()
   * @model
   * @generated
   */
  Einterface getImp();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.GenericClass#getImp <em>Imp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imp</em>' reference.
   * @see #getImp()
   * @generated
   */
  void setImp(Einterface value);

} // GenericClass
