/* 
 * Copyright 2002-2009 Andy Clark, Marc Guillemot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.parser.html.sample;

import org.apache.xerces.parsers.AbstractSAXParser;

import com.taoxiha.common.parser.html.HTMLConfiguration;

/**
 * This sample shows how to extend a Xerces2 parser class, replacing
 * the default parser configuration with the NekoHTML configuration.
 *
 * @author Andy Clark
 *
 * @version $Id: HTMLSAXParser.java,v 1.3 2004/02/19 20:00:17 andyc Exp $
 */
public class HTMLSAXParser 
    extends AbstractSAXParser {

    //
    // Constructors
    //

    /** Default constructor. */
    public HTMLSAXParser() {
        super(new HTMLConfiguration());
    } // <init>()

} // class HTMLSAXParser
