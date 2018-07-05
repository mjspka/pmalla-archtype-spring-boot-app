package ${package}.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * This class will hold configuration for app.properties
 * 
 * @author Praveen Malla
 */
@Component
@PropertySource("classpath:app.properties")
@ConfigurationProperties
public class AppConfiguration {

	private boolean enabled;
	private String message;
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
