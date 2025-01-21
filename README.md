# CWExercises

These are a selection of Java based excercises completed as part of "OBJECT ORIENTED PROGRAMMING" module at uni

Brief:
You are required to incorporate your solutions to a selection of the lab exercises into a given project so it runs without reporting errors. Download the Eclipse project (also provided at the bottom of the page) and carefully follow the instructions given in Main.java. The submission will incorporate your work from the following lab exercises:

  Week 2: Timecode
  
Write a program that prints a given time value with units of seconds as a timecode. The timecode format required is HH:MM:SS:mmm where HH is hours, MM is minutes, SS is seconds and mmm is milliseconds. For example, if the time value is 3661.001 seconds, the timecode value is 01:01:01:001. Print the timecode using System.out.printf to show the correct number of digits with leading zeros. You are not allowed to use any functions from java.lang.Math for your calculations. Hint: Use casting, integer division and modulo to compute the four timecode components as integers.
  
  Week 3: Finding Pi
  
Write a program that returns the closest rational number to pi (3.1415926535898...) for integers under 1000. A rational number is given by a/b where a and b are both integers and b is not zero. Additionally, print out the number of decimal places your approximation is accurate to. Pi is available in Java as Math.PI. Challenge: Can you find the best approximation for integers under 100,000? For integers under 500,000? How can you optimize your program to get the result faster?
  
  Week 5: String Weaver
  
You have just been hired at Acme Inc. as a programmer to work on their inventory system. They need a basic mutable string class as Java's built-in String class is immutable. Your mentor has given you the following main() function and it is your task to write the class so the code compiles and runs without throwing any exceptions. You are given the following DynString class code to get started:

	public class DynString {
		private char[] data;

		// Construct of given size
		public DynString(int len){
			resizeData(len);
		}

		// Construct copying values from char array
		public DynString(char[] src){
			this(src.length);
			for(int i=0; i<size(); ++i){
				data[i] = src[i];
			}
		}

		// Get current size
		public int size(){
			return data.length;
		}

		// Resize internal array; zeroes all values
		private void resizeData(int n){
			data = new char[n];
		}
	}
As you build the class out, adhere to the DRY (don't repeat yourself) principle. Encapsulate repeated code into functions and/or delegate work to another method or constructor. For example, in the starter code, we see the constructor that copies from a char[] to delegate the sizing of the internal data to the size constructor which in turn delegates the memory allocation to a resizeData() method (which should be private). The tests occur roughly in order of increasing complexity with more basic/non-dependent functionality appearing before more advanced/dependent functionality. It is suggested that you work piece-meal. Comment out all but the first test block and then introduce later test blocks one-by-one writing the necessary methods to make main() compile and run without exceptions.
  
  Week 6: Enter the Data
  
For this exercise, you will create a program that allows the user to edit a database from the console. The database will store a person's first name, last name and age. The user should be allowed to add, remove and list database entries. Whenever a new entry is added to the database, it should be assigned a unique ID. IDs should start at 1 and increment by 1 for each new entry added. Create a custom class to represent the database entries and an appropriate container type to store the entries. Here is an example session showing how the program should behave:

    > Please enter a command: help

    Valid commands are:
      a   Add record
      r   Remove record
      l   List records
      q   Quit

    > Please enter a command: l

    Database is empty.

    > Please enter a command: a
    > Enter data as "firstName lastName age": John Doe 47

    Record added.

    > Please enter a command: a
    > Enter data as "firstName lastName age": Jane Doe 42

    Record added.

    > Please enter a command: l

    Doe, John 47 (id 1)
    Doe, Jane 42 (id 2)

    > Please enter a command: r
    > Enter ID of record to remove: 3

    No record found.

    > Please enter a command: r
    > Enter ID of record to remove: 2

    Record removed.

    > Please enter a command: l

    Doe, John 47 (id 1)

    > Please enter a command: q
