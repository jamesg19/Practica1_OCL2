/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import arbol.Operacion;

/**
 * 
 * @author James Gramajo 
 */
public class GestorReproducir {
    //Identificador de la variable que se va a incrementar.
    private  String nota;
    private  int octava;
    private  int tiempo;
    private  int canal;
    private  String linea;
    private boolean esNota;

   /**
    * GESTOR PARA DEPRODUCIR MUSICA
    * @param nota
    * @param octava
    * @param tiempo
    * @param canal 
    */ 
    public GestorReproducir(boolean esNota,String nota, int octava, int tiempo, int canal ) {
        this.esNota=esNota;
        this.nota = nota;
        this.octava = octava;
        this.tiempo = tiempo;
        this.canal = canal;

    }
    
    /**
     * GESTOR PARA ESPERA
     * @param tiempo
     * @param canal 
     */
    public GestorReproducir(boolean esNota,int tiempo, int canal) {
        this.esNota=esNota;
        this.tiempo=tiempo;
        this.canal=canal;

    }
   
    
    
    
    
    

}
