/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author James Gramajo 
 */
public class Server {
    static int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    DataInputStream entrada;
    String mensajeRecibido;
    
    
    
    public void initServidor(){
        
        Scanner teclado = new Scanner(System.in);
        try{
            sc = new ServerSocket(PUERTO);
            so = new Socket();
            
            System.out.println("Esperando conexión...");
            so = sc.accept();
            System.out.println("Se ha conectado el cliente");
            entrada = new DataInputStream(so.getInputStream());
            salida = new DataOutputStream(so.getOutputStream());
            String msn = "";
            while(!msn.equals("x")){
                
                mensajeRecibido = entrada.readUTF();//Leemos respuesta
                System.out.println(mensajeRecibido);
//                System.out.println("Escriba un msn para enviar");
//                msn = teclado.nextLine();
//                salida.writeUTF(""+msn);//enviamos mensaje

            }
            //sc.close();
        }catch(Exception e){
            System.out.println("ERROR "+e);
        }
    }
    public void responderCliente(String respuesta){
        String mensaje = respuesta;
        try {
            salida.writeUTF(""+mensaje);//enviamos mensaje
            
        } catch (IOException ex) {
            
            System.out.println("ERROR AL ENVIAR EL MENSAJE AL CLIENTE KOTLIN");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
