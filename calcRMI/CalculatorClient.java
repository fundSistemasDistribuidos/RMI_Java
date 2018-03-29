import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CalculatorClient{


    public static void main(String[] args)
    {
        //Capturando os argumentos da soma
        String firstElement = (args.length < 1) ? null : args[0];
        String secondElement = (args.length < 2) ? null : args[1];

        try
        {

          //Pegando os serviços oferecidos
          Registry reg = LocateRegistry.getRegistry();
          //Procurando por um serviço com o nomde de ADD
          Calculator stub = (Calculator) reg.lookup("Add");
          //Usando serviço que foi consultado
          Long result = stub.add( Long.parseLong(firstElement), Long.parseLong(secondElement));
          System.out.println("Adição: "+result);
        }
        catch (Exception e)
        {
            System.out.println("CalculatorClient exception: "
            + e.getMessage());
            e.printStackTrace();
        }
    }
}
