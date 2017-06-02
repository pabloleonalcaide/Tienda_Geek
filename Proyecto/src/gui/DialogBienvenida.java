package gui;

import javax.swing.JDialog;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import stock.FondoImagen;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
/**
 * La ventana de Bienvenida habilita/deshabilita el menu de opciones de los empleados
 * permitiendo así que se mantenga activa la barra de clientes para comprobar cambios
 * @author pablo
 *
 */
public class DialogBienvenida {

	private JDialog frameWelcome;

	public DialogBienvenida() {
		initialize();
	}


	private void initialize() {
		frameWelcome = new JDialog();
		frameWelcome.setVisible(true);
		frameWelcome.setModal(true);
		frameWelcome.setTitle("    --Developer's Dungeon--");
		frameWelcome.setResizable(false);
		frameWelcome.setBounds(100, 100, 402, 156);
		frameWelcome.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frameWelcome.getContentPane().setLayout(null);
		try {
			BufferedImage image = null;
			image = ImageIO.read(new File(getClass().getResource("/img/fondoBienvenida.jpg").getFile()));
			FondoImagen fondo = new FondoImagen(image);
			((JComponent) frameWelcome.getContentPane()).setBorder(fondo);
			frameWelcome.getContentPane().setLayout(null);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frameWelcome, "problemas al cargar el fondo");
		}
		JButton btnAreaClientes = new JButton("\u00c1rea Clientes");
		btnAreaClientes.setMnemonic('C');
		btnAreaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarVentanasCliente();
				frameWelcome.setVisible(false);
				Principal.framePrincipal.setVisible(true);

			}
			/**
			 * Habilita el menu de cliente, es decir, las pestañas de acciones de cliente
			 */
			private void habilitarVentanasCliente() {
				Principal.menuEmpleado.setVisible(false);
				
			}
		});
		btnAreaClientes.setBounds(35, 54, 150, 47);
		frameWelcome.getContentPane().add(btnAreaClientes);
		
		JButton btnAreaEmpleados = new JButton("\u00c1rea Empleados");
		btnAreaEmpleados.setMnemonic('E');
		btnAreaEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitarVentanasEmpleado();
				frameWelcome.setVisible(false);
				Principal.framePrincipal.setVisible(true);
			}
			/**
			 * Habilita el menu de empleado, es decir, pestañas de gestion
			 */
			private void habilitarVentanasEmpleado() {
				Principal.menuUsuario.setVisible(false);
				
				
			}
		});
		btnAreaEmpleados.setBounds(212, 54, 150, 47);
		frameWelcome.getContentPane().add(btnAreaEmpleados);
		
		JLabel lblBIenvenido1 = new JLabel("Bienvenido a la Mazmorra del Desarrollador");
		lblBIenvenido1.setForeground(Color.WHITE);
		lblBIenvenido1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBIenvenido1.setBounds(35, 0, 383, 15);
		frameWelcome.getContentPane().add(lblBIenvenido1);
		
		JLabel lblBienvenido2 = new JLabel("Indica si eres cliente o empleado");
		lblBienvenido2.setForeground(Color.WHITE);
		lblBienvenido2.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblBienvenido2.setBounds(69, 26, 314, 15);
		frameWelcome.getContentPane().add(lblBienvenido2);
	}
}
