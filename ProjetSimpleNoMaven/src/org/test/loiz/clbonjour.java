//commentaire ajouté
package org.test.loiz ;
import javax.swing.JFrame;

public class clbonjour {
	public  static void main(String[] argv) {
		try {
			System.out.println("Bonjour par méthode println");
		}
		catch (Exception e) { 
			System.out.println(e.getMessage());			
		}
	}
}