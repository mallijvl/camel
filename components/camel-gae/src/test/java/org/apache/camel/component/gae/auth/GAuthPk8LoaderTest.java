/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.gae.auth;

import java.security.PrivateKey;

import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Before;
import org.junit.Test;

public class GAuthPk8LoaderTest extends CamelTestSupport {

    private GAuthPk8Loader keyLoader;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        keyLoader = new GAuthPk8Loader();
        keyLoader.setCamelContext(context);
        keyLoader.setKeyLocation("classpath:org/apache/camel/component/gae/auth/test2.pk8");
    }

    @Test
    public void testLoadPrivateKey() throws Exception {
        PrivateKey key = keyLoader.loadPrivateKey();
        assertEquals("RSA", key.getAlgorithm());
        assertEquals("PKCS#8", key.getFormat());
    }

    @Override
    public boolean isUseRouteBuilder() {
        return false;
    }
}
