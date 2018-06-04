package factory;

import java.util.List;

import edge.ForwardConnection;
import vertex.Vertex;

public class ForwardConnectionFactory extends EdgeFactory{

	@Override
	public ForwardConnection createEdge(String label, List<Vertex> vertices) {
		ForwardConnection e=new ForwardConnection(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
