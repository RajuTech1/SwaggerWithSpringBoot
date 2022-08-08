package com.swagger.integration.SwaggerWithSpringBoot.swaggerui.schema;

import java.util.List;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topics {

	@Schema(name="message", type = "string", defaultValue = "List of Topics", maxLength = 100)
	private String message;
	
	@ArraySchema(schema =  @Schema (description = "Topic", implementation = Topic.class), minItems = 1, maxItems = 100)
	private List<Topic> data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Topic> getData() {
		return data;
	}

	public void setData(List<Topic> data) {
		this.data = data;
	}	
	
}
