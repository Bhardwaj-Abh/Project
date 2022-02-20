package com.project.abhinav;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CRUDoperations {
		
	public void getAllFiles(String path)  {


		if (path == null || path.length()==0 || path.length()==0)
			throw new NullPointerException("Please specify a path in the Main class under 'Path' variable");


		File repo = new File(path);

		String [] files = repo.list();

		if(files != null && files.length > 0) {

			Set<String>filesList = new TreeSet<String>(Arrays.asList(files));
			Iterator<String> filesIterator = filesList.iterator();
			while(filesIterator.hasNext()) {
				   System.out.println(filesIterator.next());
				}
		}else {

			System.out.println("No file present at "+path);
		}

	
	}
	
	public void addNewFile(String path , String fileName) throws IOException {

		if (path == null || path.length()==0 || path.length()==0)
			throw new NullPointerException("Please specify a path in the Main class under 'Path' variable");


		if (fileName == null || fileName.length()==0 || fileName.length()==0)
			throw new NullPointerException("\n Please enter a valid file name");

		File newFile = new File(path + File.separator + fileName);

		boolean transaction = newFile.createNewFile();

		if (transaction) {

			System.out.println(fileName+" created");

		}else {

			System.out.println("\nFile already exist with the current name\nPlease try a diffrent name" );

		}

	}

	public void deleteFile(String path , String fileName) throws IOException {


		if (path == null || path.isEmpty() || path.length()==0)
			throw new NullPointerException("Please specify a path in the Main class under 'Path' variable");


		if (fileName == null || fileName.isEmpty() || fileName.length()==0)
			throw new NullPointerException("\\n Please enter a valid file name");

		File newFile = new File(path + File.separator + fileName);

		boolean transaction = newFile.delete();

		if (transaction) {

			System.out.println(fileName+" Deleted");

		}else {

			System.out.println("\nFile Not Found.. Please try again." );

		}

	
	}

	public void searchFile(String path , String fileName) {


		if (path == null || path.isEmpty() || path.length()==0)
			throw new NullPointerException("Please specify a path in the Main class under 'Path' variable");


		if (fileName == null || fileName.isEmpty() || fileName.length()==0)
			throw new NullPointerException("\\n Please enter a valid file name");

		File repo = new File(path);

		String [] listOfFIles = repo.list();
		boolean flag = false;

		Pattern pat = Pattern.compile(fileName);

		if(listOfFIles != null && listOfFIles.length > 0) {
			for(String file:listOfFIles) {
				Matcher mat = pat.matcher(file);
				if(mat.matches()) {
					System.out.println(fileName+" is present at " + path);
					flag = true;
					break;
				}
			}
		}

		if(flag == false)
			System.out.println("There is no file with the name " +fileName);


	
	}
}
