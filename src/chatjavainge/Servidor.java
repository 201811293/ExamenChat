/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatjavainge;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;//para el txt
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Servidor {
    
public static void main(String argv[]) {
    ServerSocket socket;
    BufferedReader in2 = new BufferedReader(new InputStreamReader(System.in));//entrada
    
        byte[] mensaje_bytes = new byte[256];
        String mensaje="",mensajeCliente="";  
        String Final = null;
    try { 
        socket = new ServerSocket(6000);
        
        Socket socket_cli = socket.accept();
        DataInputStream in =
    new DataInputStream(socket_cli.getInputStream());
       
    DataOutputStream out =new DataOutputStream(socket_cli.getOutputStream());    //salida
        System.out.println("Envie mensaje: ");
        
        
        while(!mensaje.equals("fin")){  //palabra para cerra
                mensaje=in.readUTF();  
                System.out.println("Cliente: "+mensaje);  
                mensajeCliente=in2.readLine();  
                out.writeUTF(mensajeCliente);  
                out.flush();  
                
                
                
                if(Final == null){
                    Final= "Cliente: "+mensaje+"\n"+"Servidor: "+mensajeCliente+"\n";
                }else{
                    Final= Final+"Cliente: "+mensaje+"\n"+"Servidor: "+mensajeCliente+"\n";
                  
                }
        
        }
        in.close();  
        socket.close();  
        int i = 1;
        String ruta = "C:/Users/Usuario/Documents/ExamenIngEder/"+ i +".txt";
        File archivo = new File(ruta); 
        
        
        
        
        do{
            ++i;
            ruta = "C:/Users/Usuario/Documents/ExamenIngEder/"+ i +".txt";
            archivo = new File(ruta);
        }while (archivo.exists());//mientras

        
        PrintWriter writer = new PrintWriter("C:/Users/Usuario/Documents/ExamenIngEder/"+ i +".txt", "UTF-8");
        writer.println(Final);
        writer.close();
        
     
        }
    catch (Exception e) {
        System.err.println(e.getMessage());
        System.exit(1);
        }
    }
}
