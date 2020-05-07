
package com.bluequest.obterdadosplanilha;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reach_Values {

    public List<Item_Dados> capturar() throws IOException{
        
        List<Item_Dados> dados = new ArrayList();
      
      //abrir o arquivo selecionado
      @Cleanup FileInputStream file = new FileInputStream("/Users/mac/Desktop/Teste.xlsx");  
      Workbook workbook = new XSSFWorkbook(file);
      
      //Setando as abas
      Sheet sheet = workbook.getSheetAt(0);
      
      //Setando as linhas
      List<Row> rows = (List<Row>) toList(sheet.iterator());
      
      rows.forEach(row ->{
          
          List<Cell> cells = (List<Cell>) toList(row.cellIterator());
          Item_Dados dado = Item_Dados.builder()
                  .supplier(cells.get(0).getStringCellValue())
                  .material(cells.get(1).getStringCellValue())
                  .build();
          dados.add(dado);
      });
      
      return dados;
        
    }

    public List<?> toList(Iterator<?> iterator){
        
    return IteratorUtils.toList(iterator);
    }
            
    public void imprimir(List<Item_Dados> dados){
        dados.forEach(System.out::println);
    }
}
