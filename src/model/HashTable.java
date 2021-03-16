package model;

public class HashTable<K extends Comparable<K>, V> implements HashTableInterface<K, V> {

	private Book<? extends Comparable<?>, ?>[] books;
	private int m;

	public HashTable(int m) {
		books = new Book<?, ?>[m];
		this.m = m;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int hash(K key, int explorator) {
		int hash = auxHash(key);
		Book<K, V> current = (Book<K, V>) books[hash + explorator];
		while ((current != null && current.getKey().compareTo(key) != 0) && explorator < m) {
			explorator++;
		}
		if (explorator < m) {
			return hash + explorator;
		} else {
			return -1;
		}
	}

	@Override
	public int auxHash(K key) {
		return keyToInteger(key) % m;
	}

	@Override
	public void put(Book<K, V> book) {
		int hash = hash(book.getKey(), 0);
		if (hash != -1) {
			books[hash] = book;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(K key) {
		int hash = hash(key, 0);
		if (hash != -1 && books[hash] != null) {
			return (V) books[hash].getValue();
		} else {
			return null;
		}
	}

	@Override
	public int keyToInteger(K key) {
		int integer = 0;
		if (key instanceof Character) {
			integer = (Character) key - 97;
		} else if (key instanceof Integer) {
			integer = (Integer) key;
		} else if (key instanceof Double) {
			integer = (int) ((Double) key * m);
		} else {
			String s = key.toString();
			for (int i = 0; i < s.length(); i++) {
				integer += s.charAt(i);
			}
		}
		return integer;
	}

}
