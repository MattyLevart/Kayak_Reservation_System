package pl.coderslab.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){

        this.userRepository = userRepository;
    }
    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/add")
    public String save(User user) {
        userRepository.save(user);
        return "redirect:/user/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("user", userRepository.findById(id));
        return "user/form";
    }
    @PostMapping("/edit/{id}")
    public String update(User user){
        userRepository.save(user);
        return "redirect:/user/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id){
        userRepository.deleteById(id);
        return "redirect:/user/list";
    }

}

