package KochSnowflake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class KochSnowflake extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel centerPanel = new JPanel();
	private final int maxOrder = 10;
	private final int initOrder = 1;
	
	public KochSnowflake() {
		initGUI();		
		
		setTitle("Koch Snowflake");
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initGUI() {
		// menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu orderMenu = new JMenu("Order");
		menuBar.add(orderMenu);
		
		for (int order=1; order<=maxOrder; order++) {
			
			final int order_ = order;
			JMenuItem orderMenuItem = new JMenuItem(Integer.toString(order_));
			
			orderMenuItem.addActionListener(new ActionListener() {
				@Override 
				public void actionPerformed(ActionEvent e) {
					centerPanel.removeAll();
					centerPanel.add(new KochPanel(order_));
					centerPanel.revalidate();
				}
			});
			
			orderMenu.add(orderMenuItem);
			
		}
		
		// center panel
		centerPanel.setBackground(Color.BLACK);
		add(centerPanel, BorderLayout.CENTER);
 
		// add Koch snowflake panel
		centerPanel.add(new KochPanel(initOrder));
	}

	public static void main(String[] args) {
		new KochSnowflake();
	}
	
}
