/*
 * Copyright (c) 2010-2012 Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package com.taoxiha.common.http.client.providers.jdk;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.taoxiha.common.http.client.AsyncHttpProviderConfig;

public class JDKAsyncHttpProviderConfig implements AsyncHttpProviderConfig<String, String> {

    public static final String FORCE_RESPONSE_BUFFERING = "bufferResponseInMemory";

    private final ConcurrentHashMap<String, String> properties = new ConcurrentHashMap<String, String>();

    @Override
    public JDKAsyncHttpProviderConfig addProperty(String name, String value) {
        properties.put(name, value);
        return this;
    }

    public String getProperty(String name) {
        return properties.get(name);
    }

    public String removeProperty(String name) {
        return properties.remove(name);
    }

    public Set<Map.Entry<String, String>> propertiesSet() {
        return properties.entrySet();
    }
}
