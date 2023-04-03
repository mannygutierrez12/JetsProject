package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {
	private List<Jet> fleet;

	public Airfield() {
		fleet = readFromFile();
	}

	public void setFleet(List<Jet> fleet) {
		this.fleet = fleet;
	}

	public void printFleetDetails() {
		for (Jet jet : fleet) {
			System.out.println(jet.getModel() + ", speed: " + jet.getSpeed() + ", range: " + jet.getRange()
					+ ", price: " + jet.getPrice());
		}
	}

	public List<Jet> getFleet() {
		return fleet;
	}

	public void flyAllJets() {
		for (Jet jet : fleet) {
			System.out
					.println(jet.getModel() + " is flying for " + (int) (jet.getRange() / jet.getSpeed()) + " hours.");
			jet.fly();
		}

	}

	public Jet findFastestJet() {
		Jet thefastestJet = null;
		double speed = 0;
		for (Jet jet : fleet) {
			if (jet.getSpeed() > speed) {
				speed = jet.getSpeed();
				thefastestJet = jet;
			}
		}
		return thefastestJet;
	}

	public void viewFastestJet() {
		Jet fastestJet = findFastestJet();
		if (fastestJet != null) {
			System.out.println("The fastest jet is the " + fastestJet.getModel());
		} else {
			System.out.println("There are no jets in the fleet.");
		}
	}

	public Jet findJetLongestRange() {
		Jet longestRangeJet = null;
		double range = 0;
		for (Jet jet : fleet) {
			if (jet.getRange() > range) {
				range = jet.getRange();
				longestRangeJet = jet;
			}
		}
		return longestRangeJet;
	}

	public void longestRange() {
		Jet longestRange = findJetLongestRange();
		if (longestRange != null) {
			System.out.println("The jet with the longest range is the " + longestRange.getModel());
		} else {
			System.out.println("There are no jets in the fleet.");
		}
	}

	public void loadAllCargoJets() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoJet) {
				System.out.println("Loading cargo on " + jet.getModel() + "...");
				((CargoJet) jet).loadCargo();
			}
		}
	}

	public void dogfight() {
		for (Jet jet : fleet) {
			if (jet instanceof CombatJet) {
				System.out.println("The " + jet.getModel() + " is getting ready to fight");
				((CombatJet) jet).attackMode();
			}
		}
	}

	public void addJetToFleet() {
	    Jet jet = null;

	    System.out.println("Please choose the type of jet you would like to add");
	    System.out.println("Type 1 for Cargo, 2 for Fighter, or 3 for Passenger");
	    
	    Scanner kb = new Scanner(System.in);
	    
	    String input = kb.nextLine();
	    System.out.println("What's the model");
	    String model = kb.nextLine();
	    
	    System.out.println("What's the speed");
	    double speed = kb.nextDouble();
	    
	    System.out.println("What's the range");
	    double range = kb.nextDouble();
	    
	    System.out.println("What's the price");
	    double price = kb.nextDouble();

	    if (input.equals("1")) {
	        jet = new CargoJet(model, speed, range, price);
	    } else if (input.equals("2")) {
	        jet = new CombatJet(model, speed, range, price);
	    } else if (input.equals("3")) {
	        jet = new PassengerJet(model, speed, range, price);
	    } else {
	        System.out.println("Invalid input");
	    }

	    if (jet != null) {
	        fleet.add(jet);
	        System.out.println("Jet added to the list");
	    }
	}



	public List<Jet> readFromFile() {
		List<Jet> jets = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String aJet;
			while ((aJet = bufIn.readLine()) != null) {
				String[] jetDetails = aJet.split(",");
				String type = jetDetails[0];
				String model = jetDetails[1];
				double speed = Double.parseDouble(jetDetails[2]);
				int range = Integer.parseInt(jetDetails[3]);
				long price = Long.parseLong(jetDetails[4]);

				Jet jet = null;
				if (type.equals("Cargo")) {
					jet = new CargoJet(model, speed, range, price);
				} else if (type.equals("Fighter")) {
					jet = new CombatJet(model, speed, range, price);
				} else if (type.equals("Passenger")) {
					jet = new PassengerJet(model, speed, range, price);
				}
				jets.add(jet);
			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return jets;
	}

}
