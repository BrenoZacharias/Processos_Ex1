package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController(){
		super();
	}
	
	public void ip (String so){
		if(so.contains("Windows")){
			String process = "ipconfig";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null){
					if(linha.contains("Adaptador")){
						String temAdaptador = linha;
						linha = buffer.readLine();
							while(!linha.contains("Adaptador") && !linha.equals(null)){
								if(linha.contains("IPv4")){		
									String[] vetorDados = linha.split(". :");
									System.out.println(temAdaptador + vetorDados [1]);
								}
								linha = buffer.readLine();
							}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			} 
			catch (IOException e) {
			e.printStackTrace();
			}
		}
		if(so.contains("Linux")){
			
			
		}
		
		
	}
	
	public void ping (String so){
		if(so.contains("Windows")){
			String process = "ping -4 -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha!=null){
					if(linha.contains("dia =")){
						String[] vetorDados = linha.split("dia ");
						System.out.println("Média " + vetorDados [1]);
					}
					linha = buffer.readLine();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(so.contains("Linux")){
			
		}
		
		
	}
	
}
