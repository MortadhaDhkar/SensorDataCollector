import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class SensorView  extends JFrame {

	private static final long serialVersionUID = 1L;
	public JFrame mainWindow;
	public JTextField ipAdress;
	public JButton connect;
	public JButton SEND = new JButton();
	public JLabel query = new JLabel("query:");
	public Object[][] donnees = { { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" }

	};

	String[] entetes = { "Prénom", "Nom", "Couleur favorite", "Homme", "Sport" };

	public JTable tableau;

	public SensorView() {
		setLayout(new FlowLayout());
		setTitle("contiki");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 300);
		String[] entetes = { "node", "température", "luminosité", "séquence" };
		tableau = new JTable(donnees,entetes);
		mainWindow = new JFrame();
		ipAdress = new JTextField(20);
		connect = new JButton("connecter");
		add(ipAdress);
		add(connect);
		add(tableau);
		setVisible(true);
		getContentPane().add(tableau.getTableHeader(), BorderLayout.NORTH);
        getContentPane().add(tableau, BorderLayout.CENTER);

	}
}
