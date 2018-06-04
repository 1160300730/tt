package factory;

import java.util.List;

import edge.FriendConnection;
import vertex.Vertex;

public class FriendConnectionFactory extends EdgeFactory{

	@Override
	public FriendConnection createEdge(String label, List<Vertex> vertices) {
		FriendConnection e=new FriendConnection(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
