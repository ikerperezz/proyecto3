package ventanas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDatos.DBManager;
import clases.BaseDatos;
import clases.Jugador;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;

public class VentanaEquipo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> model;
	private DefaultListModel<String> modelsup;
	private JList<BaseDatos> list;
	private ArrayList<BaseDatos> nombreJugador;



	/**
	 * Create the frame.
	 */
	public VentanaEquipo() {
		setTitle("Plantilla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(219, 11, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Plantilla titular");
		lblNewLabel_2.setBounds(75, 67, 82, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Suplentes");
		lblNewLabel_3.setBounds(367, 67, 49, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazDeUsuarioPublico v = new InterfazDeUsuarioPublico(null, null, null);
				v.setVisible(true);
				VentanaEquipo.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 317, 89, 23);
		contentPane.add(btnNewButton);
		cargarJListTit();
		cargarJListSup();
		JList<String> list = new JList<String>(model);
		list.setBounds(41, 96, 162, 194);
		contentPane.add(list);

	
		
		JList<String> list_1 = new JList<String>(modelsup);
		list_1.setBounds(308, 96, 162, 194);
		contentPane.add(list_1);

	}

	



	public void cargarJListTit() {
		// TODO Auto-generated method stub
		DBManager dbmanager= new DBManager();
		dbmanager.conectar();
		List<Jugador> jug = dbmanager.crearListaPlantilla(InterfazDeUsuarioPublico.usP);
	
		model = new DefaultListModel<String>();
		for (int i = 0; i < jug.size(); i++) {
			if(jug.get(i).isTitular()) {
			model.addElement(jug.get(i).toString());
			}
		}

	}
	
	public void cargarJListSup() {
		// TODO Auto-generated method stub
		DBManager dbmanager= new DBManager();
		dbmanager.conectar();
		List<Jugador> jug = dbmanager.crearListaPlantilla(InterfazDeUsuarioPublico.usP);
for (int i = 0; i < jug.size(); i++) {
	System.out.println(jug.get(i).getNombreJugador());
}
		modelsup = new DefaultListModel<String>();
		for (int i = 0; i < jug.size(); i++) {
			if(!jug.get(i).isTitular()) {
			modelsup.addElement(jug.get(i).toString());
			}
		}

	}
}
