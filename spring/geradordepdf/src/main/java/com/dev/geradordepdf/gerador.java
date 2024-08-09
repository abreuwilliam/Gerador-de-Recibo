package com.dev.geradordepdf;

import org.springframework.stereotype.Service;

@Service
public class gerador  {
	private String documento = "teste";
	
	public gerador(){
	}

	public String getDocumento() {
		return documento;
	}

	public String setDocumento(String documento) {
		return this.documento = documento;
	}
	
}

