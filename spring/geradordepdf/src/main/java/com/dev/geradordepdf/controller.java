package com.dev.geradordepdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@CrossOrigin("*")
@RequestMapping(value = "/user")
public class controller {
	@Autowired
	private gerador gerador;
	
	@GetMapping
	public String home() {
		String documento = gerador.getDocumento();
        return documento; 
    }
	
	@PostMapping
	public String postMethodgerador(@RequestBody String document) {
		//TODO: process POST request
		String documento = gerador.setDocumento(document);
		return documento;
	}
	
}
