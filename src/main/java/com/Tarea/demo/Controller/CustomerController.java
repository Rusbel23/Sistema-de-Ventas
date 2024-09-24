package com.Tarea.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Customer")
public class CustomerController {
    @GetMapping("/Listar")
    public String listarAuthor(Model model){
        model.addAttribute("title", "Listado de Clientes");
        return "Customer";
    }
}
