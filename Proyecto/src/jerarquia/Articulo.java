package jerarquia;

import interfaces.Rebajable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import enumeraciones.EstadoArticulo;
import excepciones.PrecioNoValidoException;

public abstract class Articulo implements Serializable{
	private String nombre;
	private String descripcion;
	private double precio;
	protected double descuento=1;
	private double precioTotal;
	private EstadoArticulo estado;
	private LocalDate fechaEntrada;
	private boolean seleccionado;
	private int id;
	private static int codigo=1;
	private int cantidad;
	
	public Articulo(String nombre,String descripcion, double precio,EstadoArticulo estado, LocalDate fecha) throws PrecioNoValidoException{
		setId();
		this.seleccionado=false; //no puede incluirse directamente seleccionado para la cesta de compra
		this.precioTotal=calcularTotal();
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setEstado(estado);
		setFecha();
		
	}
	public Articulo (int id){
		setId(id);
	}
	
	public Articulo(String nombre) {
		setNombre(nombre);
	}
	protected void setId(int id) {
		this.id=id;
		
	}
	/**
	 * Calcula el precio al que será vendido el producto.
	 * @return precio total tras aplicar descuentos
	 */
	public double calcularTotal() {
		return getPrecio()-obtenerDescuento();
	}
	/**
	 * Establece el id unico del articulo
	 */
	private void setId() {
		this.id=codigo++;
	}
	/**
	 * 
	 * @return identificador univoco del articulo
	 */
	public int getId(){
		return id;
	}
	/**
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 *  
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * 
	 * @return precio base del producto (sin descuento)
	 */
	public double getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @param precio base del producto (sin descuento)
	 * @throws PrecioNoValidoException 
	 */
	public void setPrecio(double precio) throws PrecioNoValidoException {
		if (precio>1000 && getEstado()==EstadoArticulo.DESCATALOGADO)
			throw new PrecioNoValidoException("los productos descatalogados no valen tanto");
		else if (precio<10 && getEstado()==EstadoArticulo.ED_LIMITADA)
			throw new PrecioNoValidoException("es una edicion limitada, vale mas!");
		else if (precio<=0)
			throw new PrecioNoValidoException("el precio ha de ser positivo");
		else this.precio=precio;
	}
	/**
	 * 
	 * @return base de descuento
	 */
	public double getDescuento() {
		return descuento;
	}
	void setDescuento(double descuento){
		this.descuento=descuento;
	}
	/**
	 * @return estado del producto
	 * @see Enum Estado
	 */
	public EstadoArticulo getEstado() {
		return estado;
	}
	/**
	 * 
	 * @param estado
	 * @see Enum Estado
	 */
	public void setEstado(EstadoArticulo estado) {
		this.estado = estado;
	}
	/**
	 * 
	 * @return fecha de llegada al stock
	 */
	public LocalDate getFecha() {
		return fechaEntrada;
	}
	/**
	 * La fecha se establece en base al momento de instanciar el objeto
	 */
	public void setFecha() {
		this.fechaEntrada = LocalDate.now();
	}
	/**
	 * 
	 * @return true / false (dentro/fuera de la cesta de compra)
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}
	/**
	 * 
	 * @param seleccionado
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	public Object getClass(Articulo articulo){
		return getClass(articulo);
	}
	// ¿Debería ser un método del ArrayList? --> recuento a través de instanceof <objeto>
	public int getCantidad() {
		return cantidad;
	}
	// idem del anterior
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * Metodo abstracto que calcula el descuento del articulo
	 */
	public abstract void calcularDescuento();

	/**
	 * Metodo abstracto que devuelve el descuento especifico del articulo
	 */
	public abstract double obtenerDescuento();
	

	@Override
	public String toString() {
		return "\nArticulo [nombre=" + getNombre() + ", descripcion=" + getDescripcion()
				+ ", precioTotal=" + calcularTotal() + ", estado=" + getEstado()
				+ ", id=" + getId() + "]";
	}
	

}