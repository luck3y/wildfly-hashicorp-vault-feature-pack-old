/*
 * Copyright The WildFly Authors
 * SPDX-License-Identifier: Apache-2.0
 */
package org.wildfly.extension.hashicorp.vault;

import org.jboss.as.controller.ModelVersion;
import org.jboss.as.controller.ReloadRequiredWriteAttributeHandler;
import org.jboss.as.controller.SimpleAttributeDefinition;
import org.jboss.as.controller.SimpleAttributeDefinitionBuilder;
import org.jboss.as.controller.SimpleResourceDefinition;
import org.jboss.as.controller.operations.common.GenericSubsystemDescribeHandler;
import org.jboss.as.controller.registry.AttributeAccess;
import org.jboss.as.controller.registry.ManagementResourceRegistration;
import org.jboss.dmr.ModelNode;
import org.jboss.dmr.ModelType;

public class VaultSubsystemDefinition extends SimpleResourceDefinition {

    private static final String HOST="host";
    private static final String NAME="name";

    protected static final SimpleAttributeDefinition HOST_NAME =
            new SimpleAttributeDefinitionBuilder(HOST, ModelType.STRING)
                    .setRequired(false)
                    .setDefaultValue(new ModelNode("host"))
                    .setAllowExpression(true)
                    .setXmlName(NAME)
                    .setFlags(AttributeAccess.Flag.RESTART_ALL_SERVICES)
                    .build();

    protected VaultSubsystemDefinition() {
        super(VaultExtension.SUBSYSTEM_PATH,
                VaultSubsystemRegistrar.RESOLVER,
                VaultSubsystemAdd.INSTANCE,
                VaultSubsystemRemove.INSTANCE);
        setDeprecated(ModelVersion.create(3,0,0));
    }

    /**
     * {@inheritDoc}
     * Registers an add operation handler or a remove operation handler if one was provided to the constructor.
     */
    @Override
    public void registerOperations(ManagementResourceRegistration registration) {
        super.registerOperations(registration);
        registration.registerOperationHandler(GenericSubsystemDescribeHandler.DEFINITION, GenericSubsystemDescribeHandler.INSTANCE);

    }

    @Override
    public void registerAttributes(ManagementResourceRegistration resourceRegistration) {
        resourceRegistration.registerReadWriteAttribute(HOST_NAME, null, new ReloadRequiredWriteAttributeHandler(HOST_NAME));
        // other definitions here...
    }
}
