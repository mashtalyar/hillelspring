package ua.ithillel.hillelspring.service;

import org.springframework.stereotype.Service;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
    public class UserService {

        private final UserRepository userRepository;

        public UserService(
                UserRepository userRepository
        ) {
            this.userRepository = userRepository;
        }

        public List<User> getAll() {
            return userRepository.getAll();
        }

        public User getById(Integer id) {
            return userRepository.getById(id);
        }

        public User getByEmailAndPhone(String email, int phone) {
            return userRepository.getByEmailAndPhone(email, phone);
        }

        public User save(User user) {
            return userRepository.save(user);
        }

        public User update(Integer id, User user) {
            return userRepository.update(id, user);
        }

        public Integer delete(Integer id) {
            return userRepository.delete(id);
        }

        public User getUserByFilter(Integer id, String name, String surname) {
            return userRepository.getUserByFilter(id,name,surname);
        }
    }


