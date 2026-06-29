import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ============================================
 * POSSYSTEMFRAME CLASS
 * ============================================
 * Ang POS System na bumubukas after successful login
 * May Order Now at Reserve Now buttons sa main screen
 */
public class POSSystemFrame {
	
	// ===== MAIN FRAME =====
	private JFrame mainFrame;
	
	// ===== PANELS =====
	private JPanel mainPanel;
	private JPanel orderPanel;
	private JPanel reservePanel;
	
	// ===== USER INFO =====
	private String loggedInEmail;
	
	/**
	 * CONSTRUCTOR
	 * Initialize ang POS System
	 * 
	 * @param email - Email ng logged in user
	 */
	public POSSystemFrame(String email) {
		this.loggedInEmail = email;
		
		// Gumawa ng main frame
		mainFrame = new JFrame();
		mainFrame.setTitle("POS Inventory System - " + email);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(700, 600);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(new CardLayout()); // CardLayout para sa page switching
		
		// ===== SHOW MAIN SCREEN =====
		showMainScreen();
		
		// Display
		mainFrame.setVisible(true);
	}
	
	/**
	 * SHOW MAIN SCREEN
	 * Ang pangunahing screen with Order Now at Reserve Now buttons
	 */
	private void showMainScreen() {
		
		// Gumawa ng main panel
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(245, 245, 245));
		
		// ===== TITLE LABEL =====
		JLabel titleLabel = new JLabel("Welcome to POS System");
		titleLabel.setBounds(100, 50, 500, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
		titleLabel.setForeground(new Color(51, 51, 51));
		mainPanel.add(titleLabel);
		
		// ===== SUBTITLE LABEL =====
		JLabel subtitleLabel = new JLabel("Logged in as: " + loggedInEmail);
		subtitleLabel.setBounds(100, 110, 500, 25);
		subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		subtitleLabel.setForeground(new Color(100, 100, 100));
		mainPanel.add(subtitleLabel);
		
		// ===== ORDER NOW BUTTON =====
		JButton orderButton = new JButton("Order Now");
		orderButton.setBounds(150, 200, 180, 80);
		orderButton.setFont(new Font("Arial", Font.BOLD, 20));
		orderButton.setBackground(new Color(76, 175, 80)); // Green
		orderButton.setForeground(Color.WHITE);
		orderButton.setFocusable(false);
		orderButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		orderButton.addActionListener(e -> showOrderScreen());
		mainPanel.add(orderButton);
		
		// ===== RESERVE NOW BUTTON =====
		JButton reserveButton = new JButton("Reserve Now");
		reserveButton.setBounds(370, 200, 180, 80);
		reserveButton.setFont(new Font("Arial", Font.BOLD, 20));
		reserveButton.setBackground(new Color(33, 150, 243)); // Blue
		reserveButton.setForeground(Color.WHITE);
		reserveButton.setFocusable(false);
		reserveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		reserveButton.addActionListener(e -> showReserveScreen());
		mainPanel.add(reserveButton);
		
		// ===== LOGOUT BUTTON =====
		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(260, 400, 180, 40);
		logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
		logoutButton.setBackground(new Color(244, 67, 54)); // Red
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setFocusable(false);
		logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logoutButton.addActionListener(e -> handleLogout());
		mainPanel.add(logoutButton);
		
		// Add sa frame
		mainFrame.add(mainPanel);
	}
	
	/**
	 * SHOW ORDER SCREEN
	 * Screen para sa orders
	 */
	private void showOrderScreen() {
		
		// Clear ang frame
		mainFrame.getContentPane().removeAll();
		
		// Gumawa ng order panel
		orderPanel = new JPanel();
		orderPanel.setLayout(null);
		orderPanel.setBackground(Color.WHITE);
		
		// ===== HEADER =====
		JLabel headerLabel = new JLabel("ORDER NOW");
		headerLabel.setBounds(50, 30, 300, 40);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 32));
		headerLabel.setForeground(new Color(76, 175, 80)); // Green
		orderPanel.add(headerLabel);
		
		// ===== CONTENT AREA =====
		JPanel contentBox = new JPanel();
		contentBox.setBounds(50, 100, 600, 250);
		contentBox.setBackground(new Color(249, 249, 249));
		contentBox.setBorder(BorderFactory.createLineBorder(new Color(221, 221, 221), 2));
		contentBox.setLayout(null);
		
		JLabel contentLabel = new JLabel("Menu Items Will Be Listed Here");
		contentLabel.setBounds(20, 20, 560, 30);
		contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		contentLabel.setForeground(new Color(102, 102, 102));
		contentBox.add(contentLabel);
		
		orderPanel.add(contentBox);
		
		// ===== BACK BUTTON =====
		JButton backButton = new JButton("← Back to Main");
		backButton.setBounds(50, 370, 150, 40);
		backButton.setFont(new Font("Arial", Font.BOLD, 12));
		backButton.setBackground(new Color(117, 117, 117)); // Gray
		backButton.setForeground(Color.WHITE);
		backButton.setFocusable(false);
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(e -> {
			mainFrame.getContentPane().removeAll();
			showMainScreen();
			mainFrame.revalidate();
			mainFrame.repaint();
		});
		orderPanel.add(backButton);
		
		// Add sa frame
		mainFrame.add(orderPanel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	/**
	 * SHOW RESERVE SCREEN
	 * Screen para sa reservations
	 */
	private void showReserveScreen() {
		
		// Clear ang frame
		mainFrame.getContentPane().removeAll();
		
		// Gumawa ng reserve panel
		reservePanel = new JPanel();
		reservePanel.setLayout(null);
		reservePanel.setBackground(Color.WHITE);
		
		//HEADER
		JLabel headerLabel = new JLabel("RESERVE NOW");
		headerLabel.setBounds(50, 30, 300, 40);
		headerLabel.setFont(new Font("Arial", Font.BOLD, 32));
		headerLabel.setForeground(new Color(33, 150, 243)); // Blue
		reservePanel.add(headerLabel);
		
		// CONTENT AREA
		JPanel contentBox = new JPanel();
		contentBox.setBounds(50, 100, 600, 250);
		contentBox.setBackground(new Color(249, 249, 249));
		contentBox.setBorder(BorderFactory.createLineBorder(new Color(221, 221, 221), 2));
		contentBox.setLayout(null);
		
		JLabel contentLabel = new JLabel("Reservation Form Will Be Listed Here");
		contentLabel.setBounds(20, 20, 560, 30);
		contentLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		contentLabel.setForeground(new Color(102, 102, 102));
		contentBox.add(contentLabel);
		
		reservePanel.add(contentBox);
		
		//  back button 
		JButton backButton = new JButton("← Back to Main");
		backButton.setBounds(50, 370, 150, 40);
		backButton.setFont(new Font("Arial", Font.BOLD, 12));
		backButton.setBackground(new Color(117, 117, 117)); // Gray
		backButton.setForeground(Color.WHITE);
		backButton.setFocusable(false);
		backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(e -> {
			mainFrame.getContentPane().removeAll();
			showMainScreen();
			mainFrame.revalidate();
			mainFrame.repaint();
		});
		reservePanel.add(backButton);
		
		// add sa may frame
		mainFrame.add(reservePanel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	/**
	 * HANDLE LOGOUT
	 * Mag-logout at bumalik sa login page
	 */
	private void handleLogout() {
		
		// ask user kung sure sila mag login dito
		int response = JOptionPane.showConfirmDialog(
			mainFrame,
			"Are you sure you want to logout?",
			"Logout Confirmation",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE
		);
		
		if (response == JOptionPane.YES_OPTION) {
			// close POS System
			mainFrame.dispose();
			
			// bukas ang login page ulit
			EmailandPassword emailandPassword = new EmailandPassword();
			new LoginPage(emailandPassword.getLoginInfo());
		}
	}
}