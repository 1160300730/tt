package factory;

import helper.MyException;
import vertex.Person;
import vertex.Vertex;
import vertex.Word;

public class PersonVertexFactory extends VertexFactory{

	@Override
	public Person createVertex(String label, String[] args){
		Person a = new Person(label);
		a.fillVertexInfo (args);
	    return a;
	}

}
