package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
			
		}
		
	}
	
	public void mataPid() {
		
	}
	
	public void mataNome() {
		
	}
}
