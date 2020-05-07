package parse;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrappingSiteABAL {

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://abal.org.br/a-abal/empresas-associadas/").get();
        Elements nomeempresas = doc.select("option");
        for (Element nomeempresa : nomeempresas) {
            System.out.println(nomeempresa.text());
        }
        
        String dados = doc.getElementsByTag("ALCAST DO BRASIL LTDA").text();
        System.out.println(dados);
        /*    for (Element dado:dados){
                if (dado.hasClass("dados-associado")){
                    System.out.println(dado.text());
                }
                
            }
        /*Elements dados = doc.select("strong");        
                for (Element dado:dados){
                    System.out.println(dado.text());
                    System.out.println(dado.absUrl("href"));
                }
                
                
                    String urlempresa = dado.absUrl("href");
                    String dadosassociado = dado.text();
                    System.out.println(urlempresa);
                    System.out.println(dadosassociado);    
                    String dadosassociado = nomeempresa.getElementsByClass("dados-associado").text();
                    String produtos = nomeempresa.getElementsByClass("produtos-servicos-associado").text();
         */
    }
}
