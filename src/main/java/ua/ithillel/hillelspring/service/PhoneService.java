package ua.ithillel.hillelspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.entity.Phone;
import ua.ithillel.hillelspring.repository.PhoneRepository;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getAll(){
        return phoneRepository.getAll();
    }
}
