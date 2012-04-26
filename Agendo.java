import java.io.*;
import java.util.*;

public class Agendo{

/**********************************************************************
 * The main function is where the program starts running
 */	
	public static void main(String [] args) throws Exception{
	//Create a new Task database named "tasks"
		TaskDB tasks=new TaskDB();
		
	//Loop over and over until the user exits
		while(true){
		//Print out a prompt, asking the user to type something in
			System.out.print("<Press '?' for help>: ");
			String[] command=readCommand();
			
		//The user typed something, let's figure out what to do
		//If there was an error, or if they typed 'exit', let's exit
			if(command==null || command[0].equals("exit")){
				System.out.println("Goodbye!");
				return;
			
		//If the user typed '?', then show them a help screen
			}else if(command[0].equals("?")){
				System.out.println("The following commands are available:");
				System.out.println(" ?         : Displays this help text");
				System.out.println("");
			
		//If the user typed 'list', then print a list of tasks
			}else if(command[0].equals("list")){
				String[] l=tasks.listTasks();
				System.out.println("");
				for(int i=0; i<l.length; i++){
					System.out.println(i+" : "+l[i]);
				}
				System.out.println("");
			
		//If the user typed 'add', then some text, add the text as
		//  a new task
			}else if(command[0].equals("add")){
				tasks.addTask(command[1]);
			
		//If the user typed 'del', then a number, try to delete
		//  the task with that number
			}else if(command[0].equals("del")){
				try{
					int id=Integer.parseInt(command[1]);
					tasks.delTask(id);
				}catch(Exception e){
					System.out.println("No such task");
				}
			}
		}
	}

/***********************************************************************
 * Written by Matt
 * The stdin variable and readCommand function are wrappers to hide the
 * complexity of using Java to read from the command line
 * readCommand returns an array with two parts: the first word typed,
 *   and the rest of the line.  The first word is the command, the
 *   rest is the parameter for that command.  For example:
 *     add This is my task
 *   "add" is the command, and "This is my task" is the paramter
 **********************************************************************/
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	
	private static String[] readCommand(){
		try{
			String line=stdin.readLine();
			return((line==null)?(null):(line.trim().split("\\s",2)));
		}catch(IOException ioe){
			return(null);
		}
	}
/**********************************************************************/
}