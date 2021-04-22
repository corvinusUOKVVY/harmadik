package hu.corvinus.beadando;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @ResponseBody
    @GetMapping(path = "/")
    String getMessage(@RequestParam String name){
        return String.format("Hello Felhasznalo! %s", name);
    }
}
