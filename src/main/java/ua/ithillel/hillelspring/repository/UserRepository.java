package ua.ithillel.hillelspring.repository;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ua.ithillel.hillelspring.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(0,"Serhii", "Mashtalyar", 19,"email1", 111));
        users.add(new User(1,"Victor", "Kislii", 25,"email2", 222));
        users.add(new User(2,"Nastya", "Lifenceva", 21,"email3", 333));

    }

    public List<User> getAll() {
        return users;
    }

    public User getById(Integer id) {
        return users.get(id);
    }

    public User getByEmailAndPhone(String email, int phone) {
//        User user = new User();
//        for (int i = 0; i < users.size(); i++) {
//            if (users.get(i).getEmail() == email && users.get(i).getPhone() == phone) {
//                user=users.get(i);
//            }
//        }
//        return user;
        return null;
    }

    public User save(User user) {
        users.add(user);
        user.setId(users.size()-1);
        return user;
    }

    public User update(Integer id, User user) {
        final User oldUser = users.get(id);
        oldUser.setName(user.getName());
        oldUser.setSurname(user.getSurname());
        oldUser.setPhone(user.getPhone());
        oldUser.setAge(user.getAge());
        oldUser.setEmail(user.getEmail());
        return users.get(id);
    }

    public Integer delete(int id) {
        users.remove(id);
        return id;
    }

    public User getUserByFilter(Integer id, String name, String surname) {
        return  null;
    }
}

