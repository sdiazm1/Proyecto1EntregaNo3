package logic;

import java.util.ArrayList;

public class Participante {
	
	private static String nombre;
	private static String correo;
	private ArrayList participantes;
	
	public Participante(String pNombre, String pCorreo)
	{
		this.nombre=pNombre;
		this.correo=pCorreo;
		participantes = new ArrayList<Participante>();
	}
	
	public Participante crearParticipante(String pNombre, String pCorreo)
	{
		Participante participanteNuevo = new Participante(pNombre, pCorreo);
		participantes.add(participanteNuevo);
		return participanteNuevo;
	}
	
	public void generarReporte() 
	{
		System.out.println("Reporte de participante: ");
		System.out.println(nombre);
		System.out.println(correo);
	}
	
}
