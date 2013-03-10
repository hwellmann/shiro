/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package org.apache.shiro.cdi.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import javax.enterprise.inject.spi.BeanManager;

import org.apache.shiro.cdi.impl.BeanManagerProvider;
import org.apache.webbeans.cditest.CdiTestContainer;
import org.apache.webbeans.cditest.CdiTestContainerLoader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BeanManagerProviderTest {
    private static CdiTestContainer container;

    @BeforeClass
    public static void start() throws Exception {
        container = CdiTestContainerLoader.getCdiContainer();
        container.bootContainer();
    }

    @AfterClass
    public static void close() throws Exception {
        container.shutdownContainer();
    }

    @Test
    public void findBeanManagerWithoutJndi() {
        BeanManager beanManager = container.getBeanManager();
        BeanManagerProvider.setBeanManager(beanManager);
        assertThat(BeanManagerProvider.getBeanManager(), is(sameInstance(beanManager)));
    }
}
