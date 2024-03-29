/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.LayerSegment#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.LayerSegment#getRelations <em>Relations</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.LayerSegment#getSublayerSegments <em>Sublayer Segments</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getLayerSegment()
 * @model
 * @generated
 */
public interface LayerSegment extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getLayerSegment_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.LayerSegment#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.LayerSegmentRelation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Relations</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getLayerSegment_Relations()
   * @model containment="true"
   * @generated
   */
  EList<LayerSegmentRelation> getRelations();

  /**
   * Returns the value of the '<em><b>Sublayer Segments</b></em>' containment reference list.
   * The list contents are of type {@link org.xtext.example.mydsl.myDsl.SublayerSegment}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sublayer Segments</em>' containment reference list.
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getLayerSegment_SublayerSegments()
   * @model containment="true"
   * @generated
   */
  EList<SublayerSegment> getSublayerSegments();

} // LayerSegment
