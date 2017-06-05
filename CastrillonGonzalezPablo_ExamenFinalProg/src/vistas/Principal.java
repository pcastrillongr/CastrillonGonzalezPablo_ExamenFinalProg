package vistas;

import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.joda.time.LocalTime;

import models.Coche;
import models.Tiempo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal {
	
	/**
	 * 
	 * declaramos elementos del frame
	 */

	private JFrame frame;
	
	public JFrame getFrame() {
		return frame;
	}



	private JTextField txtmatricula;
	private JButton btnentrada;
	private JButton btnsalida;
	private JButton btncajadeldia;
	private JLabel lblmatricula;
	private Coche c;
	private LocalTime hora;
	private Tiempo t;
   


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	/**
	 * 
	 * Inicializamos elementos del frame
	 */
	public Principal() {

		frame = new JFrame();
		btnentrada = new JButton("ENTRADA ");
		btnsalida = new JButton("PAGO Y SALIDA");
		btncajadeldia = new JButton("CAJA DEL DIA");
		
		lblmatricula = new JLabel("Matricula:");
		txtmatricula = new JTextField();
		

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		propiedades();
		eventos();

	}
	
	/**
	 * Propiedades de nuestro frame
	 */

	private void propiedades()

	{
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnentrada.setBounds(10, 11, 124, 79);
		frame.getContentPane().add(btnentrada);

		btnsalida.setBounds(160, 11, 124, 79);
		frame.getContentPane().add(btnsalida);

		btncajadeldia.setBounds(300, 11, 124, 79);
		frame.getContentPane().add(btncajadeldia);

		txtmatricula.setBounds(156, 172, 141, 30);
		frame.getContentPane().add(txtmatricula);
		txtmatricula.setColumns(10);

		lblmatricula.setBounds(48, 180, 72, 14);
		frame.getContentPane().add(lblmatricula);

		

	}

	public void eventos() {

		/**
		 * En la entrada seteamos la hora de inicio
		 */
		btnentrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				boolean escorrecto = true;

				if (txtmatricula.getText().isEmpty()) {

					JOptionPane.showMessageDialog(frame, "Inserte una matricula");
					escorrecto = false;
				}
				if (escorrecto) {

					for (Coche x : models.Container.getCoches()) {

						if (txtmatricula.getText().equals(x.getMatricula())) {

							JOptionPane.showMessageDialog(frame, "El coche ya esta dentro del parking");
							escorrecto = false;
						}
					}
						

				if(escorrecto){
					c = new Coche();
					

					c.setEntrada(new LocalTime());
					c.setMatricula(txtmatricula.getText());
					models.Container.getCoches().Add(c);
					JOptionPane.showMessageDialog(frame, "Coche Aparcado");
						}
					

				}

			}
		});
/**
 * 
 * Si el coche esta en el parking nos llevara al otro frame de pago
 */
		btnsalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				boolean escorrecto = true;
				String matricula = txtmatricula.getText();

				if (matricula.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Inserte Matricula");
					escorrecto = false;
				}
				

				if (escorrecto) {

					for (Coche x : models.Container.getCoches()) {

						if (matricula.equals(x.getMatricula())) {

							PagoySalida window = new PagoySalida(matricula, frame);
							window.getFrame2().setVisible(true);
							frame.dispose();
						} else {
							JOptionPane.showMessageDialog(frame, "No tenemos ese coche en el parking");
							

						}

					}

				}

			}
		});
		
		/**
		 * 
		 * Mostrara todo lo recaudado durante el dia
		 */
		
		btncajadeldia.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				CajaDelDia window=new CajaDelDia(frame);
				window.getFrame3().setVisible(true);
				frame.dispose();
			}
		});

	}
}
