package pl.coderslab.kayak;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/kayaks")
public class KayakController {

    private final KayakService kayakService;

    public KayakController(KayakService kayakService){
        this.kayakService = kayakService;
    }

    @GetMapping
    public String listKayaks(Model model){
        model.addAttribute("kayaks", kayakService.getAllKayaks());
        return "admin/kayaks";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("kayak", new Kayak());
        return "admin/kayak-form";
    }

    @PostMapping("/add")
    public String addKayak(@Valid @ModelAttribute("kayak") Kayak kayak, BindingResult result){
        if (result.hasErrors()){
            return "admin/kayak-form";
        }
        kayakService.saveKayak(kayak);
        return "redirect:/admin/kayaks";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Kayak kayak = kayakService.getKayakById(id);
        model.addAttribute("kayak", kayak);
        return "admin/kayak-form";
    }
    @PostMapping("/edit/{id}")
    public String updateKayak(@PathVariable("id") Long id, @Valid @ModelAttribute("kayak") Kayak kayak, BindingResult result){
        if (result.hasErrors()){
            return "admin/kayak-form";
        }
        kayak.setId(id);
        kayakService.saveKayak(kayak);
        return "redirect:/admin/kayaks";
    }
    @GetMapping("/delete/{id}")
    public String deleteKayak(@PathVariable("id") Long id){
        kayakService.deleteKayak(id);
        return "redirect:/admin/kayaks";
    }
}
