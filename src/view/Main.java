package view;

import controller.KillController;

public class Main {
	public static void main(String args[]) {
		KillController killcontroller = new KillController();
		
		killcontroller.listaProcessos();	
	}

}
