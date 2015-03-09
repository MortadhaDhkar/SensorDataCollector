import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 public class SensorView extends JFrame {

 private static final long serialVersionUID = 1L;
 private JFrame mainWindow;
 private JTextField ipAdress;
 private JButton connect;
 private JTable tableau;
 private JButton SEND = new JButton();
 private JLabel query = new JLabel("query:");
 private Object[][] donnees = { { "12", "414", "123", "431" },
 { "12", "414", "123", "431" }, { "12", "414", "123", "431" },
 { "12", "414", "123", "431" }, { "12", "414", "123", "431" }

 };

 public SensorView() {
 createUI();
 }

 private void createUI() {
 setLayout(new FlowLayout());
 setTitle("contiki");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(500, 300);
 String[] entetes = { "node", "température", "luminosité", "séquence" };
 tableau = new JTable(donnees, entetes);
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

 }*/
public class SensorView extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JFrame requetInterface;
	private static JPanel requetInterfaceGui;
	private static JLabel query;
	private static JTextField queryBox;
	private static JLabel ipAdress;
	private static JTextField IPBox;
	private static JLabel port;
	private static JTextField portBox;
	private static JButton envoyer;
	private static String Myrequet;
	private static String Myport;
	private static String Myaddresse;
	private static JTable tableau;
	private Object[][] donnees = { { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" }, { "12", "414", "123", "431" },
			{ "12", "414", "123", "431" },

	};

	SensorView() {
		requetInterface = new JFrame();
		query = new JLabel("Query         : ");
		requetInterfaceGui = new JPanel();
		queryBox = new JTextField(34);
		ipAdress = new JLabel("IP address : ");
		IPBox = new JTextField(20);
		port = new JLabel("port : ");
		portBox = new JTextField(10);
		envoyer = new JButton("send");
		String[] entetes = { "node", "température", "luminosité", "séquence" };
		tableau = new JTable(donnees, entetes);
		BuildSensorViewInterface();
	}

	public static void BuildSensorViewInterface() {
		requetInterface.setTitle("client Udp");
		ConfigureSensorViewInterface();
		sensorViewInterface_Action();
		requetInterface.setVisible(true);
	}

	public static void ConfigureSensorViewInterface() {

		requetInterface.setContentPane(requetInterfaceGui);
		requetInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		requetInterface.setMinimumSize(new Dimension(500, 555));
		requetInterface.pack();
		requetInterface.setLocationRelativeTo(null);

		try {
			// 1.6+
			requetInterface.setLocationByPlatform(true);
			requetInterface.setMinimumSize(requetInterface.getSize());
		} catch (Throwable ignoreAndContinue) {
		}
		requetInterfaceGui.setLayout(new FlowLayout());
		requetInterfaceGui.add(query);
		requetInterfaceGui.add(queryBox);
		requetInterfaceGui.add(ipAdress);
		requetInterfaceGui.add(IPBox);
		requetInterfaceGui.add(port);
		requetInterfaceGui.add(portBox);
		requetInterfaceGui.add(envoyer);
		requetInterfaceGui.add(new JScrollPane(tableau), BorderLayout.CENTER);

	}

	public static void sensorViewInterface_Action() {
		envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sensorViewInterface__ACTION();
			}

		});
		queryBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sensorViewInterface__ACTION();
			}
		});
		IPBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sensorViewInterface__ACTION();
			}
		});
		portBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sensorViewInterface__ACTION();
			}
		});

	}

	public static void sensorViewInterface__ACTION() {
		if (!queryBox.getText().equals("")) {
			Myrequet = queryBox.getText().trim();
		} else {
			JOptionPane.showMessageDialog(null, "entrer votre requet !");
		}
		if (!IPBox.getText().equals("")) {
			Myaddresse = IPBox.getText().trim();
		} else {
			JOptionPane.showMessageDialog(null, "entrer votre adresse !");
		}

		if (!portBox.getText().equals("")) {
			Myport = portBox.getText().trim();
		} else {
			JOptionPane.showMessageDialog(null, "entrer votre port !");
		}
		requetInterface.dispose();
		envoyer.setEnabled(true);
	}

	/*
	 * public static void main(String[] args) throws UnknownHostException,
	 * IOException {
	 * 
	 * SensorView.BuildSensorViewInterface(); }
	 */

}