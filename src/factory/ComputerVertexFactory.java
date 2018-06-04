package factory;

import helper.MyException;
import vertex.Computer;

public class ComputerVertexFactory extends VertexFactory{

	@Override
	public Computer createVertex(String label, String[] args){
		Computer a = new Computer(label);		
		a.fillVertexInfo (args);		
	    return a;
	}

}
