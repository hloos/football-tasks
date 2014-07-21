package com.footballradar.tasks.technical;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Generate beans in the container.
 * @author hloos
 */
@Configuration
public class ConfigurationContainer {

	private String[] baseNames = new String[] {
			"Parameter"
	};
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.setBasenames(baseNames);
		return bundle;
	}
}
