package controller;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
public class RedesController {
	public RedesController() {
		super();
	}
	private String os() { // retorna o nome do Sistema Operacional
		String os = System.getProperty("os.name");
		return os;
	}
	public void ip(String proc) throws IOException { // imprime o nome do adaptador de rede e o IPv4, portanto, adaptadores sem IPv4 não devem ser mostrados
		String os = os();
        System.out.println(os);
		try {
			Process p = Runtime.getRuntime().exec(proc);
            InputStream in = p.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            BufferedReader buffer = new BufferedReader(reader);

            String linha = buffer.readLine();

            while(linha != null ) {
                String adaptador;
                boolean v4 = false;

                if(linha.contains("Adaptador")) {
                    adaptador = linha;
                }

                if(linha.contains("IPv4")) {
                    String[] ipv4 = linha.split(": ");

                    v4 = true;
                }

                if(v4) {
                    
                }
                
                linha = buffer.readLine();
            }

            buffer.close();
            reader.close();
            in.close();
			
		} catch(IOException e) {
			System.err.println(e.getMessage());
		}
	}

 
}