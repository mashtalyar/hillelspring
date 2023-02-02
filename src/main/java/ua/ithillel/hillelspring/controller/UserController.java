package ua.ithillel.hillelspring.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.service.UserService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @GetMapping("/{email}/{phone}")
    public User getByNameOrPhone(
            @PathVariable String email,
            @PathVariable int phone
    ) {
        return userService.getByEmailAndPhone(email, phone);
    }

    @GetMapping("/filter")
    public User getUserByFilter(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = true) String name,
            @RequestParam(required = false) String surname
    ) {
        return userService.getUserByFilter(id,name,surname);
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id,
                       @RequestBody User user) {
        return userService.update(id,user);
    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }
}

