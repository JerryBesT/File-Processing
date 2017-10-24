//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:            CS302
// Files:            Place.java, MyPlaceApp.java, PlaceList.java
// Semester:         Fall 2016
//
// Author:           Zhenyu Zou
// Email:            zzou24@wisc.edu
// CS Login:         zzou
// Lecturer's Name:  Gary Dahl
// Lab Section:      1350
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// 
// Partner Name:     xx I DONT HAVE A PARTNER
// Partner Email:    xx
// Partner CS Login: xx
// Lecturer's Name:  xx
// Lab Section:      xx
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//    _Y_ Write-up states that Pair Programming is allowed for this assignment.
//    _Y_ We have both read the CS302 Pair Programming policy.
//    _Y_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates 
// strangers, etc do.
//
// Persons:          (identify each person and describe their help in detail)
// Online Sources:   piazza, google
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  Place that contains name and address fields for a place 
 *  (what should be the visibility of these data members?). 
 *  This class will contain appropriate constructors, accessor (getter) and mutator (setter) methods.
 * @author jerryzou
 *
 */
public class MyPlacesApp {
	
	/**
	 * the method for the menu.
	 */
	public static void menu()
	{
		System.out.println("\nMy Places 2016");
		System.out.println("--------------------------");
		System.out.println("No places in memory.");
		System.out.println("--------------------------");
		System.out.print("A)dd R)ead Q)uit: ");
	}
	
	/**
	 * the static method from the user to add places
	 * @param input scanner input
	 * @param newPlace the place that needs to be added
	 * @param places the array list that will be stored places
	 */
	public static void UserChoiceForAdding(Scanner input, Place newPlace, PlaceList places)
	{
		// prompt out the questions for names and addresses for places and store them to play list
		System.out.print("Enter the name: ");
		String userName = input.nextLine();
		System.out.print("Enter the address: ");
		String userAddress = input.nextLine();
		System.out.println("Adding: " + userName);
		newPlace = new Place(userName, userAddress);
		places.addPlace(newPlace);
	}
	
	/**
	 * the static method from the user to read the files
	 * @param places the array list that will be stored places
	 * @param newPlace the place that needs to be added
	 * @param in scanner input
	 */
	public static void UserChoiceForReading(PlaceList places, Place newPlace, Scanner in)
	{
		//set a new array list for the file names
		ArrayList<String> fileInfo = new ArrayList<String>();
		System.out.println("My Places Files: ");
		// set up a file to search all the files
		File folder = new File(".");
		// iterate all the files in folder
		for(File file: folder.listFiles())
		{
			// it prints and add the files names to the file array list
			if ( file.getName().endsWith( ".mp" )) 
			{
				System.out.println("    " + file.getName());
				fileInfo.add(file.getName());
			}
		}
		System.out.print("\nEnter filename: ");
		String filename = in.nextLine();
		String name = null;
		// to extract the right name of the file name from the array list
		for(int i=0;i < fileInfo.size();++i)
			if(fileInfo.get(i).equals(filename))
				name = fileInfo.get(i);
		// check if the input of filenames is equal to the existing file names
		if(filename.equals(name))
		{
			System.out.println("Reading file: " + filename);
			// read the file if the file name matched
			places.readFile(filename, newPlace);
			System.out.print("Press Enter to continue.");
			in.nextLine();
		}
		else
		{
			// print out wrong message if they do not match
			System.out.println("Unable to read from file: " + filename);
			System.out.print("Press Enter to continue.");
			in.nextLine();
		}
	}
	
	/**
	 * the static method from the user to write the files
	 * @param places the array list that will be stored places
	 * @param place the place that needs to be added
	 * @param in scanner input
	 */
	public static void UserChoiceForWriting(Scanner in, PlaceList places, Place place)
	{
		System.out.println("My Places Files: ");
		File folder = new File(".");
		String name = null;
		// this loop can iterate the while folder to print out all the file names ending with ".mp"
		for(File file: folder.listFiles())
		{
			if ( file.getName().endsWith( ".mp" )) 
			{
				System.out.println("    " + file.getName());
				name = file.getName();
			}
		}
		
		System.out.print("\nEnter filename: ");
		String filename = in.nextLine();
		System.out.println("Writing file: " + filename);  
		// call the write method to write the file content
		places.writeFile(filename, place);
		System.out.print("Press Enter to continue.");
		in.nextLine();
	}
	
	/**
	 * the menu that should be executed after the  first choice.
	 * @param input scanner input
	 * @param places the places array list
	 * @param userInput the choice from user
	 */
	public static void manu2(Scanner input, PlaceList places, String userInput)
	{
		System.out.println("\nMy Places 2016");
		System.out.println("--------------------------");
		
		// print out all the already stored places to the new menu
		for(int i=0; i < places.numPlace(); i++)
		{
			System.out.println((i + 1) + ") " + places.getPlace(i));
		}
		
		System.out.println("--------------------------");
		System.out.print("A)dd S)how D)elete R)ead W)rite Q)uit: ");
	}

	/**
	 * main method that executes the program
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// followings are all the necessary variables
		PlaceList places = new PlaceList();
		Place newPlace = null;
		String userInput = null;
		String confirm;
		int Invalid;
		String Invalid2;
		Scanner input = new Scanner(System.in);
		// a boolean variable to check if the loop should be ended or not
		boolean isEnd = true;
		do
		{
			//it executes as long as the place list is empty
			if(places.isEmpty())
			{
				// the first menu executes for the not existing places
 				MyPlacesApp.menu();
 				// 
				if(input.hasNextInt())
				{
					//if the input contains number, then return invalid and repeat
					Invalid = input.nextInt();
					System.out.println("Unrecognized choice: " + Invalid);
					System.out.print("Press Enter to continue.");
					confirm = input.nextLine();
					input.nextLine();
				}
				else
				{
					// under the condition that the input does not contain numbers
					userInput = input.nextLine();
					// executes when the choice is q
					if(userInput.equalsIgnoreCase("Q"))
					{
						System.out.println("Thank you for using My Places 2016!");
						isEnd = false;
					}
					// executes when the choice is a
					else if(userInput.equalsIgnoreCase("A"))
					{
						// call the method for adding
						MyPlacesApp.UserChoiceForAdding(input, newPlace, places);
						System.out.print("Press Enter to continue.");
						confirm = input.nextLine();
					}
					// executes when the choice is r
					else if(userInput.equalsIgnoreCase("R"))
					{
						// call the method for reading
						MyPlacesApp.UserChoiceForReading(places, newPlace, input);
					}
					// executes when the choice is nothing from above
					else if(userInput.trim().length() > 1 || !userInput.equalsIgnoreCase("A") || !userInput.equalsIgnoreCase("R"))
					{
						// return error and repeat the loop
						System.out.println("Unrecognized choice: " + userInput);
						System.out.print("Press Enter to continue.");
						confirm = input.nextLine();
					}
				}
			}
			// executes when the place list is not empty
			else if(!places.isEmpty())
			{
				// call the second menu to print out the existing places
				MyPlacesApp.manu2(input, places, userInput);
				userInput = input.nextLine();
				// executes when the choice is a
				if(userInput.equalsIgnoreCase("A"))
				{
					// call the adding method
					MyPlacesApp.UserChoiceForAdding(input, newPlace, places);
					System.out.print("Press Enter to continue.");
					confirm = input.nextLine();
				}
				// executes when the choice is q
				else if(userInput.equalsIgnoreCase("Q"))
				{
					System.out.println("Thank you for using My Places 2016!");
					isEnd = false;
				}
				// executes when the choice is s
				else if(userInput.equalsIgnoreCase("S"))
				{
					System.out.print("Enter number of place to Show: ");
					int userNum = input.nextInt();
					// if the number is within the range, it executes
					if(userNum > 0 && userNum <= places.numPlace())
					{
						System.out.println(places.getPlace(userNum - 1).getName());
						System.out.println(places.getPlace(userNum - 1).getAddress());
					}
					// if not, return error and repeat the loop again
					else
					{
						System.out.println("Expected a number between 1 and " + places.numPlace() + ".");
					}
					
					System.out.print("Press Enter to continue.");
					confirm = input.nextLine();
					input.nextLine();
				}
				// executes when the choice is d
				else if(userInput.equalsIgnoreCase("D"))
				{
					System.out.print("Enter number of place to Delete: ");
					int userNumToD = input.nextInt();
					// if the number is within the range, it executes
					if(userNumToD > 0 && userNumToD <= places.numPlace())
					{
						// remove the index and show the message of delecting
						System.out.println("Deleting: " + places.getPlace(userNumToD - 1));
						places.removePalce(userNumToD - 1);
					}
					else
					{
						System.out.println("Expected a number between 1 and " + places.numPlace() + ".");
					}
					
					System.out.print("Press Enter to continue.");
					confirm = input.nextLine();
					input.nextLine();
				}
				// executes when the choice is r
				else if(userInput.equalsIgnoreCase("R"))
				{
					UserChoiceForReading(places, newPlace, input);
				}
				// executes when the choice is w
				else if(userInput.equalsIgnoreCase("W"))
				{
					UserChoiceForWriting(input, places, newPlace);
				}
			}
		}while(isEnd);
		
	}

}
