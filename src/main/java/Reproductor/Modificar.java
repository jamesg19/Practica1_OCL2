/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import Archivos.LecturaArchivoBinario;

/**
 * 
 * @author James Gramajo 
 */
public class Modificar {
    private String nombrePista;
    private Pista pista;
    
    public Modificar(String nombrePista) {
        this.nombrePista = nombrePista;
    }
    
    
    
    public String  modificar(){
        String codigo_pista="";
        LecturaArchivoBinario arch = new LecturaArchivoBinario();
        //obtenemos el objeto pista seleccionado
        pista=null;
        pista =(Pista) arch.LeerArchivo(nombrePista);
        codigo_pista=pista.getCODIGO();
        
        return codigo_pista;
    }

}
