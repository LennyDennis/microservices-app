package com.eazybytes.accounts;

import com.eazybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = AccountsContactInfoDto.class)
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice Rest API documentation",
				description = "Lenny Dennis Accounts Microservice API Documentation",
				version = "V1",
				contact = @Contact(
						name = "Lenny Dennis",
						email = "lenny.macharia@zeraki.app",
						url = "https://www.zeraki.app"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.zeraki.app"

				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Lenny Dennis Accounts Microservice API Documentation",
				url = "https://www.zeraki.app"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
