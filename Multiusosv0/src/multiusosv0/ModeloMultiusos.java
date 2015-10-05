/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusosv0;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public void Guardar(String nombreFichero,String tipoFichero)
    {
        this.nombreFichero=nombreFichero;
        if(tipoFichero.equals("BINARIO"))
        {
            DataOutputStream file=null;
            try {
                file = new DataOutputStream(new FileOutputStream(nombreFichero));
                for(int i=0;i<miLista.size();i++)
                {
                    Software aux=miLista.get(i);
                    StringBuffer buffer=null;
                    buffer=new StringBuffer(aux.getNombre());
                    buffer.setLength(50);
                    file.writeChars(buffer.toString());
                    buffer=new StringBuffer(aux.getDescripcion());
                    buffer.setLength(50);
                    file.writeChars(buffer.toString());
                    buffer=new StringBuffer(aux.getLicencia());
                    buffer.setLength(50);
                    file.writeChars(buffer.toString());
                    file.writeDouble(aux.getPrecio());
                    buffer=new StringBuffer(aux.getRequisitos());
                    buffer.setLength(50);
                    file.writeChars(buffer.toString());
                    buffer=new StringBuffer(aux.getAlternativas());   
                    buffer.setLength(50);
                    file.writeChars(buffer.toString());
                }   file.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        else
        {
            
        }
    }
    
    public void Anyadir(Software miSoft)
    {
        miLista.add(miSoft);
    }
    
}
