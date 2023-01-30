package ua.ithillel.hillelspring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ua.ithillel.hillelspring.entity.Phone;

@Configuration
@ComponentScan("ua.ithillel.hillelspring.configuration")
@PropertySource("classpath:application.properties")
public class BeanConfiguration {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.hp}")
    private int botHP;

    @Bean
    @Scope("singleton")
    public String stringBean() {
        return "stringBean";
    }

    @Bean
    @Scope("prototype")
    public Phone getCustomPhone() {
        return new Phone("Iphone", "IOS", "X");
    }

    @Bean
    public String getBotName() {
        return botName;
    }

    @Bean
    public int getBotHP() {
        return botHP;
    }
}
