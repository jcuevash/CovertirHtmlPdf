/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcuevash.htmlpdf;

import com.jcuevash.manejoArchivos.ManejoDeArchivos;
import com.lowagie.text.DocumentException;

import java.io.IOException;


/**
 *
 * @author jair
 */
public class pruba {
      public static void main(String[] args) throws IOException, DocumentException { 
       boolean ok = false;
        
          ManejoDeArchivos mda = new ManejoDeArchivos();
          
          ok = mda.generaHtml();
          if(ok){
             ok = mda.generaPdf();
          }
        if(ok){
            System.out.println("Termino el proceso de manera Correcta");
        }else{
            System.out.println("Error en el proceso");
        }
      }
}
