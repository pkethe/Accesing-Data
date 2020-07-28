package com.exampleaql.accesingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/demo")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping("/addUser")
    public String addUser (Model model) {
        model.addAttribute("user",new User());
        return "login";
    }

    @PostMapping("/addUser")
    public String user(@ModelAttribute User user){

        userRepository.save(user);
        return "success";
    }

}
