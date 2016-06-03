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
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.robo.navigation.Command;
import com.robo.navigation.CommandContainer;

/**
 * Uses Guice injector to resolve commands.
 *
 * @author robo-admin
 */
public class GuiceCommandContainer implements CommandContainer {

    private Injector mInjector;

    public GuiceCommandContainer(Injector injector) {
        mInjector = injector;
    }

    @Override
    public <T> Command<T> resolve(Class<? extends Command<T>> contract) {
        return mInjector.getInstance(contract);
    }

    @Override
    public <T> Command<T> resolve(Class<? extends Command<T>> contract, String name) {
        return mInjector.getInstance(Key.get(contract, Names.named(name)));
    }
}
