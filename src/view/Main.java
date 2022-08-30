package view;
import controller.KillController;
public class Main {
	public static void main(String[] args) {
		KillController killController = new KillController();

		killController.listaProcessos();
		killController.mataPid(10412);
		killController.mataNome("wordpad.exe");
		
		
	}

}
