package models;


public class Container {
	
	

	static ListaOrdenada<Coche>coches=new ListaOrdenada<Coche>((Coche a,Coche b)->a.getEntrada().compareTo(b.getEntrada()));
	static float cantidad;

	public static float getCantidad() {
		return cantidad;
	}

	
	public static void setCantidad(float cantidad) {
		Container.cantidad = cantidad;
	}


	public static ListaOrdenada<Coche> getCoches() {
		return coches;
	}





	
}
