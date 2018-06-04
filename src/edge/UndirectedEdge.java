package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class UndirectedEdge extends Edge{
     
	UndirectedEdge(String label, double weight) {
		super(label, weight);
		// TODO Auto-generated constructor stub
	}
    //要求vertices.size()=2，无需考虑次序
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		if(vertices.size()==1)
		{
			this.start=vertices.get(0);
			this.end=vertices.get(0);
			return true;
		}
		else if(vertices.size()!=2)
		return false;
		else {
			this.start=vertices.get(0);
			this.end=vertices.get(1);
			return true;
		}
	}

	@Override
	Set<Vertex> sourceVertices() {
		Set<Vertex> s=new HashSet<Vertex>();
		s.add(this.start);
		s.add(this.end);
		return s;
	}

	@Override
	Set<Vertex> targetVertices() {
		Set<Vertex> s=new HashSet<Vertex>();
		s.add(this.end);
		s.add(this.start);
		return s;
	}
    
}
