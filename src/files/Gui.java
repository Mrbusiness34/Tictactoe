package files;
//package files;
import javax.swing.JFrame
import javax.swing.Jpanel;
import javax.swing.BorderFactory;

public class GUI {
	public GUI() {
		JFrame frame = new JFrame();
		JPanel panel = new Jpanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0,1));
		frame.add(panel, BorderLayout.Center);
		frame.setDefaultCloseOperation(Jframe.EXIT)
		
	}
	public static void main(Stringp[ args) {
	new gui();
	}
	}
	