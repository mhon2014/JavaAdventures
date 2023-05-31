package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext c =
                new AnnotationConfigApplicationContext(ProjectConfig.class)){

        }
    }
}
