package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edge.Edge;
import vertex.Vertex;

public class ConcreteGraph<L extends Vertex, E extends Edge> implements Graph<L,E>
{
	public Set<L> vertices = new HashSet<>();
	public List<E> edges = new ArrayList<>();
	@Override
	public boolean addVertex(L v) {
		if(vertices.contains(v))
		    return false;
		else {
			vertices.add(v);
			return true;
		}		  
	}

	@Override
	public boolean removeVertex(L v) {
		if(!vertices.contains(v))
		    return false;
		else {
			for (E edge : edges) {
    		if (edge.start.equals(v) || edge.end.equals(v)) {    			
    			edge.weight=0;
    			edges.remove(edge);
            }    		
    	}
			vertices.remove(v);
			return true;
		}
	}

	@Override
	public Set<L> vertices() {		
		return vertices;
	}

	@Override
	public Map<L, List<Double>> sources(L target) {
		Map<L, List<Double>> map=new HashMap<L, List<Double>>();		
		for (E edge : edges) {
			if (edge.end.equals(target)) {
				List<Double> l=new ArrayList<Double>();
				for (E e : edges) {
					if(e.end.equals(target)&&e.start.equals(edge.start))					
						l.add(e.weight);					
					
				}	
				map.put((L) edge.start, l);
			}
		}
		return map;	
		
	}

	@Override
	public Map<L, List<Double>> targets(L source) {
		Map<L, List<Double>> map=new HashMap<L, List<Double>>();		
		for (E edge : edges) {
			if (edge.start.equals(source)) {
				List<Double> l=new ArrayList<Double>();
				for (E e : edges) {
					if(e.end.equals(edge.end)&&e.start.equals(source))					
						l.add(e.weight);										
				}	
				map.put((L) edge.end, l);
			}							
		}
		return map;
	}

	@Override
	public boolean addEdge(E edge) {
		// TODO Auto-generated method stub
		if(edges.contains(edge)) {
			
			return false;
		}
			
	    else {
		     edges.add(edge);
		     
		return true;
	}		
	}

	@Override
	public boolean removeEdge(E edge) {
		// TODO Auto-generated method stub
		if(!edges.contains(edge))
			return false;
	else {
		edges.remove(edge);
		return true;
	}	
	}

	@Override
	public Set<E> edges() {
		Set<E> a=new HashSet<E>();
		for(int i=0;i<edges.size();i++)
			a.add(edges.get(i));
		return a;
    
	}	
	@Override
	public String toString() {
		String s="顶点：";
		Iterator<L> iter = vertices.iterator(); 
		while (iter.hasNext()) 
		      s+=iter.next().toString()+" "; 		
		for(int i=0;i<edges.size();i++)
			s+="\n边："+edges.get(i).label+" "+edges.get(i).start+"到"+edges.get(i).end+"权值"+edges.get(i).weight;
		return s;
    
	}	
	}
