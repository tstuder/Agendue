import java.util.*;
import java.io.*;

/**
 * TaskDB stores tasks in a database and can be saved to a file.
 * Written by Matt
 */
public class TaskDB{

	List<String> tasks;
	String file="tasks.db";

	/**
	 * Constructs a TaskDB object, which can be serialized to "tasks.db"
	 * Written by Matt
	 */
	@SuppressWarnings("unchecked")
	public TaskDB(){
		this.file=file;
		try
		{
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			tasks = (List<String>)in.readObject();
			in.close();
			fileIn.close();
		}catch(Exception e){
			tasks=new ArrayList<String>();
		}
	}
	
	/**
	 * Returns a String array listing the text of all tasks in the database
	 * Written by Matt
	 * @return list of tasks' text
	 */
	public String[] listTasks(){
		return(tasks.toArray(new String[0]));
	}
	
	/**
	 * Adds a new task to the database
	 * Written by Matt
	 * @param text the text of the new task
	 */
	public void addTask(String text){
		tasks.add(text);
	}
	
	/**
	 * Deletes a task from the database
	 * Written by Matt
	 * @param index number of the task to be deleted
	 */
	public void delTask(int index){
		tasks.remove(index);
	}

	/**
	 * Saves (serializes) the task DB
	 * Written by Matt
	 */
	public void save(){
		try{
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tasks);
			out.close();
			fileOut.close();
		}catch(Exception e){
          e.printStackTrace();
		}
	}
}

