import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class BasicGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasicGUI window = new BasicGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BasicGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(34, 139, 34));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Create Purchase Order");
		btnNewButton.setBounds(249, 97, 147, 46);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(label_2);
		
		JFormattedTextField frmtdtxtfldWarehouseWingmanV = new JFormattedTextField();
		frmtdtxtfldWarehouseWingmanV.setBounds(96, 23, 231, 27);
		frmtdtxtfldWarehouseWingmanV.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldWarehouseWingmanV.setText("Warehouse Wingman V1.0");
		frmtdtxtfldWarehouseWingmanV.setFont(new Font("Tahoma", Font.BOLD, 17));
		frmtdtxtfldWarehouseWingmanV.setBackground(new Color(224, 255, 255));
		frame.getContentPane().add(frmtdtxtfldWarehouseWingmanV);
		
		JButton btnNewButton_1 = new JButton("Process Purchase Order");
		btnNewButton_1.setBounds(249, 163, 147, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.setBounds(22, 238, 389, 23);
		frame.getContentPane().add(btnViewOrders);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 0, 0, 0);
		frame.getContentPane().add(label_3);
		
		JButton btnNewButton_2 = new JButton("Update Order Status");
		btnNewButton_2.setBounds(22, 163, 143, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnAssignOrders = new JButton("Assign Orders");
		btnAssignOrders.setBounds(22, 97, 143, 46);
		frame.getContentPane().add(btnAssignOrders);
	}
}
