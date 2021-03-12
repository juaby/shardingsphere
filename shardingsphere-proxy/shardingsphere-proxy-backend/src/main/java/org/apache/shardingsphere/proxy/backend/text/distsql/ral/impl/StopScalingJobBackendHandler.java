/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.proxy.backend.text.distsql.ral.impl;

import org.apache.shardingsphere.distsql.parser.statement.ral.impl.StopScalingJobStatement;
import org.apache.shardingsphere.proxy.backend.response.header.ResponseHeader;
import org.apache.shardingsphere.proxy.backend.response.header.update.UpdateResponseHeader;
import org.apache.shardingsphere.proxy.backend.text.AbstractBackendHandler;
import org.apache.shardingsphere.scaling.core.api.ScalingAPI;
import org.apache.shardingsphere.scaling.core.api.ScalingAPIFactory;

/**
 * Stop scaling job backend handler.
 */
public final class StopScalingJobBackendHandler extends AbstractBackendHandler<StopScalingJobStatement> {
    
    private final ScalingAPI scalingAPI = ScalingAPIFactory.getScalingAPI();

    public StopScalingJobBackendHandler(final StopScalingJobStatement sqlStatement) {
        super(sqlStatement, "");
    }

    @Override
    protected ResponseHeader execute(final String schemaName, final StopScalingJobStatement sqlStatement) {
        scalingAPI.stop(sqlStatement.getJobId());
        return new UpdateResponseHeader(sqlStatement);
    }
}