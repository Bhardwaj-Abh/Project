package com.project.abhinav;

import java.io.IOException;
import java.util.Scanner;

public class Options {

	Scanner scan = new Scanner(System.in);
	CRUDoperations operation = new CRUDoperations();

	public void selectPrimaryOptions() {

		System.out.println("Choose your option");
		System.out.println("1.Get all current files");
		System.out.println("2.Operations on files");
		System.out.println("3.Close the application");

	}

	public void selectSecondaryOptions() {

		System.out.println("Choose your option");
		System.out.println("1.Add a file");
		System.out.println("2.Delete a file ");
		System.out.println("3.Search a file");
		System.out.println("4.Return to Main Menu");

	}

	public void closeApplication() {
		System.out.println("\n\n");
		System.out.println("Thank you for choosing LockedMe.com");
	}

	public void primaryOptions() {

		int choice = 0;
		char decision = 0;
		

			selectPrimaryOptions();

			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nPlease enter a valid option");
				selectPrimaryOptions();
			}

			if (choice == 1) {
				System.out.println();
				try {
					operation.getAllFiles(Main.path);
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}

			else if (choice == 2) {
				System.out.println();
				secondaryOptions();
				
			} else if (choice == 3) {
				System.out.println("Are you sure you want to close the application");
				System.out.println("Press [N] for No");
				System.out.println("Press [Y] for Yes");
				decision = scan.nextLine().toUpperCase().charAt(0);
				if (decision == 'Y') {
					System.out.println("\n");
					closeApplication();
					System.exit(1);
				} else if (decision == 'N') {
					System.out.println("\n");
					selectPrimaryOptions();
				} else {
					System.out.println("\nPlease enter a valid choice");
					selectPrimaryOptions();   
				}
			}

			else {
				System.out.println("\nPlease enter a valid choice");
				selectPrimaryOptions();
			}


		

	}
	
	public void secondaryOptions() {
		

		String file = null;
		String fileName = null;
		int choice = 0;

		do {

			selectSecondaryOptions();

			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid option");
				selectSecondaryOptions();
			}

			if(choice ==1) {
				System.out.println("Enter name for the file ");
				file = scan.nextLine();
				fileName = file.trim();
				try {
					operation.addNewFile(Main.path, fileName);
				}catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}catch(IOException e) {
					System.out.println("ERROR");
				}catch(Exception e) {
					System.out.println("ERROR");
				}
				break;
			}
			
			else if (choice==2) {
				System.out.println("Enter file name");
				file = scan.nextLine();
				fileName = file.trim();
				try {
					operation.deleteFile(Main.path, fileName);
				}catch(NullPointerException e) {
					System.out.println(e.getMessage());
				}catch(IOException e) {
					System.out.println("ERROR");
				}catch(Exception e) {
					System.out.println("ERROR");
				}
				break;
			}
			
			else if(choice ==3) {
				System.out.println("Enter file name");
				file = scan.nextLine();
				fileName = file.trim();
				try {
					operation.searchFile(Main.path, fileName);
				}catch(NullPointerException e) {
					System.out.println("ERROR");
				}catch(IllegalArgumentException e) {
					System.out.println("ERROR");
				}catch(Exception e) {
					System.out.println("ERROR");
				}
				break;
			}
			
			else if(choice ==4) {
				 selectPrimaryOptions();
					break;
			}
			
			else {
				System.out.println("Please enter a valid option");
				selectSecondaryOptions();
			}
			

		file = null;
		fileName = null;

		}while(true);
}
	
}