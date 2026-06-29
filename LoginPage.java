import yourpackage.POSSystemFrame;  // Add this sa top ng file

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 
 * LOGINPAGE CLASS - WITH SHOW/HIDE PASSWORD
 
 * Ang class na ito ay gumagawa ng login interface
 * eye icon button para sa password visibility toggle
 */
public class LoginPage implements ActionListener {
	
	
	private JFrame frame;
	
	// LABELS (Text na read only)
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JLabel messageLabel;
	
	// INPUT FIELDS
	private JTextField emailField;
	private JPasswordField passwordField;
	private JTextField visiblePasswordField; // Para sa visible password
	
	// buttons
	private JButton loginButton;
	private JButton resetButton;
	private JButton togglePasswordButton; // Eye icon button
	
	//data
	private HashMap<String, String> logininfo;
	private boolean passwordVisible = false; // Track kung visible ang password
	
	/**
	 * CONSTRUCTOR
	 * Nag-setup ng lahat ng UI components
	 * 
	 * @param loginInfoOriginal - HashMap ng credentials mula EmailandPassword class
	 */
	public LoginPage(HashMap<String, String> loginInfoOriginal) {
		
		// Store ang credentials
		this.logininfo = loginInfoOriginal;
		
		// Gumawa ng frame (window)
		frame = new JFrame();
		frame.setTitle("Login System");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 420);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null); // I-center ang window
		
		//  INITIALIZE LAHAT NG COMPONENTS
		initializeComponents();
		addComponentsToFrame();
		
		// Ipakita ang frame
		frame.setVisible(true);
	}
	
	/**
	 * INITIALIZE COMPONENTS
	 * Gumawa at nag-setup ng lahat ng UI elements
	 */
	private void initializeComponents() {
		
		// labels
		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(50, 80, 100, 25);
		emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 130, 100, 25);
		passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
		
		messageLabel = new JLabel("");
		messageLabel.setBounds(50, 200, 450, 40);
		messageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
		
		// inpout fields
		emailField = new JTextField();
		emailField.setBounds(150, 80, 300, 25);
		emailField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		// Password field (hidden)
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 130, 250, 25);
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		
		// Visible password field (hidden initially)
		visiblePasswordField = new JTextField();
		visiblePasswordField.setBounds(150, 130, 250, 25);
		visiblePasswordField.setFont(new Font("Arial", Font.PLAIN, 14));
		visiblePasswordField.setVisible(false); // Initially hidden
		
		// eye icon
		togglePasswordButton = new JButton("👁️");
		togglePasswordButton.setBounds(410, 130, 40, 25);
		togglePasswordButton.setFont(new Font("Arial", Font.BOLD, 16));
		togglePasswordButton.setBackground(new Color(200, 200, 200));
		togglePasswordButton.setForeground(Color.BLACK);
		togglePasswordButton.setFocusable(false);
		togglePasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		togglePasswordButton.addActionListener(this);
		
		// buttons
		loginButton = new JButton("Login");
		loginButton.setBounds(150, 160, 100, 30);
		loginButton.setFont(new Font("Arial", Font.BOLD, 14));
		loginButton.setBackground(new Color(76, 175, 80)); // Green
		loginButton.setForeground(Color.WHITE);
		loginButton.setFocusable(false);
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.addActionListener(this);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(260, 160, 100, 30);
		resetButton.setFont(new Font("Arial", Font.BOLD, 14));
		resetButton.setBackground(new Color(155, 155, 155)); // Gray
		resetButton.setForeground(Color.WHITE);
		resetButton.setFocusable(false);
		resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		resetButton.addActionListener(this);
	}
	
	/**
	 * ADD COMPONENTS TO FRAME
	 * I-add ang lahat ng components sa frame
	 */
	private void addComponentsToFrame() {
		frame.add(emailLabel);
		frame.add(passwordLabel);
		frame.add(messageLabel);
		frame.add(emailField);
		frame.add(passwordField);
		frame.add(visiblePasswordField);
		frame.add(togglePasswordButton);
		frame.add(loginButton);
		frame.add(resetButton);
	}
	
	/**
	 * ACTION PERFORMED
	 * Tumatawag kapag may button click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Kung nag-click ng Toggle Password button (Eye icon)
		if (e.getSource() == togglePasswordButton) {
			handleTogglePasswordButton();
		}
		
		// Kung nag-click ng Reset button
		if (e.getSource() == resetButton) {
			handleResetButton();
		}
		
		// Kung nag-click ng Login button
		if (e.getSource() == loginButton) {
			handleLoginButton();
		}
	}
	
	/**
	 * HANDLE TOGGLE PASSWORD BUTTON
	 * Ipapakita o iipon ang password depende sa estado
	 */
	private void handleTogglePasswordButton() {
		
		if (!passwordVisible) {
			// SHOW PASSWORD
			// Kunin ang password mula sa hidden field
			String password = String.valueOf(passwordField.getPassword());
			
			// I-set sa visible field
			visiblePasswordField.setText(password);
			
			// Hide ang hidden field, show ang visible field
			passwordField.setVisible(false);
			visiblePasswordField.setVisible(true);
			
			// Change button to closed eye
			togglePasswordButton.setText("👁️‍🗨️");
			togglePasswordButton.setBackground(new Color(76, 175, 80)); // Green
			
			passwordVisible = true;
			
		} else {
			// HIDE PASSWORD
			// Kunin ang password mula sa visible field
			String password = visiblePasswordField.getText();
			
			// I-set sa hidden field
			passwordField.setText(password);
			
			// Hide ang visible field, show ang hidden field
			visiblePasswordField.setVisible(false);
			passwordField.setVisible(true);
			
			// Change button back to normal eye
			togglePasswordButton.setText("👁️");
			togglePasswordButton.setBackground(new Color(200, 200, 200)); // Gray
			
			passwordVisible = false;
		}
	}
	
	/**
	 * HANDLE RESET BUTTON
	 * Nag-clear ng lahat ng fields
	 */
	private void handleResetButton() {
		emailField.setText("");
		passwordField.setText("");
		visiblePasswordField.setText("");
		messageLabel.setText("");
		
		// Reset ang password visibility sa hidden
		if (passwordVisible) {
			passwordField.setVisible(true);
			visiblePasswordField.setVisible(false);
			togglePasswordButton.setText("👁️");
			togglePasswordButton.setBackground(new Color(200, 200, 200));
			passwordVisible = false;
		}
	}
	
	/**
	 * HANDLE LOGIN BUTTON
	 * Nag-verify ng credentials at nag-process ng login
	 */
	private void handleLoginButton() {
		
		// STEP 1: Kunin ang input ng user
		String email = emailField.getText();
		
		// Get password mula sa currently visible field
		String password;
		if (passwordVisible) {
			password = visiblePasswordField.getText();
		} else {
			password = String.valueOf(passwordField.getPassword());
		}
		
		// STEP 2: Mag-validate ng inputs (hindi dapat empty)
		if (email.isEmpty() || password.isEmpty()) {
			displayErrorMessage("Email at password ay kailangan");
			return;
		}
		
		// STEP 3: Check kung may email sa database
		if (!logininfo.containsKey(email)) {
			displayErrorMessage("Email not found");
			return;
		}
		
		// STEP 4: Check kung tama ang password
		String correctPassword = logininfo.get(email);
		
		if (correctPassword.equals(password)) {
			// Password tama! ✅
			displaySuccessMessage("Login successful!");
			
			// STEP 5: Bigyan ng delay para makita ng user ang success message
			try {
				Thread.sleep(1500); // 1.5 second delay
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			// STEP 6: CLOSE LOGIN FRAME at OPEN POSSystem
			frame.dispose();
			new POSSystemFrame(email); // Ipass ang email para sa reference
			
		} else {
			// Password mali ❌
			displayErrorMessage("Wrong password");
		}
	}
	
	/**
	 * DISPLAY SUCCESS MESSAGE
	 * Nagpapakita ng green success message
	 * 
	 * @param message - Ang message na ipapakita
	 */
	private void displaySuccessMessage(String message) {
		messageLabel.setForeground(new Color(76, 175, 80)); // Green
		messageLabel.setText(message);
	}
	
	/**
	 * DISPLAY ERROR MESSAGE
	 * Nagpapakita ng red error message
	 * 
	 * @param message - Ang message na ipapakita
	 */
	private void displayErrorMessage(String message) {
		messageLabel.setForeground(new Color(244, 67, 54)); // Red
		messageLabel.setText(message);
	}
}
