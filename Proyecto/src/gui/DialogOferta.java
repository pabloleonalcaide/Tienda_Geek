package gui;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jerarquia.Articulo;
import javax.swing.JTextPane;
/**
 * Panel que muestra las ofertas actuales
 * @author pablo
 *
 */
public class DialogOferta extends JDialog {

	private static final long serialVersionUID = 1L;
	JTextPane textOfertas;
	private final JPanel contentPanel = new JPanel();
	public DialogOferta() {
		buscarOfertas();
		setTitle("Menu Ofertas");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		textOfertas = new JTextPane();
		textOfertas.setEnabled(false);
		textOfertas.setEditable(false);
		textOfertas.setBounds(10, 23, 422, 239);
		contentPanel.add(textOfertas);
		textOfertas.setText(buscarOfertas());
	}

	/**
	 * Recorre el stock buscando aquellos articulos con mejores descuentos
	 */
	private String buscarOfertas() {
		StringBuilder contenido = new StringBuilder();
		contenido.append("--Ofertas--");
		int contador=0;
		for (Articulo art : Principal.stock.getStock()) {
			if (art.getDescuento() > 0.5) {
				contenido.append(art.getNombre() + ", precio: " + art.getPrecio() + "\n");
				contador++;
				if (contador>4)break;
			}

		}
		return contenido.toString();
	}

}
