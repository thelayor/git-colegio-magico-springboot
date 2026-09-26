package com.quipux.colegio.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com.quipux.colegio.services");
        register(io.swagger.v3.jaxrs2.integration.resources.OpenApiResource.class);
    }
}