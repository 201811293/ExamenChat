/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatjavainge;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Cliente {
public static void main(String argv[]) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));//para que lea
            Socket socket;
    byte[] mensaje_bytes = new byte[256];
        String mensaje="";
    try {
        socket = new Socket("127.0.0.1",6000);
        DataOutputStream out =
    new DataOutputStream(socket.getOutputStream());//salida
    
        
        DataInputStream in2 = new DataInputStream(socket.getInputStream());//entrada
        
        System.out.println("Envie mensaje: ");
        String mensajeServidor ="";
    do {
        mensaje = in.readLine();
        out.writeUTF(mensaje);
        out.flush();
        
        mensajeServidor = in2.readUTF();
        System.out.println("Recibiendo mensaje del servidor: "+mensajeServidor);
        
        
      
    } while (!mensaje.startsWith("fin"));//si el mensaje no comienza con fin end mid pls 
        }
    catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
    }
}
