import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/**
 * ============================================
 * MAIN APPLICATION CLASS - POSSystem
 * ============================================
 * Ito ang main class ng buong POS system
 * Responsable sa pag-manage ng lahat ng screens
 */
public class POSSystem extends Application {
    
    // Private variable - only this class can access
    private Stage primaryStage;
    
    /**
     * START METHOD - Automatic na tatakbo kapag program start
     */
    @Override
    public void start(Stage stage) {
        try {
            this.primaryStage = stage;
            
            // Setup window properties
            primaryStage.setTitle("POS Inventory System");
            primaryStage.setWidth(700);
            primaryStage.setHeight(500);
            primaryStage.setResizable(true);
            
            // Ipakita ang main/home screen
            showMainScreen();
            
            // Display the window
            primaryStage.show();
            
        } catch (Exception e) {
            System.out.println("Error sa start method: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * MAIN SCREEN METHOD
     * Ang pangunahing screen na makikita ng user
     * May dalawang buttons: Order Now at Reserve Now
     */
    private void showMainScreen() {
        try {
            // Create main layout container
            VBox mainLayout = new VBox(20);
            mainLayout.setPadding(new Insets(50));
            mainLayout.setAlignment(Pos.CENTER);
            mainLayout.setStyle("-fx-background-color: #f5f5f5;");
            
            // Create title label
            Label titleLabel = new Label("Welcome to POS System");
            titleLabel.setStyle(
                "-fx-font-size: 32; " +
                "-fx-font-weight: bold; " +
                "-fx-text-fill: #333333;"
            );
            
            Label subtitleLabel = new Label("Eto na ang intro ng putanginang pos");
            subtitleLabel.setStyle(
                "-fx-font-size: 14; " +
                "-fx-text-fill: #666666;"
            );
            
            // Create Order Now button
            Button orderButton = createOrderButton();
            
            // Create Reserve Now button
            Button reserveButton = createReserveButton();
            
            // Add all components to layout
            mainLayout.getChildren().addAll(
                titleLabel,
                subtitleLabel,
                orderButton,
                reserveButton
            );
            
            // Create and set scene
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            
        } catch (Exception e) {
            System.out.println("Error sa showMainScreen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * CREATE ORDER BUTTON
     * Gumawa ng Order Now button with styling
     */
    private Button createOrderButton() {
        Button orderButton = new Button("Order Now");
        orderButton.setStyle(
            "-fx-font-size: 18; " +
            "-fx-padding: 20 80; " +
            "-fx-background-color: #4CAF50; " +
            "-fx-text-fill: white; " +
            "-fx-cursor: hand; " +
            "-fx-font-weight: bold; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        
        // Set action kapag nag-click
        orderButton.setOnAction(event -> showOrderScreen());
        
        return orderButton;
    }
    
    /**
     * CREATE RESERVE BUTTON
     * Gumawa ng Reserve Now button with styling
     */
    private Button createReserveButton() {
        Button reserveButton = new Button("Reserve Now");
        reserveButton.setStyle(
            "-fx-font-size: 18; " +
            "-fx-padding: 20 80; " +
            "-fx-background-color: #2196F3; " +
            "-fx-text-fill: white; " +
            "-fx-cursor: hand; " +
            "-fx-font-weight: bold; " +
            "-fx-border-radius: 5; " +
            "-fx-background-radius: 5;"
        );
        
        // Set action kapag nag-click
        reserveButton.setOnAction(event -> showReserveScreen());
        
        return reserveButton;
    }
    
    /**
     * SHOW ORDER SCREEN
     * Ipakita ang order screen kapag nag-click ng Order button
     */
    private void showOrderScreen() {
        try {
            OrderScreen orderScreen = new OrderScreen(this);
            Scene scene = orderScreen.getScene();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            System.out.println("Error sa showOrderScreen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * SHOW RESERVE SCREEN
     * Ipakita ang reserve screen kapag nag-click ng Reserve button
     */
    private void showReserveScreen() {
        try {
            ReserveScreen reserveScreen = new ReserveScreen(this);
            Scene scene = reserveScreen.getScene();
            primaryStage.setScene(scene);
        } catch (Exception e) {
            System.out.println("Error sa showReserveScreen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * GO BACK TO MAIN
     * Method para bumalik sa main screen
     */
    public void goBackToMain() {
        showMainScreen();
    }
    
    /**
     * MAIN METHOD
     * Entry point ng program - dito magsisimula lahat
     */
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println("Error sa main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

