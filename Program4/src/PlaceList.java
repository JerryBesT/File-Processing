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

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PlaceList that will manage a list of instances of the place class. 
 * An ArrayList is used to hold the instances. This class will have instance methods 
 * to add a place, remove a place, return the number of places, and return whether there are places.
 * @author jerryzou
 *
 */
public class PlaceList 
{
	private ArrayList<Place> places;
	
	/**
	 * a instant method to write the new file contents
	 * @param filename the name of the file that needs to be written
	 * @param place	the specific place that needed to be checked
	 */
	public void writeFile(String filename, Place place)
	{
		//try catch to avoid the situation from writing not existed file
		try
		{
			// choose the file to input information
			PrintWriter out = new PrintWriter(filename);
			// iterate all the places that have been stored
			for(int i = 0; i < places.size(); ++i)
			{
				// to check if the writing place is equal to the existing place
				if(place.isEqual(places.get(i)))
					// if the place has already existed, print out statement, else write the information into the file
					System.out.println(place.getName() + " already in list.");
				else
					out.println(places.get(0).getName() + ";" + places.get(0).getAddress());
			}
			// close the file if it is finished
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to write to file: " + filename);
		}
	}
	
	/**
	 * a instant method to read the file from the folder if it exists
	 * @param filename the name of the file
	 * @param place it stores all the places and their information
	 */
	public void readFile(String filename, Place place)
	{
		//try catch to avoid the situation from writing not existed file
			try
			{
				// the scanner to extract all the information from the file
				Scanner info = new Scanner(new File(filename));
				// use the arraylist to store all the information
				ArrayList<String> content = new ArrayList<String>();
				// it keeps looping as long as the next line exists
				while(info.hasNextLine())
				{
					// add every line to the arraylist
					content.add(info.nextLine());
				}
				// check if the places class has information or not
				if(!places.isEmpty())
				{
					//iterate the array list
					for(int j=0;j < content.size();++j)
					{
						// use the split method to break down the information into two parts, which are x[0] and x[1]
						String[] x = content.get(j).split(";");
						// store the information into place instances
						place = new Place(x[0], x[1]);
						// if the existing places are equal to the new then print out already in list, else just add the new place
						if(place.isEqual(places.get(j)))
							System.out.println(place.getName() + " already in list.");
						else
							places.add(place);
					}
				}
				// if the placelist is empty, then executes
				else
				{
					// iterate the whole file lines
					for(int j=0;j < content.size();++j)
					{
						// use the split method to break down the information
						String[] x = content.get(j).split(";");
						// store the new place information into a instance
						place = new Place(x[0], x[1]);
						// add the new place instance to place list
						places.add(place);
					}
				}
				
			}catch(FileNotFoundException e)
			{
				System.out.println("Unable to read from file: " + filename);
			}
	}
	
	/**
	 * store all the places instances into the array list at placelist
	 */
	public PlaceList()
	{
		places = new ArrayList<Place>();
	}
	
	/**
	 * add a new place instance to to place list
	 * @param place a new place instance including address and name
	 */
	public void addPlace(Place place)
	{
		places.add(place);
	}
	
	/**
	 * remove a certain place in the place list class
	 * @param x
	 */
	public void removePalce(int x)
	{
		places.remove(x);
	}
	/**
	 * to retrieve a place information from the place list
	 * @param x the index of the place that needs to be retrieved
	 * @return the information of the specific place
	 */
	public Place getPlace(int x)
	{
		return places.get(x);
	}
	/**
	 * the size of the place array list or the total number of places
	 * @return the size of array list
	 */
	public int numPlace()
	{
		return places.size();
	}
	/**
	 * check if the place list is empty or not
	 * @return true if the list is empty, false if it is not
	 */
	public boolean isEmpty()
	{
		if(places.size() > 0)
			return false;
		else
			return true;
	}
	
	/**
	 * check if the place exists or not
	 * @param place
	 * @return check if the place exists or not
	 */
	public boolean isExist(Place place)
	{
		return places.contains(place);
	}
}
