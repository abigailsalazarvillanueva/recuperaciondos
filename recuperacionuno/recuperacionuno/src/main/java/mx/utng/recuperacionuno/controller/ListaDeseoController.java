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
import mx.utng.recuperacionuno.model.entity.ListaDeseo;
import mx.utng.recuperacionuno.model.service.IListaDeseoService;


@Controller
@SessionAttributes("listaDeseo")
public class ListaDeseoController {
    //Inyectamos una dependencia del servicio
    @Autowired
    private IListaDeseoService listaDeseoService;

    //Manda llamar este metodo en una peticion GET que contenga como final de la query string "", "/", "/list"
    @GetMapping({"/listaDeseo/list","/listaDeseo","/listaDeseo/"})
    public String list(Model model){
        model.addAttribute("title", "Listado de lista deseos tecnologia ");
    model.addAttribute("listaDeseos", listaDeseoService.list());
    return "llist";
    }

    //Peticion que contenga al final de la url /form
    @GetMapping("/listaDeseo/form")
    public String create (Model model){
        model.addAttribute("title", "Formulario de lista deseos tecnologia");
        model.addAttribute("listaDeseo", new ListaDeseo());
        return "lform";
    }

    @GetMapping("/listaDeseo/form/{id}")
    public String update(@PathVariable Long id,Model model){
        ListaDeseo listaDeseo = null;
        if (id>0) {
            listaDeseo = listaDeseoService.getById(id);
        }else{
            return "redirect:/listaDeseo/list";
        }

        model.addAttribute("title", "Editar lista deseos tecnologia");
        model.addAttribute("listaDeseo", listaDeseo);
        return "lform";
    }


    @PostMapping ("/listaDeseo/form")
    public String save(@Valid ListaDeseo listaDeseo, BindingResult br, Model model){

        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de lista deseos tecnologia");
            return "lform";
        }

        listaDeseoService.save(listaDeseo);
        return "redirect:/listaDeseo/list";
    }

    @GetMapping("/listaDeseo/delete/{id}")
    public String delete (@PathVariable Long id, Model model){
        if (id>0) {
            listaDeseoService.delete(id);
        }
        return "redirect:/listaDeseo/list";
    }

}






