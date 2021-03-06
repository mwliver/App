package pl.edu.us.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.edu.us.app.controller.ClientController;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.edu.agh.careSystemService.controller")
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        final ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        converter.setObjectMapper(objectMapper);
        converters.add(converter);
        super.configureMessageConverters(converters);
    }
    
    @Bean
    public ClientController clientController() {
        return new ClientController();
    }

}