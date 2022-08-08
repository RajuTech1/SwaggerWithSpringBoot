package com.swagger.integration.SwaggerWithSpringBoot.swaggerui.schema;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema
public class Topic {
	
	@Schema(name="topicName", type = "string", defaultValue = "new-topic", maxLength = 100)
	private String topicName;
	
	@Schema(type = "integer", defaultValue = "5", format = "int32")
	private Integer partitions;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Integer getPartitions() {
		return partitions;
	}

	public void setPartitions(Integer partitions) {
		this.partitions = partitions;
	}
	
	
	

}
