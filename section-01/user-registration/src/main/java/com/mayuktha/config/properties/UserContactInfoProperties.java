package com.mayuktha.config.properties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "user")
@Setter @Getter
@Component
public class UserContactInfoProperties {
	
	private String message;
	private List<String> onCallSupport;
	private Map<String,String> contactDetails;
	

}
