package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDatos.DBManager;
import clases.UsuarioPublico;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class VentanaClasificacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<String> model;
	/**
	 * Create the frame.
	 */
	public VentanaClasificacion() {
		setTitle("Clasificación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		cargarJlist();
		JList<String> list = new JList<String>(model);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					VentanaJugador v = new VentanaJugador();
					v.setVisible(true);
				}
			}
		});
		list.setBounds(150, 117, 256, 250);
		contentPane.add(list);

		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazDeUsuarioPublico v = new InterfazDeUsuarioPublico(null, null, null);
				v.setVisible(true);
				VentanaClasificacion.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 346, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblnombre = new JLabel("Clasificación de la liga" + InterfazDeUsuarioPublico.usP.getIdLiga());
		lblnombre.setBounds(180, 53, 211, 39);
		contentPane.add(lblnombre);


	}

	public void cargarJlist() {
		// TODO Auto-generated method stub
		DBManager dbmanager = new DBManager();
		dbmanager.conectar();
		List<UsuarioPublico> us = dbmanager.crearListaDeMismaLiga(InterfazDeUsuarioPublico.usP);

		Collections.sort(us, new ComparadorPuntos());
		model = new DefaultListModel<String>();
		for (UsuarioPublico usuario : us) {
			model.addElement(usuario.toString());
		}

	}

	static class ComparadorPuntos implements Comparator<UsuarioPublico> {

		@Override
		public int compare(UsuarioPublico puntos1, UsuarioPublico puntos2) {
			return puntos2.getPuntos() - puntos1.getPuntos();
		}
	}

	public static List<UsuarioPublico> clasificacion(List<UsuarioPublico> ranking) {
		ComparadorPuntos comparador = new ComparadorPuntos();
		Collections.sort(ranking, new ComparadorPuntos());
		return ranking;
	}
}
