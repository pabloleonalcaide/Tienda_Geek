package gui;

import java.util.ListIterator;

import jerarquia.Articulo;

/**
 * @author pablo
 *
 */
public class PanelMostrar extends PanelPadre {

	public PanelMostrar(ListIterator<Articulo> iterator) {
		super(iterator);
		this.it = iterator;

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
		textColeccionJuego.setEnabled(false);
		textDimensiones.setEnabled(false);
		textEdad.setEnabled(false);
		textFieldDuracion.setEnabled(false);
		textGenero.setEnabled(false);
		textTipo.setEnabled(false);
		textPiezas.setEnabled(false);
		textJugadores.setEnabled(false);
		numElementos.setEnabled(false);

		
		btnALaCesta_anadir.setVisible(false);
		btnSacar_borrar.setText("Eliminar");
		btnAnterior.setEnabled(false);
		
		spinnerEntrada.setEnabled(false);
		spinnerPeso.setEnabled(false);
		spinnerPublicacion.setEnabled(false);
		
		comboBoxEstado.setEnabled(false);
		comboBox_Idioma.setEnabled(false);
		comboBox_Genero.setEnabled(false);
		comboBoxTipoArticulo.setVisible(false);
		comboBoxDificultad.setEnabled(false);
		comboBoxMaterialRol.setEnabled(false);
		
		chckbxEnLaCesta.setVisible(false);
		chkbxColeccion.setEnabled(false);
		chckbxDesmontable.setEnabled(false);
		
		avanzar();
	}

	
}
