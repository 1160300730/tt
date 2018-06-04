/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import edge.Edge;
import edge.WordEdge;
import graph.Graph;
import vertex.Vertex;
import vertex.Word;


public class GraphPoet extends ConcreteGraph<Word,WordEdge>{
	
	@Override
	public boolean addEdge(WordEdge edge) {
		// TODO Auto-generated method stub
		if(edges.contains(edge)||!vertices.contains(edge.end)||!vertices.contains(edge.start))
			return false;
		else {
			edges.add(edge);
			return true;
		}		
	}
}
