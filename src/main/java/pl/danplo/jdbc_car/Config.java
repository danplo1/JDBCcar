package pl.danplo.jdbc_car;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource(){

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://85.10.205.173:3306/czas_2");
        dataSourceBuilder.username("czas_2");
        dataSourceBuilder.username("2222");



    }

}
