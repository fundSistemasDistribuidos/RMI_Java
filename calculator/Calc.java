import java.rmi.*;
import java.rmi.RemoteException;

/*
Classname: Hello
Comment: The remote interface.
*/
public interface Calc extends Remote {
	Integer calc(String op, Integer op1, Integer op2) throws RemoteException;
}
