/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reproductor;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

/**
 * 
 * @author James Gramajo 
 */
public class GestorGrafica extends Thread {
    private long initialTime;
    private LinkedList<NotasLeidas> notas = new LinkedList();
    private JPanel panel;
    private XYSeriesCollection oDataset;
    private JFreeChart oChart;
    private ChartPanel oPanel;
    private String SILENCIO=" R";
    String DO=" C/0.05";
    XYSeries oSeriesAnt;
    
    

    public GestorGrafica(JPanel panel,XYSeriesCollection oDataset,JFreeChart oChart,ChartPanel oPanel) {
        this.panel=panel;
        this.oDataset=oDataset;
        this.oChart=oChart;
        this.oPanel=oPanel;
    }
    
    @Override
    public void run(){
        //nombre de la linea
            XYSeries oSeries = new XYSeries("Canal " + notas.get(0).getCanal());
            //XYSeriesCollection oDataset = new XYSeriesCollection();

            
            oSeries.add(0, 0);
            Player jukeboxG = new Player();


        System.out.println("@@@@@@@@------ENTRA A GRAFICA-----@@@@@@");
        try {
 
            for (int i = 0; i < notas.size(); i++) {
                //System.out.println(i);
                System.out.println(i);
                double seg=( (System.currentTimeMillis() - initialTime) / 1000);
                double hertz=notas.get(i).getFrecuencia();
                
                oSeriesAnt= oSeries;
                oSeries.add( seg,hertz);
                System.out.println("(Hz,seg) "+hertz+","+seg+" canal "+notas.get(0).getCanal());
                int time= (int) ((notas.get(i).getTiempo())*(1000));

                esperarXsegundos(time);
                if(i>0){
                    oDataset.removeSeries(oSeriesAnt);
                    
                }
                
                oDataset.addSeries(oSeries);
                
                oChart = ChartFactory.createXYLineChart("", "Seg", "Hz", oDataset, PlotOrientation.VERTICAL, true, false, false);
                
                
                //ChartPanel oPanel = new ChartPanel(oChart);
                oPanel.setChart(oChart);
                
                panel.setLayout(new java.awt.BorderLayout());
                panel.add(oPanel);
                panel.validate();
                
                

            }
        } catch (Exception e) {
             //Logger.getLogger(GestorGrafica.class.getName()).log(Level.SEVERE, null, e);
            //System.out.println("____________ERROR AL LEER LAS NOTAS GESTOR GRAFICA");
        }
        System.out.println("EL GRAFICO " + notas.get(0).getCanal() + " HA TERMINADO A: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg.");
    }
    private void esperarXsegundos(int segundos) {
        try {
           
            Thread.sleep(segundos);
        } catch (InterruptedException ex) {
            System.out.println("__________ERROR EN TIEMPO DE ESPERA"+ex);
            Thread.currentThread().interrupt();
        }
    }

    public long getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    public LinkedList<NotasLeidas> getNotas() {
        return notas;
    }

    public void setNotas(LinkedList<NotasLeidas> notas) {
        this.notas = notas;
    }
    
    
    
    
    

}
