package main;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
 

class Node1{
 
        public final String value;
        public double g_scores;
       // public final double h_scores;
        public double f_scores;
        public Edge1[] adjacencies;
        public Node1 parent;
        HashMap<String, Double> hm = new HashMap();
       public Node1(String val)
	{
		
		value = val;
		
        }
 
        public String toString(){
                return value;
        }
        public void hValues(String val,double hval)
	{
		hm.put(val, hval);
	}
	
	public HashMap getHashMap()
	{
		
		return hm;
	}
 
}
 
class Edge1{
        public final double cost;
        public final Node1 target;
 
        public Edge1(Node1 targetNode, double costVal){
                target = targetNode;
                cost = costVal;
        }
}
public class AStarAlgorithm{
 
 
        //h scores is the stright-line distance from the current city to Bucharest
        public void searchPath(String location)
        {
// System.out.println("-7777777777777777777777777------"+location);
             Node1 n1 = new Node1("home");
             n1.hValues("home",0);
             n1.hValues("7659McCallum",0.2);
             n1.hValues("ValeroCoidRd",0.4);
             n1.hValues("DavenPortRd",1.5);
             n1.hValues("PavillionNorth",1.5);
             n1.hValues("WestCampbell",1.3);
             n1.hValues("2230CoitRoad",1.0);
             n1.hValues("3801BushTurnPike",2.4);
		     n1.hValues("17370PrestonRoad",2.4);
		     n1.hValues("17620PrestonRd",3.1);
		     n1.hValues("7522CampbellRd",5);
		
		 Node1 n2 = new Node1("7659McCallum");
		 n2.hValues("home",0.2);
         n2.hValues("7659McCallum",0);
         n2.hValues("ValeroCoidRd",0.7);
         n2.hValues("DavenPortRd",1.3);
         n2.hValues("PavillionNorth",1.3);
         n2.hValues("WestCampbell",1.5);
         n2.hValues("2230CoitRoad",1.3);
         n2.hValues("3801BushTurnPike",2.7);
	     n2.hValues("17370PrestonRoad",2.3);
	     n2.hValues("17620PrestonRd",2.8);
	     n2.hValues("7522CampbellRd",4.8);
	 
		 Node1 n3 = new Node1("ValeroCoidRd");
		 n3.hValues("home",0.4);
         n3.hValues("7659McCallum",0.7);
         n3.hValues("ValeroCoidRd",0);
         n3.hValues("DavenPortRd",2.1);
         n3.hValues("PavillionNorth",2.1);
         n3.hValues("WestCampbell",0.8);
         n3.hValues("2230CoitRoad",0.5);
         n3.hValues("3801BushTurnPike",1.9);
	     n3.hValues("17370PrestonRoad",3.1);
	     n3.hValues("17620PrestonRd",3.6);
	     n3.hValues("7522CampbellRd",1.2);
	 
		 Node1 n4 = new Node1("DavenPortRd");
		 n4.hValues("home",1.5);
         n4.hValues("7659McCallum",1.3);
         n4.hValues("ValeroCoidRd",2.1);
         n4.hValues("DavenPortRd",0);
         n4.hValues("PavillionNorth",2.6);
         n4.hValues("WestCampbell",2.8);
         n4.hValues("2230CoitRoad",2.7);
         n4.hValues("3801BushTurnPike",4);
	     n4.hValues("17370PrestonRoad",0.9);
	     n4.hValues("17620PrestonRd",1.4);
	     n4.hValues("7522CampbellRd",3.4);
	 
		 Node1 n5 = new Node1("PavillionNorth");
		 n5.hValues("home",1.5);
         n5.hValues("7659McCallum",1.3);
         n5.hValues("ValeroCoidRd",2.1);
         n5.hValues("DavenPortRd",2.6);
         n5.hValues("PavillionNorth",0);
         n5.hValues("WestCampbell",0.9);
         n5.hValues("2230CoitRoad",0.38);
         n5.hValues("3801BushTurnPike",2.8);
	     n5.hValues("17370PrestonRoad",2.7);
	     n5.hValues("17620PrestonRd",2.3);
	     n5.hValues("7522CampbellRd",0.25);
	 
		 Node1 n6 = new Node1("WestCampbell");
		 n6.hValues("home",1.3);
         n6.hValues("7659McCallum",1.5);
         n6.hValues("ValeroCoidRd",0.8);
         n6.hValues("DavenPortRd",2.8);
         n6.hValues("PavillionNorth",0.09);
         n6.hValues("WestCampbell",0);
         n6.hValues("2230CoitRoad",0.25);
         n6.hValues("3801BushTurnPike",2.8);
	     n6.hValues("17370PrestonRoad",2.9);
	     n6.hValues("17620PrestonRd",2.4);
	     n6.hValues("7522CampbellRd",0.35);
	 
	     Node1 n7 = new Node1("2230CoitRoad");
	     n7.hValues("home",1.0);
         n7.hValues("7659McCallum",1.3);
         n7.hValues("ValeroCoidRd",0.5);
         n7.hValues("DavenPortRd",2.7);
         n7.hValues("PavillionNorth",0.38);
         n7.hValues("WestCampbell",0.25);
         n7.hValues("2230CoitRoad",0);
         n7.hValues("3801BushTurnPike",2.6);
	     n7.hValues("17370PrestonRoad",3.2);
	     n7.hValues("17620PrestonRd",2.7);
	     n7.hValues("7522CampbellRd",0.6);
	 
	     Node1 n8 = new Node1("3801BushTurnPike");
	     n8.hValues("home",2.4);
         n8.hValues("7659McCallum",2.7);
         n8.hValues("ValeroCoidRd",1.9);
         n8.hValues("DavenPortRd",4);
         n8.hValues("PavillionNorth",2.8);
         n8.hValues("WestCampbell",2.8);
         n8.hValues("2230CoitRoad",2.6);
         n8.hValues("3801BushTurnPike",0);
	     n8.hValues("17370PrestonRoad",5.1);
	     n8.hValues("17620PrestonRd",5.6);
	     n8.hValues("7522CampbellRd",3.2);
	 
	     Node1 n9 = new Node1("17370PrestonRoad");
	     n9.hValues("home",2.4);
         n9.hValues("7659McCallum",2.3);
         n9.hValues("ValeroCoidRd",3.1);
         n9.hValues("DavenPortRd",0.9);
         n9.hValues("PavillionNorth",2.7);
         n9.hValues("WestCampbell",2.9);
         n9.hValues("2230CoitRoad",3.2);
         n9.hValues("3801BushTurnPike",5.1);
	     n9.hValues("17370PrestonRoad",0);
	     n9.hValues("17620PrestonRd",0.45);
	     n9.hValues("7522CampbellRd",2.5);
	 
	     Node1 n10 = new Node1("17620PrestonRd");
	     n10.hValues("home",3.1);
         n10.hValues("7659McCallum",2.8);
         n10.hValues("ValeroCoidRd",3.6);
         n10.hValues("DavenPortRd",1.4);
         n10.hValues("PavillionNorth",2.3);
         n10.hValues("WestCampbell",2.4);
         n10.hValues("2230CoitRoad",2.7);
         n10.hValues("3801BushTurnPike",5.6);
	     n10.hValues("17370PrestonRoad",0.45);
	     n10.hValues("17620PrestonRd",0);
	     n10.hValues("7522CampbellRd",2);
	 
	     Node1 n11 = new Node1("7522CampbellRd");
	     n11.hValues("home",5);
         n11.hValues("7659McCallum",4.8);
         n11.hValues("ValeroCoidRd",1.2);
         n11.hValues("DavenPortRd",3.4);
         n11.hValues("PavillionNorth",0.25);
         n11.hValues("WestCampbell",0.35);
         n11.hValues("2230CoitRoad",0.6);
         n11.hValues("3801BushTurnPike",3.2);
	     n11.hValues("17370PrestonRoad",2.5);
	     n11.hValues("17620PrestonRd",2);
	     n11.hValues("7522CampbellRd",0);
	
	    
                //initialize the edges
 
      
                n1.adjacencies = new Edge1[]{
                        new Edge1(n2,0.3),
                        new Edge1(n3,0.5),
                       
                };
                 
                
                n2.adjacencies = new Edge1[]{
                        new Edge1(n1,0.3),
                        new Edge1(n4,1.4),
                        new Edge1(n5,1.4)
                };
                 
 
                
                n3.adjacencies = new Edge1[]{
                        new Edge1(n1,0.5),
                        new Edge1(n7,0.6),
                        new Edge1(n8,2)
                };
                 
                 
                n4.adjacencies = new Edge1[]{
                        new Edge1(n2,1.4),
                        new Edge1(n9,1)
                       
                };
                 
 
                 
                n5.adjacencies = new Edge1[]{
                        new Edge1(n2,1.4),
                        new Edge1(n6,0.1),
                        new Edge1(n11,0.3)
                };
                 
                 
                n6.adjacencies = new Edge1[]{
                        new Edge1(n5,0.1),  
                        new Edge1(n7,0.7)
                       
                };
                 
                 
                n7.adjacencies = new Edge1[]{
                        new Edge1(n3,0.6),
                        new Edge1(n6,0.3)
                };
                 
                 
                n8.adjacencies = new Edge1[]{
                        new Edge1(n3,2)
                       
                };
                 
                 
                n9.adjacencies = new Edge1[]{
                        new Edge1(n4,1),
                        new Edge1(n10,0.5)
                        
                };
 
                
                n10.adjacencies = new Edge1[]{
                        new Edge1(n9,0.5),
                        new Edge1(n11,2.1)
                };
                 
               
                n11.adjacencies = new Edge1[]{
                        new Edge1(n5,0.3),
                        new Edge1(n10,2.1)
                };
 
                HashMap<String,Node1> hashLoc = new HashMap();
                hashLoc.put("home",n1);
                hashLoc.put("7659McCallum",n2);
                hashLoc.put("ValeroCoidRd",n3);
                hashLoc.put("DavenPortRd",n4);
                hashLoc.put("PavillionNorth",n5);
                hashLoc.put("WestCampbell",n6);
                hashLoc.put("2230CoitRoad",n7);
                hashLoc.put("3801BushTurnPike",n8);
                hashLoc.put("17370PrestonRoad",n9);
                hashLoc.put("17620PrestonRd",n10);
                hashLoc.put("7522CampbellRd",n11);
                
 
                AstarSearch(n1,hashLoc.get(location));
 
                List<Node1> path = printPath(hashLoc.get(location));
 System.out.println("---------------------------------------------------------------");
                        System.out.println("Path a based on shortest Path Admissible Heuristic and total length to destination is "+hashLoc.get(location).f_scores+" mile");
                        
 System.out.println("---------------------------------------------------------------");

 for(int i=0 ; i < path.size();i++)
 {
  System.out.println(path.get(i).value);
 
 }
 
        }
 
        public static List<Node1> printPath(Node1 target){
                List<Node1> path = new ArrayList<Node1>();
    
        for(Node1 node = target; node!=null; node = node.parent){
            path.add(node);
        }
 
        Collections.reverse(path);
 
        return path;
        }
 
        public static void AstarSearch(Node1 source, Node1 goal){
 
                Set<Node1> explored = new HashSet<Node1>();
 
                PriorityQueue<Node1> queue = new PriorityQueue<Node1>(20, 
                        new Comparator<Node1>(){
                                 //override compare method
                 public int compare(Node1 i, Node1 j){
                    if(i.f_scores > j.f_scores){
                        return 1;
                    }
 
                    else if (i.f_scores < j.f_scores){
                        return -1;
                    }
 
                    else{
                        return 0;
                    }
                 }
 
                        }
                        );
 
                //cost from start
                source.g_scores = 0;
 
                queue.add(source);
 
                boolean found = false;
 
                while((!queue.isEmpty())&&(!found)){
 
                        //the Node1 in having the lowest f_score value
                        Node1 current = queue.poll();
 
                        explored.add(current);
 
                        //goal found
                        if(current.value.equals(goal.value)){
                                found = true;
                        }
 
                        //check every child of current Node1
                        for(Edge1 e : current.adjacencies){
                                Node1 child = e.target;
                                double cost = e.cost;
                                double temp_g_scores = current.g_scores + cost;
                               // double temp_hvalue 
                                double temp_f_scores = temp_g_scores + (double)(child.hm.get(goal.value));
                                
 
 
                                /*if child node has been evaluated and 
                                the newer f_score is higher, skip*/
                                
                                if((explored.contains(child)) && 
                                        (temp_f_scores >= child.f_scores)){
                                        continue;
                                }
 
                                /*else if child node is not in queue or 
                                newer f_score is lower*/
                                
                                else if((!queue.contains(child)) || 
                                        (temp_f_scores < child.f_scores)){
 
                                        child.parent = current;
                                        child.g_scores = temp_g_scores;
                                        child.f_scores = temp_f_scores;
 
                                        if(queue.contains(child)){
                                                queue.remove(child);
                                        }
 
                                        queue.add(child);
                                        
 
                                }
 
                        }
 
                }
 
        }
        
}
 