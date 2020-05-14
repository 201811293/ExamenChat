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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Servidor {
    
public static void main(String argv[]) {
    ServerSocket socket;
    BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));
    
    byte[] mensaje_bytes = new byte[256];
        String mensaje="";
boolean fin = false;
    try { 
        socket = new ServerSocket(6000);
        Socket socket_cli = socket.accept();
        DataInputStream in =
    new DataInputStream(socket_cli.getInputStream());
       
    DataOutputStream out =new DataOutputStream(socket_cli.getOutputStream());    
        System.out.println("Envie mensaje: ");
    do {
        String mensajeCliente ="";
        mensajeCliente = in.readUTF();
        System.out.println("Recibiendo mensaje: "+mensajeCliente);
        
        mensaje = in2.readLine();
        out.writeUTF(mensaje);
        out.flush();
    } while (!mensaje.startsWith("fin"));
        }
    catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
    }
}
