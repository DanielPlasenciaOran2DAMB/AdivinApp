package dad.adivina.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {

	private Label numeroLabel;
	private TextField numeroText;
	private Button comprobarButton;
	private VBox rootPanel;

	@Override
	public void start(Stage primaryStage) throws Exception {

		numeroText = new TextField();
		numeroText.setPromptText("Introduce un número");
		numeroText.setText("0");
		numeroText.setMaxWidth(100);

		numeroLabel = new Label();
		numeroLabel.setText("Introduce un número del 1 al 100");

		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));

		rootPanel = new VBox();
		rootPanel.setSpacing(5);
		rootPanel.setAlignment(Pos.CENTER);
		rootPanel.getChildren().addAll(numeroLabel, numeroText, comprobarButton);

		Scene scene = new Scene(rootPanel, 320, 200);

		primaryStage.setTitle("AdivinaApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onComprobarButtonAction(ActionEvent e) {

		int numeroAleatorio = (int) ((Math.random() * 100) + 1);
		int i;
		
		for (i = 0; i <= 0; i++) {
			if (numeroAleatorio == numeroText.getText()) {
				
			}
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
