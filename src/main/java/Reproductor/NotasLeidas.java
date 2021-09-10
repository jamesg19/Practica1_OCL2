/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reproductor;

import Error.Exeption;
import arbol.Operacion;
import java.io.Serializable;

/**
 *
 * @author James Gramajo
 */
public class NotasLeidas implements Serializable {

    //Identificador de la variable que se va a incrementar.
    private String nota;
    private int octava;
    private double tiempo;
    private int canal;
    private String linea;
    private boolean esNota;
    private double frecuencia;

    /**
     * GESTOR PARA DEPRODUCIR MUSICA
     *
     * @param nota
     * @param octava
     * @param tiempo
     * @param canal
     */
    public NotasLeidas(boolean esNota, String nota, int octava, int tiempo, int canal) {
        this.esNota = esNota;
        this.nota = nota;
        this.octava = octava;
        this.tiempo = (tiempo)/1000.0;
        this.canal = canal;
        frecuenciaHZ(nota, octava);
        
    }

    /**
     * GESTOR PARA ESPERA
     *
     * @param tiempo
     * @param canal
     */
    public NotasLeidas(boolean esNota, int tiempo, int canal) {
        this.esNota = esNota;
        this.tiempo = tiempo/1000;
        this.canal = canal;
        this.nota = "silencio";
        this.frecuencia = 0;
        System.out.println("?????????????????____________________NOTA LEIDA CON"+this.tiempo);

    }

    public void frecuenciaHZ(String nt, int octava) {

        //OCTABA 0
        if (octava == 0) {
            if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 27.50;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 29.14;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 30.87;
            }
        }

        //OCTABA 1
        if (octava == 1) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 32.70;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 34.65;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 36.71;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 38.89;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 41.20;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 41.20;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 43.65;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 46.25;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 49.00;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 51.91;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 55.0;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 58.27;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 61.74;
            }
        }
        //OCTAVA 2
        if (octava == 2) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 65.41;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 69.30;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 73.42;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 77.78;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 82.41;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 82.41;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 87.31;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 92.50;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 98;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 103.83;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 110;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 116;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 123.47;
            }
        }

        //OCTAVA 3
        if (octava == 3) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 130.81;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 138.59;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 146.83;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 155.56;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 164.81;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 164.81;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 174.61;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 185;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 196;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 207.65;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 220.0;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 233.08;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 264.94;
            }
        }

        //OCTAVA 4
        if (octava == 4) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 261.63;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 277.18;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 293.66;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 311.13;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 329.63;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 329.63;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 349.23;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 369.99;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 392.0;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 415.30;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 440;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 466.16;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 493.88;
            }
        }
        //OCTAVA 5
        if (octava == 5) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 523.25;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 554.37;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 587.33;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 622.25;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 659.26;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 659.26;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 698.46;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 739.99;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 783.99;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 830.61;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 880;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 932.33;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 987.77;
            }
        }
        //OCTAVA 6
        if (octava == 6) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 1046.50;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 1108.73;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 1174.66;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 1244.51;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 1318.51;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 1318.51;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 1396.91;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 1479.88;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 1567.98;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 1661.22;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 1760;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 1864.66;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 1975.33;
            }
        }
        //OCTAVA 7
        if (octava == 7) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 2093;
            } else if (nt.equalsIgnoreCase("do#")) {
                this.frecuencia = 2217.46;
            } else if (nt.equalsIgnoreCase("re")) {
                this.frecuencia = 2349.32;
            } else if (nt.equalsIgnoreCase("re#")) {
                this.frecuencia = 2489.02;
            } else if (nt.equalsIgnoreCase("mi")) {
                this.frecuencia = 2637.02;
            } else if (nt.equalsIgnoreCase("mi#")) {
                this.frecuencia = 2637.02;
            } else if (nt.equalsIgnoreCase("fa")) {
                this.frecuencia = 2793.83;
            } else if (nt.equalsIgnoreCase("fa#")) {
                this.frecuencia = 2959.96;
            } else if (nt.equalsIgnoreCase("sol")) {
                this.frecuencia = 3135.96;
            } else if (nt.equalsIgnoreCase("sol#")) {
                this.frecuencia = 3322.44;
            } else if (nt.equalsIgnoreCase("la")) {
                this.frecuencia = 3520;
            } else if (nt.equalsIgnoreCase("la#")) {
                this.frecuencia = 3729.31;
            } else if (nt.equalsIgnoreCase("si")) {
                this.frecuencia = 3951.07;
            }
        }

        //OCTAVA 8
        if (octava == 8) {
            if (nt.equalsIgnoreCase("do")) {
                this.frecuencia = 4186.01;
            }
        }

    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getOctava() {
        return octava;
    }

    public void setOctava(int octava) {
        this.octava = octava;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public boolean isEsNota() {
        return esNota;
    }

    public void setEsNota(boolean esNota) {
        this.esNota = esNota;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

}
