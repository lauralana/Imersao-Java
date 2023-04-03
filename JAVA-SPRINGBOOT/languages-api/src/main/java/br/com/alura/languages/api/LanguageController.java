package br.com.alura.languages.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    private List<Languages> lang = 
        List.of(
            new Languages("Java", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png", 1),
            new Languages("JavaScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png", 2),
            new Languages("TypeScript", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/typescript/typescript_256x256.png", 3),
            new Languages("Go", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/go/go_256x256.png", 4),
            new Languages("Python", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/python/python_256x256.png", 5),
            new Languages("Html", "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/html/html_256x256.png", 6)
        );

    @GetMapping("/languages-of-programing")
    public List<Languages> getLang(){
        return lang;
    }  
    
// @RestController
// public class LanguageController {

//     @GetMapping("/test")
//     public String testController() {
//         return "Hello Word";
//     }
}
