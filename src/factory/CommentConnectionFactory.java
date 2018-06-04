package factory;

import java.util.List;

import edge.CommentConnection;
import vertex.Vertex;

public class CommentConnectionFactory extends EdgeFactory{

	@Override
	public CommentConnection createEdge(String label, List<Vertex> vertices) {
		CommentConnection e=new CommentConnection(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
