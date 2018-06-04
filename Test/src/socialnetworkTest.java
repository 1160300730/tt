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
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edge.FriendConnection;
import edge.WordEdge;
import factory.FriendConnectionFactory;
import factory.PersonVertexFactory;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.GraphPoet;
import graph.SocialNetwork;
import helper.socialnetwork;
import vertex.Person;
import vertex.Vertex;
import vertex.Word;

public class socialnetworkTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SocialNetwork g = new socialnetwork().createGraph("src\\helper\\file3.txt");
		String[] a1= {"M", "37"};
		Person v1 =new PersonVertexFactory().createVertex("Person1201", a1);
		g.addVertex(v1);
		String[] a2= {"M", "40"};
		Person v2 =new PersonVertexFactory().createVertex("Person1202", a2);
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		FriendConnection edge4=new FriendConnectionFactory().createEdge("P1201P1202",vers);
		g.addEdge(edge4);
		edge4.weight=0.3;
		File file10 = new File("src\\helper\\file3.txt"); 
		File new10 = new File("src\\helper\\new3.txt");		
		byte buffer10[]=buffer10=new String("Vertex = <\"Person1201\", \"Person\", <\"M\", \"37\">>\n"+"Vertex = <\"Person1202\", \"Person\", <\"M\", \"40\">>\n"+"Edge = <\"P1201P1202FriendTie\", \"FriendTie\", \"0.3\", \"Person1201\", \"Person1202\", \"Yes\">\n").getBytes();
		FileOutputStream o10=null;
        try {
        	o10=new FileOutputStream("src\\helper\\new3.1.txt");
            FileInputStream i=new FileInputStream("src\\helper\\file3.txt");
            while(true){
            	int temp=i.read();
            	if(temp==-1){break;}
            	o10.write(temp);
            	}          
            o10.write(buffer10, 0, buffer10.length);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                o10.close();
            } catch (IOException ioEx) {
                System.out.println(ioEx.toString());
            }
        }
		System.out.println("³É¹¦");
	}	
}
