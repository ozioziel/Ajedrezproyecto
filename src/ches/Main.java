package ches;
import javax.swing.JFrame;
public class Main {

	public static void main(String[] args) {
		System.out.print("Pulse click derecho para ver el estado del tablero en la consola. :D");
        JFrame window = new JFrame();
        window.setTitle("xd");       
        window.setSize(400, 300);
        
        panel gamepanel = new panel();
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        gamepanel.start();
        
	}

}
