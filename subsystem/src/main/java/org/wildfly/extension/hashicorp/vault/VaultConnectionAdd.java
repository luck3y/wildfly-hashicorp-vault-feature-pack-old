package org.wildfly.extension.hashicorp.vault;

import org.jboss.as.controller.AbstractAddStepHandler;
import org.jboss.as.controller.OperationContext;
import org.jboss.as.controller.OperationFailedException;
import org.jboss.dmr.ModelNode;

public class VaultConnectionAdd extends AbstractAddStepHandler {

    public static final VaultConnectionAdd INSTANCE = new VaultConnectionAdd();

    @Override
    protected void performRuntime(OperationContext context, ModelNode operation, ModelNode model)
            throws OperationFailedException {
        
        // TODO: create vault connections here:

        final String name = context.getCurrentAddressValue();
        final String hostname = VaultSubsystemDefinition.HOST_NAME_DEF.resolveModelAttribute(context, model).asString();
        final String auth_method = VaultSubsystemDefinition.HOST_NAME_DEF.resolveModelAttribute(context, model).asString();
        final boolean tls_verify = VaultSubsystemDefinition.TLS_VERIFY_DEF.resolveModelAttribute(context, model).asBoolean();
        final String namespace = VaultSubsystemDefinition.HOST_NAME_DEF.resolveModelAttribute(context, model).asString();
        final String token = VaultSubsystemDefinition.TOKEN_DEF.resolveModelAttribute(context, model).asStringOrNull();

        // create the resource / service here:
        // example something like: VaultService vaultService = new VaultService(hostname, token, namespace, tlsVerify, auth_method);
 
        // ServiceBuilder<?> serviceBuilder = context.getCapabilityServiceTarget()
        //           .addService().setInstance(vaultService);
        // serviceBuilder.install();
    }
}
