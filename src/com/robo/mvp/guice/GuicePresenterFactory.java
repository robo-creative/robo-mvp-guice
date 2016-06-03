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

import com.google.inject.Injector;
import com.robo.mvp.Presenter;
import com.robo.mvp.PresenterFactory;

/**
 * Provides an implementation of {@link PresenterFactory}. Uses Guice's injector
 * to resolve presenter instances.
 * 
 * @author robo-admin.
 *
 */
public class GuicePresenterFactory implements PresenterFactory {

	private final Injector mInjector;

	public GuicePresenterFactory(Injector injector) {
		mInjector = injector;
	}

	public Presenter create(Class<? extends Presenter> presenterType) {
		return mInjector.getInstance(presenterType);
	}

}
