package graph;

import edge.Edge;
import vertex.Vertex;

public class NetworkTopology extends ConcreteGraph<Vertex,Edge>{
	@Override
	public boolean addEdge(Edge edge) {
		// TODO Auto-generated method stub
		if(edges.contains(edge)||!vertices.contains(edge.end)||!vertices.contains(edge.start)||edge.end.equals(edge.start))
			return false;
		else {
			edges.add(edge);
			for (Edge e : edges) {
				e.weight*=1-edge.weight;
			}
			return true;
		}		
	}
}
