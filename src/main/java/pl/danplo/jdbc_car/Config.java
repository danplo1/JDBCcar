package pl.danplo.jdbc_car;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {


    @Bean
    public DataSource getDataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://85.10.205.173:3306/czas_2?serverTimezone=UTC");
        dataSourceBuilder.username("czas_2");
        dataSourceBuilder.password("222333");
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");

        return dataSourceBuilder.build();
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
    return  new JdbcTemplate(getDataSource());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit(){
        String sql = "CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar (255));";
        getJdbcTemplate().update(sql);


    }



}
