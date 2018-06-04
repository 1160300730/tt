package factory;

import java.util.List;

import edge.Edge;
import edge.WordEdge;
import vertex.Vertex;

public class WordEdgeFactory extends EdgeFactory{

	@Override
	public WordEdge createEdge(String label, List<Vertex> vertices) {
		WordEdge e=new WordEdge(label, 1);		
		e.addVertices(vertices);
		return e;
	}

}
