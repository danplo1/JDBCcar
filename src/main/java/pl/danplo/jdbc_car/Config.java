package pl.danplo.jdbc_car;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    //schowanie hasła
    @Value("$[password]")
    private String password;



    @Bean
    public DataSource getDataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://85.10.205.173:3306/czas_2?serverTimezone=UTC");
        dataSourceBuilder.username("czas_2");
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");

        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }



    }

