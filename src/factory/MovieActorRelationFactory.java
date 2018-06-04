package factory;

import java.util.List;

import edge.Edge;
import edge.MovieActorRelation;
import vertex.Vertex;

public class MovieActorRelationFactory extends EdgeFactory{

	@Override
	public MovieActorRelation createEdge(String label, List<Vertex> vertices) {
		MovieActorRelation e=new MovieActorRelation(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
