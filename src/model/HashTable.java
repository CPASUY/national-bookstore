
package model;

import java.util.ArrayList;

public class HashTable<K extends Comparable<K>, V> implements HashTableInterface<K, V> {

	private ArrayList<Book<K, V>> books;
	private int size;

	public HashTable(int size) {
		books=new ArrayList<Book<K, V>>(size);
		this.size = size;
	}
	@Override
	public int keyToInteger(K key) {
		int integer = 0;
		if (key instanceof Character) {
			integer = (Character) key - 97;
		} else if (key instanceof Integer) {
			integer = (Integer) key;
		} else if (key instanceof Double) {
			integer = (int) ((Double) key *size);
		} else {
			String s = key.toString();
			for (int i = 0; i < s.length(); i++) {
				integer += s.charAt(i);
			}
		}
		return integer;
	}

	@Override
	public int hashFuntion(K k) {
		Integer key=0;
		int n=keyToInteger(k);
		key=n%size;
		return key;
	}

	@Override
	public void put(K key, V value,String chapter,String review,String critique,String title,int cost,int quantity) {
		int k=hashFuntion(key);
		Book<K, V> newN=new Book<K, V>(key,value,chapter,review,critique,title,cost,quantity);
		if(books.get(k)==null) {
			books.set(k,newN);
		}
		else {
			Book<K, V>  current=books.get(k);
			while (current.getNextBook()!=null) {
				current=current.getNextBook();
			}
			current.setNextBook(newN);
			newN.setPrevBook(current);
		}
	}
	@Override
	public Book<K, V> search(K key) {
		int k=hashFuntion(key);
		Book<K, V> current=books.get(k);
		if(current!=null) {
			while (current.getKey()!=key && current.getNextBook()!=null) {
				current=current.getNextBook();
			}
			if(current.getKey()!=key) {
				return null;
			}
			return current;
		}
		return null;
	}
	@Override
	public boolean remove(K key) {
		int k=hashFuntion(key);
		Book<K,V> s = search(key);
		boolean find=false;
		if(s!=null) {
			if(s == books.get(k) && books.get(k).getNextBook()!=null) {
				books.set(k,books.get(k).getNextBook());
				books.get(k).setPrevBook(null);
				
			}
			else if(s == books.get(k) && books.get(k).getNextBook()==null) {
				books.set(k,null);
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

}
