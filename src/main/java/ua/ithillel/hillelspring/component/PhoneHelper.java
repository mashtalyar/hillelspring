package ua.ithillel.hillelspring.component;

import org.springframework.stereotype.Component;
import ua.ithillel.hillelspring.entity.Phone;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneHelper {
    public List<Phone> createPhone(){
        return List.of(new Phone("Samsung","Android","S20"));
    }
}
