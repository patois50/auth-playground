package com.patrickmcgeever.springjwtdemo.configuration;

import com.patrickmcgeever.springjwtdemo.dao.AbstractHibernateDAO;
import com.patrickmcgeever.springjwtdemo.dao.HibernateDAO;
import com.patrickmcgeever.springjwtdemo.domain.User;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
public class HibernateConf {

    @Bean
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    LocalSessionFactoryBean entityManagerFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.patrickmcgeever.springjwtdemo.domain");
        return sessionFactory;
    }

    @Bean
    HibernateDAO<User> userDAO() {
        return new AbstractHibernateDAO<User>(User.class){};
    }

}
