package TelaMesas;

import java.net.URL;
import java.util.ResourceBundle;

import Mesas.Mesa;
import TelaCaixa.controllerCaixa;
import application.controllerLogin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import parteCaixa.Caixa;

public class ControllerFecharCaixa implements Initializable {
	@FXML
    private Label totalConta;
	 @FXML
	 private TableView<Mesa> tabela = new TableView<Mesa>();
	 
	 private TableColumn<Mesa, String> taMesa= new TableColumn<Mesa, String>("");
	  private TableColumn<Mesa, Integer> taCodigo= new TableColumn<Mesa, Integer>("Codigo"); 
	  private TableColumn<Mesa, String> taNome= new TableColumn<Mesa, String>("Nome");
	  private TableColumn<Mesa, Double> taTotal= new TableColumn<Mesa, Double>("Total");
	  
	  ObservableList<Mesa> listaDeContas = FXCollections.observableArrayList();
	  
    
	 @FXML
    void fecharCaixa(ActionEvent event) {
		    
    }
	 
	 @SuppressWarnings("unchecked")
	@Override
		public void initialize(URL url, ResourceBundle rb) {
		 
		    
		    tabela.setItems(listaDeContas);
		    taMesa.setCellValueFactory(new PropertyValueFactory<Mesa, String>("nomeMesa"));
	    	taNome.setCellValueFactory(new PropertyValueFactory<Mesa, String>("nomeReserva"));
	    	taCodigo.setCellValueFactory(new PropertyValueFactory<Mesa, Integer>("numeroDaMesa"));
	    	taTotal.setCellValueFactory(new PropertyValueFactory<Mesa, Double>("precoMesa"));
	    	

	    	tabela.getColumns().addAll(taMesa,taCodigo,taNome,taTotal);
		}
	 
	 @FXML
	    void atualizar(MouseEvent event) {
		 if(controllerMesas.getControlador() == 100) {
				
			 listaDeContas.addAll(controllerCaixa.listaContas());
			 controllerMesas.setControlador(1); 
		 
	    }
      }

}
