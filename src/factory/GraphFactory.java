package factory;

import graph.Graph;
import helper.MyException;

public abstract class GraphFactory {
	public abstract Graph createGraph(String filePath) throws MyException ;
}
