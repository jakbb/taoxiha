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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.taoxiha.common.http.client.Cookie;
import com.taoxiha.common.http.client.HttpResponseBodyPart;
import com.taoxiha.common.http.client.HttpResponseHeaders;
import com.taoxiha.common.http.client.HttpResponseStatus;
import com.taoxiha.common.http.client.providers.ResponseBase;
import com.taoxiha.common.http.netty.handler.codec.http.CookieDecoder;
import com.taoxiha.common.http.util.AsyncHttpProviderUtils;

public class JDKResponse extends ResponseBase {

    public JDKResponse(HttpResponseStatus status,
                       HttpResponseHeaders headers,
                       List<HttpResponseBodyPart> bodyParts) {
        super(status, headers, bodyParts);
    }

    /* @Override */

    public String getResponseBodyExcerpt(int maxLength) throws IOException {
        return getResponseBodyExcerpt(maxLength, DEFAULT_CHARSET);
    }

    public String getResponseBodyExcerpt(int maxLength, String charset) throws IOException {
        // should be fine; except that it may split multi-byte chars (last char may become '?')
        byte[] b = AsyncHttpProviderUtils.contentToBytes(bodyParts, maxLength);
        return new String(b, charset);
    }

    /* @Override */
    public List<Cookie> buildCookies() {
    	List<Cookie> cookies = new ArrayList<Cookie>();
        for (Map.Entry<String, List<String>> header : headers.getHeaders().entrySet()) {
            if (header.getKey().equalsIgnoreCase("Set-Cookie")) {
                // TODO: ask for parsed header
                List<String> v = header.getValue();
                for (String value : v) {
                    cookies.addAll(CookieDecoder.decode(value));
                }
            }
        }
        return Collections.unmodifiableList(cookies);
    }
}
