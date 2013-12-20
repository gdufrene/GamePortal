package fr.eservice.web;

import java.io.File;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import fr.eservice.portal.score.ScoreDO;

@Configuration
@EnableWebMvc
@ComponentScan({"fr.eservice.portal","fr.eservice.web","fr.eservice.rallyman"})
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		
		return resolver;
	}
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("Hello world !");
		System.out.println( new File("src/main/webapp/www").exists()  );
		registry
			.addResourceHandler("/assets/**")
			.addResourceLocations("/")
			.setCachePeriod(31556926);
		
	}
	
	@Bean
    public DataSource dataSource() {  
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		return dataSource;
    }
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
	    
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource());
	    
	    Class<ScoreDO> classes[] = new Class[1];
	    classes[0] = ScoreDO.class;
	    sessionFactoryBean.setAnnotatedClasses(classes);
	    
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
	    hibernateProperties.put("hibernate.current_session_context_class", "thread");
	    hibernateProperties.put("hibernate.show_sql", true);
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	}
}
