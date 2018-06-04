package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import edge.Edge;
import vertex.Vertex;

public class SocialNetwork extends ConcreteGraph<Vertex,Edge>{	
	@Override
	public boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		if(edges.contains(edge)||!vertices.contains(edge.end)||!vertices.contains(edge.start)||edge.end.equals(edge.start))
			return false;
		else {			
			for (Edge e : edges) {
				e.weight=e.weight*(1-edge.weight);	
				
			}
			edges.add(edge);
			return true;
		}		
	}
	@Override
	public boolean removeEdge(Edge edge) {
		// TODO Auto-generated method stub
		if(!edges.contains(edge))
			return false; 
		else {
			edges.remove(edge);
			for (Edge e : edges) {
				e.weight/=1-edge.weight;
			}
			return true;
		}	
	}
	@Override
	public boolean removeVertex(Vertex v) {
		if(!vertices.contains(v))
		    return false;
		else {
			for (Edge edge : edges) {
    		if (edge.start.equals(v) || edge.end.equals(v)) {    			
    			edges.remove(edge);
    			for (Edge e : edges) {
    				e.weight/=1-edge.weight;
    			}
            }    		
    	}
			vertices.remove(v);
			
			return true;
		}
	}
	public boolean set(Edge edge,Double weight)
	{
		if(!edges.contains(edge))
		    return false;
		else {
			Double k=edge.weight;
			edge.weight=weight;
			for (Edge e : edges) {
				e.weight*=(1-edge.weight)/(1-k);
			}
			return true; 
		}
	}
}
