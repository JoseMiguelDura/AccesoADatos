/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiusosv0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    public void cargar(String nombreFichero)
    {
        this.nombreFichero=nombreFichero;
        if(nombreFichero.endsWith(".dat"))
        {
            
            try {
                DataInputStream file=null;
                file = new DataInputStream(new FileInputStream(nombreFichero));
                int cantidad=file.read();
                for(int softwareAct=0;softwareAct<cantidad;softwareAct++)
                {
                    String nombre="";
                    for(int i=0;i<50;i++)
                    {
                        nombre+=file.readChar();
                    }
                    String descripcion="";
                    for(int i=0;i<50;i++)
                    {
                        descripcion+=file.readChar();
                    }
                    String licencia="";
                    for(int i=0;i<50;i++)
                    {
                        licencia+=file.readChar();
                    }
                    Double precio=file.readDouble();
                    String requisitos="";
                    for(int i=0;i<50;i++)
                    {
                        requisitos+=file.readChar();
                    }
                    String alternativas="";
                    for(int i=0;i<50;i++)
                    {
                        alternativas+=file.readChar();
                    }
                    miLista.add(new Software(nombre,descripcion,licencia,
                            precio,requisitos,alternativas));
                    file.close();
                }
            } 
            catch(EOFException e)
            {
                
            }catch (FileNotFoundException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
                FileReader fr = null;
            try {
                fr = new FileReader(new File(nombreFichero));
                BufferedReader br=new BufferedReader(fr);
                int cantidad=Integer.parseInt(br.readLine());
                for(int i=0;i<cantidad;i++)
                {
                    String nombre=br.readLine();
                    String descripcion=br.readLine();
                    String licencia=br.readLine();
                    Double precio=Double.parseDouble(br.readLine());
                    String requisitos=br.readLine();
                    String alternativas=br.readLine();
                    miLista.add(new Software(nombre,descripcion,licencia,precio,
                            requisitos,alternativas));
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fr.close();
                } catch (IOException ex) {
                    Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void guardar(String nombreFichero,String tipoFichero)
    {
        this.nombreFichero=nombreFichero;
        if(tipoFichero.equals("BINARIO"))
        {
            DataOutputStream file=null;
            try {
                file = new DataOutputStream(new FileOutputStream(nombreFichero+".dat"));
                file.write(miLista.size());
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
                FileWriter fw = null;
            try {
                fw = new FileWriter(new File(nombreFichero+".txt"));
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(miLista.size());
                bw.newLine();
                for(int i=0;i<miLista.size();i++)
                {
                    Software aux=miLista.get(i);
                    bw.write(aux.getNombre());
                    bw.newLine();
                    bw.write(aux.getDescripcion());
                    bw.newLine();
                    bw.write(aux.getLicencia());
                    bw.newLine();
                    bw.write(String.valueOf(aux.getPrecio()));
                    bw.newLine();
                    bw.write(aux.getRequisitos());
                    bw.newLine();
                    bw.write(aux.getAlternativas());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ModeloMultiusos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void Anyadir(Software miSoft)
    {
        miLista.add(miSoft);
    }
    
}
