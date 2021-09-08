/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Archivos;

import Reproductor.Pista;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;

/**
 * 
 * @author James Gramajo 
 */
public class LecturaArchivoBinario {
    private LinkedList<String> pistas=new LinkedList();
    public LecturaArchivoBinario() {
    }
    
    
    public Pista LeerArchivo(String nombre){
        String basePath = new File("").getAbsolutePath();
        basePath+="\\src\\main\\java\\ArchivoPista\\";
        
        File archivo= new File(basePath+nombre+".dat");

        try{
           FileInputStream fis= new FileInputStream(archivo);
           ObjectInputStream ois;
           while(fis.available()>0){
               ois=new ObjectInputStream(fis);
               Pista pista=(Pista) ois.readObject();
               return pista;
           }
            fis.close();
            
            
        }catch(Exception e){
            
        }
        return null;
    }
    
    public void ver_pistas() {
        String basePath = new File("").getAbsolutePath();
        basePath+="\\src\\main\\java\\ArchivoPista\\";
        
        File carpeta = new File(basePath);
        File[] lista = carpeta.listFiles();
        for(File lst: lista){
            String name=lst.getName().substring(0, lst.getName().toString().lastIndexOf('.'));
            
            pistas.add(name);
        }
        //System.out.println("\n Hay " + lista.length + " elementos");

    }

    public LinkedList<String> getPistas() {
        return pistas;
    }

    public void setPistas(LinkedList<String> pistas) {
        this.pistas = pistas;
    }

    
    
    

}
