package factory;

import helper.MyException;
import vertex.Director;

public class DirectorVertexFactory extends VertexFactory{

	@Override
	public Director createVertex(String label, String[] args) {
		Director a = new Director(label);
		a.fillVertexInfo (args);
	    return a;
	}

}
