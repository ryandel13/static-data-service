package net.mkengineering.studies.sds.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.mkengineering.studies.sds.bl.MockRepositoryClientFallback;
import net.mkengineering.studies.sds.bl.MockRepositoryDefault;
import net.mkengineering.studies.sds.bl.SdsRepository;

@Configuration
public class SdsConfiguration {
	
	@Bean
	@ConditionalOnMissingBean(SdsRepository.class)
	public SdsRepository myBeanForOthers() {
		System.out.println("LOADING FALLBACK BEAN");
		return new MockRepositoryDefault();
	}
}
