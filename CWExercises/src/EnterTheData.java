import java.util.ArrayList;
import java.util.Scanner;

public class EnterTheData {
	public static void run(Scanner scan){
		// Place your code here...
		
		System.out.println("\nExercises: Scanner:");
		
		ArrayList<Data> database = new ArrayList<>();
		var scanIn = scan;
		int idCounter = 1;
		
		 System.out.print("\n> Please enter a command: ");
		 
		 while (scanIn.hasNext()) {
	            String input = scanIn.nextLine();
	            
	            if (input.equals("help")) {
	            	System.out.println("\nValid commands are:");
	            	System.out.println("  a   Add record");
	            	System.out.println("  r   Remove record");
	            	System.out.println("  l   List records");
	            	System.out.println("  q   Quit");
	            }
	            
	            else if (input.equals("a")) {
	                    System.out.print("> Enter data as \"firstName lastName age\": ");
	                    String fullName = scanIn.nextLine();
	                    String[] split = fullName.split(" ");

	                    if (split.length == 3) {
	                    	try {
	                            database.add(new Data(split[0], split[1], Integer.parseInt(split[2]), idCounter++));
	                            System.out.println("\nRecord added.");   
	                    	}
	                    	catch (Exception e) {
	                            System.out.println("\nInvalid age.");
	                        }
	                    } 
	                    else {
	                        System.out.println("\nInvalid format.");
	                    }
	            }
	            
	            else if(input.equals("r")) {
	            	System.out.print("> Enter ID of record to remove: ");
	            	
	            	 while (!scanIn.hasNextInt()) {
	                     System.out.print("> Please enter a valid ID (integer): ");
	                     scanIn.next();
	                     }
	            	
	            	boolean recordFound = false;
                    int idToRemove = scanIn.nextInt();
                    scanIn.nextLine();
                    
                    
                    for (int i = 0; i < database.size(); i++) {
                    	if (database.get(i).getId() == idToRemove){
                    		database.remove(i);
                    		recordFound = true;
                    		System.out.println("\nRecord Removed.");
                    		break;
                    	}
                    }
                    if (!recordFound) {
                        System.out.println("\nNo record found.");
                    }
                    
	            }
	            
	            else if(input.equals("l")) {
	            	if (database.isEmpty()) {
	            		System.out.println("\nDatabase is empty.");
                    }
	            	else {
	            		System.out.println();
	            		for (int i = 0; i < database.size(); i++) {
	            		    System.out.println(database.get(i));   
	            		}
	            	}
	            }
	            
	            else if(input.equals("q")) {
                    scanIn.close();
                    return;
	            }
	            
	            else {
	            	System.out.println("\nUnknown command.");
	            	System.out.println("Type \"help\" for list of commands.");
	            }
	            System.out.print("\n> Please enter a command: ");
		 }

	}
}

class Data {
    private String fName;
    private String lName;
    private int age;
    private int id;

    public Data(String fName, String lName, int age, int id) {
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public String toString() {
        return lName+", "+fName+" "+age+"(id "+id+")";
    }
}