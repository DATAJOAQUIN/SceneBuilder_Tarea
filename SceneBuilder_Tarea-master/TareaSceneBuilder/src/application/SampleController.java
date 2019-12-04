package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SampleController {
	
	private Stage stage;
	
	@FXML
	private TextField entrada;
	
	@FXML
	private Label resultado;
	
	@FXML
	private Button boton;
	
	@FXML
    private Button btnLogin;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtPassword;
	
	
	@FXML
	 void cambiar(ActionEvent event) {

		resultado.setText(entrada.getText());
	}
	
	@FXML
	void login(ActionEvent event) throws IOException {
    	//Creamos la alerta que aparecerá para decirnos si hemos introducido bien las credenciales
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("Información");
    	alert.setHeaderText(null);
    	
    	//Variables ficticias para emular un inicio de sesión
    	String usuario = "usuario";
    	String password = "123456";
    	
    	//Comprobamos si coinciden los datos del login
    	if(txtUsuario.getText().equals(usuario) && txtPassword.getText().equals(password)) {
    		//Si coincide, nos muestra el siguiente mensaje
    		alert.setContentText("Ha iniciado sesión correctamente");  
    		
    		cambiarVentana(event);
    	}else {
    		//Si no hemos escrito bien nuestra credenciales, nos muestra este otro
    		alert.setContentText("Email y/o contraseña incorrectos");
    	
    	}
    	
    	alert.showAndWait();
	}
	
    private void cambiarVentana(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NewWindow.fxml"));
		AnchorPane admin = (AnchorPane)loader.load();
		
    	Scene adminScene = new Scene(admin);
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.setTitle("Nueva ventana");
    	stage.setScene(adminScene);
    	stage.show();

    }
	
}
