package helper;

import graph.Graph;

public interface Strategy {
	   public <L extends Graph> L createGraph(String filePath);
	}