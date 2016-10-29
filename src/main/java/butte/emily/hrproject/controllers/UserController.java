package butte.emily.hrproject.controllers;

import butte.emily.hrproject.domain.User;
import butte.emily.hrproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "Http://localhost:9000")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //     retrieves users from database
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAllUsers() {
        StringBuilder builder = new StringBuilder("[");

        userRepository.findAll().forEach(user -> {
            builder.append(user.toString());
        });

        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    // adds users to database
    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)

    public
    @ResponseBody
    String addUser(@RequestBody User request) {
        try {
            userRepository.saveAndFlush(new User(request.getUsername(), request.getPassword()));
        } catch (DataIntegrityViolationException e) {
            return "{\"message\":\"Error! User already exists!\"}";

        }
        return "{\"message\":\"Success!\"}";

    }

}

