package ventanas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import clases.BaseDatos;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMercado extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMercado frame = new VentanaMercado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMercado() {
		setTitle("Mercado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(272, 11, 49, 14);
		contentPane.add(lblNewLabel);
		
		JList list = new JList();
		list.setBounds(103, 110, 302, 286);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(408, 181, 115, 156);
		contentPane.add(list_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(526, 433, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion v = new InicioSesion();
				v.setVisible(true);
				VentanaMercado.this.setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 429, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(522, 65, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

class RendererBusquedaJugadores extends JButton implements ListCellRenderer<clases.BaseDatos>{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon selectedIcon;
	 
	 public RendererBusquedaJugadores() {
         selectedIcon = new ImageIcon(getClass().getResource("https://cdn-icons-png.flaticon.com/512/2015/2015046.png"));
         setOpaque(true);
         setIcon(selectedIcon);
	 }

	@Override
	public Component getListCellRendererComponent(JList<? extends BaseDatos> list, BaseDatos value, int index,
			boolean isSelected, boolean cellHasFocus) {
		return this;
	}
	
	
	
}
