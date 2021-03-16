package ui;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Book;

public class NationalLibraryController {
	
	private Stage stage;
	
	@FXML
	private BorderPane basePane;

    @FXML
    private TableView<Book<String,Integer>> tableBooks;

    @FXML
    private TableColumn<Book<String,Integer>,String> idTitle;

    @FXML
    private TableColumn<Book<String,Integer>,String> idISBN;

    @FXML
    private TableColumn<Book<String,Integer>,Integer> idRack;

    @FXML
    private TableColumn<Book<String,Integer>,String> idChapter;

    @FXML
    private TableColumn<Book<String,Integer>,String> idReview;

    @FXML
    private TableColumn<Book<String,Integer>,String> idCritique;
    @FXML
    private TableColumn<Book<String,Integer>, Integer> idCost;

    @FXML
    private TableColumn<Book<String,Integer>,Integer> idQuantity;
    
	public NationalLibraryController(Stage s) {
		stage=s;
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			//Book<String,Integer> b = new Book<String,Integer>("SDSDSDS",2);
			
			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
			}
		});

	}
	public void loadSeccion1() throws IOException {
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
	public void loadSeccion2() throws IOException{
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
	public void loadSeccion3() throws IOException{
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion3.fxml"));
		fxmload.setController(this);
		Parent root;
		root = fxmload.load();
		basePane.getChildren().clear();
		basePane.setCenter(root);
	}
	public void loadBooksList() {
	    	basePane.setOnKeyPressed(null);
	    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
			fxmload.setController(this);
			Parent root;
			try {
				root = fxmload.load();
				basePane.getChildren().clear();
				basePane.setCenter(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
			tableBooks.getItems().clear();
			//ObservableList<Book<String,Integer>>books= FXCollections.observableArrayList(gm.showList());
			//tableBooks.setItems(books);
			
			idTitle.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, String>("Title"));
			idISBN.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, String>("ISBN"));
			idRack.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, Integer>("Rack"));
			idChapter.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>,String>("Chapter"));
			idReview.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, String>("Review"));
			idCritique.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, String>("Critique"));
			idCost.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>,Integer>("Review"));
			idQuantity.setCellValueFactory(new PropertyValueFactory<Book<String,Integer>, Integer>("Critique"));
		}
}
