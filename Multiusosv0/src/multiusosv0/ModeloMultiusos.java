/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusosv0;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jose Miguel Durá Sirvent
 */
public class ModeloMultiusos {
    private List<Software> miLista;
    private String nombreFichero;
    
    public ModeloMultiusos()
    {
        miLista=new ArrayList<>();
    }
   
    public Software getSoftware(int i)
    {
        return miLista.get(i);
    }
    
    public int getSize()
    {
        return miLista.size();
    }
    
    public void Cargar()
    {
      //TODO   
    }
    
    public void Guardar(String nombreFichero)
    {
        this.nombreFichero=nombreFichero;
        //TODO
    }
    
    public void Anyadir(Software miSoft)
    {
        miLista.add(miSoft);
    }
    
}
