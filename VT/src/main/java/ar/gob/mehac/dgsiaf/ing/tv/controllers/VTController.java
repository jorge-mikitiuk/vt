package ar.gob.mehac.dgsiaf.ing.tv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VTController {

  @RequestMapping("/")
  public String home1() {
    return "index";
  }

  @RequestMapping("/home")
  public String home() {
    return "index";
  }

  @GetMapping("/admin/**")
  public String admin() {
    return "admin";
  }

  @GetMapping("/user/**")
  public String user() {
    return "user";
  }

  @GetMapping("/about")
  public String about() {
    return "about";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/403")
  public String error403() {
    return "error";
  }

  @RequestMapping("/layout")
  public String layout() {
    return "layout";
  }

  @PostMapping("/addRSS")
  public String addRSS(@RequestParam("name") String name, @RequestParam("url") String url, Model model) {
    model.addAttribute("name", name);
    model.addAttribute("url", url);
    return "ack";
  }
}
