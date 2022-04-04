package Interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.time.LocalDateTime;
import java.util.Date;

import Procesamiento.Registro;
import logic.Archivador;
import logic.Participante;
import logic.Proyecto;

public class Interfaz {

	Registro registro;
	Proyecto proyecto;
	Participante participante;
	Archivador archivador;
	
	public void iniciarAplicacion()
	{
		registro = new Registro(null, null, null, null);
		proyecto = new Proyecto(null, null, null, null, false);
		participante = new Participante(null,null);
		archivador = new Archivador();
		boolean continuar = true;
		while (continuar)
		{
			try
			{
				System.out.println("\nOPCIONES\n");
				System.out.println("\t1. Crear un nuevo registro.");
				System.out.println("\t2. Crear nuevo proyecto.");
				System.out.println("\t3. Crear nuevo participante.");
				System.out.println("\t4. Modificar registro");
				System.out.println("\t5. Consultar registro");
				System.out.println("\t6. Cerrar aplicación.");
				System.out.println();
				int opcion_seleccionada = Integer.parseInt(input("Seleccione una opción"));
				if (opcion_seleccionada < 6 && opcion_seleccionada > 0) 
					ejecutarOpcion(opcion_seleccionada);
				
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else
				{
					System.out.println("\nSeleccione una opción válida.\n");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("\nSeleccione un número de las opciones..\\n");
			}
		}
	}
	
	public void ejecutarOpcion(int opcionSeleccionada)
	{
		if (opcionSeleccionada == 1)
			crearNuevoRegistro();
		else if (opcionSeleccionada == 2)
			crearNuevoProyecto();
		else if (opcionSeleccionada == 3)
			crearNuevoParticipante();
		else if (opcionSeleccionada == 4)
			modificarRegistro();
		else if (opcionSeleccionada == 5)
			consultarRegistro();
	}
	
	public void crearNuevoRegistro()
	{
		System.out.println("-------- Crear un nuevo registro --------\n");
		String titulo = input("Ingrese el titulo del registro");
		String Descripcion = input("Ingrese la descripcion del registro");
		String tipo = input("Ingrese el tipo del registro");
		String Autor = input("Autor del registro ");
		registro.crearRegistro(titulo, Descripcion, tipo, Autor);
	}
	
	public void crearNuevoProyecto()
	{
		System.out.println("-------- Crear un nuevo proyecto --------\n");
		String titulo = input("Ingrese el titulo del registro donde desea añadir el proyecto");
		for (int i=0; i<registro.darRegistros().size(); i++)
		{
			if(registro.darRegistros().get(i).darTitulo().equals(titulo))
			{
				String nombre = input("Ingrese el nombre del proyecto");
				String Descripcion = input("Ingrese la descripcion del proyecto");
				Date fecha = darfecha();
				String fechaFinal = input("Ingrese la fecha final del proyecto (Formato YYYY-MM-DD)");
				Date fechaFin= obtenerfecha(fechaFinal);
				Proyecto proyectoNuevo = new Proyecto(nombre, Descripcion, fecha, fechaFin, true);
				proyecto.darProyectos().add(proyectoNuevo);
				registro.darRegistros().get(i).agregarProyectoARegistro(proyectoNuevo);
			}
			else
			{
				System.out.println("No se encuentra el registro");
			}
		}
	}
	
	public void crearNuevoParticipante()
	{
		System.out.println("-------- Crear un nuevo participante --------\n");
		String nombre = input("Ingrese el nombre del proyecto donde desea añadir al participante");
		for (int i=0; i<proyecto.darProyectos().size(); i++)
		{

			if(proyecto.darProyectos().get(i).darNombre().equals(nombre))
			{
				String nombreParticipante = input("Ingrese el nombre del participante");
				String correo = input("Ingrese el correo del participante");
				Participante participanteNuevo = participante.crearParticipante(nombreParticipante, correo);
				proyecto.darProyectos().get(i).añadirParticipante(participanteNuevo);
				System.out.println("Se ha creado el participante exitosamente");
				
			}
			else
			{
				System.out.println("No se encuentra el proyecto");
			}
		}
	}
	
	public void modificarRegistro()
	{
		System.out.println("-------- Modificar registro --------\n");
		String titulo = input("Ingrese el titulo del registro que desea modificar");
		for (int i=0; i<registro.darRegistros().size(); i++)
		{
			if(registro.darRegistros().get(i).darTitulo().equals(titulo))
			{
				System.out.println("T = titulo");
				System.out.println("D = descripcion");
				System.out.println("Ti = tipo");
				System.out.println("A = autor");
				System.out.println("AP = agregar proyecto");
				System.out.println("EP = eliminar proyecto");
				String opcion = input("Ingrese la letra(s) correspondiente a la opcion que desea modificar");
				if (opcion.equals("T"))
				{
					String tituloNuevo = input("Ingrese el titulo nuevo");
					registro.darRegistros().get(i).cambiarTitulo(tituloNuevo);
					System.out.println("Cambio realizado");
				}
				else if(opcion.equals("D"))
				{
					String descripcionNueva = input("Ingrese la descripcion nueva");
					registro.darRegistros().get(i).cambiarDescripcion(descripcionNueva);
				}
				else if(opcion.equals("Ti"))
				{
					String tipoNuevo = input("Ingrese el tipo nuevo");
					registro.darRegistros().get(i).cambiarTipo(tipoNuevo);
				}
				else if(opcion.equals("A"))
				{
					String autorNuevo = input("Ingrese el autor nuevo");
					registro.darRegistros().get(i).cambiarAutor(autorNuevo);
				}
				else if(opcion.equals("AP"))
				{
					String nombre = input("Ingrese el nombre del proyecto");
					String Descripcion = input("Ingrese la descripcion del proyecto");
					Date fecha = darfecha();
					String fechaFinal = input("Ingrese la fecha final del proyecto (Formato YYYY-MM-DD)");
					Date fechaFin= obtenerfecha(fechaFinal);
					Proyecto proyectoNuevo = new Proyecto(nombre, Descripcion, fecha, fechaFin, true);
					proyecto.darProyectos().add(proyectoNuevo);
					registro.darRegistros().get(i).agregarProyectoARegistro(proyectoNuevo);
				}
				else if(opcion.equals("EP"))
				{
					String nombre = input("Ingrese el nombre del proyecto que desea eliminar");
					for(int j = 0; j<proyecto.darProyectos().size(); j++)
					{
						if(proyecto.darProyectos().get(j).darNombre().equals(nombre))
						{
							proyecto.darProyectos().remove(proyecto.darProyectos().get(j));
						}
						else
						{
							System.out.println("No se encuentra el proyecto");
						}
					}
				}
				else
				{
					System.out.println("Seleccione una opcion valida");
				}
				
			}
			else
			{
				System.out.println("No se encuentra el registro");
			}
		}
		
	}
	
	public void consultarRegistro()
	{
		String titulo = input("Ingrese el titulo del registro que desea ver");
		archivador.imprimirRegistro(titulo);
	}
	
	public Date darfecha()
	{
		String fechaActual= ""+LocalDateTime.now();
//		System.out.println(fechaActual);
		String fecha= fechaActual.split("T")[0];
//		System.out.println(fecha);
		int año= Integer.parseInt(fecha.split("-")[0]);
		int mes= Integer.parseInt(fecha.split("-")[1]);
		int dia= Integer.parseInt(fecha.split("-")[2]);
//		System.out.println(año+"-"+mes+"-"+dia);
		Date fecha1 = new java.sql.Date(122, mes-1, dia);
//		System.out.println(fecha1);
		return fecha1;
		
	}
	
	public Date obtenerfecha(String fecha)
	{
		int año= Integer.parseInt(fecha.split("-")[0])-1900;
		int mes= Integer.parseInt(fecha.split("-")[1]);
		int dia= Integer.parseInt(fecha.split("-")[2]);
//		System.out.println(año+"-"+mes+"-"+dia);
		Date fecha1 = new java.sql.Date(año, mes-1, dia);
//		System.out.println(fecha1);
		return fecha1;
		
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		Interfaz interfaz =new Interfaz();
		interfaz.iniciarAplicacion();
	}
}
