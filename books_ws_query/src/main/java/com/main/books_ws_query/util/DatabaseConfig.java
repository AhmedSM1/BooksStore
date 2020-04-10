package com.main.books_ws_query.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db.properties" })
@EnableJpaRepositories(
        basePackages = "com.main.books_ws_query.data.BookRepo",
        entityManagerFactoryRef = "bookEntityManager"
)
public class DatabaseConfig {
    @Autowired
    private Environment env;


    @Primary
    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookEntityManager() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(bookDataSource());
        em.setPackagesToScan(
                new String[] { "com.main.books_ws_query.data.bookEntity" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;


    }

    @Primary
    @Bean(name = "bookDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource bookDataSource() {
      return DataSourceBuilder.create().build();
    }



    @Primary
    @Bean(name = "bookTransactionManager")
    public PlatformTransactionManager bookTransactionManager() {
        //by annotating the bean definition with @Primary.
        // That's helpful whenever we're going to implicitly or explicitly inject the transaction manager
        // without specifying which one by name.
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(bookEntityManager().getObject());
        return transactionManager;
    }
}
