package br.com.alura.languages.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LanguageController {

    @GetMapping("/test")
    public String testController() {
        return "Hello Word";
    }
}
