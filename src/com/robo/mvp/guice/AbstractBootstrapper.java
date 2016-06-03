/**
 * Copyright (c) 2016 Robo Creative - https://robo-creative.github.io.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.robo.mvp.guice;

import java.util.Collection;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.robo.mvp.PresenterFactory;
import com.robo.navigation.ApplicationController;
import com.robo.navigation.ApplicationControllerImp;

/**
 * The base class for implementing bootstrappers which support Google Guice
 * dependency injection.
 * 
 * @author robo-admin
 *
 */
public abstract class AbstractBootstrapper extends com.robo.mvp.Bootstrapper {

	private Injector mInjector;

	@Override
	public final void start() {
		configureInjector();
		super.start();
	}

	@Override
	protected PresenterFactory createPresenterFactory() {
		return new GuicePresenterFactory(mInjector);
	}

    @Override
    protected ApplicationController createApplicationController() {
        return new ApplicationControllerImp(new GuiceCommandContainer(mInjector));
    }

    private void configureInjector() {
		Collection<AbstractModule> modules = collectModules();
		mInjector = null != modules && !modules.isEmpty() ? Guice.createInjector(modules) : Guice.createInjector();
	}

	/**
	 * When overridden in subclass, returns a collection of application modules
	 * used for registering contract-concrete binding information at application
	 * startup.
	 */
	protected abstract Collection<AbstractModule> collectModules();
}
