package io.github.justincodinguk.icdmediator.controller;

import io.github.justincodinguk.icdmediator.data.IcdEntityRepository;
import io.github.justincodinguk.icdmediator.model.IcdEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
public class IcdController {

    private final IcdEntityRepository icdEntityRepository;

    @Autowired
    public IcdController(IcdEntityRepository icdEntityRepository) {
        this.icdEntityRepository = icdEntityRepository;
    }

    @GetMapping("/api/icd")
    @ResponseBody
    public Mono<List<IcdEntity>> showIcdEntries(@RequestParam String search) {
        return icdEntityRepository.searchFor(search);
    }

    @GetMapping("/icd")
    public String showWebPage(@RequestParam(required = false) String search, Model model) {
        if(search!=null && !search.isEmpty()) {
            model.addAttribute("entities", icdEntityRepository.searchFor(search));
            return "icd";
        }
        model.addAttribute("search", search);
        return "icd";
    }

}
