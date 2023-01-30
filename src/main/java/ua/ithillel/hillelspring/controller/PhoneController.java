package ua.ithillel.hillelspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ua.ithillel.hillelspring.entity.Phone;
import ua.ithillel.hillelspring.service.PhoneService;

import java.util.List;

@Controller
public class PhoneController {
    private final PhoneService phoneService;
    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    public List<Phone> getAll() {
        return phoneService.getAll();
    }
}
