/*
package battleforglory;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;


public class Servidor{
    private int puerto=8000;
    private int PLAYER1=1;
    private int PLAYER2=2;
    public static void main(String[] args) {
        Servidor server = new Servidor();
    }
    public Servidor (){
        //se crea el servidor
        try{
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println(new Date()+ "Servidor iniciado en el puerto "+puerto);
            int sesionNo=1;
            while(true){
                System.out.println(new Date()+": esperando conexion con jugadores en servidor #"+sesionNo);
                
                Socket player1= serverSocket.accept();
                System.out.println(new Date()+": conexion establecida con jugador 1");
                System.out.println(" Jugador 1 IP:  "+player1.getInetAddress().getHostAddress());
                new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);
                
                Socket player2=serverSocket.accept();
                System.out.println(new Date()+": conexion establecida con jugador 2");
                System.out.println(" Jugador 2 IP: "+player2.getInetAddress().getHostAddress());
                new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);
                
                System.out.println("Juego iniciado en el servidor numero: "+sesionNo);
                
                HandleASession task = new HandleASession (player1,player2);
                new Thread (task).start();
            }
            
        }
        catch(IOException ex) {
            System.err.println(ex);
        }
        
        
        
    }

}
class HandleASession extends Objeto implements Runnable{
            
            private Socket player1;
            private Socket player2;
            
            private DataInputStream fromPlayer1;
            private DataOutputStream toPlayer1;
            private DataInputStream fromPlayer2;
            private DataOutputStream toPlayer2;
            
            private boolean continueToPlay = true;
            
            public HandleASession (Socket player1, Socket player2){
                super(null);
                this.player1=player1;
                this.player2=player2;
            }
            
            @Override
            public void run() {
                try{
                     ObjectInputStream fromPlayer1 = new ObjectInputStream(
                                player1.getInputStream());
                     ObjectOutputStream toPlayer1 = new ObjectOutputStream(
                                player1.getOutputStream());
                     ObjectInputStream fromPlayer2 = new ObjectInputStream(
                                player2.getInputStream());
                     ObjectOutputStream toPlayer2 = new ObjectOutputStream(
                                player2.getOutputStream());
                     while (true){
                         Object obj1=fromPlayer1.readObject();
                         Object obj2=fromPlayer2.readObject();
                         sendMove(toPlayer1,obj2);
                         sendMove(toPlayer2,obj1);
                     }
                }catch(IOException ex) {
                    System.err.println(ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            private void sendMove(ObjectOutputStream out,Object ob)
            throws IOException{
                out.writeObject(ob); 
            }

            @Override
            public void dibujar(GraphicsContext lapiz) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }*/