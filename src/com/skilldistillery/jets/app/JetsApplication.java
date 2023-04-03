package com.skilldistillery.jets.app;

import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	private Airfield airfield = new Airfield();
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	private void launch() {
		// airfield.populateAirfieldFromFile("jets.txt");

		boolean amIDone = true;
		while (amIDone) {
			mainMenu();
			String choice = input.nextLine();

			if (choice.equals("1")) {
				listFleet();
			} else if (choice.equals("2")) {
				flyAllJets();
			} else if (choice.equals("3")) {
				viewFastestJet();
			} else if (choice.equals("4")) {
				longestRange();
			} else if (choice.equals("5")) {
				loadAllCargoJets();
			} else if (choice.equals("6")) {
				dogfight();
	         } else if (choice.equals("7")) {
	             addJetToFleet();
//	         } else if (choice.equals("8")) {
//	             removeJetFromFleet();
			} else if (choice.equals("9")) {
				amIDone = false;
				System.out.println("See you later");
				break;
			} else {
				System.out.println("Invalid input. Please try again.");
			}
		}
	}

	private void mainMenu() {
		System.out.println();
		System.out.println("PLEASE CHOOSE AN ITEM FROM THE MENU BELOW");
		System.out.println("1. List fleet");
		System.out.println("2. Fly all jets");
		System.out.println("3. View fastest jet");
		System.out.println("4. View jet with longest range");
		System.out.println("5. Load all Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a jet to Fleet");
		System.out.println("8. Remove a jet from Fleet");
		System.out.println("9. Quit");
		System.out.print("PLEASE ENTER A NUMBER FROM THE MENU ABOVE: ");
		System.out.println();

	}

	public void listFleet() {
		airfield.printFleetDetails();
	}

	public void flyAllJets() {
		airfield.flyAllJets();
	}

	private void viewFastestJet() {
		airfield.viewFastestJet();
	}

	private void longestRange() {
		airfield.longestRange();
	}

	private void loadAllCargoJets() {
		airfield.loadAllCargoJets();
	}

	private void dogfight() {
		airfield.dogfight();
	}

	private void addJetToFleet() {
		airfield.addJetToFleet();
	   
		
		}
	}

