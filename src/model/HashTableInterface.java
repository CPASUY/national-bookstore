package model;

public interface HashTableInterface<K extends Comparable<K>, V> {

	public int hash(K key, int explorator);
	public int auxHash(K key);
	public void put(Book<K,V> tuple);
	public V get(K key);
	public int keyToInteger(K key);
	
}
