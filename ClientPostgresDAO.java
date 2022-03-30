package buccaneers.bank.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buccaneers.bank.Client;
import buccaneers.bank.ConnectionUtils;

public class ClientPostgresDAO implements ClientDAO {

	@Override
	public List<Client> getAllClients() {
		Connection conn = ConnectionUtils.createConnection();
		Client c;
		PreparedStatement pstmt;
		ArrayList<Client> cList = new ArrayList<Client>();
		String selectAllClients = "SELECT * From bankaccount";

		try {
			pstmt = conn.prepareStatement(selectAllClients);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("client_id");
				String name = rs.getString("client_name");
				int capHit = rs.getInt("client_cap_hit");
				int baseSalary = rs.getInt("client_base_salary");
				int signingBonus = rs.getInt("client_signing_bonus");
				c = new Client(id, name, capHit, baseSalary, signingBonus);
				cList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cList;
	}

	
	public Client addClient(Client client) { 
		try(Connection conn=ConnectionUtils.createConnection()) {
			String sql = "insert into bankaccount values(?,?,?,?,?)"; 
		 
		  PreparedStatement pstmt =conn.prepareStatement(sql);
		  pstmt.setInt(1, client.getId());
		  pstmt.setString(2, client.getName());
		  pstmt.setInt(3, client.getCapHit());
		  pstmt.setInt(4, client.getBaseSalary());
		  pstmt.setInt(5, client.getSigningBonus());
		  pstmt.execute(); //return
		  ResultSet rs= pstmt.getGeneratedKeys();
		  rs.next();
		  
		  }catch(SQLException e) { 
			  e.printStackTrace(); } 
		return null; }

	
	public Client updateClient(Client c1, int id) {
		try(Connection conn = ConnectionUtils.createConnection();){
			PreparedStatement pstmt = conn.prepareStatement("update bankaccount set client_name=? where client_id=?");
			pstmt.setString(1, c1.getName());
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch(SQLException e) { 
		  e.printStackTrace();
		 } 
		return null;}
	
	
	public Client deleteClient(Client client, int id) {
		try(Connection conn = ConnectionUtils.createConnection();){
			PreparedStatement pstmt = conn.prepareStatement("Delete FROM bankaccount WHERE client_id=?");
			pstmt.setInt(1, id);
			pstmt.execute();
		}catch(SQLException e) { 
			  e.printStackTrace();
			 }
		return null;}
	
	
	  public Client addClientbyid(Client client, int id) {
		  try(Connection conn=ConnectionUtils.createConnection()) {
			  PreparedStatement pstmt = conn.prepareStatement("insert into bankaccount values(?,?,?,?,?)");
				pstmt.setInt(1, client.getId());
				pstmt.setString(2, client.getName());
				pstmt.setInt(3, client.getCapHit());
				pstmt.setInt(4, client.getBaseSalary());
				pstmt.setInt(5, client.getSigningBonus());
				pstmt.execute();
	  }catch(SQLException e) { 
		  e.printStackTrace();}
	return null;}
}
	  


