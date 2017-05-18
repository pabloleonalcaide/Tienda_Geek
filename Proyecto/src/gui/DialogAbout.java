package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
/**
 * Muestra la informacion acerca del autor y el proyecto
 * @author pablo
 *
 */
public class DialogAbout extends JDialog {

	
	private final JPanel contentPanel = new JPanel();
	 URI uri;
	public DialogAbout() {
	    try {
			uri = new URI("https://github.com/pabloleonalcaide/Tienda_Geek");
		} catch (URISyntaxException e) {
			System.out.println("url invalida");
		}

		getContentPane().setBackground(SystemColor.window);
		setTitle("Acerca del Proyecto");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 289, 228);
		
		JTextArea txtrAutorPabloLeon = new JTextArea();
		txtrAutorPabloLeon.setToolTipText("");
		txtrAutorPabloLeon.setBackground(SystemColor.window);
		txtrAutorPabloLeon.setEditable(false);
		txtrAutorPabloLeon.setText("Autor: Pablo Leon Alcaide\r\n \r\nAsignatura: Programacion\r\n\r\nFecha de entrega: Ayer\r\n ");
		txtrAutorPabloLeon.setBounds(50, 27, 196, 90);
		
		getContentPane().setLayout(null);
		getContentPane().add(txtrAutorPabloLeon);
		
		JButton btnirAllink = new JButton("repositorio");
		btnirAllink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open(uri);
			}
		});
		btnirAllink.setBounds(34, 148, 229, 25);
		 btnirAllink.setText("<HTML>Ir al <FONT color=\"#000099\"><U>repositorio</U></FONT></HTML>");
			    btnirAllink.setHorizontalAlignment(SwingConstants.LEFT);
			    btnirAllink.setBorderPainted(false);
			    btnirAllink.setOpaque(false);
			    btnirAllink.setBackground(Color.WHITE);
			    btnirAllink.setToolTipText(uri.toString());
		getContentPane().add(btnirAllink);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	/**
	 * 
	 * @param uri
	 */
	private static void open(URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { 
	      }
	    } else {
	    	
	    }
}
	}