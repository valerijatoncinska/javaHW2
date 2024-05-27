package client;

import app.controller.AnimalController;
import app.domain.Animal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");
        AnimalController controller = context.getBean(AnimalController.class);
        controller.loadAnimalsFromFile();

        Animal animal1 = controller.getById(1);
        Animal animal2 = controller.getById(2);
        Animal animal3 = controller.getById(3);
        Animal animal4 = controller.getById(4);
        Animal animal5 = controller.getById(5);

        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);
        System.out.println(animal4);
        System.out.println(animal5);
    }

}
