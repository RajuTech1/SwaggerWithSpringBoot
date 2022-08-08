package com.swagger.integration.SwaggerWithSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

@SpringBootApplication
@OpenAPIDefinition(
		info = @io.swagger.v3.oas.annotations.info.Info(title = "Kafka Admin API", 
		description = "Kafka Admin APIs Documentation provides details for a set of APIs which can be used to manage",
		version = "1.0", termsOfService = "urn:tos", contact = @io.swagger.v3.oas.annotations.info.Contact(email = "mfk@gmail.com", name = "mk"),
		license = @io.swagger.v3.oas.annotations.info.License(name = "****Services 1.0", url = "http://www.apache.org/licenses/LICENSE-2.0")),
		security = @SecurityRequirement(name = "okta", scopes = {"kafkaAPIProduce", "kafkaAPIRead", "kafkaAPICreate"}), 
		servers = @Server(url = "kafka.api.sandbox", description = "/v1/") 
		)
@SecurityScheme(name = "okta", type = SecuritySchemeType.OAUTH2, description = "OKTA OAuth 2.0 Authentication", 
flows = @OAuthFlows(authorizationCode = 
	@OAuthFlow(authorizationUrl = "https://256", tokenUrl = "https://tokens", 
		scopes = {
				@OAuthScope(name = "kafkaAPIProduce", description = "Scope for Publish API"),
				@OAuthScope(name = "kafkaAPIRead", description = "Scope for Get APIs"),
				@OAuthScope(name = "kafkaAPICreate", description = "Scope for Create Topic API")
		})
	))
@Tags(value = {@Tag(name = "topic", description = "Admin APIs to manage topics"), @Tag(name = "producer", description = "API to produce messages to topics")})
public class SwaggerWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerWithSpringBootApplication.class, args);
	}
}
