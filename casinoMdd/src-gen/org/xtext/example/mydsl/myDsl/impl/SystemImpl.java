/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.myDsl.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.xtext.example.mydsl.myDsl.Architecture;
import org.xtext.example.mydsl.myDsl.Domain;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.Technology;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SystemImpl#getDom <em>Dom</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SystemImpl#getArch <em>Arch</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.myDsl.impl.SystemImpl#getTech <em>Tech</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends MinimalEObjectImpl.Container implements org.xtext.example.mydsl.myDsl.System
{
  /**
   * The cached value of the '{@link #getDom() <em>Dom</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDom()
   * @generated
   * @ordered
   */
  protected Domain dom;

  /**
   * The cached value of the '{@link #getArch() <em>Arch</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArch()
   * @generated
   * @ordered
   */
  protected Architecture arch;

  /**
   * The cached value of the '{@link #getTech() <em>Tech</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTech()
   * @generated
   * @ordered
   */
  protected Technology tech;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SystemImpl()
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
    return MyDslPackage.Literals.SYSTEM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Domain getDom()
  {
    return dom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDom(Domain newDom, NotificationChain msgs)
  {
    Domain oldDom = dom;
    dom = newDom;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__DOM, oldDom, newDom);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDom(Domain newDom)
  {
    if (newDom != dom)
    {
      NotificationChain msgs = null;
      if (dom != null)
        msgs = ((InternalEObject)dom).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__DOM, null, msgs);
      if (newDom != null)
        msgs = ((InternalEObject)newDom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__DOM, null, msgs);
      msgs = basicSetDom(newDom, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__DOM, newDom, newDom));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Architecture getArch()
  {
    return arch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetArch(Architecture newArch, NotificationChain msgs)
  {
    Architecture oldArch = arch;
    arch = newArch;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__ARCH, oldArch, newArch);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setArch(Architecture newArch)
  {
    if (newArch != arch)
    {
      NotificationChain msgs = null;
      if (arch != null)
        msgs = ((InternalEObject)arch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__ARCH, null, msgs);
      if (newArch != null)
        msgs = ((InternalEObject)newArch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__ARCH, null, msgs);
      msgs = basicSetArch(newArch, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__ARCH, newArch, newArch));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Technology getTech()
  {
    return tech;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTech(Technology newTech, NotificationChain msgs)
  {
    Technology oldTech = tech;
    tech = newTech;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__TECH, oldTech, newTech);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTech(Technology newTech)
  {
    if (newTech != tech)
    {
      NotificationChain msgs = null;
      if (tech != null)
        msgs = ((InternalEObject)tech).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__TECH, null, msgs);
      if (newTech != null)
        msgs = ((InternalEObject)newTech).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MyDslPackage.SYSTEM__TECH, null, msgs);
      msgs = basicSetTech(newTech, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MyDslPackage.SYSTEM__TECH, newTech, newTech));
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
      case MyDslPackage.SYSTEM__DOM:
        return basicSetDom(null, msgs);
      case MyDslPackage.SYSTEM__ARCH:
        return basicSetArch(null, msgs);
      case MyDslPackage.SYSTEM__TECH:
        return basicSetTech(null, msgs);
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
      case MyDslPackage.SYSTEM__DOM:
        return getDom();
      case MyDslPackage.SYSTEM__ARCH:
        return getArch();
      case MyDslPackage.SYSTEM__TECH:
        return getTech();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case MyDslPackage.SYSTEM__DOM:
        setDom((Domain)newValue);
        return;
      case MyDslPackage.SYSTEM__ARCH:
        setArch((Architecture)newValue);
        return;
      case MyDslPackage.SYSTEM__TECH:
        setTech((Technology)newValue);
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
      case MyDslPackage.SYSTEM__DOM:
        setDom((Domain)null);
        return;
      case MyDslPackage.SYSTEM__ARCH:
        setArch((Architecture)null);
        return;
      case MyDslPackage.SYSTEM__TECH:
        setTech((Technology)null);
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
      case MyDslPackage.SYSTEM__DOM:
        return dom != null;
      case MyDslPackage.SYSTEM__ARCH:
        return arch != null;
      case MyDslPackage.SYSTEM__TECH:
        return tech != null;
    }
    return super.eIsSet(featureID);
  }

} //SystemImpl
