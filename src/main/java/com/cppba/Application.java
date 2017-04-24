package com.cppba;

import com.cppba.base.factory.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
//WebFilter,WebServlet,WebListener
@ServletComponentScan
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
