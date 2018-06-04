package edge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public class HyperEdge extends Edge{
	Set<Vertex> s=new HashSet<Vertex>();
	HyperEdge(String label, double weight) {
		super(label, weight);
		this.s=s;
		// TODO Auto-generated constructor stub
	}
    //要求vertices.size()>=2，该函数添加 vertices 中的所有 节点到该超边
	@Override
	public boolean addVertices(List<Vertex> vertices) {
		if(vertices.size()<2)
		return false;
		else {
			for(int i=0;i<vertices.size();i++)
			{
				this.s.add(vertices.get(i));
			}
			return true;
		}
	}

	@Override
	Set<Vertex> sourceVertices() {		
		return s;
	}

	@Override
	Set<Vertex> targetVertices() {		
		return s;
	}
    
}
