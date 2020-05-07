
package parse;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrappingSiteABSOLAR{
    
    public static void main(String[] args) throws IOException {
        
        Document doc = Jsoup.connect("http://absolar.org.br/associado").get();
        
        
        Elements companyName = doc.getElementsByAttribute("li");
        
        System.out.println(companyName.size());
        
        /*
        Elements nomeempresas = doc.select("li div.nome");
        Elements dados = doc.select("li a[href]");
        System.out.println(nomeempresas);
        System.out.println(dados);
        for (Element nomeempresa:nomeempresas){
            System.out.println(nomeempresa.text());
            for (Element dado:dados){
                System.out.println(dado.attr("href"));
            }
        
            
            String dados = data.select("div[style*=5px] > a[href]").attr("href");
            if (nomeempresa != null){
            System.out.println(nomeempresa);
            System.out.println(dados);
            }
            Elements elements = doc.select("div.nome");
            Elements mails = doc.select("div[style*=5px] > a[href]");
            for (Element element:elements){
            String nome = element.text();
            System.out.println(nome);
            for (Element mail:mails){
                String mail1 = mail.attr("href");
                System.out.println(mail1);
            }
        }*/ 
    }
}
//Elements elements = doc.getElementsByClass("nome");
