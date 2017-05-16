package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import enumeraciones.*;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import excepciones.PesoNoValidoException;
import excepciones.PrecioNoValidoException;
import jerarquia.Articulo;
import jerarquia.Figura;
import jerarquia.Libro;
import javax.swing.JPanel;

/**
 * 
 * acciones para a�adir Figuras y Juegos (con su respectiva herencia)
 * 
 * @author d16lealp
 *
 */
public class PanelAnadir extends PanelPadre {

	public PanelAnadir() {
		setTitle("Stock: Introducir articulo");
		textNombre.setEnabled(true);
		textDetalles.setEnabled(true);
		textPrecio.setEnabled(true);
		textPaginas.setEnabled(true);
		btnAnterior.setVisible(false);
		btnSacar_borrar.setVisible(false);
		btnSiguiente.setVisible(false);
		rdbtnCartas.setSelected(true);
		panelButtons.setVisible(false);
		comboBoxEstado.setEnabled(true);
		btnALaCesta_anadir.setText("A\u00f1adir");
		
		btnALaCesta_anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panelLibro.isVisible()) {
					try {
//						if (textAutor.getText() == null) {
//							Principal.stock.addToStock(new Libro(textNombre.getText()), 1);
//						} else {
							Principal.stock.addToStock(new Libro(textNombre.getText(), textDetalles.getText(),
									Double.parseDouble(textPrecio.getText()),
									(EstadoArticulo) comboBoxEstado.getSelectedItem(), LocalDate.now(),
									Integer.parseInt(textPaginas.getText()), readDateSpinner(spinnerPublicacion),
									textAutor.getText(), true, (IdiomaLibro) comboBox_Idioma.getSelectedItem(),
									(CategoriaLibro) comboBox_Genero.getSelectedItem()),
									Integer.parseInt(textStock.getText()));
				//		}
					} 
				catch (NumberFormatException | NombreNoValidoException | PrecioNoValidoException
							| FechaNoValidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else if (panelJuego.isVisible()) {
				
				}else if (panelFigura.isVisible()) {
					try {
						Principal.stock.addToStock(new Figura(textNombre.getText(), textDetalles.getText(),
								Double.parseDouble(textPrecio.getText()),
								(EstadoArticulo) comboBoxEstado.getSelectedItem(), LocalDate.now(),
								(double) (spinnerPeso.getValue()), textTematica.getText(), chkbxColeccion.isSelected(),
								chckbxDesmontable.isSelected(), (int) (numElementos.getValue())),
								Integer.parseInt(textStock.getText()));
					} catch (NumberFormatException | PesoNoValidoException | PrecioNoValidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

					}
				}

			}
		});

	}

}
