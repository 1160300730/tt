package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class DirectedEdge extends Edge{

	DirectedEdge(String label, double weight) {
		super(label, weight);
		// TODO Auto-generated constructor stub
	}
    //要求vertices.size()=2|1，该操作将vertices中的第一个元素作为 source，将第二个元素作为 target,或形成一条loop
	@Override
	public boolean addVertices(List<Vertex> vertices) {				
		if(vertices.size()>2)
		    return false;
		else if(vertices.size()==1)
		{
			//this.vertices=vertices;
			try{
				this.vertices.contains(vertices.get(0));
				this.start=vertices.get(0);
				this.end=vertices.get(0);				
				return true;
				}catch(Exception e){
					System.out.println("顶点不存在"); 
					throw e;
				}			
		}
		else {
			try{
				this.vertices.contains(vertices.get(0));
				this.vertices.contains(vertices.get(1));
				this.start=vertices.get(0);
				this.end=vertices.get(1);
				return true;
				}catch(Exception e){
					System.out.println("顶点不存在"); 
					throw e;
				}
			
		}
	}

	@Override
	Set<Vertex> sourceVertices() {
		Set<Vertex> s=new HashSet<Vertex>();
		s.add(this.start);
		return s;
	}

	@Override
	Set<Vertex> targetVertices() {
		Set<Vertex> s=new HashSet<Vertex>();
		s.add(this.end);
		return s;
	}
    
}
