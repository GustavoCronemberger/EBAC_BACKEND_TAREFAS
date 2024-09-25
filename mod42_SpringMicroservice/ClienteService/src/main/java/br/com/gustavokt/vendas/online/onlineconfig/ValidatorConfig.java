package br.com.gustavokt.vendas.online.onlineconfig;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {

//	@Autowired
//    ResourceBundleMessageSource messageSource;

    @Bean
    public Validator validatorFactory () {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	    bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
