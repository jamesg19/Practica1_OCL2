/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;

import Reproductor.Pista;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author James Gramajo 
 */
public class GuardarArchivoBinario {
    Pista pista;
    public GuardarArchivoBinario(Pista pista) {
        this.pista=pista;
        
    }
    public void guardarObjeto(){
        String basePath = new File("").getAbsolutePath();
        basePath+="\\src\\main\\java\\ArchivoPista\\";
        File archivo = new File(basePath+pista.getNombre()+".dat");
        System.out.println("path: "+basePath+""+pista.getNombre()+".dat");
        
        try{
            FileOutputStream fos= new FileOutputStream(archivo,true);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(pista);
            oos.close();
            fos.close();
            System.out.println("SE HA GUADADO EL OBJETO");
            
        
        
        }catch(Exception e){
            System.out.println(e);
            System.out.println("ERROR AL GUARDAR OBJETO");
        }
        
    }
    
    
    
    
    
    
    

}
