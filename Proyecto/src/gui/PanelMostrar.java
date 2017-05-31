package gui;

import java.util.ListIterator;

import jerarquia.Articulo;

/**
 * Ventana que permite recorrer los articulos y mostrar sus caracteristicas
 * @author pablo
 *
 */
public class PanelMostrar extends PanelPadre {

	public PanelMostrar(ListIterator<Articulo> iterator) {
		super(iterator);
		this.it = iterator;

		rdbtnCartas.setEnabled(false);
		rdbtnRol.setEnabled(false);
		rdbtnTablero.setEnabled(false);
		lblPrecio.setText("P.V.P");
		textPaginas.setEnabled(false); 
		textAutor.setEnabled(false);
		textNombre.setEnabled(false);
		textDetalles.setEnabled(false);
		textTematica.setEnabled(false);
		textPrecio.setEditable(false);
		textEdicion.setEnabled(false);
		textStock.setEnabled(false);
		textId.setEnabled(false);
		textCartas.setEnabled(false);
		chbxColeccionJuego.setEnabled(false);
		textDimensiones.setEnabled(false);
		textEdad.setEnabled(false);
		textFieldDuracion.setEnabled(false);
		
		
		textPiezas.setEnabled(false);
		textJugadores.setEnabled(false);
		textNumElementos.setEnabled(false);
		
		btnALaCesta_anadir.setVisible(false);
		btnSacar_borrar.setText("");
		btnSacar_borrar.setVisible(false);
		
		spinnerEntrada.setEnabled(true);
		spinnerPeso.setEnabled(false);
		spinnerPublicacion.setEnabled(true);
		
		comboBox_Genero.setEnabled(false);
		comboBoxCategoriaLibro.setEnabled(false);
		comboBoxEstado.setEnabled(false);
		comboBox_Idioma.setEnabled(false);
		comboBox_Genero.setEnabled(false);
		comboBoxTipoArticulo.setVisible(false);
		comboBoxDificultad.setEnabled(false);
		comboBoxMaterialRol.setEnabled(false);
		
		checkEnLaCesta.setVisible(false);
		checkColeccion.setEnabled(false);
		checkDesmontable.setEnabled(false);	
		showNext();
		btnAnterior.setEnabled(false);

	}

	
}
