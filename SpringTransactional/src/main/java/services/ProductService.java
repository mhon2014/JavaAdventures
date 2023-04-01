package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addOneProduct(){
        productRepository.addProduct("Water");
        throw new RuntimeException(":(");
    }
    @Transactional(rollbackFor = Exception.class)
    public void addOneProductExcept() throws Exception {
        productRepository.addProduct("Juice");

        System.out.println("Transactional does not work on regular Exception, have to use rollbackFor semantics");

        throw new Exception(":(");
    }
}
