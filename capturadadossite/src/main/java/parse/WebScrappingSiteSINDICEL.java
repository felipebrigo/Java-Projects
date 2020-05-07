
package parse;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class WebScrappingSiteSINDICEL {
    
    public static void main(String[] args) throws IOException {
        
            Document doc = Jsoup.connect("http://www.sindicel.org.br/associados.asp").get();
            Elements nomeempresas = doc.select("tr td a[href]");
                for (Element nomeempresa:nomeempresas){
                    System.out.println(nomeempresa.text());
                    String urlempresa = nomeempresa.absUrl("href");
                    if (urlempresa.contains("associados.asp?id")==true){
                        System.out.println(urlempresa);
                    Document empresa = Jsoup.connect(urlempresa).get();
                    Elements dadosempresa = empresa.select("table.font02a tr td");
                        for (Element dadoempresa:dadosempresa){
                            System.out.println(dadoempresa.text());
                        }
                    }
                }
    }     
}
