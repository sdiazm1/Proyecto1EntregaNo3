package logic;

import java.util.ArrayList;

import Procesamiento.Registro;

public class Archivador {
	
	private ArrayList<Registro> Listaregistros = new ArrayList<Registro>(); 
	
	public void archivar(Registro registro)
	{
		Listaregistros.add(registro);
	}
	
	public void imprimirRegistro(String tituloRegistro)
	{
		for(int i=0; i<Listaregistros.size(); i++)
		{
			if (Listaregistros.get(i).darTitulo().equals(tituloRegistro))
			{
				Registro registro = Listaregistros.get(i);
				System.out.println(registro.darTitulo());
				System.out.println(registro.darDescripcion());
				System.out.println(registro.darTipo());
				System.out.println(registro.darAutor());
				System.out.println("Proyectos del registro: ");
				for(int j=0; j<registro.darProyectos().size();j++)
				{
					System.out.println(registro.darProyectos().get(j).darNombre());
					System.out.println(registro.darProyectos().get(j).darDescripcion());
					System.out.println(registro.darProyectos().get(j).darfechaInicio());
					System.out.println(registro.darProyectos().get(j).darfechaFin());
					
				}
				
				
			}
		}
	}
}
