/*
 * Copyright 2006-2017 the original author or authors.
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

package com.consol.citrus.simulator.annotation;

import com.consol.citrus.simulator.config.SimulatorConfigurationProperties;
import com.consol.citrus.simulator.mapper.ContentBasedXPathScenarioMapper;
import com.consol.citrus.simulator.mapper.ScenarioMapper;
import org.springframework.jms.connection.SingleConnectionFactory;

import javax.jms.ConnectionFactory;

/**
 * @author Christoph Deppisch
 */
public abstract class SimulatorJmsAdapter implements SimulatorJmsConfigurer {

    @Override
    public ConnectionFactory connectionFactory() {
        return new SingleConnectionFactory();
    }

    @Override
    public String inboundDestination(SimulatorJmsConfigurationProperties simulatorJmsConfiguration) {
        return simulatorJmsConfiguration.getInboundDestination();
    }

    @Override
    public String replyDestination(SimulatorJmsConfigurationProperties simulatorJmsConfiguration) {
        return simulatorJmsConfiguration.getReplyDestination();
    }

    @Override
    public boolean useSoap(SimulatorJmsConfigurationProperties simulatorJmsConfiguration) {
        return simulatorJmsConfiguration.isUseSoap();
    }

    @Override
    public boolean synchronous(SimulatorJmsConfigurationProperties simulatorJmsConfiguration) {
        return simulatorJmsConfiguration.isSynchronous();
    }

    @Override
    public ScenarioMapper scenarioMapper() {
        return new ContentBasedXPathScenarioMapper().addXPathExpression("local-name(/*)");
    }

    @Override
    public Long exceptionDelay(SimulatorConfigurationProperties simulatorConfiguration) {
        return simulatorConfiguration.getExceptionDelay();
    }
}