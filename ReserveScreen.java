
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
 
/**
 * ============================================
 * RESERVE SCREEN CLASS
 * ============================================
 * Responsable sa reserve screen UI at functionality
 */
public class ReserveScreen {
    
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