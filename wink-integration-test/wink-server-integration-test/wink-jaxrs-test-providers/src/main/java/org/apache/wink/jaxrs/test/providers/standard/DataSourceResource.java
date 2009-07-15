/*
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
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.wink.jaxrs.test.providers.standard;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("providers/standard/datasource")
public class DataSourceResource {

    private DataSource ds = null;

    @GET
    public Response getDataSource() {
        return Response.ok(ds).build();
    }

    @POST
    public DataSource postDataSource(DataSource ds) {
        return ds;
    }

    @PUT
    public void putDataSource(DataSource ds) {
        this.ds = ds;
    }

    @POST
    @Path("subclass/should/fail")
    public DataSource postDataSource(FileDataSource ds) {
        return ds;
    }
}