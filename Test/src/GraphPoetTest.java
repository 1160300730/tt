package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edge.WordEdge;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.GraphPoet;
import helper.graphpoet;
import helper.graphpoet1;
import helper.graphpoet;
import vertex.Vertex;
import vertex.Word;

public class GraphPoetTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		GraphPoet g = new graphpoet().createGraph("src\\helper\\file4.txt");
		Word v1 =new WordVertexFactory().createVertex("Word1801", null);
		g.addVertex(v1);
		Word v2 =new WordVertexFactory().createVertex("Word1802", null);
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		WordEdge edge4=new WordEdgeFactory().createEdge("W1801W1802",vers);
		g.addEdge(edge4);
		edge4.weight=1.0;
		File file4 = new File("src\\helper\\file4.txt"); 
		File new4 = new File("src\\helper\\new4.txt");
		try {  
		    BufferedReader reader = new BufferedReader(new FileReader(file4));  
		    BufferedWriter writer  = new BufferedWriter(new FileWriter(new4,true)); 
		    String line = reader.readLine();  
		    while(line!=null){  
		        writer.write(line+"\n");  
		        line = reader.readLine();  
		    } 
		    writer.write("Vertex = <\"Word1801\", \"Word\">\n"); 
		    writer.write("Vertex = <\"Word1802\", \"Word\">\n"); 
		    writer.write("Edge = <\"W1801W1802\", \"WordNeighborhood\", \"1\", \"Word1801\", \"Word1802\", \"Yes\">"); 
		    writer.flush();  
		    reader.close();  
		    writer.close();  
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
		System.out.println("³É¹¦");
	}
//	@Test
//	public void test1() {
//		GraphPoet g = new graphpoet1().createGraph("src\\helper\\file4.txt");
//		Word v1 =new WordVertexFactory().createVertex("Word1801", null);
//		g.addVertex(v1);
//		Word v2 =new WordVertexFactory().createVertex("Word1802", null);
//		g.addVertex(v2);
//		List<Vertex> vers=new ArrayList<Vertex>();
//		vers.add(v1);
//		vers.add(v2);
//		WordEdge edge4=new WordEdgeFactory().createEdge("W1801W1802",vers);
//		g.addEdge(edge4);
//		edge4.weight=1.0;
//		File file4 = new File("src\\helper\\file4.txt"); 
//		File new4 = new File("src\\helper\\new4.txt");
//		try {  
//		    BufferedReader reader = new BufferedReader(new FileReader(file4));  
//		    BufferedWriter writer  = new BufferedWriter(new FileWriter(new4,true)); 
//		    String line = reader.readLine();  
//		    while(line!=null){  
//		        writer.write(line+"\n");  
//		        line = reader.readLine();  
//		    } 
//		    writer.write("Vertex = <\"Word1801\", \"Word\">\n"); 
//		    writer.write("Vertex = <\"Word1802\", \"Word\">\n"); 
//		    writer.write("Edge = <\"W1801W1802\", \"WordNeighborhood\", \"1\", \"Word1801\", \"Word1802\", \"Yes\">"); 
//		    writer.flush();  
//		    reader.close();  
//		    writer.close();  
//		} catch (FileNotFoundException e) {  
//		    e.printStackTrace();  
//		} catch (IOException e) {  
//		    e.printStackTrace();  
//		}
		
	
}
