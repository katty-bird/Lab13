package Scrabble;

import java.util.*;

public class HashTable {
	
	LinkedList<String>[] hm;
	int size;
	int countEntry;
	int collision;
	
	@SuppressWarnings("unchecked")
	public HashTable(int numberOfKeys) {
		size = numberOfKeys;
		hm = new LinkedList[size];
		countEntry = 0;
		collision = 0;
	}
	
	public void put(int key, String object) {
		if (hm[index(key)] != null) {
			searchList(index(key), object);
			collision++;
		}
		else {
			createEntry(index(key),object);
		}
	}
	
	public String[] get(Integer key) {
		// Help through https://www.tutorialspoint.com/how-to-convert-linkedlist-to-array-in-java
		if (hm[index(key)] == null) { 
			String[] result = {"Now words found"};
			return result;
		}
		LinkedList<String> list = hm[index(key)];
		Object[] objectArray = list.toArray();
		int length = objectArray.length;
		String[] returnArray = new String[length];
		for (int i = 0; i < length; i++) {
			returnArray[i] = (String) objectArray[i];
		}
		return returnArray;
	}
	
	public String[] getLongestList() {
		int superkey = 0;
		int superlength = 0;
		for (int i = 0; i < size; i++) {
			if (hm[i] != null && hm[i].size() > superlength) {
				superkey = i;
				superlength = hm[i].size();
			}
		};
		return get(superkey);
	}
	
	private void searchList(int key, String object) {
		LinkedList<String> list = hm[key];
		if (!list.contains(object)) {
			list.addLast(object);
			}
		hm[key] = list; 
		}
	
	private void createEntry(int key, String object) {
		countEntry++;
		LinkedList<String> list = new LinkedList<String>();
		list.add(object);
		hm[key] = list;
	}
	
	private int index(int key) {
		int result = Math.abs(key) % size;
		return result;
	}
	
	public void getEntry() {
		System.out.println("There are " + countEntry + " entries in the table.");
	}
	
	public void getCollisions() {
		System.out.println("There are " + collision + " collisions in the table.\n");
	}
}
