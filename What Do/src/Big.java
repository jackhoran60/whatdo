import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Big {
	
	public static BufferedReader reader;
	public static BufferedWriter writer;
	public static ArrayList<String> list;
	public static String scanned;
	public static Scanner scanner;
	
	
	public static void main(String[] args) throws IOException {
		printOnOpen();
	    populate();
	    scannerLoop();
	}
	
	
	public static void printOnOpen() {
		System.out.println(" _       __          __                                          __        \r\n" + 
				"| |     / /  ___    / /  _____  ____    ____ ___   ___          / /_  ____ \r\n" + 
				"| | /| / /  / _ \\  / /  / ___/ / __ \\  / __ `__ \\ / _ \\        / __/ / __ \\\r\n" + 
				"| |/ |/ /  /  __/ / /  / /__  / /_/ / / / / / / //  __/       / /_  / /_/ /\r\n" + 
				"|__/|__/   \\___/ /_/   \\___/  \\____/ /_/ /_/ /_/ \\___/        \\__/  \\____/ ");
		System.out.println("                       __             __        __           __\r\n" + 
				"          _      __   / /_   ____ _  / /_  ____/ /  ____    / /\r\n" + 
				"         | | /| / /  / __ \\ / __ `/ / __/ / __  /  / __ \\  / / \r\n" + 
				"         | |/ |/ /  / / / // /_/ / / /_  / /_/ /  / /_/ / /_/  \r\n" + 
				"         |__/|__/  /_/ /_/ \\__,_/  \\__/  \\__,_/   \\____/ (_)   \r\n" + 
				"                                                               ");
		System.out.println("Type 'controls' to see howto whatdo.");
	}
	public static void populate() throws IOException {
		list = new ArrayList<String>();
		reader = new BufferedReader(new FileReader("todo.txt"));
	    
	    String line = reader.readLine();
	    while (line != null) {
	       list.add(line);
	       line = reader.readLine();
	    }
	    
	    reader.close();
	    scanner = new Scanner(System.in);
	}
	public static void scannerLoop() throws IOException {
		while(scanner.hasNextLine()) {
	    	scanned = scanner.nextLine();
	    	whatDoesWhatDoDo();
	    	System.out.println();
	    	sort();
	    	save();
	    }
	}
	public static void whatDoesWhatDoDo() throws IOException {
		if(scanned.equals("Random") || scanned.equals("random") || scanned.equals("rand")) {
    		random();
    	}
    	else if((scanned.length() >= "random: ".length()) && (scanned.substring(0,8).equals("random: ") || scanned.substring(0,8).equals("Random: "))) {
    		randomCat8();
    	}
    	else if((scanned.length() >= "random ".length()) && (scanned.substring(0,7).equals("random ") || scanned.substring(0,7).equals("Random "))) {
    		randomCat7();
    	}
    	else if(scanned.equals("save") || scanned.equals("Save")) {
    		save();
    	}
    	else if(scanned.equals("show") || scanned.equals("showAll") || scanned.equals("Show") || scanned.equals("List") || scanned.equals("list") || scanned.equals("print")) {
    		show();
    	}
    	else if((scanned.length() >= "show: ".length()) && (scanned.substring(0,6).equals("show: ") || scanned.substring(0,6).equals("show: "))) {
    		showCat6();
    	}
    	else if((scanned.length() >= "show ".length()) && (scanned.substring(0,5).equals("show ") || scanned.substring(0,5).equals("show "))) {
    		showCat5();
    	}
    	else if(scanned.equals("stop") || scanned.equals("quit") || scanned.equals("abort") || scanned.equals("Abort") || scanned.equals("close")) {
    		quit();
    	}
    	else if(scanned.equals("Controls") || scanned.equals("controls") || scanned.equals("Instructions") || scanned.equals("instructions")) {
    		controls();
    	}
    	else if((scanned.length() >= "Finished: ".length()) && (scanned.substring(0,10).equals("finished: ") || scanned.substring(0,10).equals("Finished: "))) {
    		finished0();
    	}
    	else if((scanned.length() >= "Remove: ".length()) && (scanned.substring(0,8).equals("remove: ") || scanned.substring(0,8).equals("Remove: "))) {
    		finished1();
    	}
    	else if((scanned.length() >= "Remove ".length()) && (scanned.substring(0,7).equals("remove ") || scanned.substring(0,7).equals("Remove "))) {
    		finished2();
    	}
    	else {
    		addItem();
    	}
	}
	
	private static void random() {
		if(list.size() > 0) {
			int randInd = (int) (Math.random() * list.size());
    		System.out.println("your random query is " + list.get(randInd));
		}
		else {
			System.out.println("List is empty.");
		}
	}
	private static void randomCat8() {
		String cat = scanned.substring(8);
		ArrayList<String> sublist = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).length() >= cat.length() + 2) {
				if(list.get(i).substring(0,cat.length()).equals(cat) && list.get(i).substring(cat.length(),cat.length()+2).equals(": ")) {
    				sublist.add(list.get(i).substring(cat.length() + 2));
    			}
			}
		}
		if(sublist.size() > 0) {
			int randInd = (int) (Math.random() * sublist.size());
    		System.out.println("your random query from category " + cat + " is " + sublist.get(randInd));
		}
		else {
			System.out.println("Category does not exist.");
		}
	}
	private static void randomCat7() {
		String cat = scanned.substring(7);
		ArrayList<String> sublist = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).length() >= cat.length() + 2) {
				if(list.get(i).substring(0,cat.length()).equals(cat) && list.get(i).substring(cat.length(),cat.length()+2).equals(": ")) {
    				sublist.add(list.get(i).substring(cat.length() + 2));
    			}
			}
		}
		if(sublist.size() > 0) {
			int randInd = (int) (Math.random() * sublist.size());
			System.out.println("your random query from category " + cat + " is " + sublist.get(randInd));
		}
		else {
			System.out.println("Category does not exist.");
		}
	}
	private static void show() {
		if(list.size() > 0) {
			System.out.println("||||||||||||||||||||||| Showing all items |||||||||||||||||||||||||||||");
			for(int i = 0; i < list.size(); i++) {
    			System.out.println(list.get(i));
    		}
			System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		}
		else {
			System.out.println("List is empty.");
		}
	}
	private static void showCat6() {
		String cat = scanned.substring(6);
		ArrayList<String> sublist = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).length() >= cat.length() + 2) {
				if(list.get(i).substring(0,cat.length()).equals(cat) && list.get(i).substring(cat.length(),cat.length()+2).equals(": ")) {
    				sublist.add(list.get(i).substring(cat.length() + 2));
    			}
			}
		}
		if(sublist.size() > 0) {
			String topBar = "||||||||||||||||||||||| Showing items from "+ cat + " |||||||||||||||||||||||||||||";
			System.out.println(topBar);
			for(int i = 0; i < sublist.size(); i++) {
				System.out.println(sublist.get(i));
			}
			String bottomBar = "";
			for(int i = 0; i < topBar.length(); i++) {
				bottomBar += "|";
			}
			System.out.println(bottomBar);
		}
		else {
			System.out.println("Category does not exist.");
		}
	}
	private static void showCat5() {
		String cat = scanned.substring(5);
		ArrayList<String> sublist = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).length() >= cat.length() + 2) {
				if(list.get(i).substring(0,cat.length()).equals(cat) && list.get(i).substring(cat.length(),cat.length()+2).equals(": ")) {
    				sublist.add(list.get(i).substring(cat.length() + 2));
    			}
			}
		}
		if(sublist.size() > 0) {
			String topBar = "||||||||||||||||||||||| Showing items from "+ cat + " |||||||||||||||||||||||||||||";
			System.out.println(topBar);
			for(int i = 0; i < sublist.size(); i++) {
				System.out.println(sublist.get(i));
			}
			String bottomBar = "";
			for(int i = 0; i < topBar.length(); i++) {
				bottomBar += "|";
			}
			System.out.println(bottomBar);
		}
		else {
			System.out.println("Category does not exist.");
		}
	}
	private static void save() throws IOException {
		writer = new BufferedWriter(new FileWriter("todo.txt", true));
		new PrintWriter("todo.txt").close();
		for(int i = 0; i < list.size(); i++) {
			writer.write(list.get(i));
			writer.newLine();
		}
		writer.close();
	}
	private static void quit() throws IOException {
		System.exit(0);
	}
	private static void controls() {
		System.out.println("1: type an item and hit 'enter' to add it to your to-do list.");
		System.out.println("2: 'random' will pick a random item off of the to-do list to do.");
		System.out.println("3: 'show' will list all of your to-do items.");
		System.out.println("4: 'remove: [your item]' will remove an item from the list once you complete it.");
		System.out.println("5: you can use categories by adding your item as '[category name]: [your item]'.");
		System.out.println("6: you can type 'random: [category name]' or 'show: [category name]' to only interact with items of a specific category.");
	}
	private static void finished0() {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(scanned.substring(10))) {
				
				list.remove(i);
			}
		}
		System.out.println("Removed item!");
	}
	private static void finished1() {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(scanned.substring(8))) {
				
				list.remove(i);
			}
		}
		System.out.println("Removed item!");
	}
	private static void finished2() {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(scanned.substring(7))) {
				
				list.remove(i);
			}
		}
		System.out.println("Removed item!");
	}
	private static void addItem() {
		boolean contains = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(scanned)) {
				contains = true;
			}
		}
		if(!contains) {
			list.add(scanned);
			System.out.println("added '"+ scanned + "' to list!");
		}
		else
			System.out.println("this item is already on the list!");
	}
	private static void sort() {
		Collections.sort(list, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.compareToIgnoreCase(s2);
		    }
		});
	}
}
