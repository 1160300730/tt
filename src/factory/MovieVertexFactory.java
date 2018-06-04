package factory;

import helper.MyException;
import vertex.Movie;
import vertex.Person;
import vertex.Vertex;

public class MovieVertexFactory extends VertexFactory{

	@Override
	public Movie createVertex(String label, String[] args){
		Movie a = new Movie(label);
		a.fillVertexInfo (args);
	    return a;
	}

}
