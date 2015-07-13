package main;

import java.util.PriorityQueue;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;



class Node2{
 
        public final String value;
        public double g_scores;
       // public final double h_scores;
        public double f_scores;
        public Edge2[] adjacencies;
        public Node2 parent;
        HashMap<String, Double> hm = new HashMap();
       public Node2(String val)
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
 
class Edge2{
        public final double cost;
        public final Node2 target;
 
        public Edge2(Node2 targetNode, double costVal){
                target = targetNode;
                cost = costVal;
        }
}
 
public class AStarAlgorithm2{
 
 
        //h scores is the stright-line distance from the current city to Bucharest
        public void searchPath(String location)
        {
 
             Node2 n1 = new Node2("home");
             n1.hValues("home",0);
             n1.hValues("7659McCallum",3);
             n1.hValues("ValeroCoidRd",2);
             n1.hValues("DavenPortRd",8);
             n1.hValues("PavillionNorth",9);
             n1.hValues("WestCampbell",11);
             n1.hValues("2230CoitRoad",5);
             n1.hValues("3801BushTurnPike",7);
		     n1.hValues("17370PrestonRoad",12);
		     n1.hValues("17620PrestonRd",31);
		     n1.hValues("7522CampbellRd",14);
		
		 Node2 n2 = new Node2("7659McCallum");
		 n2.hValues("home",3);
         n2.hValues("7659McCallum",0);
         n2.hValues("ValeroCoidRd",6);
         n2.hValues("DavenPortRd",4);
         n2.hValues("PavillionNorth",5);
         n2.hValues("WestCampbell",10);
         n2.hValues("2230CoitRoad",9);
         n2.hValues("3801BushTurnPike",11);
	     n2.hValues("17370PrestonRoad",8);
	     n2.hValues("17620PrestonRd",17);
	     n2.hValues("7522CampbellRd",10);
	 
		 Node2 n3 = new Node2("ValeroCoidRd");
		 n3.hValues("home",2);
         n3.hValues("7659McCallum",6);
         n3.hValues("ValeroCoidRd",0);
         n3.hValues("DavenPortRd",11);
         n3.hValues("PavillionNorth",12);
         n3.hValues("WestCampbell",8);
         n3.hValues("2230CoitRoad",2);
         n3.hValues("3801BushTurnPike",4);
	     n3.hValues("17370PrestonRoad",15);
	     n3.hValues("17620PrestonRd",23);
	     n3.hValues("7522CampbellRd",17);
	 
		 Node2 n4 = new Node2("DavenPortRd");
		 n4.hValues("home",8);
         n4.hValues("7659McCallum",4);
         n4.hValues("ValeroCoidRd",11);
         n4.hValues("DavenPortRd",0);
         n4.hValues("PavillionNorth",10);
         n4.hValues("WestCampbell",15);
         n4.hValues("2230CoitRoad",14);
         n4.hValues("3801BushTurnPike",16);
	     n4.hValues("17370PrestonRoad",3);
	     n4.hValues("17620PrestonRd",12);
	     n4.hValues("7522CampbellRd",22);
	 
		 Node2 n5 = new Node2("PavillionNorth");
		 n5.hValues("home",9);
         n5.hValues("7659McCallum",5);
         n5.hValues("ValeroCoidRd",12);
         n5.hValues("DavenPortRd",10);
         n5.hValues("PavillionNorth",0);
         n5.hValues("WestCampbell",4);
         n5.hValues("2230CoitRoad",10);
         n5.hValues("3801BushTurnPike",17);
	     n5.hValues("17370PrestonRoad",14);
	     n5.hValues("17620PrestonRd",14);
	     n5.hValues("7522CampbellRd",4);
	 
		 Node2 n6 = new Node2("WestCampbell");
		 n6.hValues("home",11);
         n6.hValues("7659McCallum",10);
         n6.hValues("ValeroCoidRd",8);
         n6.hValues("DavenPortRd",15);
         n6.hValues("PavillionNorth",4);
         n6.hValues("WestCampbell",0);
         n6.hValues("2230CoitRoad",5);
         n6.hValues("3801BushTurnPike",13);
	     n6.hValues("17370PrestonRoad",19);
	     n6.hValues("17620PrestonRd",19);
	     n6.hValues("7522CampbellRd",9);
	 
	     Node2 n7 = new Node2("2230CoitRoad");
	     n7.hValues("home",5);
         n7.hValues("7659McCallum",9);
         n7.hValues("ValeroCoidRd",2);
         n7.hValues("DavenPortRd",14);
         n7.hValues("PavillionNorth",10);
         n7.hValues("WestCampbell",5);
         n7.hValues("2230CoitRoad",0);
         n7.hValues("3801BushTurnPike",7);
	     n7.hValues("17370PrestonRoad",18);
	     n7.hValues("17620PrestonRd",25);
	     n7.hValues("7522CampbellRd",15);
	 
	     Node2 n8 = new Node2("3801BushTurnPike");
	     n8.hValues("home",7);
         n8.hValues("7659McCallum",11);
         n8.hValues("ValeroCoidRd",4);
         n8.hValues("DavenPortRd",16);
         n8.hValues("PavillionNorth",17);
         n8.hValues("WestCampbell",13);
         n8.hValues("2230CoitRoad",7);
         n8.hValues("3801BushTurnPike",0);
	     n8.hValues("17370PrestonRoad",21);
	     n8.hValues("17620PrestonRd",32);
	     n8.hValues("7522CampbellRd",22);
	 
	     Node2 n9 = new Node2("17370PrestonRoad");
	     n9.hValues("home",12);
         n9.hValues("7659McCallum",8);
         n9.hValues("ValeroCoidRd",15);
         n9.hValues("DavenPortRd",3);
         n9.hValues("PavillionNorth",14);
         n9.hValues("WestCampbell",19);
         n9.hValues("2230CoitRoad",18);
         n9.hValues("3801BushTurnPike",21);
	     n9.hValues("17370PrestonRoad",0);
	     n9.hValues("17620PrestonRd",8);
	     n9.hValues("7522CampbellRd",18);
	 
	     Node2 n10 = new Node2("17620PrestonRd");
	     n10.hValues("home",31);
         n10.hValues("7659McCallum",17);
         n10.hValues("ValeroCoidRd",23);
         n10.hValues("DavenPortRd",12);
         n10.hValues("PavillionNorth",14);
         n10.hValues("WestCampbell",19);
         n10.hValues("2230CoitRoad",25);
         n10.hValues("3801BushTurnPike",32);
	     n10.hValues("17370PrestonRoad",8);
	     n10.hValues("17620PrestonRd",0);
	     n10.hValues("7522CampbellRd",9);
	 
	     Node2 n11 = new Node2("7522CampbellRd");
	     n11.hValues("home",14);
         n11.hValues("7659McCallum",10);
         n11.hValues("ValeroCoidRd",17);
         n11.hValues("DavenPortRd",22);
         n11.hValues("PavillionNorth",4);
         n11.hValues("WestCampbell",9);
         n11.hValues("2230CoitRoad",15);
         n11.hValues("3801BushTurnPike",22);
	     n11.hValues("17370PrestonRoad",18);
	     n11.hValues("17620PrestonRd",9);
	     n11.hValues("7522CampbellRd",0);
	
	
                //initialize the edges
 
                n1.adjacencies = new Edge2[]{
                        new Edge2(n2,4),
                        new Edge2(n3,3),
                       
                };
                 
                n2.adjacencies = new Edge2[]{
                        new Edge2(n1,4),
                        new Edge2(n4,5),
                        new Edge2(n5,6)
                };
                 
 
                n3.adjacencies = new Edge2[]{
                        new Edge2(n1,3),
                        new Edge2(n7,3),
                        new Edge2(n8,5)
                };
                 
               
                n4.adjacencies = new Edge2[]{
                        new Edge2(n2,5),
                        new Edge2(n9,4)
                       
                };
                 
 
               
                n5.adjacencies = new Edge2[]{
                        new Edge2(n2,6),
                        new Edge2(n6,5),
                        new Edge2(n11,5)
                };
                 
             
                n6.adjacencies = new Edge2[]{
                        new Edge2(n5,5),  
                        new Edge2(n7,6)
                       
                };
                 
              
                n7.adjacencies = new Edge2[]{
                        new Edge2(n3,3),
                        new Edge2(n6,6)
                };
                 
            
                n8.adjacencies = new Edge2[]{
                        new Edge2(n3,5)
                       
                };
                 
               
                n9.adjacencies = new Edge2[]{
                        new Edge2(n4,4),
                        new Edge2(n10,9)
                        
                };
 
                
                n10.adjacencies = new Edge2[]{
                        new Edge2(n9,9),
                        new Edge2(n11,10)
                };
                 
               
                n11.adjacencies = new Edge2[]{
                        new Edge2(n5,5),
                        new Edge2(n10,10)
                };
 
                HashMap<String,Node2> hashLoc = new HashMap();
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
 
                List<Node2> path = printPath(hashLoc.get(location));
 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Path according to the Popularity of road(Second Admissible Heuristic),Lesser the value more popular the route");
                        
 System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

 for(int i=0 ; i < path.size();i++)
 {
  System.out.println(path.get(i).value);
 
 }
 
        }
 
        public static List<Node2> printPath(Node2 target){
                List<Node2> path = new ArrayList<Node2>();
    
        for(Node2 node = target; node!=null; node = node.parent){
            path.add(node);
        }
 
        Collections.reverse(path);
 
        return path;
        }
 
        public static void AstarSearch(Node2 source, Node2 goal){
 
                Set<Node2> explored = new HashSet<Node2>();
 
                PriorityQueue<Node2> queue = new PriorityQueue<Node2>(20, 
                        new Comparator<Node2>(){
                                 //override compare method
                 public int compare(Node2 i, Node2 j){
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
 
                        //the Node2 in having the lowest f_score value
                        Node2 current = queue.poll();
 
                        explored.add(current);
 
                        //goal found
                        if(current.value.equals(goal.value)){
                                found = true;
                        }
 
                        //check every child of current Node2
                        for(Edge2 e : current.adjacencies){
                                Node2 child = e.target;
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
 