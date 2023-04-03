package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Airfield {
	
	private List<Jet> fleet = new ArrayList<>();
	
	public Airfield() {
		
	}
	
	public List<Jet> getFleet() {
		return fleet;
	}

	public void addNewJet(Jet jet) {
		fleet.add(jet);
	}
	
	public void removeJet(int index) {
		fleet.remove(index);
	}

	public List<Jet> readFromFile(String fn) {
		List<Jet> jets = new ArrayList<>();
		
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {
				String[] jetDetails = aJet.split(",");
				
				// create the appropriate jet based on details
				String type = jetDetails[0];
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4].replaceAll("_", ""));
				
				Jet jet = null;
				
				if (type.equals("Cargo")) {
					jet = new CargoJet(model, speed, range, price);
				}
				else if (type.equals("Fighter")) {
					jet = new CombatJet(model, speed, range, price);
				}
				else if (type.equals("Passenger")) {
					jet = new PassengerJet(model, speed, range, price);
				}
				
				jets.add(jet);
			}
		}
		catch (IOException e) {
			System.err.println(e);
		}
		
		return jets;
	}
}
