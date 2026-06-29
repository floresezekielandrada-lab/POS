package POSSystem;

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
    
 
 
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            System.out.println("Error sa main: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
 
 
/**
 * ============================================
 * ORDER SCREEN CLASS
 * ============================================
 * Responsable sa order screen UI at functionality
 */
class OrderScreen {
    
    private Scene scene;
    private POSSystem main;
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 500;
    
    /**
     * CONSTRUCTOR
     * Initialize ang OrderScreen
     */
    public OrderScreen(POSSystem main) {
        this.main = main;
        createScene();
    }
    
    /**
     * CREATE SCENE
     * Lumikha ng complete order screen
     */
    private void createScene() {
        try {
            // Main layout
            VBox mainLayout = new VBox(15);
            mainLayout.setPadding(new Insets(20));
            mainLayout.setStyle("-fx-background-color: #ffffff;");
            
            // Header section
            VBox headerBox = createHeaderBox("ORDER NOW", "#4CAF50");
            
            // Content section
            VBox contentBox = createContentBox("Menu Items Will Be Listed Here");
            
            // Add sections to main layout
            mainLayout.getChildren().addAll(headerBox, contentBox);
            
            // Create scene
            this.scene = new Scene(mainLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
            
        } catch (Exception e) {
            System.out.println("Error sa createScene (OrderScreen): " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * CREATE HEADER BOX
     * Lumikha ng header section with title and back button
     */
    private VBox createHeaderBox(String title, String color) {
        VBox headerBox = new VBox(10);
        
        // Title label
        Label titleLabel = new Label(title);
        titleLabel.setStyle(
            "-fx-font-size: 28; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: " + color + ";"
        );
        
        // Back button
        Button backButton = createBackButton();
        
        headerBox.getChildren().addAll(titleLabel, backButton);
        return headerBox;
    }
    
    /**
     * CREATE CONTENT BOX
     * Lumikha ng content area
     */
    private VBox createContentBox(String message) {
        VBox contentBox = new VBox(10);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle(
            "-fx-border-color: #dddddd; " +
            "-fx-border-radius: 5; " +
            "-fx-background-color: #f9f9f9;"
        );
        
        Label contentLabel = new Label(message);
        contentLabel.setStyle(
            "-fx-font-size: 16; " +
            "-fx-text-fill: #666666;"
        );
        
        contentBox.getChildren().add(contentLabel);
        return contentBox;
    }
    
    /**
     * CREATE BACK BUTTON
     * Gumawa ng back button
     */
    private Button createBackButton() {
        Button backButton = new Button("← Back to Main");
        backButton.setStyle(
            "-fx-font-size: 12; " +
            "-fx-padding: 8 20; " +
            "-fx-background-color: #757575; " +
            "-fx-text-fill: white; " +
            "-fx-cursor: hand;"
        );
        backButton.setOnAction(event -> main.goBackToMain());
        return backButton;
    }
    
    /**
     * GET SCENE
     * Return ang scene para ipakita
     */
    public Scene getScene() {
        return scene;
    }
}
 
 
/**
 * ============================================
 * RESERVE SCREEN CLASS
 * ============================================
 * Responsable sa reserve screen UI at functionality
 */
class ReserveScreen {
    
    private Scene scene;
    private POSSystem main;
    private final int WINDOW_WIDTH = 700;
    private final int WINDOW_HEIGHT = 500;
    
    /**
     * CONSTRUCTOR
     * Initialize ang ReserveScreen
     */
    public ReserveScreen(POSSystem main) {
        this.main = main;
        createScene();
    }
    
    /**
     * CREATE SCENE
     * Lumikha ng complete reserve screen
     */
    private void createScene() {
        try {
            // Main layout
            VBox mainLayout = new VBox(15);
            mainLayout.setPadding(new Insets(20));
            mainLayout.setStyle("-fx-background-color: #ffffff;");
            
            // Header section
            VBox headerBox = createHeaderBox("RESERVE NOW", "#2196F3");
            
            // Content section
            VBox contentBox = createContentBox("Reservation Form Will Be Listed Here");
            
            // Add sections to main layout
            mainLayout.getChildren().addAll(headerBox, contentBox);
            
            // Create scene
            this.scene = new Scene(mainLayout, WINDOW_WIDTH, WINDOW_HEIGHT);
            
        } catch (Exception e) {
            System.out.println("Error sa createScene (ReserveScreen): " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * CREATE HEADER BOX
     * Lumikha ng header section with title and back button
     */
    private VBox createHeaderBox(String title, String color) {
        VBox headerBox = new VBox(10);
        
        // Title label
        Label titleLabel = new Label(title);
        titleLabel.setStyle(
            "-fx-font-size: 28; " +
            "-fx-font-weight: bold; " +
            "-fx-text-fill: " + color + ";"
        );
        
        // Back button
        Button backButton = createBackButton();
        
        headerBox.getChildren().addAll(titleLabel, backButton);
        return headerBox;
    }
    
    /**
     * CREATE CONTENT BOX
     * Lumikha ng content area
     */
    private VBox createContentBox(String message) {
        VBox contentBox = new VBox(10);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle(
            "-fx-border-color: #dddddd; " +
            "-fx-border-radius: 5; " +
            "-fx-background-color: #f9f9f9;"
        );
        
        Label contentLabel = new Label(message);
        contentLabel.setStyle(
            "-fx-font-size: 16; " +
            "-fx-text-fill: #666666;"
        );
        
        contentBox.getChildren().add(contentLabel);
        return contentBox;
    }
    
    /**
     * CREATE BACK BUTTON
     * Gumawa ng back button
     */
    private Button createBackButton() {
        Button backButton = new Button("← Back to Main");
        backButton.setStyle(
            "-fx-font-size: 12; " +
            "-fx-padding: 8 20; " +
            "-fx-background-color: #757575; " +
            "-fx-text-fill: white; " +
            "-fx-cursor: hand;"
        );
        backButton.setOnAction(event -> main.goBackToMain());
        return backButton;
    }
    
    /**
     * GET SCENE
     * Return ang scene para ipakita
     */
    public Scene getScene() {
        return scene;
    }
}
