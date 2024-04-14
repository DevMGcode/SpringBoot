package com.melissa.csb.webapp.springbootweb;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration

@PropertySources({
	@PropertySource(value="classpath:values.properties", encoding = "UTF-8") //ISO 8859-1
})

public class valuesconfig {

}
