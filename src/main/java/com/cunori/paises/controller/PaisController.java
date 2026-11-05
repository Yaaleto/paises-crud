package com.cunori.paises.controller;

import com.cunori.paises.model.Pais;
import com.cunori.paises.repository.PaisRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class PaisController {

    private final PaisRepository repo;

    public PaisController(PaisRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/paises";
    }

    // LISTAR
    @GetMapping("/paises")
    public String listar(Model model) {
        model.addAttribute("paises", repo.findAll(Sort.by("nombre")));
        return "paises/lista";
    }

    // REGISTRAR (mostrar formulario vacío)
    @GetMapping("/paises/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("pais", new Pais());
        return "paises/form";
    }

    // REGISTRAR / EDITAR (guardar)
    @PostMapping("/paises/guardar")
    public String guardar(@Valid @ModelAttribute("pais") Pais pais,
                          BindingResult result,
                          RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "paises/form";
        }
        boolean esNuevo = pais.getId() == null;
        repo.save(pais);
        ra.addFlashAttribute("mensaje",
                esNuevo ? "País registrado correctamente" : "País actualizado correctamente");
        return "redirect:/paises";
    }

    // CONSULTAR
    @GetMapping("/paises/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        model.addAttribute("pais", buscar(id));
        return "paises/detalle";
    }

    // EDITAR (mostrar formulario con datos)
    @GetMapping("/paises/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("pais", buscar(id));
        return "paises/form";
    }

    // ELIMINAR
    @PostMapping("/paises/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
        repo.delete(buscar(id));
        ra.addFlashAttribute("mensaje", "País eliminado correctamente");
        return "redirect:/paises";
    }

    private Pais buscar(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "País no encontrado"));
    }
}