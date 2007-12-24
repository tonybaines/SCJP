package suncertify.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 */
public interface IRemote extends Remote {
    public String[] getStringArray() throws RemoteException;
}
