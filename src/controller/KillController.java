package controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class KillController {
	public KillController() {
		super();
	}
	private String os()  {
		return System.getProperty("os.name").split(" ")[0];
		
		
	}
	public void listaProcessos(){
		String process = os().equals("Windows") ? "TASKLIST /FO TABLE" : "ps -ef";
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha= buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
			
	}
	}
	
	
	public void mataPid(int pid){
		String process = os().equals("Windows") ? "TASKKILL /PID " : "kill -9 ";
		
		try {
			Process p = Runtime.getRuntime().exec(process+pid);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha= buffer.readLine();
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void mataNome(String processo){
		String process = os().equals("Windows") ? "TASKKILL /IM " : "pkill -f ";
		
		try {
			Process p = Runtime.getRuntime().exec(process+processo);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}



