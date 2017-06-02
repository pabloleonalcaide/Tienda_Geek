package jerarquia;

import java.time.LocalDate;

import enumeraciones.DificultadCartas;
import enumeraciones.EstadoArticulo;
import excepciones.EdadNoValidaException;
import excepciones.PrecioNoValidoException;
/**
 * clase cartas hereda de Juego, que hereda de Articulo
 * @author pablo leon alcaide
 *
 */
public class Cartas extends Juego {

	private static final long serialVersionUID = 1L;
	private int num_cartas;
	private DificultadCartas dificultad;
	private boolean coleccion;
	


	public Cartas(String nombre, String descripcion, double precio,
			EstadoArticulo estado, LocalDate fecha, double duracion, int edad,int numCartas,
			DificultadCartas dif, boolean coleccion, int cantidad)
			throws PrecioNoValidoException, EdadNoValidaException {
		super(nombre, descripcion, precio, estado, fecha, duracion, edad, cantidad);
		setNum_cartas(numCartas);
		setDificultad(dif);
		setColeccion(coleccion);
	}
	/**
	 * constructor por id
	 * @param id
	 */
	public Cartas(int id) {
		super(id);

	}
	/**
	 * 
	 * @return número de cartas
	 */
	public int getNum_cartas() {
		return num_cartas;
	}
	/**
	 * 
	 * @param num_cartas
	 */
	public void setNum_cartas(int num_cartas) {
		this.num_cartas = num_cartas;
	}
	/**
	 * 
	 * @return dificultad del juego
	 */
	public DificultadCartas getDificultad() {
		return dificultad;
	}
	/**
	 * 
	 * @param dificultad
	 */
	public void setDificultad(DificultadCartas dificultad) {
		this.dificultad = dificultad;
	}
	/**
	 * 
	 * @return true o false
	 */
	public boolean isColeccion() {
		return coleccion;
	}
	/**
	 * 
	 * @param coleccion
	 */
	public void setColeccion(boolean coleccion) {
		this.coleccion = coleccion;
	}
	/**
	 * El descuento se calcula en base a que sea o no coleccionable
	 */
	@Override
	public void calcularDescuento() {
		if(isColeccion())
			setDescuento(getPrecio()*0.010);
		else 
			setDescuento(0);
	}

	@Override
	public double obtenerDescuento() {
		calcularDescuento();
		return getDescuento();
	}

}
