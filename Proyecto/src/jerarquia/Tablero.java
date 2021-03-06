package jerarquia;

import java.time.LocalDate;

import enumeraciones.EstadoArticulo;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;
/**
 * Clase Tablero, hereda de Juego, que hereda de Articulo
 * @author pablo
 *
 */
public class Tablero extends Juego {

	private static final long serialVersionUID = 1L;
	private int num_piezas;
	private double dimensiones;
	private int num_jugadores;
	private boolean coleccion;

	public Tablero(String nombre, String descripcion, double precio, EstadoArticulo estado, LocalDate fecha,
			double duracion, int edad, int piezas, double dimension, int jugadores, boolean coleccion,int cantidad)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad,cantidad);
	}

	
	/**
	 * Constructor por id
	 * @param id
	 */
	public Tablero(int id) {
		super(id);
	}


	/**
	 * 
	 * @return numero de piezas
	 */
	public int getNum_piezas() {
		return num_piezas;
	}
	/**
	 * 
	 * @param num_piezas
	 */
	public void setNum_piezas(int num_piezas) {
		this.num_piezas = num_piezas;
	}
	/**
	 * 
	 * @return dimensiones
	 */
	public double getDimensiones() {
		return dimensiones;
	}
	/**
	 * 
	 * @param dimensiones
	 */
	public void setDimensiones(double dimensiones) {
		this.dimensiones = dimensiones;
	}
	/**
	 * 
	 * @return numero jugadores
	 */
	public int getNum_jugadores() {
		return num_jugadores;
	}
	/**
	 * 
	 * @param num_jugadores
	 */
	public void setNum_jugadores(int num_jugadores) {
		this.num_jugadores = num_jugadores;
	}
	/**
	 * 
	 * @return true o false
	 */
	boolean isColeccion() {
		return coleccion;
	}
	/**
	 * 
	 * @param coleccion
	 */
	public void setColeccion(boolean coleccion) {
		this.coleccion = coleccion;
	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}
	/**
	 * El descuento se aplica en base a si es un juego coleccionable o no
	 */
	@Override
	public void calcularDescuento() {
		if (isColeccion())
			setDescuento(getPrecio() * 0.013);
		else
			setDescuento(0);
	}
}
