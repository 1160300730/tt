package src;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edge.MovieActorRelation;
import edge.WordEdge;
import factory.ActorVertexFactory;
import factory.MovieActorRelationFactory;
import factory.MovieVertexFactory;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.GraphPoet;
import graph.MovieGraph;

import helper.moviegraph;
import helper.moviegraph1;
import vertex.Actor;
import vertex.Movie;
import vertex.Vertex;
import vertex.Word;

public class moviegraphTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		MovieGraph g = new moviegraph().createGraph("src\\helper\\file2.txt");
		String[] a1= {"1997","1","8.6"};
		Movie v1 = new MovieVertexFactory().createVertex("Movie20018",a1);
		g.addVertex(v1);
		String[] a2= {"M","81"};
		Actor v2 =new ActorVertexFactory().createVertex("Actor201", a2);		
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		MovieActorRelation edge4=new MovieActorRelationFactory().createEdge("M20018A201",vers);
		edge4.weight=3;
		g.addEdge(edge4);		
		File file2 = new File("src\\helper\\file2.txt"); 
		File new2 = new File("src\\helper\\new2.txt");		       
		try {  
		    BufferedReader reader = new BufferedReader(new FileReader(file2));  
		    BufferedWriter writer  = new BufferedWriter(new FileWriter(new2,true)); 
		    String line = reader.readLine();  
		    while(line!=null){  
		        writer.write(line+"\n");  
		        line = reader.readLine();  
		    } 
		    writer.write("Vertex = <\"Movie20018\", \"Movie\", <\"1997\", \"1\", \"8.6\">>\n"); 
		    writer.write("Vertex = <\"Actor5\", \"Actor\", <\"M\", \"81\">>\n"); 
		    writer.write("Edge = <\"M20018A201\", \"MovieActorRelation\", \"3\", \"Movie20018\", \"Actor201\", \"No\">\n"); 
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
	
}


