package ui;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Book;
import model.HashTable;

public class NationalLibraryController {
	
	private Stage stage;
	@FXML
	private BorderPane basePane;

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableColumn<Book,String> idTitle;

    @FXML
    private TableColumn<Book,String> idISBN;

    @FXML
    private TableColumn<Book,Integer> idRack;

    @FXML
    private TableColumn<Book,String> idChapter;

    @FXML
    private TableColumn<Book,String> idReview;

    @FXML
    private TableColumn<Book,String> idCritique;
    @FXML
    private TableColumn<Book, Integer> idCost;

    @FXML
    private TableColumn<Book,Integer> idQuantity;
    
    @FXML
    private Button goNextSection;
    
    @FXML
    private TextField identificationTextField;
    
    @FXML
    private TextField isbnAdd;
    
    @FXML
    private TextField quantityAdd;
    
    @FXML
    private Button addBookButton;
    
    @FXML
    private TableView<Book<String,Integer>> tableSearchBooks;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> isbnSearchBooks;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> rackSearchBooks;
    
    @FXML
    private ChoiceBox<String> sortByBox;
    
    @FXML
    private TableView<Book<String,Integer>> tableMyBasket;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> isbnMyBasket;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> rackMyBasket;
    
    @FXML
    private Button fillMyBasket;
    
    @FXML
    private Button addOtherClientButton;
    
    @FXML
    private Button purchaseButton;
    
    @FXML
    private TableView<Book<String,Integer>> tableQueue;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> identificationQueue;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> quantityBooksQueue;
    
    @FXML
    private TableView<Book<String,Integer>> tableExit;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> identificationExit;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> isbnsBooksExit;
    
    @FXML
    private TableColumn<Book<String,Integer>,Integer> priceExit;
    
    @FXML
    private Button finishAndExitButton;
    
    @FXML
    private TextField numberOfShelvings;
    
    @FXML
    private TextField numberCashRegister;
    
    @FXML
    private Button startButton;
    
    
    
    
    
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
	public void loadBooksList(HashTable h) {
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
			ArrayList<Book> list=h.booksList();
			ObservableList<Book>books= FXCollections.observableArrayList(list);
			tableBooks.setItems(books);
			
			idTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
			idISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
			idRack.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Rack"));
			idChapter.setCellValueFactory(new PropertyValueFactory<Book,String>("Chapter"));
			idReview.setCellValueFactory(new PropertyValueFactory<Book, String>("Review"));
			idCritique.setCellValueFactory(new PropertyValueFactory<Book, String>("Critique"));
			idCost.setCellValueFactory(new PropertyValueFactory<Book,Integer>("Review"));
			idQuantity.setCellValueFactory(new PropertyValueFactory<Book, Integer>("Critique"));
	}
	public void heapSort(Book books[]){ 
        int n = books.length; 
        for (int i = n / 2 - 1; i >= 0; i--) { 
            heapify(books, n, i); 
    	}
        for (int i=n-1; i>=0; i--){ 
            Book temp = books[0]; 
            books[0] = books[i]; 
            books[i] = temp; 
            heapify(books, i, 0); 
        } 
    } 
	void heapify(Book books[], int n, int i) { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2;  
        if (l < n && books[l].getValue() > books[largest].getValue()) {
            largest = l; 
        }
        if (r < n && books[r].getValue() > books[largest].getValue()) {
            largest = r; 
        }
        if (largest != i){ 
            Book swap = books[i]; 
            books[i] = books[largest]; 
            books[largest] = swap; 
            heapify(books, n, largest); 
        } 
    } 
}
