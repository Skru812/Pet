package io.jmix.petclinic;

import com.google.common.base.Strings;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ConfigurationPropertiesScan
public class JmixPetclinicApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(JmixPetclinicApplication.class, args);
	}

	@EventListener
	public void printApplicationUrl(ApplicationStartedEvent event) {
		String applicationStartedMessage = String.format(
				"Application started at http://localhost:%s%s",
				environment.getProperty("local.server.port"),
				Strings.nullToEmpty(environment.getProperty("server.servlet.context-path"))
		);

		LoggerFactory.getLogger(JmixPetclinicApplication.class)
				.info(applicationStartedMessage);
	}
}
