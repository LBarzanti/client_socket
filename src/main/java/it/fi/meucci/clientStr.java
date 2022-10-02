package it.fi.meucci;
import java.io.*;
import java.net.*;

public class clientStr 
{
    String nomeServer = "localhost";
    int portaServer = 25565;
    Socket mioSocket;
    BufferedReader tastiera;
    String utente;
    String ricevuta;
    DataOutputStream toServer;
    BufferedReader byServer;
    public Socket connetti()
    {
        try
        {
            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(nomeServer, portaServer);
            toServer = new DataOutputStream(mioSocket.getOutputStream());
            byServer = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));
        }
        catch (UnknownHostException e)
        {
            System.out.println("Host sconosciuto");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("errore durante la connessione");
            System.exit(1);
        }
        return mioSocket;
    }

    public void comunica()
    {
        try
        {
            System.out.println("inserisci la stringa da trasmettere");
            utente = tastiera.readLine();
            toServer.writeBytes(utente + "\n");
            ricevuta = byServer.readLine();
            System.out.println("il server ha risposto: " + ricevuta);
            mioSocket.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione col server");
            System.exit(1);
        }
    }
}

