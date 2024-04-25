package mx.utng.recuperacionuno.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.recuperacionuno.model.entity.ConsumoInternet;
import mx.utng.recuperacionuno.model.service.IConsumoInternetService;


@Controller
@SessionAttributes("consumoInternet")
public class ConsumoInternetController {
    
    @Autowired
    private IConsumoInternetService service;

    @GetMapping({"", "/", "/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Consumo Internet");
        model.addAttribute("consumoInternet", service.list());
        return "list";
    }

    @GetMapping("/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Consumo Internet ");
        model.addAttribute("consumoInternet", new ConsumoInternet());
        return "form";
    }

    @PostMapping("/form")
    public String save(@Valid ConsumoInternet consumoInternet, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Consumo Internet");
            return "form";
        }
        service.save(consumoInternet);
        return "redirect:list";
    }

    @GetMapping("/form/{id}")
    public String update(@PathVariable Long id, Model model){
        ConsumoInternet consumoInternet = null;
        if(id>0){
            consumoInternet = service.getById(id);
        }else{
            return "redirect:list";
        }
        model.addAttribute("title", "Editar Consumo Internet");
        model.addAttribute("consumoInternet", consumoInternet);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/list";
    }



}
