package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {
	public static void main(String args[]) {
		KillController killcontroller = new KillController();
		
		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					"Digite a opção desejada:\n" + 
			"1 - Mostrar processos\n"
			+ "2 - Matar por PID\n"
			+ "3 - Matar por Nome\n" + 
			"9 - Finalizar"));
			switch (opcao) {
			case 1:
				killcontroller.listaProcessos();
				break;
			case 2:
				killcontroller.mataPid();
				break;
			case 3:
				killcontroller.mataNome();
				break;
			default:
				break;
			}
		} while (opcao != 9);
	}

}
