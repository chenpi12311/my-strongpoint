package com.czp.mystrongpoint;

import com.czp.mystrongpoint.repository.impl.BaseDaoFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseDaoFactoryBean.class)
public class MyStrongpointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyStrongpointApplication.class, args);
	}
}
