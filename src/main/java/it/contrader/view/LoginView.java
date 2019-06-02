package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class LoginView implements View {

	private String nomeUtente;
	private String password;

	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("----- .:LOGIN - ROSER:. ----\n");
		System.out.print("Username:");
		nomeUtente = getInput();
		System.out.print("Password:");
		password = getInput();
	}

	public void submit() {
		Request request = new Request();
		request.put("nomeUtente", nomeUtente);
		request.put("password", password);
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
