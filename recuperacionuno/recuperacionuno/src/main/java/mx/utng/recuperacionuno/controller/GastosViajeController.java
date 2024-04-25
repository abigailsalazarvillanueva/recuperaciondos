package mx.utng.recuperacionuno.controller;




    /** 
 * @author Guadalupe Abigail Salazar Villanueva
 * @grupo GDS0624
 * @DATE 22/abril/2024
*/


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import jakarta.validation.Valid;
import mx.utng.recuperacionuno.model.entity.GastosViaje;

import mx.utng.recuperacionuno.model.service.IGastosViajeService;


@Controller
@SessionAttributes("gastosViaje")
public class GastosViajeController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IGastosViajeService gastosViajeService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/gastosViaje/list","/gastosViaje","/gastosViaje/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de gastos viaje ");
    model.addAttribute("gastosViajes", gastosViajeService.list());
    return "glist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/gastosViaje/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de gastos viaje");
        model.addAttribute("gastosViaje", new GastosViaje());
        return "gform";
    }

    @GetMapping("/gastosViaje/form/{id}")
    public String update(@PathVariable Long id,Model model){
        GastosViaje gastosViaje = null;
        if (id>0) {
            gastosViaje = gastosViajeService.getById(id);
        }else{
            return "redirect:/gastosViaje/list";
        }

        model.addAttribute("title", "Editar gastos viaje");
        model.addAttribute("gastosViaje", gastosViaje);
        return "gform";
    }


    @PostMapping ("/gastosViaje/form")
    public String save(@Valid GastosViaje gastosViaje, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de gastos viaje");
            return "gform";
        }

        gastosViajeService.save(gastosViaje);
        return "redirect:/gastosViaje/list";
    }

    @GetMapping("/gastosViaje/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            gastosViajeService.delete(id);
        }
        return "redirect:/gastosViaje/list";
    }

}






