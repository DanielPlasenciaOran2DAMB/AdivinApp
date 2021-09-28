package dad.adivina.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {

	public static int Aleatorio() {
		int numeroAdivina = (int) ((Math.random() * 100) + 1);
		return numeroAdivina;
	}

	private Label numeroLabel;
	private TextField numeroText;
	private Button comprobarButton;
	private VBox rootPanel;
	private Integer numeroAleatorio = Aleatorio();
	private Integer intentos = 1;

	public void reincicioApp() {
		numeroAleatorio = Aleatorio();
		intentos = 0;
	}

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

		try {
			if (numeroAleatorio == Integer.parseInt(numeroText.getText())) {
				Alert ganadorAlert = new Alert(AlertType.INFORMATION);
				ganadorAlert.setTitle("AdivinaApp");
				ganadorAlert.setHeaderText("¡Has ganado!");
				ganadorAlert.setContentText(
						"Sólo has necesitado " + intentos + " intentos. \n\n Vuelve a jugar y hazlo mejor");

				ganadorAlert.showAndWait();

				reincicioApp();
			} else if (numeroAleatorio > Integer.parseInt(numeroText.getText())) {
				Alert pistaMayorAlert = new Alert(AlertType.WARNING);
				pistaMayorAlert.setTitle("AdivinaApp");
				pistaMayorAlert.setHeaderText("¡Has fallado!");
				pistaMayorAlert.setContentText("El número a adivinar es mayor que "
						+ Integer.parseInt(numeroText.getText()) + ". \n\n Vuelve a intentarlo.");

				pistaMayorAlert.showAndWait();
			} else if (numeroAleatorio < Integer.parseInt(numeroText.getText())) {
				Alert pistaMenorAlert = new Alert(AlertType.WARNING);
				pistaMenorAlert.setTitle("AdivinaApp");
				pistaMenorAlert.setHeaderText("¡Has fallado!");
				pistaMenorAlert.setContentText("El número a adivinar es menor que "
						+ Integer.parseInt(numeroText.getText()) + ". \n\n Vuelve a intentarlo.");

				pistaMenorAlert.showAndWait();
			}
		} catch (NumberFormatException error) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("AdivinaApp");
			errorAlert.setHeaderText("Error");
			errorAlert.setContentText("El número introducido no es válido.");

			errorAlert.showAndWait();
		}

		intentos++;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
