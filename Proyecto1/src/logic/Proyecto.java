package logic;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {

	private static String Nombre;
	private static String Descripcion;
	private static Date fechaInicio;
	private static Date fechaFin;
	private boolean enProgreso;
	private ArrayList<Participante> participantes;
	private ArrayList<Proyecto> proyectos;
	private int tiempoTranscurrido;
	
	public Proyecto (String pNombre, String pDescripcion, Date pFechaInicio, Date pFechaFin,  boolean pEnPorgreso)
	{
		this.Nombre=pNombre;
		this.Descripcion=pDescripcion;
		this.fechaInicio=pFechaInicio;
		this.fechaFin=pFechaFin;
		this.enProgreso=pEnPorgreso;
		proyectos= new ArrayList<Proyecto>();
		participantes =new ArrayList<Participante>();
	}
	
	public void crearUnProyecto(String pNombre, String pDescripcion, Date pFechaInicio, Date pFechaFin)
	{
		Proyecto proyectoNuevo = new Proyecto(pNombre, pDescripcion, pFechaInicio, pFechaFin, true);
		proyectos.add(proyectoNuevo);
//		Iniciar cronometro 
	}
	
	public void añadirParticipante(Participante pParticipante)
	{
		participantes.add(pParticipante);
	}
	public void terminarProyecto()
	{
//		Finalizar Cronometro y actualizar timepo transcurrido
	}
	public ArrayList<Proyecto> darProyectos()
	{
		return proyectos;
	}
	
	public String darNombre()
	{
		return Nombre;
	}
	
	public String darDescripcion()
	{
		return Descripcion;
	}
	
	public String darfechaInicio()
	{
		return ""+fechaInicio;
	}
	
	public String darfechaFin()
	{
		return ""+fechaFin;
	}
	
	public ArrayList<Participante> darParticipantes()
	{
		return participantes;
	}
}