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
import javax.swing.JOptionPane;

/**
 *
 * @author James Gramajo
 */
public class GuardarArchivoBinario {

    Pista pista;

    public GuardarArchivoBinario(Pista pista) {
        this.pista = pista;

    }

    public GuardarArchivoBinario() {
    }
    
    
    
    public void guardarObjeto() {
        String basePath = new File("").getAbsolutePath();
        basePath += "\\src\\main\\java\\ArchivoPista\\";

        //verificar existencia de archivo para no sobreescribir
        boolean flag=verificar_existencia_archivo(basePath + pista.getNombre() + ".dat");
        System.out.println("FLAG: "+flag);
        if (  flag==false) {

            File archivo = new File(basePath + pista.getNombre() + ".dat");
            System.out.println("path: " + basePath + "" + pista.getNombre().toString() + ".dat");

            try {
                FileOutputStream fos = new FileOutputStream(archivo, true);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(pista);
                oos.close();
                fos.close();
                System.out.println("SE HA GUADADO EL OBJETO");

            } catch (Exception e) {
                System.out.println(e);
                System.out.println("ERROR AL GUARDAR OBJETO");
            }
        }else{
            System.out.println("HAY UN ARCHIVO DUPLICADO Y NO SE PUEDE GUARDAR");
        }
    }

    public boolean verificar_existencia_archivo(String path) {
        File archivo = new File(path);
        if (archivo.exists()) {
            System.out.println("EL ARCHIVO EXISTEEEEE!!!!PTM");
            return true;
            //System.out.println("OJO: ¡¡No existe el archivo de configuración!!");
        } else {
            System.out.println("EL ARCHIVOOO NO EXISTEEEE!!!!");
            return false;
        }
    }
    
    public void EliminarArchivo(String nombre) {
        String basePath = new File("").getAbsolutePath();
        basePath += "\\src\\main\\java\\ArchivoPista\\";
        
        File fichero = new File(basePath+nombre+".dat");

        if (fichero.delete()) {
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente la pista: "+nombre);
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUDOELIMINAR LA PISTA "+nombre);
        }
    }


}
