package gui;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextArea;

public class DialogHelp extends JDialog {


	private static final long serialVersionUID = 1L;
	private static DialogHelp ayuda;
	private final JPanel contentPanel = new JPanel();

	DialogHelp() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Ayuda");
		setModal(false);
		setBounds(100, 100, 464, 444);

		getContentPane().setLayout(null);

		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText(
				"\t----Guia de Ayuda----\n"
				+ "\t---SECCIÓN ADMINISTRADOR---\n"
				+ "El menú de Archivo nos permite gestionar nuestro stock,pudiendo\n"
				+ "abrir uno existente, iniciar uno nuevo o guardar el actual\n"
				+ "El menú de Gestión nos ofrece la posibilidad de añadir, mostrar,\n "
				+ "modificar o eliminar artículos, alterando la estructura de la \n"
				+ "ventana en función del tipo de artículo. Por otra parte, se ofrece\n"
				+ " la posibilidad de eliminar por código o recorriendo el stock."
				+ "\nActualizar existencias permite añadir una cantidad determinada "
				+ "\nde todos los artículos del stock"
				+ "\nLa opción de Pedidos pretende abrir un fichero de texto que \n"
				+ "almacena los pedidos realizados por los usuarios, (ver Clientes)"
				+ "\nLa opción Cambiar Destacados, pendiente de completar, modificaría\n "
				+ "los artículos que se mostrarían como destacados en el área de clientes\n"
				+ "\n\t---SECCIÓN CLIENTES---\n"
				+ "Ofertas -->\n"
				+ "Muestra los artículos con mejores ofertas en ese momento\n"
				+ "Artículos -->\n"
				+ "Muestra los artículos del stock ordenados por precio o por nombre\n"
				+ "Además de permitir mostrarlos clasificados en función de su categoría\n"
				+ "así como descargar el catálogo de artículos en un fichero txt"
				+ "");
		textArea.setBounds(0, 0, 454, 434);
		getContentPane().add(textArea);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * singleton
	 * @return new Ayuda
	 */
	public static DialogHelp getInstance() {
		if (ayuda == null)
			ayuda = new DialogHelp();
		return ayuda;
	}
}