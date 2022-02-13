/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcuevash.manejoArchivos;

import com.lowagie.text.DocumentException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author jair
 */
public class ManejoDeArchivos {
    
            String ruta = "C:\\Users\\jair\\Desktop\\java";
            String nameFile="index.html";
            String contenido = "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <title>Document</title>\n" +
"</head>\n" +
"<body>\n" +
"    <h1>prueba</h1>\n" +
"</body>\n" +
"</html>";
            
            
    public boolean generaHtml(){
        boolean resultado = true;
        String archivo =ruta+"\\"+nameFile;
        System.out.println("Inicia el metodo:generaHtml");
             System.out.println("ruta: "+archivo);
       try {      
                 File file = new File(archivo);
                 if(!file.exists()){
                        file.createNewFile();
                     }
                 
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            System.out.println("Se inserta el contenido del archivo");
            bw.close();
           } catch (IOException ex) {
               System.out.println("Erro metodo generaHtml: "+ex);
            }
       System.out.println("Termina el metodo:generaHtml");
        return resultado;
    }
    
      public boolean generaPdf() {
         boolean resultado = true;
         String ficheroHTML=ruta+"\\"+nameFile;
         String url; 
          System.out.println("Inicia el metodo: generaPdf");
                try {
                         url = new File(ficheroHTML).toURI().toURL().toString();
                        System.out.println("url: "+url);
                        String ficheroPDF =ruta+"\\"+ "plantilla.pdf"; 
                        OutputStream os = new FileOutputStream(ficheroPDF);  
                        ITextRenderer renderer = new ITextRenderer();     
                        renderer.setDocument(url); 
                        renderer.layout(); 
                        renderer.createPDF(os); 
                        os.close(); 
                } catch (MalformedURLException ex) {
                    System.out.println("Error1:"+ex);
                } catch (DocumentException ex) {       
                    System.out.println("Error2:"+ex);
                } catch (IOException ex) {
                System.out.println("Error3:"+ex);
                }
                System.out.println("Termina el metodo:generaPdf");
         return resultado;
      }
    
}
