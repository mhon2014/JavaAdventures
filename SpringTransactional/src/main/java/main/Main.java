package main;

import ProjectConfig.java.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.ProductService;

public class Main {
    public static void main(String[] args) throws Exception {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            ProductService p = c.getBean(ProductService.class);
            p.addOneProductExcept();
//            p.addOneProduct();
        }
    }
}
