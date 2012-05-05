import java.io.*;
import java.util.*;

public class Agendoo{

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
			if(command==null){
				System.out.println("Goodbye!");
				return;
				
			}else if(command[0].equals("exit") || command[0].equals("quit")){
				System.out.println("Goodbye!");
				return;
			
		//If the user typed '?', then show them a help screen
			}else if(command[0].equals("?")){
				System.out.println("The following commands are available:");
				System.out.println(" ?                : Displays this help text");
				System.out.println(" add <task name>  : creates a task");
				System.out.println(" del <task #>     : Deletes a task");
				System.out.println(" list             : Lists all tasks");
				System.out.println(" quit             : Exits out of program");
				System.out.println("");

		//If the user typed 'list', then print a list of tasks
			}else if(command[0].equals("list")){
				String[] list=tasks.listTasks();
				System.out.println("");
				System.out.println("~====================~");
				for(int i=0; i<list.length; i++){
					System.out.println((i+1)+" - "+list[i]);
					
				}
				System.out.println("~====================~");
				System.out.println("");
			
		//If the user typed 'add', then some text, add the text as
		//  a new task
			}else if(command[0].equals("add")){
				tasks.addTask(command[1]);
				System.out.println("Your task has been added");
			
		//If the user typed 'del', then a number, try to delete
		//  the task with that number
			}else if(command[0].equals("del")){
				//the following try-catch block simply trys something,
				//and if it fails and creates an error,
				//the catch will then run
				try{
					int id=Integer.parseInt(command[1]);
					tasks.delTask(id-1);
					System.out.println("The task has been sucessfully deleted");
				}catch(Exception e){
					System.out.println("No such task");
				}
			}else{
			// Check for error, if true, return error message
				System.out.println("Your request was unable to be completed. Please press ? for help");
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
