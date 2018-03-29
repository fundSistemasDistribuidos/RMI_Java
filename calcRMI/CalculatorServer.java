import java.rmi.Naming;
import java.rmi.RemoteException;
// import java.rmi.RMISecurityManager;
import java.rmi.server.*;


import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class CalculatorServer extends UnicastRemoteObject
implements Calculator
{

    private static final long serialVersionUID = 1L;

    public long add(long a, long b) throws RemoteException {
        return a+b;
    }

    public CalculatorServer() throws RemoteException{}

    public static void main(String[] args)
    {
        try
        {
            CalculatorServer c = new CalculatorServer();
            //Criando um registro
            Registry registry = LocateRegistry.getRegistry();
            //Registrando o servidor e no nome do servidor
            registry.rebind("Add", c);
        }
        catch (Exception ex)
        {
            System.out.println("error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
