/* 
 * Copyright 2004-2008 Andy Clark, Marc Guillemot
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

package com.taoxiha.common.parser.html;

import org.apache.xerces.xni.parser.XMLComponent;

/**
 * This interface extends the XNI <code>XMLComponent</code> interface
 * to add methods that allow the preferred default values for features
 * and properties to be queried.
 *
 * @author Andy Clark
 *
 * @version $Id: HTMLComponent.java,v 1.4 2005/02/14 03:56:54 andyc Exp $
 */
public interface HTMLComponent 
    extends XMLComponent {

    //
    // HTMLComponent methods
    //

    /** 
     * Returns the default state for a feature, or null if this
     * component does not want to report a default value for this
     * feature.
     */
    public Boolean getFeatureDefault(String featureId);

    /** 
     * Returns the default state for a property, or null if this
     * component does not want to report a default value for this
     * property. 
     */
    public Object getPropertyDefault(String propertyId);

} // interface HTMLComponent
