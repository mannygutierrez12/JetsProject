package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List <Jet> fleet;
	
	public Airfield() {
		
	}
	
	
	public List<Jet> readFromFile(String fn) {
		List<Jet> jets = new ArrayList<>();
		
		
		//Read various jet types from file
		// as you read in a jet, create a jet
		//and add that specific Jet type to your jets list
		try ( BufferedReader bufIn = new BufferedReader(new FileReader("fn")) ) {
			  String aJet;
			  while ((aJet = bufIn.readLine()) != null) {
			   // System.out.println(line);
				  String[] jetDetails = aJet.split(",");
				  // create the appropriate jet based on details
				  /*
				   * if the jetdetails [0] happens to be a dcv, the create
				   * a dilithimpower jet if instead a fighter create a fighter jet
				   * and add that to jet list
				   */
				  
				  
				  
				  
			  }
			}
			catch (IOException e) {
			  System.err.println(e);
			}
		
		return jets;
				
		
		
	}
}
