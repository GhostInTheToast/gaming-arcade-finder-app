package com.gost.gaminggroup.gaminggroupapp.controllers;

import com.gost.gaminggroup.gaminggroupapp.dto.ArcadeDto;
import com.gost.gaminggroup.gaminggroupapp.models.Arcade;
import com.gost.gaminggroup.gaminggroupapp.services.ArcadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArcadeController {
    private ArcadeService arcadeService;

    @Autowired
    public ArcadeController(ArcadeService arcadeService) {
        this.arcadeService = arcadeService;
    }

    @GetMapping("/arcades")
    public String listArcades(Model model) {
        List<ArcadeDto> arcades = arcadeService.findAllArcades();
        model.addAttribute("arcades", arcades);
        return "arcades-list";
    }

    @GetMapping("/arcades/new")
    public String createArcadeForm(Model model){
        Arcade arcade = new Arcade();
        model.addAttribute("arcade", arcade);
        return "arcades-create";
    }

    @PostMapping("/arcades/new")
    public String saveArcade(@ModelAttribute("arcade") Arcade arcade) {
        arcadeService.saveArcade(arcade);
        return "redirect:/arcades";
    }

    @GetMapping("/arcades/{arcadeId}/edit")
    public String editArcadeForm(@PathVariable("arcadeId") long arcadeId, Model model) {
        ArcadeDto arcade = arcadeService.findArcadeById(arcadeId);
        model.addAttribute("arcade", arcade);
        return "arcades-edit";
    }

    @PostMapping("/arcades/{arcadeId}/edit")
    public String updateClub(@PathVariable("arcadeId") Long arcadeId, @ModelAttribute("arcade") ArcadeDto arcade) {
        arcade.setId(arcadeId);
        arcadeService.updateArcade(arcade);
        return "redirect:/arcades";
    }

}
