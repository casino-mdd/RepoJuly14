/**
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl;

import org.xtext.example.mydsl.MyDslStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class MyDslStandaloneSetup extends MyDslStandaloneSetupGenerated {
  public static void doSetup() {
    new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
