package buccaneers.bank.daos;

import java.util.List;

import buccaneers.bank.Client;

public interface ClientDAO {
					
	List<Client>getAllClients();
					
	Client addClient(Client client); 
					
    Client updateClient(Client c1, int id);
    				
    Client deleteClient(Client client, int id);
    				
    Client addClientbyid(Client client, int Id);

}


