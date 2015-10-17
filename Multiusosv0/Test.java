/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Jose Miguel Durá Sirvent
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int suma;
        for(int numerosComprobar=1;numerosComprobar<30;numerosComprobar++)
        {
            suma=0;
            for(int i=1;i<numerosComprobar;i++)
            {
                if(numerosComprobar%i==0)
                    suma+=i;
            }
            
            if(numerosComprobar==suma)
                System.out.println(suma);
        }
    }
}
