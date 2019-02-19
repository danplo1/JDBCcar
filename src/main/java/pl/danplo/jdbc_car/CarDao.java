package pl.danplo.jdbc_car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Car car) {


        String sql = "INSERT INTO Car VALUES(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]{
                car.getCarId(),
                car.getMark(),
                car.getModel(),
                car.getColor()
        });

    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        save(new Car(1, "Volvo", "V60", "Black Pearl"));
        save(new Car(2, "Volvo", "V50", "White"));
        save(new Car(3, "Volvo", "XC90", "Silver"));
        save(new Car(4, "Volvo", "S90", "Silver Pearl"));
    }



//    String sql = "CREATE TABLE Car(car_id int, mark varchar(255), model varchar(255), color varchar (255));";
//     getJdbcTemplate().update(sql);


    }
