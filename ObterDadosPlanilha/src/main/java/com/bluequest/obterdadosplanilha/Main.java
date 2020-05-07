
package com.bluequest.obterdadosplanilha;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void  main (String [] args) throws IOException {
    
    Reach_Values gerenciadordados = new Reach_Values();
    List<Item_Dados> dados = gerenciadordados.capturar();
    
    gerenciadordados.imprimir(dados);
    
    }    
}
