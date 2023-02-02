package ua.ithillel.hillelspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ua.ithillel.hillelspring.controller.PhoneController;
import ua.ithillel.hillelspring.entity.Phone;

import java.util.List;

@SpringBootApplication
public class HillelspringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HillelspringApplication.class, args);
//        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
//        final ConfigurableApplicationContext context = SpringApplication.run(HillelspringApplication.class, args);
//        final PhoneController phoneController = context.getBean(PhoneController.class);
//        final List<Phone> all = phoneController.getAll();
//        all.forEach(System.out::println);
//        final String stringBean = context.getBean("stringBean", String.class);
//        final Phone customPhone = context.getBean("getCustomPhone", Phone.class);
//        System.out.println(stringBean);
//        System.out.println(customPhone);
//
//        final String botName = context.getBean("getBotName", String.class);
//        final int botHp = context.getBean("getBotHP", int.class);
//        System.out.println("Bot name:"+botName);
//        System.out.println("Bot hp:"+botHp);
    }
}
