package alexpetrut.overnightbooking;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import sun.tools.java.Environment;

import java.util.Date;

@Controller
public class ViewController {

    private String appMode;

//    @Autowired
//    public ViewController(Environment environment){
//        appMode = environment.getProperty("app-mode");
//    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "John");
        model.addAttribute("mode", "production");

        return "index";
    }
}
