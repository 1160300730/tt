package factory;

import helper.MyException;
import vertex.Movie;
import vertex.Server;
import vertex.Vertex;

public class ServerVertexFactory extends VertexFactory{

	@Override
	public Server createVertex(String label, String[] args){
		Server a = new Server(label);
		a.fillVertexInfo (args);
	    return a;
	}

}
