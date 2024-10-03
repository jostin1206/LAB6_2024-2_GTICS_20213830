package com.example.lab6.controller;

import com.example.lab6.entity.Eventos;
import com.example.lab6.repository.EventosRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EventosController {

    private final EventosRepository eventosRepository;

    public EventosController(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @GetMapping(value = {"/eventos/lista"})
    public String listaEventos(Model model) {
        model.addAttribute("listaEventos", eventosRepository.findAll());
        return "eventos/lista";
    }

    @GetMapping("/eventos/nuevo")
    public String nuevoEventoFrm(Model model, @ModelAttribute("eventos") Eventos eventos) {
        return "eventos/edit";
    }

    @GetMapping("/eventos/edit")
    public String editarEventos(@ModelAttribute("eventos") Eventos eventos,
                                      Model model, @RequestParam("id") int id) {

        Optional<Eventos> optEventos = eventosRepository.findById(id);

        if (optEventos.isPresent()) {
            eventos = optEventos.get();
            model.addAttribute("eventos", eventos);
            return "eventos/edit";
        } else {
            return "redirect:/eventos/lista";
        }
    }

    @PostMapping("/eventos/save")
    public String guardarEventos(RedirectAttributes attr, Model model,
                                  @ModelAttribute("eventos") @Valid Eventos eventos, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal


                if (eventos.getId() == 0) {
                    attr.addFlashAttribute("msg", "Evento creado exitosamente");
                } else {
                    attr.addFlashAttribute("msg", "Evento actualizado exitosamente");
                }
                eventosRepository.save(eventos);
                return "redirect:/eventos/lista";


        } else { //hay al menos 1 error

            return "eventos/edit";
        }
    }

}
