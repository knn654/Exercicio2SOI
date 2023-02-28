package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {
	
	private String os() {
		String nome = System.getProperty("os.name");
		return nome;
		
	}
	
	public void listaProcessos() {
		String nome = System.getProperty("os.name");
		if(nome.contains("Windows")) {
			String processo = "TASKLIST /FO TABLE";
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String processo = "ps -ef";
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null) {
					System.out.println(linha);
					linha = buffer.readLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void mataPid() {
		int PID = 0;
		PID = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID a ser morto"));
		String nome = System.getProperty("os.name");
		if(nome.contains("Windows")) {
			String processo = "TASKKILL /PID " + PID;
			try {
				Process p = Runtime.getRuntime().exec(processo);
				System.out.println("Processo encerrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String processo = "kill -9 " + PID;
			try {
				Process p = Runtime.getRuntime().exec(processo);
				System.out.println("Processo encerrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mataNome() {
		String Nome = "";
		Nome = JOptionPane.showInputDialog("Digite o nome do programa a ser morto");
		String nome = System.getProperty("os.name");
		if(nome.contains("Windows")) {
			String processo = "TASKKILL /IM " + Nome;
			try {
				Process p = Runtime.getRuntime().exec(processo);
				System.out.println("Processo encerrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			String processo = "pkill -f " + Nome;
			try {
				Process p = Runtime.getRuntime().exec(processo);
				System.out.println("Processo encerrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		
	
}
