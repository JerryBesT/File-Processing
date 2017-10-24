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

/**
 *  Place that contains name and address fields for a place 
 *  (what should be the visibility of these data members?). 
 *  This class will contain appropriate constructors, accessor (getter) and mutator (setter) methods.
 * @author jerryzou
 *
 */
public class Place {
	private String place;
	private String name;
	private String address;
	
	/**
	 * constructor that holds the places individually
	 * @return nothing
	 */
	public Place(String name, String address)
	{
		this.name = name;
		this.address = address;
	}
	
	/**
	 * a instant method to get name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * a instant method to get address
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * @Override to show the character
	 */
	public String toString()
	{
		return name;
	}
	/**
	 * a instant method to check if two instants are equal in names and addresses
	 * @param obj the another object
	 * @return true if the two instances are equal, else not, or they are not the same type
	 */
	public boolean isEqual(Object other)
	{
		if(other instanceof Place)
		{
			Place place = (Place)other;
			if(place.getName().equals(this.name) && place.getAddress().equals(this.address))
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
