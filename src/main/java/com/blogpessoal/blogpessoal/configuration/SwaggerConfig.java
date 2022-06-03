package com.blogpessoal.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI().info(new Info().title("Aplicação do Blog Pessoal")
				.description("Projeto desenvolvido pelos integrantes do curso DH e Porto Seguro").version("v.0.1")
				.license(new License().name("Digital House").url("https://digitalhouse.com"))
				.contact(new Contact().name("Treinamento Porto Seguro").email("portoseguro@portoseguro.com.br")))
				.externalDocs(new ExternalDocumentation().description("github").url("https://github.com/portoseg"));

	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser()
	{
		return openApi -> {
		openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> 
		{
		ApiResponses apiResponses = operation.getResponses();
		
		apiResponses.addApiResponse("200", createApiRespose("Sucesso!!!"));
		apiResponses.addApiResponse("201", createApiRespose("Objeto persistido!!!"));
		apiResponses.addApiResponse("204", createApiRespose("Objeto excluído!!!"));
		apiResponses.addApiResponse("400", createApiRespose("Erro na requisição!!!"));
		apiResponses.addApiResponse("401", createApiRespose("Acesso não autorizado!!"));
		apiResponses.addApiResponse("404", createApiRespose("Objeto não encontrado!!!"));
		apiResponses.addApiResponse("500", createApiRespose("Erro na aplicação!!!"));
		}));	
	};
	
}

	private ApiResponse createApiRespose(String string) {
		
		return null;
	}
}	
