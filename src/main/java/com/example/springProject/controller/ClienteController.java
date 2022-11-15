package com.example.springProject.controller;

import com.example.springProject.models.CiudadModel;
import com.example.springProject.models.ClienteModel;
import com.example.springProject.respository.ClienteRepository;
import com.example.springProject.services.ICiudadService;
import com.example.springProject.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/views/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteSrevice;

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping("/")
    public String getClientes(Model model) {
        List<ClienteModel> listarClientes = clienteSrevice.listarClientes();
        model.addAttribute("titulo", "Lista de clientes");
        model.addAttribute("clientes", listarClientes);

        return "/views/clientes/listar";
    }

    @GetMapping("/crear")
    public String crearCliente(Model model) {

        ClienteModel cliente = new ClienteModel();
        List<CiudadModel> listaDeCiudades = ciudadService.listarCiudades();

        model.addAttribute("titulo", "Crear nuevo cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("ciudades", listaDeCiudades);

        return "/views/clientes/crear";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute ClienteModel cliente, BindingResult result, Model model,
                          RedirectAttributes redirectAttrs) {

        List<CiudadModel> listaDeCiudades = ciudadService.listarCiudades();

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Crear nuevo cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listaDeCiudades);
            System.out.println("Hubieron errores en el formulario");
            return "/views/clientes/crear";
        }

        clienteSrevice.guardarCliente(cliente);
        redirectAttrs
                .addFlashAttribute("success", "Agregado correctamente");



        return "redirect:/views/clientes/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model, RedirectAttributes redirectAttrs) {

        Optional<ClienteModel> cliente = clienteSrevice.buscarClienteById(id);

        if (clienteSrevice.comprobarExistencia(id)){
            List<CiudadModel> listarCiudades = ciudadService.listarCiudades();

            model.addAttribute("titulo", "Editar cliente");
            model.addAttribute("cliente", cliente);
            model.addAttribute("ciudades", listarCiudades);

            redirectAttrs
                    .addFlashAttribute("success", "Editado correctamente"); //no funciona

            return "/views/clientes/crear";
        } else {

            redirectAttrs
                    .addFlashAttribute("error", "Usuario no encontrado");

            return "redirect:/views/clientes/";
        }

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttrs) {
        clienteSrevice.eliminarCliente(id);

        redirectAttrs
                .addFlashAttribute("error", "Usuario eliminado");

        return "redirect:/views/clientes/";
    }


}
