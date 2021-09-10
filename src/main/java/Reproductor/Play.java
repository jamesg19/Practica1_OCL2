/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import Archivos.LecturaArchivoBinario;
import java.util.LinkedList;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author James Gramajo
 */

public class Play {

    private String nombrePista;
    
    private Pista pista;
    private LinkedList<NotasLeidas> notas = new LinkedList();
    private LinkedList<Integer> canal = new LinkedList();

    private long initialTime;
    
    private JPanel panel;
    private XYSeriesCollection oDataset;
    private JFreeChart oChart;
    private ChartPanel oPanel;
    
    
    public Play(JPanel panel, String nombrePista,XYSeriesCollection oDataset,JFreeChart oChart,ChartPanel oPanel) {
        this.panel = panel;
        this.oDataset=oDataset;
        this.oChart=oChart;
        this.oPanel=oPanel;
        this.nombrePista = nombrePista;
    }

    public void reproducirPistaSeleccionada() {

        LecturaArchivoBinario arch = new LecturaArchivoBinario();
        //obtenemos el objeto pista seleccionado
        pista=null;
        pista =(Pista) arch.LeerArchivo(nombrePista);

        //obtenemos las notas de la pista
        notas=null;
        notas = pista.getSONIDO();

        analizarNotas();
        crearCanales();
    }

    private void analizarNotas() {

        for (int i = 0; i < notas.size(); i++) {
            //verifica si la lista de canales ya contiene este indice en su lista
            if (!canal.contains(notas.get(i).getCanal())) {
                canal.add(notas.get(i).getCanal());
            }

        }
    }

    private void crearCanales() {

        LinkedList<Canal> CanalesSonido = new LinkedList();
        LinkedList<GestorGrafica> GestorGraficaCanal = new LinkedList();

        //todos los canales solicitados por la pista
        for (int i = 0; i < canal.size(); i++) {
            //creamos un canal 
            Canal chanel = new Canal(panel,oDataset);
            GestorGrafica gst=new GestorGrafica(panel, oDataset, oChart, oPanel);
            
            
            //busca las notas de reproduccion y las asigna a cada canal
            for (int j = 0; j < notas.size(); j++) {

                if (notas.get(j).getCanal() == canal.get(i)) {
                    chanel.getNotas().add(notas.get(j));
                    gst.getNotas().add(notas.get(j));
                }
            }
            chanel.obtener_codigo_musical();
            CanalesSonido.add(chanel);
            GestorGraficaCanal.add(gst);
        }
       
        ejecutar_canales(CanalesSonido,GestorGraficaCanal);
    }
    
    private void ejecutar_canales(LinkedList<Canal> CanalesSonido,LinkedList<GestorGrafica> GestorGraficaCanal){
        try{
        long initialTime = System.currentTimeMillis();
        
        for(int i=0;i<CanalesSonido.size();i++){
            CanalesSonido.get(i).setInitialTime(initialTime);
            GestorGraficaCanal.get(i).setInitialTime(initialTime);
            CanalesSonido.get(i).start();
            GestorGraficaCanal.get(i).start();
        }
        }catch(Exception e){
            System.out.println("____________ERROR EN EJECUTAR CANALES PLYA.CLASS"+e);
        }
         
    }
    
    
    

}
