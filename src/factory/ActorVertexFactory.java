package factory;

import helper.MyException;
import vertex.Actor;

public class ActorVertexFactory extends VertexFactory{

	@Override
	public Actor createVertex(String label, String[] args){	
		Actor a = new Actor(label);		
		a.fillVertexInfo (args);						
		return a;
	}

}
