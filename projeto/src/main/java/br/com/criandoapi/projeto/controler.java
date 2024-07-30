/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.criandoapi.projeto;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrador
 */
public class controler {
   
    @RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Nome da sua view
    }
}
}
