/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *  
 *   http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *  
 *******************************************************************************/
package org.apache.wink.server.internal.servlet;

import java.lang.reflect.Field;

import junit.framework.TestCase;


public class RestServletTest extends TestCase {

    /*
     * ensure relative URL starts with forward slash character
     */
    public void testReflection() throws Exception {
        RestServlet servlet = new RestServlet();
        // use "getDeclaredField" to get private fields
        Field field = servlet.getClass().getDeclaredField("PROPERTIES_DEFAULT_FILE");
        field.setAccessible(true);
        String value = (String) field.get(String.class);
       
        // TODO: review.  Some containers require a '/' on a relative path, some don't.
        // See WebSphere vs. Geronimo Tomcat 
        //
        // Tomcat appears to not be honoring its own javadoc:
        // http://tomcat.apache.org/tomcat-5.5-doc/servletapi/index.html
        //   -- see ServletContext.getResource
        assertFalse(value.startsWith("/"));
    }

    
}
