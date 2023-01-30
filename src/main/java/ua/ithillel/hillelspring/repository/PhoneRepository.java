package ua.ithillel.hillelspring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelspring.component.PhoneHelper;
import ua.ithillel.hillelspring.entity.Phone;

import java.util.List;

@Repository
public class PhoneRepository {
    private final PhoneHelper phoneHelper;
    @Autowired
    public PhoneRepository(PhoneHelper phoneHelper) {
        this.phoneHelper = phoneHelper;
    }

    public List<Phone> getAll(){
        return phoneHelper.createPhone();
    };
}
