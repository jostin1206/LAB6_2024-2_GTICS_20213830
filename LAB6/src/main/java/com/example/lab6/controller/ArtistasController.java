package com.example.lab6.controller;

import com.example.lab6.repository.ArtistasRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistasController {

    private final ArtistasRepository artistasRepository;

    public ArtistasController(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }

    @GetMapping(value = {"/artistas/lista"})
    public String listaArtistas(Model model) {
        model.addAttribute("listaArtistas", artistasRepository.findAll());
        return "artistas/lista";
    }


}
