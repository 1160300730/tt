package factory;

import java.util.List;

import edge.Edge;
import edge.MovieDirectorRelation;
import vertex.Vertex;

public class MovieDirectorRelationFactory extends EdgeFactory{

	@Override
	public MovieDirectorRelation createEdge(String label, List<Vertex> vertices) {
		MovieDirectorRelation e=new MovieDirectorRelation(label, 0);
		e.addVertices(vertices);
		return e;
	}

}
