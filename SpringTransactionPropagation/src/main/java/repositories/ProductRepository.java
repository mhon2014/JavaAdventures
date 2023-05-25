package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class ProductRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addProduct(String name){
        String sql = "INSERT INTO product2(name) VALUES(?)";
        jdbcTemplate.update(sql, name);
    }



}
