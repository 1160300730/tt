package factory;

import java.util.List;

import edge.Edge;
import edge.NetworkConnection;
import vertex.Vertex;

public class NetworkConnectionFactory extends EdgeFactory{

	@Override
	public NetworkConnection createEdge(String label, List<Vertex> vertices) {
		NetworkConnection e=new NetworkConnection(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
