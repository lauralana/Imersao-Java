package br.com.alura.languages.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LangRepository repository;
        
    @GetMapping("/languages-of-programing")
    public List<Languages> getLang() {
        List<Languages> lang = repository.findAll();
        return lang;
    }

    @PostMapping("/languages-of-programing")
    public Languages postLang(@RequestBody Languages lang) {
        var saveNewLang = repository.save(lang);
        return saveNewLang;        
    }
}
