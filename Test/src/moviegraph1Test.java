package src;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edge.MovieActorRelation;
import factory.ActorVertexFactory;
import factory.MovieActorRelationFactory;
import factory.MovieVertexFactory;
import graph.MovieGraph;
import helper.moviegraph1;
import vertex.Actor;
import vertex.Movie;
import vertex.Vertex;

public class moviegraph1Test {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		MovieGraph g = new moviegraph1().createGraph("src\\helper\\file2.txt");
		String[] a1= {"1997","1","8.6"};
		Movie v1 = new MovieVertexFactory().createVertex("Movie20001",a1);
		g.addVertex(v1);
		String[] a2= {"M","81"};
		Actor v2 =new ActorVertexFactory().createVertex("Actor202", a2);		
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		MovieActorRelation edge4=new MovieActorRelationFactory().createEdge("M20001A202",vers);
		edge4.weight=3;
		g.addEdge(edge4);		
		File file2 = new File("src\\helper\\file2.txt"); 
		File new2 = new File("src\\helper\\new2.1.txt");
		byte buffer[]=buffer=new String("Vertex = <\"Movie20001\", \"Movie\", <\"1997\", \"1\", \"8.6\">>\n"+"Vertex = <\"Actor202\", \"Actor\", <\"M\", \"81\">>\n"+"Edge = <\"M20001A202\", \"MovieActorRelation\", \"3\", \"Movie20001\", \"Actor202\", \"No\">\n").getBytes();
		FileOutputStream o=null;
        try {
        	o=new FileOutputStream("src\\helper\\new2.1.txt");
            FileInputStream i=new FileInputStream("src\\helper\\file2.txt");
            while(true){
            	int temp=i.read();
            	if(temp==-1){break;}
            	o.write(temp);
            	}          
            o.write(buffer, 0, buffer.length);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                o.close();
            } catch (IOException ioEx) {
                System.out.println(ioEx.toString());
            }
        }  
		//System.out.println("³É¹¦");
	}

}
