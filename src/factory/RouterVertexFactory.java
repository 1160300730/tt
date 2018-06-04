package factory;

import helper.MyException;
import vertex.Movie;
import vertex.Router;
import vertex.Vertex;

public class RouterVertexFactory extends VertexFactory{

	@Override
	public Router createVertex(String label, String[] args){
		Router a = new Router(label);
		a.fillVertexInfo (args);
	    return a;
	}

}
