package hu.corvinus.beadando.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/harmadik")
@Controller
public class MainController {

    @ResponseBody
    @GetMapping
    String getMessage(){
        return "Hello Felhasznalo!";
    }

    @ResponseBody
    @GetMapping(path = "/")
    String getName(@RequestParam String name){
        return ("Hello " + name +"!");
    }
}
