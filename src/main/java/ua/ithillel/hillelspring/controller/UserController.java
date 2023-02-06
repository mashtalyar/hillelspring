package ua.ithillel.hillelspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import ua.ithillel.hillelspring.controller.dto.IntegerDto;
import ua.ithillel.hillelspring.controller.dto.UserDto;
import ua.ithillel.hillelspring.controller.mapper.UserMapper;
import ua.ithillel.hillelspring.entity.User;
import ua.ithillel.hillelspring.service.UserService;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(final UserService userService, final UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {

        return new ResponseEntity<>(
                userService.getAll().stream()
                        .map(userMapper::toDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Integer id) {
        final User userById = userService.getById(id);
        return ResponseEntity.ok(userMapper.toDto(userById));

    }

    @GetMapping("/{email}/{phone}")
    public ResponseEntity<UserDto> getByEmailOrPhone(
            @PathVariable String email,
            @PathVariable int phone
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getByEmailAndPhone(email, phone)));
    }

    @GetMapping("/filter")
    public ResponseEntity<UserDto> getUserByFilter(
            @RequestParam(required = true) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname
    ) {
        return ResponseEntity.ok(userMapper.toDto(userService.getUserByFilter(id,name,surname)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userMapper.toDto(userService.save(userMapper.toEntity(userDto))),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> update(
                       @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userMapper.toDto(userService.update(userMapper.toEntity(userDto))), HttpStatus.ACCEPTED);

    }

    @DeleteMapping
    public Integer delete(@RequestParam Integer id) {
        return userService.delete(id);
    }

    @PutMapping("/{id}/{phone}")
    public IntegerDto updateNameById(
            @PathVariable Integer id,
            @PathVariable int phone
    ) {
        return new IntegerDto(userService.updatePhoneById(phone, id));
    }

}

