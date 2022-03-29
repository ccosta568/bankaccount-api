package buccaneers.bank;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import io.javalin.http.Handler;
import buccaneers.bank.Client;
import buccaneers.bank.ConnectionUtils;
import buccaneers.bank.daos.ClientDAO;
import buccaneers.bank.daos.ClientPostgresDAO;

public class ClientHandler {
	
	static ClientDAO dao= new ClientPostgresDAO();
	
	public static Handler getAllClients = ctx->{
		List<Client> cList=dao.getAllClients();
		ctx.json(cList);
	};
	
	public static Handler addClient = ctx -> {
		Client client = ctx.bodyAsClass(Client.class);
		dao.addClient(client);
		ctx.status(201);
	};
	
	
	public static Handler updateClient = ctx ->{
			int id=Integer.parseInt(ctx.pathParam("id"));
			Client c1=ctx.bodyAsClass(Client.class);
			dao.updateClient(c1, id);
			ctx.status(200);
	};
	
	public static Handler deleteClient = ctx ->{
		int id=Integer.parseInt(ctx.pathParam("id"));
		Client client=ctx.bodyAsClass(Client.class);
		dao.deleteClient(client, id);
		ctx.status(205);
	};
	
	
	  public static Handler getClientbyid = ctx->{ 
		int p =Integer.parseInt(ctx.pathParam("id")); 
		  //Client client=ctx.bodyAsClass(Client.class); 
		  //dao.getClientbyid(client, p);
		  //ctx.json(client);
	//};
		Connection conn = ConnectionUtils.createConnection();
		PreparedStatement pstmt = conn.prepareStatement("Select * From bankaccount where client_id=?");
		pstmt.setInt(1, p);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Client> gList = new ArrayList<Client>();
		Client g;
		while (rs.next()) {
			int id = rs.getInt("client_id");
			String name = rs.getString("client_name");
			int capHit = rs.getInt("client_cap_hit");
			int baseSalary = rs.getInt("client_base_salary");
			int signingBonus = rs.getInt("client_signing_bonus");
			g = new Client(id, name, capHit, baseSalary, signingBonus);
			gList.add(g);			
		}
		ctx.json(gList);
		rs.close();
		pstmt.close();
	};
	
	public static Handler addClientbyid = ctx -> {
		int id=Integer.parseInt(ctx.pathParam("id"));
		Client client = ctx.bodyAsClass(Client.class);
		dao.addClientbyid(client, id);
		ctx.status(201);
};

}

