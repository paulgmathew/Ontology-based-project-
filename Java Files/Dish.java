package main;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;

public class Dish {
	
	
	public static void main(String[] args)
	{
		// in jena the graph interface is represented by the model interface
		// model used for creating a memory based model
//insertGraph();
		
		
		 // create an empty model
		 Model model = ModelFactory.createDefaultModel();
		
		 LinkedList<String> ll = new LinkedList();

		 // use the FileManager to find the input file
		 InputStream in = FileManager.get().open("C:/protegelearning/dish.owl");
		if (in == null) {
		    throw new IllegalArgumentException(
		                                 "File: " + "C:/protegelearning/university1.rdf" + " not found");
		}

		// read the RDF/XML file
		model.read(in, null);

		// write it to standard out
	//	model.write(System.out);
		
		//insertGraph();
		//closing in
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////////////////
		//query for selecting ingrediants 
		
		
		
		String prefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
				"PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
				"PREFIX dish: <http://www.semanticweb.org/paulgmathew/ontologies/2015/3/dish.owl#>";
		System.out.println("select the ingrediants");
		boolean done = true;
		boolean submenu = true;
		String s = null;
		HashMap<String,String> hIngrediants= new HashMap();
	while(done)
		{
		int count = 0;
		int count2 = 0;
		
		BufferedReader bufferRead;
	
		 
		 HashMap<String,String> ingre = new HashMap();
			if(submenu)
			{
		 String ingrediantQuery = "SELECT  ?dishType " +
				" WHERE {  " +
				" ?dishType rdfs:subClassOf dish:Ingrediants } ";
		 
		 String resultQuery  = prefix + ingrediantQuery;
		 
		 Query query1 = QueryFactory.create(resultQuery);

			// Execute the query and obtain results
			QueryExecution qe1 = QueryExecutionFactory.create(query1, model);
			ResultSet results1 = qe1.execSelect();
		//	ResultSetFormatter.out(System.out, results, query);
			while(results1.hasNext())
				{count++;
				 QuerySolution row=results1.nextSolution();
				 String aa =  row.get("dishType").toString();
				 String[] bb = aa.split("#");
				// System.out.println("Title: " + row.get("dishType").toString());	
				 System.out.println(count+":"+bb[1]);
				 hIngrediants.put(Integer.toString(count),bb[1]);
			     
				}
			qe1.close();
		}
			
	                       // get input from user                                                 
			try{
				if(submenu)
				{
			    bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    s = bufferRead.readLine();
			    System.out.println(s);
				}
				
				submenu = false;
			  //  System.out.println(hIngrediants.get(s));  
			    System.out.println("Select ");
			    String individuals = " SELECT  ?dishType " + 
			    	   " WHERE { " + 
					 " ?dishType rdf:type  dish:"+hIngrediants.get(s)+
		               "} " ;
			    String resultIndividual  = prefix + individuals;
				 
				 Query query2 = QueryFactory.create(resultIndividual);

					// Execute the query and obtain results
					QueryExecution qe2 = QueryExecutionFactory.create(query2, model);
					ResultSet results2 = qe2.execSelect();
				//	ResultSetFormatter.out(System.out, results, query);
					while(results2.hasNext())
						{count2++;
						 QuerySolution row=results2.nextSolution();
						 String aa1 =  row.get("dishType").toString();
						 String[] bb2 = aa1.split("#");
					//	 System.out.println("Title: " + row.get("dishType").toString());	
						 System.out.println(count2+":"+bb2[1]);
						 ingre.put(Integer.toString(count2),bb2[1]);
						}
					qe2.close();
			    System.out.println("select your ingrediants or press 'b' to go to previous menu or y to get the answer");
			    
			    bufferRead = new BufferedReader(new InputStreamReader(System.in));
			    String ss = bufferRead.readLine();
			    if(ss.equals("b"))
			    {
			    	submenu = true;
			    }
			    else if(s.equals("y")||ss.equals("y"))
			    {
			    	done = false;	
			    }
			    else
			    		{
			    System.out.println(ss);
			    System.out.println(ingre.get(ss));
			    ll.add(ingre.get(ss));
			   // System.out.println(ll.size());
			    		}
			    
			   
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			
		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Create a new query
		String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
			"PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
			"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" +
			"PREFIX dish: <http://www.semanticweb.org/paulgmathew/ontologies/2015/3/dish.owl#>" +
		    " SELECT  ?dishType" +
			" WHERE { " +
			" ?dishType dish:contains_ingrediants dish:Ham ."+
		"}";
		
		String add =" ";
		String sel =  " SELECT  ?dishType ?Location ?CookingTime" +
				" WHERE { " ;
		String prop =     "?dishType dish:cook_time ?CookingTime .?dishType dish:Location ?Location.";
		int tot = ll.size();
		int to = tot-1;
		while(tot !=0)
		{
			add = add + " ?dishType dish:contains_ingrediants dish:"+ ll.get(tot-1) +" .";
			//System.out.println("-----------------------------------------"+ll.size()+""+ll.get(tot-1));
			tot--;
		}
		
		String output = prefix+sel+add+prop+" } ";
		//System.out.println("-----------------------------------------"+output);
		
		//Query query = QueryFactory.create(queryString);
		Query query = QueryFactory.create(output);
		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		QueryExecution qe4 = QueryExecutionFactory.create(query, model);
		ResultSet results = qe.execSelect();
		ResultSet resloc =  qe4.execSelect();
		///ResultSet results2 = results; 
	//while(results.hasNext())
	//	{
	//	 QuerySolution row=results.nextSolution();
	 // System.out.println("Title: " + row.get("dishType"));
	//		
	//	}
		// Output query results	
		System.out.println("-------------------------------------------------------------------------------------------");
		ResultSetFormatter.out(System.out, results, query);
		while(resloc.hasNext())
		{
		 QuerySolution row=resloc.nextSolution();
		 String aa =  row.get("Location").toString();
		// ?dishType ?calorie ?Location
		 String dish = row.get("dishType").toString();
		 String[] dish1 = dish.split("#"); 
		 String cal = row.get("CookingTime").toString();
		 String[] cal2 = cal.split(":");
		 
		// String[] bb = aa.split("#");
		// System.out.println("Title: " + row.get("dishType").toString());	
		// System.out.println(count+":"+bb[1]);
		// hIngrediants.put(Integer.toString(count),bb[1]);
	   //  System.out.println("Location is "+aa);
	     String[] bb = aa.split(":");
	     System.out.println("-------------------------------------------------------------------------------------------");
			
	     System.out.println("Dish:"+dish1[1]+" CookingTime:"+cal2[0]+" Location: "+bb[0]+","+bb[1]);
	     AStarAlgorithm asa = new AStarAlgorithm();
			asa.searchPath(bb[1]);
			
			 AStarAlgorithm2 asa2 = new AStarAlgorithm2();
				asa2.searchPath(bb[1]);
	     
		}
	//	while(results.next() != null)
	//			{
	//				System.out.println(results.toString());
	//			}
		// Important - free up resources used running the query
		
		qe.close();
		qe4.close();
		
	}
}
