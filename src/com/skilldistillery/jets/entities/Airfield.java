package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			System.out.println(jet.getModel() + ", speed: " + jet.getSpeed()
					+ ", range: " + jet.getRange() + ", price: " + jet.getPrice());
		}
	}

	public List<Jet> getFleet() {
		return fleet;
	}
	
	public void flyAllJets() {
		for (Jet jet : fleet) {
		    System.out.println(jet.getModel() + " is flying for " + (int)(jet.getRange() / jet.getSpeed()) + " hours.");
		    jet.fly();
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
