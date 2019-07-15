/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Directory#getName <em>Name</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Directory#getFile <em>File</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Directory#getSubdirectory <em>Subdirectory</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.Directory#getPurpose <em>Purpose</em>}</li>
 * </ul>
 *
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getDirectory()
 * @model
 * @generated
 */
public interface Directory extends AbstractFrontElement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getDirectory_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Directory#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>File</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' reference.
   * @see #setFile(File)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getDirectory_File()
   * @model
   * @generated
   */
  File getFile();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Directory#getFile <em>File</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' reference.
   * @see #getFile()
   * @generated
   */
  void setFile(File value);

  /**
   * Returns the value of the '<em><b>Subdirectory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subdirectory</em>' reference.
   * @see #setSubdirectory(Directory)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getDirectory_Subdirectory()
   * @model
   * @generated
   */
  Directory getSubdirectory();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Directory#getSubdirectory <em>Subdirectory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subdirectory</em>' reference.
   * @see #getSubdirectory()
   * @generated
   */
  void setSubdirectory(Directory value);

  /**
   * Returns the value of the '<em><b>Purpose</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Purpose</em>' attribute.
   * @see #setPurpose(String)
   * @see org.xtext.example.mydsl.myDsl.MyDslPackage#getDirectory_Purpose()
   * @model
   * @generated
   */
  String getPurpose();

  /**
   * Sets the value of the '{@link org.xtext.example.mydsl.myDsl.Directory#getPurpose <em>Purpose</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Purpose</em>' attribute.
   * @see #getPurpose()
   * @generated
   */
  void setPurpose(String value);

} // Directory
