package com.swagger.integration.SwaggerWithSpringBoot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.integration.SwaggerWithSpringBoot.swaggerui.schema.Topics;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class SwaggerIntegrationController {
	
	//@Tags( value = {@Tag(name = "topic", description = "Admin APIs to manage topic"), 
	//		@Tag(name = "producer", description = "API to produce messages to Topic")})
	
	@Operation(summary = "list all the topics in a given domain", operationId = "lis the topics", method = "get")
	@Parameters(value = {@Parameter(name = "domainName", in = ParameterIn.PATH, description = "domain", required = true, content = @Content(mediaType = "String"))})
	@Tag(name = "topic", description = "Admin APIs to manage topic")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "200", description = "OK", useReturnTypeSchema = true, 
			  content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Topics.class))})	  
	 })
	  @RequestMapping(value = "/products/{domainName}", method = RequestMethod.GET)
	   public List<String> getTopic(@PathVariable String domainName) {
	      List<String> productsList = new ArrayList<>();
	      productsList.add("Honey");
	      productsList.add("Almond");
	      return productsList;
	   }
	
	   //@ApiOperation(value = "Post Operation on products", response = String.class)
	   /*@RequestMapping(value = "/products", method = RequestMethod.POST)
	   public String createProduct(@RequestBody Product productForm) {
		  
		  //System.out.println("productForm username :  " + productForm.getUsername());
	      return "Product is saved successfully";
	   }*/
}
