package models;

import java.util.ArrayList;
import java.util.Comparator;

public class ListaOrdenada<T>extends ArrayList<T> {
	
private Comparator<T> comparador;

	
	public ListaOrdenada(Comparator<T> comparador) {
		super();
		
		this.comparador =  comparador;
	}
	
	
	public boolean Add(T element)
	{
		

		if(element!=null){
			
			boolean estado=(super.add(element));
			super.sort(this.comparador);
			return estado;
			
		}else{

			throw new NullPointerException("Llevate tu null de aqui");

		}
	}
	

}
