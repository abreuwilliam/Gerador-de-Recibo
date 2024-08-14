package com.dev.geradordepdf;

import java.awt.Desktop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
@Service
public class gerador  {
	private String documento = "teste";
	
	public gerador(){
	}

	public String getDocumento() {
	
	return documento;
	}
	
	public String setDocumento(String documento) {
		String documentos = this.documento = documento;
		JSONObject jsonObject = new JSONObject(documentos);
		String valor = jsonObject.getString("valor");
        String nomePagador = jsonObject.getString("nomepagador");
        String cpfPagador = jsonObject.getString("cpfpagador");
        String referencia = jsonObject.getString("referencia");
        String nomeEmissor = jsonObject.getString("nomeemissor");
        String cpfEmissor = jsonObject.getString("cpfemissor");
        String telefone = jsonObject.getString("telefone");
        String cidade = jsonObject.getString("cidade");
        String data = jsonObject.getString("data");
        String formaPagamento = jsonObject.getString("formapagamento");
        
        
        // Converter valor para extenso
        String valorPorExtenso = converter(Integer.parseInt(valor));
      String dataPorExtenso = converterData(data);
      
        
        String documento_formatado =                  "                                                             Recibo de Pagamento\n\n" +
               "                                                                                                                                        R$" + valor + ",00"+"\n\n" +
                "Recebi de  " + nomePagador + " , a importância de , " + valorPorExtenso +" Reais, referente à " + referencia +".\n" +
                "Para maior clareza, firmo o presente recibo, que comprove o recebimento integral do valor mencionado, concedendo ━━ quitação plena, geral e irrevogável ━━ pela quantia recebida.\n" +
                "Pagamento recebido através da "+ formaPagamento + ".\n" +
                   cidade  +" de " + dataPorExtenso + ".\n\n" +
                "                                           _______________________________________\n" + // Linha para assinatura
                "                                                                        "+ nomeEmissor +"\n" +
                "                                                                    CPF: "+ cpfEmissor + "\n";
               

        
        documentos = documento_formatado;
        this.documento = documentos;
		return documento;
	}
	public void gerarpdf(){

	Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("pdf test.pdf"));
			document.open();
			document.add(new Paragraph(documento));
			
			
		}
		catch(DocumentException e){
			e.printStackTrace();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			document.close();
		}
		try{
			Desktop.getDesktop().open(new File("pdf test.pdf"));
		}catch(Exception e2){
			
		}
			
			
		}
      
private static final String[] unidades = {
        "", "um", "dois", "três", "quatro", "cinco", 
        "seis", "sete", "oito", "nove"
    };
    
    private static final String[] dezenas = {
        "", "", "vinte", "trinta", "quarenta", "cinquenta",
        "sessenta", "setenta", "oitenta", "noventa"
    };
    
    private static final String[] dezenasEspeciais = {
        "dez", "onze", "doze", "treze", "quatorze", "quinze", 
        "dezesseis", "dezessete", "dezoito", "dezenove"
    };
    
    private static final String[] centenas = {
        "", "cento", "duzentos", "trezentos", "quatrocentos", 
        "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"
    };
    
    public static String converter(int numero) {
        if (numero == 100) {
            return "cem";
        }
        if (numero < 10) {
            return unidades[numero];
        } else if (numero < 20) {
            return dezenasEspeciais[numero - 10];
        } else if (numero < 100) {
            int dezena = numero / 10;
            int unidade = numero % 10;
            return (unidade == 0) ? dezenas[dezena] : dezenas[dezena] + " e " + unidades[unidade];
        } else if (numero < 1000) {
            int centena = numero / 100;
            int resto = numero % 100;
            return (resto == 0) ? centenas[centena] : centenas[centena] + " e " + converter(resto);
        } else if (numero < 1000000) {
            int milhar = numero / 1000;
            int resto = numero % 1000;
            String milharPorExtenso = (milhar == 1) ? "mil" : converter(milhar) + " mil";
            return (resto == 0) ? milharPorExtenso : milharPorExtenso + " e " + converter(resto);
        }
        return "Número fora do intervalo suportado";
    

    }

//Método para converter data para extenso no formato yyyy-MM-dd
    
public static String converterData(String data) {
    try {
        // Parseando a data no formato yyyy-MM-dd
        LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ISO_LOCAL_DATE);
        int dia = localDate.getDayOfMonth();
        int mes = localDate.getMonthValue();
        int ano = localDate.getYear();
        
        String mesPorExtenso = new DateFormatSymbols(new Locale("pt", "BR")).getMonths()[mes - 1];
    
        return dia + " de " + mesPorExtenso + " de " + ano;
    } catch (Exception e) {
        e.printStackTrace();
        return "Data inválida";
    }
}
}
    
