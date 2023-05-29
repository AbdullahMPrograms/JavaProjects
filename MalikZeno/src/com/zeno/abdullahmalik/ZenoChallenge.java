package com.zeno.abdullahmalik;

import java.util.Scanner;

/**
 * 	Zeno's Paradox
 * @author Abdullah M
 *
 */

public class ZenoChallenge {
		
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
		// Input
		System.out.print("How many stops? ");
		
		//Variables
		int numStops = in.nextInt();
		double total = zenoDistance(numStops);
		
		//Output
		System.out.format("Total Distance %.3f\n", total);
	}
	
	/**
	 * returns distance
	 * @param numStops
	 * @return
	 */
	public static double zenoDistance (int numStops) {
		//Variables
		double total = 0.0;
		double d = 1; //distance = 1km 
				
		//Calculation
		for (int i = 0; i < numStops; i++) {
			d = d / 2;
			total = total + d; 
		}
		return total;
	}
}