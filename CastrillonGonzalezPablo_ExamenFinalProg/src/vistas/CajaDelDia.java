package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Coche;
import models.Container;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CajaDelDia {

	private JFrame frame3;
	
	public JFrame getFrame3() {
		return frame3;
	}

	/**^
	 * declaramos elementos del frame
	 */
	private JLabel lblCajaDelDia = new JLabel("CAJA DEL DIA:");
	private JLabel lblcajadeldia2 = new JLabel("");
	private JButton btnVolver = new JButton("Volver");
	private JFrame frameaux;

	public CajaDelDia(JFrame frame) {
		/**
		 * 
		 * Inicializamos elementos del frame
		 */
		
		frame3= new JFrame();
		 lblCajaDelDia = new JLabel("CAJA DEL DIA:");
		lblcajadeldia2 = new JLabel("");
		 btnVolver = new JButton("Volver");
		 this.frameaux=frame;
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Propiedades();
		eventos();
	}
	private void Propiedades()
	/**
	 * 
	 * Propiedades de los elementos del frame
	 */
	{
		
		frame3= new JFrame();
		frame3.setBounds(100, 100, 450, 300);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);
		
		
		lblCajaDelDia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblCajaDelDia.setBounds(57, 116, 116, 14);
		frame3.getContentPane().add(lblCajaDelDia);
		
		
		lblcajadeldia2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblcajadeldia2.setBounds(217, 116, 133, 14);
		frame3.getContentPane().add(lblcajadeldia2);
		
	
		btnVolver.setBounds(314, 228, 89, 23);
		frame3.getContentPane().add(btnVolver);
		
	}
	private void eventos()
	{
		/**
		 * 
		 * hACEMOS la suma de todos los pagos y los mostramos por pantalla
		 */
	
			
			lblcajadeldia2.setText(String.valueOf(Container.getCantidad()));
		
		
		
		 btnVolver.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent arg0) {
			 		
			 		frameaux.setVisible(true);
			 		frame3.dispose();
			 	}
			 });
		
	}

}
