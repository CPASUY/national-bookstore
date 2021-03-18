package ui;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NoIdentificationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Book;
import model.Client;
import model.HashTable;

public class NationalLibraryController {
	
	private Client client;
	
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
    private TextField identificationTextField;
    
    @FXML
    private TextField isbnAdd;
    
    @FXML
    private TextField quantityAdd;
    
    
    @FXML
    private TableView<Book> tableSearchBooks;
    
    @FXML
    private TableColumn<Book,String> isbnSearchBooks;
    
    @FXML
    private TableColumn<Book,Integer> rackSearchBooks;
    
    @FXML
    private ChoiceBox<String> sortByBox;
    
    @FXML
    private TableView<Book> tableMyBasket;
    
    @FXML
    private TableColumn<Book,String> isbnMyBasket;
    
    @FXML
    private TableColumn<Book,Integer> rackMyBasket;
    
    
    @FXML
    private TableView<Client> tableQueue;
    
    @FXML
    private TableColumn<Client,String> identificationQueue;
    
    @FXML
    private TableColumn<Client,Integer> quantityBooksQueue;
    
    @FXML
    private TableView<Client> tableExit;
    
    @FXML
    private TableColumn<Client,String> identificationExit;
    
    @FXML
    private TableColumn<Client,String> isbnsBooksExit;
    
    @FXML
    private TableColumn<Client,Integer> priceExit;
    
    @FXML
    private TextField numberOfShelvings;
    
    @FXML
    private TextField numberCashRegister;
    
    
   
    
    
    
    
    
    
	public NationalLibraryController(Stage s) throws NoIdentificationException {
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
	
	public void loadConfiguration(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Configuration.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSection1(){
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
	}
	public void loadSection2(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sortByBox.getItems().addAll("BubbleSort","HeapSort","MergeSort");
		sortByBox.setValue("BubbleSort");
	}
	
	public void loadSection3(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion3.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	
	@FXML
	void startSection1(){
		loadSection1();
	}
	
	@FXML
	void goToSection2(){
			try {
				client = new Client(identificationTextField.getText());
				loadSection2();
			} catch (NoIdentificationException e) {
				Alert a = new Alert(AlertType.WARNING);
				a.setContentText("You need put a identification");
				a.show();
			}
	}
	@FXML
	void addBook() {
		String value = sortByBox.getValue();
		if(value.equals("BubbleSort")) {
			bubbleSort(client.getSearchBooks());
		}
		else if(value.equals("HeapSort")) {
			
		}
		else {
			
		}
		
	}
	
	@FXML
	void fillMyBasket() {
		
	}
	
	@FXML
	void addOtherClient(){
		loadSection1();
	}
	
	@FXML
	void purchase(){
		loadSection3();
	}
	
	@FXML
	void finishAndExit() {
		System.exit(0);
	}
	
	public void bubbleSort(ArrayList<Book> books) {
		Book temp = null;
		for(int i = books.size()-1;i>0;i--) {
			for(int j = 0;j<i; j++) {
				if(books.get(j).getValue()> books.get(j+1).getValue()) {
					temp = books.get(j);
					books.set(j, books.get(j+1));
					books.set(j+1, temp);
				}
			}
		}
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
	private void heapify(Book books[], int n, int i) { 
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
	
	public ArrayList<Book> mergeSort(ArrayList<Book> list){
		ArrayList<Book> left = new ArrayList<Book>();
		ArrayList<Book> right = new ArrayList<Book>();
		
		int medium;
		
		if(list.size() == 1) {
			return list;
		}else {
			medium = list.size()/2;
			for(int i = 0 ; i < medium; i++) {
				left.add(list.get(i));
			}
			
			for(int i = medium; i<list.size(); i++) {
				right.add(list.get(i));
			}
			left = mergeSort(left);
			right = mergeSort(right);
			
			merge(left, right, list);
		}
		
		return list;
	}
	
	private void merge(ArrayList<Book> left, ArrayList<Book>right, ArrayList<Book>list) {
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			if(left.get(leftIndex).getValue()<right.get(rightIndex).getValue()) {
				list.set(listIndex, right.get(rightIndex));
				leftIndex++;
			}else {
				list.set(listIndex, right.get(rightIndex));
				rightIndex++;
			}
		}
		ArrayList<Book> temp;
		int tempIndex = 0;
		if(tempIndex>=left.size()) {
			temp = right;
			tempIndex = rightIndex;
		}else {
			temp = left;
			tempIndex = leftIndex;
		}
		for(int i = tempIndex;i<temp.size();i++) {
			list.set(listIndex, temp.get(i));
			listIndex++;
		}
	}
}
