

package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.DoctorController;
import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;

public class HomeDoctorView implements View{
	
	private String choice;
	private DoctorController doctorController;
	private Request request;
	
	public HomeDoctorView() {
		this.doctorController = new DoctorController();
	}
	public void showResults(Request request) {
		System.out.println("Welcome in ROSER " + request.get("nomeUtente").toString());
	}
	
	
	public void showOptions() {
		/*System.out.println("-------DOCTOR MENU-------\n");
		System.out.println("ID\tNome\tCognome\tUsername\tPassword\tTipoUtente\tStato");
		System.out.print("-------------------------------------------------------------------------------");
		List<User> users = doctorController.getAllUser();
		System.out.println();
		users.forEach(user -> System.out.println(user.toString()));
		System.out.println();
		System.out.println("Make a choice");
		System.out.println("[M]odify - [D]elete Patient - [I]nsert Patient - [E]xit");
		this.choice = this.getInput();
		request = new Request();
		request.put("choice",choice);
		request.put("mode", "");*/
		
	}
	
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callView("DoctorUser", null);
		
	}
}
