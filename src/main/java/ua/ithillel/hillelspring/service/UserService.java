package ua.ithillel.hillelspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.repository.FakeUserRepository;
import ua.ithillel.hillelspring.repository.UserRepository;

import java.util.List;


@Service
public class UserService {

    //        private final FakeUserRepository userRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User getByEmailAndPhone(String email, int phone) {
        return userRepository.getUserByEmailAndPhone(email, phone);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Integer delete(Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    public User getUserByFilter(Integer id, String name, String surname) {
        return userRepository.getUserByIdAndNameOrSurname(id, name, surname);
    }

    public Integer updatePhoneById(int phone, Integer id) {
        return userRepository.update(phone, id);
    }

}


