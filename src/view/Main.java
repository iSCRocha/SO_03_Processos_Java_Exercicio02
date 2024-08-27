package view;
 
import java.io.IOException;
 
import controller.RedesController;
 
public class Main {
 
	public static void main(String[] args) throws IOException {

		RedesController redesController = new RedesController();

        String proc = "ipconfig";
		
        redesController.ip(proc);
 
	}
 
}