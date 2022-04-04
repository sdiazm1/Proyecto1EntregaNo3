package Procesamiento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import logic.Archivador;
import logic.Proyecto;

public class Registro {

	private static String titulo;
	private static String descripcion;
	private static String tipo;
	private static String autor;
	private static Date fechaInicio;
	private static Date horaInicio;
	private static Date horaFin;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Registro> registros;
	Archivador archivador;
	
	public Registro(String pTitulo, String pDescripcion, String pTipo, String pAutor) 
	{
		this.titulo=pTitulo;
		this.descripcion=pDescripcion;
		this.tipo=pTipo;
		this.autor=pAutor;
		proyectos = new ArrayList<Proyecto>();
		registros = new ArrayList<Registro>();
		archivador = new Archivador();
	}
	
	public String darTitulo()
	{
		return titulo;
	}
	
	public String darDescripcion()
	{
		return descripcion;
	}
	
	public String darTipo()
	{
		return tipo;
	}
	
	public String darAutor()
	{
		return autor;
	}
	
	public ArrayList<Registro> darRegistros()
	{
		return registros;
	}
	
	public ArrayList<Proyecto> darProyectos()
	{
		return proyectos;
	}
	
	public void cambiarTitulo(String pTituloNuevo)
	{
		this.titulo=pTituloNuevo;
	}
	
	public void cambiarDescripcion(String pDescripcionNueva)
	{
		this.descripcion=pDescripcionNueva;
	}
	
	public void cambiarTipo(String pTipoNuevo)
	{
		this.tipo=pTipoNuevo;
	}
	
	public void cambiarAutor(String pAutor)
	{
		this.autor=pAutor;
	}
	
	public void crearRegistro(String pTitulo, String pDescripcion, String pTipo, String pAutor)
	{
		Registro registroNuevo = new Registro(pTitulo, pDescripcion, pTipo, pAutor);
		registros.add(registroNuevo);
		archivador.archivar(registroNuevo);
	}
	
	public void agregarProyectoARegistro(Proyecto proyecto)
	{
		proyectos.add(proyecto);
	}
	

}
