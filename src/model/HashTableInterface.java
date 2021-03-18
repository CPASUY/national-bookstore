package model;

public interface HashTableInterface<K extends Comparable<K>, V> {

	public int hashFuntion(Integer key);
	public void put(K key, V value,String chapter,String review,String critique,String title,int cost,int quantity);
	public Book search(K key);
	public boolean remove(K key);
	
}
