package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.joda.time.LocalTime;

import models.Coche;
import models.Container;
import models.Tiempo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PagoySalida {
/**
 * 
 * elementos del frame
 */
	private JFrame frame2;
	private JTextField txtimporte;
	private JLabel lblmatricula = new JLabel("Matricula:");
	private JLabel lblHoraentrada = new JLabel("HoraEntrada:");	
	private JLabel lblHorasalida = new JLabel("HoraSalida:");
	private JButton btnpagarysalir = new JButton("Pagar y Salir");	
	private JLabel lbltotalapagar = new JLabel("Total a pagar:");
	private JLabel lbltotalapagar2 = new JLabel("");
	private JLabel lblimporte = new JLabel("Importe:");
	private JLabel lblcambio = new JLabel("");
	private String matriculaaux;
	private JLabel precioaux;
	private JLabel lblmatricula2;
	private JLabel lblhoradeentrada2;
	private JLabel lblhoradesalida;
	private JButton btncobrar;
	private JFrame frameaux;

	
	



	public PagoySalida(String matricula, JFrame frame) {
		/**
		 * 
		 * Inicializamos elementos del frame
		 */
		
		frame2 = new JFrame();
		 lblmatricula = new JLabel("Matricula:");
		 lblHoraentrada = new JLabel("HoraEntrada:");	
		 lblHorasalida = new JLabel("HoraSalida:");
		 btnpagarysalir = new JButton("Pagar y Salir");	
		
		 lbltotalapagar = new JLabel("Total a pagar:");
		 lbltotalapagar2 = new JLabel("");
		 lblimporte = new JLabel("Importe:");
		 lblcambio = new JLabel("");
			txtimporte = new JTextField();
			this.matriculaaux=matricula;
			this.frameaux=frame;

		
		
		initialize();
	}

	public JFrame getFrame2() {
		return frame2;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		propiedades();
		eventos();
	
	}
	
	/**
	 * 
	 * 
	 * Propiedades de los elementos del frame
	 */
	private void propiedades()
	{
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		
		lblmatricula.setBounds(28, 64, 80, 14);
		frame2.getContentPane().add(lblmatricula);
		
		lblHoraentrada.setBounds(28, 103, 80, 14);
		frame2.getContentPane().add(lblHoraentrada);
		
		lblHorasalida.setBounds(28, 146, 80, 14);
		frame2.getContentPane().add(lblHorasalida);
		
		btnpagarysalir.setBounds(137, 195, 110, 56);
		frame2.getContentPane().add(btnpagarysalir);
		
		lbltotalapagar.setBounds(327, 64, 97, 14);
		frame2.getContentPane().add(lbltotalapagar);
		
		lbltotalapagar2.setBounds(257, 103, 167, 14);
		lbltotalapagar2.setText("Click pagar para ver cantidad");
		frame2.getContentPane().add(lbltotalapagar2);
		
		lblimporte.setBounds(344, 146, 46, 14);
		lblimporte.setText("Importe");
		frame2.getContentPane().add(lblimporte);
		
		lblcambio.setBounds(344, 195, 46, 14);
		frame2.getContentPane().add(lblcambio);
		
		txtimporte.setBounds(327, 174, 86, 20);
		frame2.getContentPane().add(txtimporte);
		txtimporte.setColumns(10);
		
		lblmatricula2 = new JLabel("");
		lblmatricula2.setBounds(118, 64, 142, 14);
		frame2.getContentPane().add(lblmatricula2);
		
		lblhoradeentrada2 = new JLabel("");
		lblhoradeentrada2.setBounds(104, 103, 143, 14);
		frame2.getContentPane().add(lblhoradeentrada2);
		
		lblhoradesalida = new JLabel("");
		lblhoradesalida.setBounds(98, 146, 149, 14);
		frame2.getContentPane().add(lblhoradesalida);
		
		btncobrar = new JButton("Cobrar");
		
		btncobrar.setBounds(324, 212, 89, 39);
		btncobrar.setVisible(false);
		frame2.getContentPane().add(btncobrar);
		
	}
	private void eventos()
	{
		
		/**
		 * 
		 * si la matricula es igual seteamos la hora de entrada
		 */
		
		lblmatricula2.setText(matriculaaux);
		for(Coche x:Container.getCoches())
		{
			if(matriculaaux.equals(x.getMatricula()))
			{
				
				lblhoradeentrada2.setText(String.valueOf(x.getEntrada()));
				
			}
			
		}
		
		
		/**
		 * 
		 * Si la matricula es igual seteamos la hora de salisa y el total a pagar	
		 */
		 btnpagarysalir.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mousePressed(MouseEvent arg0) {
			 		
			 		LocalTime salida=new LocalTime();
			 		for(Coche x:Container.getCoches())
					{
			 		if(matriculaaux.equals(String.valueOf(x.getMatricula())))
					{
						
						x.setSalida(salida);
						lblhoradesalida.setText(String.valueOf(x.getSalida()));
						
						//if(x.getSalida().compareTo(x.getEntrada())<30){ no tengo tiempo a hacer precio por tiempo por falta de tiempo
							
						
						lbltotalapagar2.setText(String.valueOf(x.getSalida().compareTo(x.getEntrada())*0.06f));
						x.setPago(Float.parseFloat(lbltotalapagar2.getText()));
						Container.setCantidad(Container.getCantidad()+Float.parseFloat(lbltotalapagar2.getText()));
						Container.getCoches().remove(x);
						btncobrar.setVisible(true);
						
						
						
					}
			 		
			 	}
			 		}
			 });
		 
		 /**
		  * 
		  * Cobramos,entregamos vuelta y volvemos a la pagina inicial
		  */
		 
		 btncobrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					boolean escorrecto=true;
					
					if(txtimporte.getText().isEmpty())
					{
						
						JOptionPane.showMessageDialog(frame2, "Inserte monedas o billete");
						escorrecto=false;
					}
					
					if(escorrecto){
					float importe=Float.parseFloat(txtimporte.getText());
					float vuelta=importe-Float.parseFloat(lbltotalapagar2.getText());
					
					JOptionPane.showMessageDialog(frame2, "Su vuelta es" +vuelta+"$ \n muchas gracias");
					
					
					frameaux.setVisible(true);
					frame2.dispose();
					}
				}
			});
		 
		 	
		
		 
		 
		
	}

}
