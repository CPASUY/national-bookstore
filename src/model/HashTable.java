
package model;

import java.util.ArrayList;

public class HashTable implements HashTableInterface<String,Integer> {
	private ArrayList <Book> list;
	private Book[] books;
	private int size;

	public HashTable() {
		books=new Book[5];
		size = 5;
	}

	@Override
	public int hashFuntion(Integer k) {
		Integer key=0;
		key=k%size;
		return key;
	}
	@Override
	public void put(String key, Integer value, String chapter, String review, String critique, String title, int cost,int quantity) {
		int num = Integer.parseInt(key);
		int k=hashFuntion(num);
		Book newN=new Book(key,value,chapter,review,critique,title,cost,quantity);
		if(books[k]==null) {
			books[k]=newN;
		}
		else {
			Book current=books[k];
			while (current.getNextBook()!=null) {
				current=current.getNextBook();
			}
			current.setNextBook(newN);
			newN.setPrevBook(current);
		}
	}

	@Override
	public Book search(String key) {
		int num = Integer.parseInt(key);
		int k=hashFuntion(num);
		Book current=books[k];
		if(current!=null) {
			while (current.getKey()!=key && current.getNextBook()!=null) {
				current=current.getNextBook();
			}
			if(current.getKey().equals(key)) {
				return current;
			}
		}
		return null;
	}
	
	@Override
	public boolean remove(String key) {
		int num = Integer.parseInt(key);
		int k=hashFuntion(num);
		Book  s = search(key);
		boolean find=false;
		if(s!=null) {
			if(s == books[k] && books[k].getNextBook()!=null) {
				books[k]=books[k].getNextBook();
				books[k].setPrevBook(null);
				
			}
			else if(s == books[k] && books[k].getNextBook()==null) {
				books[k]=null;
			}
			else if(s.getNextBook()==null && s.getPrevBook()!=null) {
				s.getPrevBook().setNextBook(null);
			}
			else {
				s.getPrevBook().setNextBook(s.getNextBook());;
				s.getNextBook().setPrevBook(s.getPrevBook());
			}
		}
		return find;
	}
	public ArrayList<Book> booksList() {
		for(int s=0;s<size;s++) {
			if(books[s]!=null) { 
				Book current=books[s];
				while(current.getNextBook()!=null) {
					list.add(current);
					current=current.getNextBook();
				}
				list.add(current);
			}
		}
		return list;
	}
}
