Running Agendue on Windows
===========================
Type https://github.com/downloads/tstuder/Agendue/Agendue.zip in your browser's address bar.
Unzip file you just downloaded
Run Agendue.bat for Windows users
Run Agendue.jar for Linux or Mac users

Getting the Agendue source code
===========================

	git clone git@github.com:tstuder/Agendue.git

Building Agendue Source Code
===========================

	javac Agendue.java
	
Running Agendue
===========================

	java Agendue

Building the Agendue package
============================
	
	jar cfe Agendue.jar Agendue Agendue.class TaskDB.class
	
Using
===========================
	* At the prompt, type ? followed by the <ENTER> key to display
		command help
	* To add a task, type "add Play video games"
	* To add another task, type "add Do Homework"
	* To add another task, type "add Go outside and play"
	* To view all tasks, type "list"
	* To delete a task, type "del 1"


