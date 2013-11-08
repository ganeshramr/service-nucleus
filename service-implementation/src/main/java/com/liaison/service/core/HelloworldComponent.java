/*
 * Copyright 2013 Netflix, Inc.
 *
 *      Licensed under the Apache License, Version 2.0 (the "License");
 *      you may not use this file except in compliance with the License.
 *      You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *      Unless required by applicable law or agreed to in writing, software
 *      distributed under the License is distributed on an "AS IS" BASIS,
 *      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *      See the License for the specific language governing permissions and
 *      limitations under the License.
 */

package com.liaison.service.core;

import com.liaison.framework.audit.AuditStatement;
import com.liaison.framework.audit.DefaultAuditStatement;
import com.liaison.framework.audit.pci.PCIV20Requirement;
import com.netflix.karyon.spi.Component;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Nitesh Kant
 *  */
@Component
public class HelloworldComponent {
	private static final Logger logger = LoggerFactory.getLogger(HelloworldComponent.class);
	
	@PostConstruct
    public void initialize() {
        // Statements added for deprecating the Initialization Servlet defined in web.xml  
    	logger.info("inside the initialize()");
    	DefaultAuditStatement audit = new DefaultAuditStatement(PCIV20Requirement.PCI10_2_6, AuditStatement.Status.SUCCEED, 
    			"Initialization via servlet");   	
    	logger.info("Servlet Init", audit);
    }
}
