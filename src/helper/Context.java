package helper;

import graph.Graph;

public class Context {
	private Strategy strategy;
    public Context(Strategy strategy){
       this.strategy = strategy;
    }

    public <L extends Graph> L executeStrategy(String filePath){
       return strategy.createGraph(filePath);
    }
}
