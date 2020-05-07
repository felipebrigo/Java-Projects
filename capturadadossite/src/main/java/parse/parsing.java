
package parse;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parsing {
    
    public static void main(String[] args) throws IOException {
        
        for (int a=1; a<=17 /*(mudar para <=17)*/; a++){
            Document doc = Jsoup.connect("http://afeal.com.br/rev/?sfid=18885&sf_paged="+a).get();
            Elements nomeempresas = doc.select("h2 a");
                for (Element nomeempresa:nomeempresas){
                    System.out.print(nomeempresa.text() + " % ");
                    String urlempresa = nomeempresa.absUrl("href");
                    Document empresa = Jsoup.connect(urlempresa).get();
                    Elements dadosempresa = empresa.select("p");
                        for (Element dadoempresa:dadosempresa){
                            System.out.print(dadoempresa.text() + " % ");
                        }
                        System.out.println("");
                }
            
        }
        //System.out.println(doc);
        
    }     
}
