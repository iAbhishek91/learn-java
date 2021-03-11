package javaBasics.clientserver.helloworld;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {

            // this will wait for the client before executing rest of the code.
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");


            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true); // if we don't put true we need flush the stream every time you write to that stream.

            // to keep the server running
            while(true) {
                String echoString = input.readLine();
                // Exit criteria, optional
                if (echoString.equals("EXIT")) {
                    break;
                }
                System.out.println("Server prints: " + echoString);
            }
        } catch (IOException ioe) {
            System.out.println("Server exception: " + ioe.getMessage());
            ioe.printStackTrace();
        }
    }

}
