package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Default -> read committed
     * READ_UNCOMMITTED
     * READ_COMMITTED -> avoids dirty reads but not repeatable
     * REPEATABLE_READ -> avoid non-repeatable and dirty, but not phantom reads
     * SERIALIZABLE -> execute as if it was serializes
     *
     * Problems:
     * - dirty reads ---> reading uncommitted values, inconsistencies?
     * - non repeatable reads ---> different values for same query, when repeated, modified or updated
     * - phantom reads ---> rows maybe different after the same, add or delete
     */

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addTenProducts(){
        for(int i = 0; i < 10; i++){
            productRepository.addProduct("Product" + i);
        }
    }
}
