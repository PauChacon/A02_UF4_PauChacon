package com.iticbcn.mywebapp.llibresapp.Controladors;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iticbcn.mywebapp.llibresapp.Model.Llibre;
import com.iticbcn.mywebapp.llibresapp.Model.Usuaris;
import com.iticbcn.mywebapp.llibresapp.Serveis.LlibreService;

@Controller
@RequestMapping("/llibres")
public class LlibreController {

    private final LlibreService llibreService;

    public LlibreController(LlibreService llibreService) {
        this.llibreService = llibreService;
    }

    @GetMapping("/")
public String home() {
    return "redirect:/llibres/login";
}


    @GetMapping("/login")
    public String loginPage() {
        return "login"; 
    }

    @PostMapping("/login")
    public String login(String usuari, String password, Model model) {
        if ("admin".equals(usuari) && "1234".equals(password)) {
            model.addAttribute("usuaris", new Usuaris(usuari, password));
            return "index"; 
        } else {
            model.addAttribute("error", "Usuari o contrasenya incorrectes");
            return "login";
        }
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("usuaris", new Usuaris("admin", "1234"));
        return "index";
    }

    @GetMapping
    public Set<Llibre> getAllLlibres() {
        return llibreService.getAllLlibres();
    }

    @GetMapping("/{id}")
    public Optional<Llibre> getLlibreById(@PathVariable Long id) {
        return llibreService.findByIdLlibre(id);
    }

    @PostMapping
    public void addLlibre(@RequestBody Llibre llibre) {
        llibreService.saveLlibre(llibre);
    }
}
