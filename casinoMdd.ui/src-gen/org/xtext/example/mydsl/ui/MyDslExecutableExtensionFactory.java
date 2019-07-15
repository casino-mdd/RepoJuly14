/*
 * generated by Xtext 2.18.0
 */
package org.xtext.example.mydsl.ui;

import casinoMdd.ui.internal.CasinoMddActivator;
import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MyDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(CasinoMddActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		CasinoMddActivator activator = CasinoMddActivator.getInstance();
		return activator != null ? activator.getInjector(CasinoMddActivator.ORG_XTEXT_EXAMPLE_MYDSL_MYDSL) : null;
	}

}