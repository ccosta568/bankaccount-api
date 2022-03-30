package buccaneers.bank.daotests;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import buccaneers.bank.Client;
import buccaneers.bank.daos.ClientDAO;
import buccaneers.bank.daos.ClientPostgresDAO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientDaoTest {
	private static ClientDAO dao = new ClientPostgresDAO();
	
	@Test
	@Order(1)
	void get_all_clients() {
        List<Client> allClients = dao.getAllClients();
        Assertions.assertEquals(allClients.size(), 21);
	}
}
