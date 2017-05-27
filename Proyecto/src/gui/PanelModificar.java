package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JOptionPane;

import enumeraciones.CategoriaLibro;
import enumeraciones.DificultadCartas;
import enumeraciones.EstadoArticulo;
import enumeraciones.GeneroRol;
import enumeraciones.IdiomaLibro;
import enumeraciones.MaterialRol;
import excepciones.EdadNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import excepciones.PrecioNoValidoException;
import jerarquia.Articulo;
import jerarquia.Cartas;
import jerarquia.Figura;
import jerarquia.Juego;
import jerarquia.Libro;
import jerarquia.Rol;
import jerarquia.Tablero;

public class PanelModificar extends PanelMostrar {

	public PanelModificar(ListIterator<Articulo> iterador) {
		super(iterador);
		textPaginas.setEnabled(true);
		textAutor.setEnabled(true);
		textNombre.setEnabled(true);
		textDetalles.setEnabled(true);
		textTematica.setEnabled(true);
		textPrecio.setEditable(true);
		textEdicion.setEnabled(true);
		textStock.setEnabled(true);
		textId.setEnabled(false);
		textCartas.setEnabled(true);
		chbxColeccionJuego.setEnabled(true);
		textDimensiones.setEnabled(true);
		textEdad.setEnabled(true);
		textFieldDuracion.setEnabled(true);
		textGenero.setEnabled(true);
		textTipo.setEnabled(true);
		textPiezas.setEnabled(true);
		textJugadores.setEnabled(true);
		numElementos.setEnabled(true);

		btnALaCesta_anadir.setVisible(true);
		btnALaCesta_anadir.setText("Modificar");
		btnSacar_borrar.setVisible(false);
		btnAnterior.setEnabled(false);

		spinnerEntrada.setEnabled(true);
		spinnerPeso.setEnabled(true);
		spinnerPublicacion.setEnabled(true);

		comboBoxEstado.setEnabled(true);
		comboBox_Idioma.setEnabled(true);
		comboBox_Genero.setEnabled(true);
		comboBoxTipoArticulo.setVisible(true);
		comboBoxDificultad.setEnabled(true);
		comboBoxMaterialRol.setEnabled(true);

		chckbxEnLaCesta.setVisible(true);
		chkbxColeccion.setEnabled(true);
		chckbxDesmontable.setEnabled(true);

		btnALaCesta_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				//	modificarArticulo(null);
					JOptionPane.showMessageDialog(getContentPane(), "Modificado con exito");
				} catch (NumberFormatException | PrecioNoValidoException | FechaNoValidaException | NombreNoValidoException e1) {
					JOptionPane.showMessageDialog(getContentPane(), "No se ha podido modificar");
				}
			}

		});

	}

	protected void modificarArticulo(Articulo articulo) throws NumberFormatException, PrecioNoValidoException, FechaNoValidaException, NombreNoValidoException, EdadNoValidaException {
		articulo.setEstado((EstadoArticulo) comboBoxEstado.getSelectedItem());
		articulo.setCantidad(Integer.parseInt(textStock.getText()));
		articulo.setFecha(readDateSpinner(spinnerEntrada));
		articulo.setDescripcion(textDetalles.getText());
		articulo.setNombre(textNombre.getText());
		articulo.setPrecio(Double.parseDouble(textPrecio.getText()));


		
		if (articulo instanceof Libro) {
			((Libro) articulo).setPaginas(Integer.valueOf(textPaginas.getText()));
			((Libro) articulo).setFechaPublicacion(readDateSpinner(spinnerPublicacion));
			((Libro) articulo).setAutor(textAutor.getText());
			((Libro) articulo).setColeccion(chkbxColeccion.isSelected());
			((Libro) articulo).setIdioma((IdiomaLibro) comboBox_Idioma.getSelectedItem());
			((Libro) articulo).setCategoria((CategoriaLibro) comboBox_Genero.getSelectedItem());

		} else if (articulo instanceof Juego) {
			((Juego) articulo).setDuracion_horas(Double.parseDouble(textFieldDuracion.getText()));
			((Juego) articulo).setEdad_minima(Integer.parseInt(textEdad.getText()));
			
			if (articulo instanceof Rol) {
				((Rol) articulo).setGenero((GeneroRol) comboBox_Genero.getSelectedItem());
				((Rol) articulo).setMaterial((MaterialRol) comboBoxMaterialRol.getSelectedItem());
				((Rol) articulo).setEdicion(Double.parseDouble(textEdicion.getText()));
			} else if (articulo instanceof Cartas) {
				((Cartas) articulo).setNum_cartas(Integer.parseInt(textCartas.getText()));
				((Cartas) articulo).setDificultad((DificultadCartas) comboBoxDificultad.getSelectedItem());
				((Cartas) articulo).setColeccion(chckbxColeccion.isSelected());
			} else if (articulo instanceof Tablero) {
				((Tablero) articulo).setNum_piezas(Integer.parseInt(textPiezas.getText()));
				((Tablero) articulo).setDimensiones(Double.parseDouble(textDimensiones.getText()));
				((Tablero) articulo).setNum_jugadores(Integer.parseInt(textJugadores.getText()));
				((Tablero) articulo).setColeccion(chkbxColeccion.isSelected());
			}
		} else if (articulo instanceof Figura) {
			
		}
		
	}
}