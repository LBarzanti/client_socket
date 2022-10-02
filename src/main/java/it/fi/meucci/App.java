package it.fi.meucci;

public class App 
{
    public static void main( String[] args )
    {
        clientStr cliente = new clientStr();
        cliente.connetti();
        cliente.comunica();
    }
}
