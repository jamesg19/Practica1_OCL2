/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfugue.pattern.Pattern;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;

/**
 *
 * @author James Gramajo
 */
public class Canal extends Thread {

    private String DO = " C";
    private String RE = " D";
    private String MI = " E";
    private String FA = " F";
    private String SOL = " G";
    private String LA = " A";
    private String SI = " B";
    private String DOO = " C#";
    private String REE = " D#";
    private String MII = " E#";
    private String FAA = " F#";
    private String SOLL = " G#";
    private String LAA = " A#";
    private String SILENCIO = " R";
    private String codigo = "";
    private long initialTime;
    private LinkedList<NotasLeidas> notas = new LinkedList();
    
    XYSeriesCollection oDataset;

    public Canal(JPanel panel,XYSeriesCollection oDataset) {
        //al crear la clase
        this.oDataset=oDataset;

    }

    @Override
    public void run() {
        try{
        System.out.println("ESTAS EN EL CANAL " + notas.get(0).getCanal());
        Player jukebox = new Player();
        
        System.out.println("EL CANAL " + notas.get(0).getCanal() + " HA INICIALO A: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg.");

        
        jukebox.play(codigo);
        System.out.println("EL CANAL " + notas.get(0).getCanal() + " HA TERMINADO A: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg.");
        } catch(Exception e){
            System.out.println("___________ERROR EN RUN() CANAL"+e);
        }
    }

    public  void obtener_codigo_musical() {
        try {
            //System.out.println("EL CANAL " + notas.get(0).getCanal() + " HA INICIALO A: " + (System.currentTimeMillis() - initialTime) / 1000 + " seg.");
            for (int i = 0; i < notas.size(); i++) {

                String tono = obtener_nota(notas.get(i).getNota());
                tono += "/" + ((notas.get(i).getTiempo())/(2));
                
                codigo += tono;

            }
        } catch (Exception e) {
            Logger.getLogger(Canal.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("____________ERROR AL LEER LAS NOTAS"+e);
        }
    }

    private String obtener_nota(String nt) {

        if (nt.equalsIgnoreCase("do")) {
            return DO;
        } else if (nt.equalsIgnoreCase("re")) {
            return RE;
        } else if (nt.equalsIgnoreCase("mi")) {
            return MI;
        } else if (nt.equalsIgnoreCase("fa")) {
            return FA;
        } else if (nt.equalsIgnoreCase("sol")) {
            return SOL;
        } else if (nt.equalsIgnoreCase("la")) {
            return LA;
        } else if (nt.equalsIgnoreCase("si")) {
            return SI;
        } else if (nt.equalsIgnoreCase("do#")) {
            return DOO;
        } else if (nt.equalsIgnoreCase("re#")) {
            return REE;
        } else if (nt.equalsIgnoreCase("mi#")) {
            return MII;
        } else if (nt.equalsIgnoreCase("fa#")) {
            return FAA;
        } else if (nt.equalsIgnoreCase("sol#")) {
            return SOLL;
        } else if (nt.equalsIgnoreCase("la#")) {
            return LAA;
        } else {
            return SILENCIO;
        }
    }
    
    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
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
