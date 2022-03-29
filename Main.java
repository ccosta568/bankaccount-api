package buccaneers.bank;

import io.javalin.Javalin;

public class Main {
	public static void main(String[] args) {
	Javalin app = Javalin.create().start();
	
	app.get("/clients", ClientHandler.getAllClients);
	
	app.post("/clients", ClientHandler.addClient);
	
	app.put("/clients/{id}", ClientHandler.updateClient);
	
	app.delete("/clients/{id}", ClientHandler.deleteClient);
	
	app.get("/clients/{id}", ClientHandler.getClientbyid);
	
	app.post("/clients/{id}", ClientHandler.addClientbyid);
	
	}
}	
    













//app.get("/buccaneers", BankController.addClient);
	 //app.get("/buccaneersbank", ctx->{ctx.result("bankbuccaneers");//});
	 //app.get("/buccaneersbank/{team}", ctx->{ctx.result("NFL 2022 Bank Account for " + ctx.pathParam("team").toUpperCase() + " Salary Cap:$208.2 Million");});//insert string after / in url to make uppercase string phrase appear
	 //app.get("/bankcontroller", BankController.getAllClients);
	 //app.get("/data", BankController.getData);
	 //app.get("/bank", BankController.getBank);
	

