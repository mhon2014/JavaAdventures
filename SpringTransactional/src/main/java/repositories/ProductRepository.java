package repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void addProduct(String name){
        String sql = "INSERT INTO product2(name) VALUES(?)";
        jdbcTemplate.update(sql, name);
    }

}
