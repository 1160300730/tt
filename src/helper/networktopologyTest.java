package helper;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edge.FriendConnection;
import edge.NetworkConnection;
import factory.ComputerVertexFactory;
import factory.FriendConnectionFactory;
import factory.NetworkConnectionFactory;
import factory.PersonVertexFactory;
import factory.RouterVertexFactory;
import graph.NetworkTopology;
import graph.SocialNetwork;
import vertex.Computer;
import vertex.Person;
import vertex.Router;
import vertex.Vertex;

public class networktopologyTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		NetworkTopology g = new networktopology().createGraph("src\\helper\\file1.txt");
		String[] a1= {"192.147.1.102"};
		Computer v1=new ComputerVertexFactory().createVertex("Computer1001",a1);
		g.addVertex(v1);
		String[] a2= {"192.147.3.102"};
		Router v2=new RouterVertexFactory().createVertex("Router1001",a1);
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		NetworkConnection edge=new NetworkConnectionFactory().createEdge("C1001R1001",vers);
		edge.weight=100;
		g.addEdge(edge);		
		File file1 = new File("src\\helper\\file1.txt"); 
		File new1 = new File("src\\helper\\new1.txt");
		try {  
		    BufferedReader reader = new BufferedReader(new FileReader(file1));  
		    BufferedWriter writer  = new BufferedWriter(new FileWriter(new1,true)); 
		    String line = reader.readLine();  
		    while(line!=null){  
		        writer.write(line+"\n");  
		        line = reader.readLine();  
		    } 
		    writer.write("Vertex = <\"Computer1001\", \"Computer\", <\"192.147.1.102\">>\n"); 
		    writer.write("Vertex = <\"Router1001\", \"Router\", <\"192.147.3.102\">>\n"); 
		    writer.write("Edge = <\"C1001R1001\", \"NetworkConnection\", \"100\", \"Router259\", \"Router1001\", \"No\">\n"); 
		    writer.flush();  
		    reader.close();  
		    writer.close();  
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
		System.out.println("成功");
	}
	@Test
	public void test1() throws FileNotFoundException {
		NetworkTopology g = new networktopology1().createGraph("src\\helper\\file1.txt");
		String[] a1= {"192.147.1.102"};
		Computer v1=new ComputerVertexFactory().createVertex("Computer1001",a1);
		g.addVertex(v1);
		String[] a2= {"192.147.3.102"};
		Router v2=new RouterVertexFactory().createVertex("Router1001",a1);
		g.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		NetworkConnection edge=new NetworkConnectionFactory().createEdge("C1001R1001",vers);
		edge.weight=100;
		g.addEdge(edge);	
		File new1 = new File("src\\helper\\file1.1.txt"); 	
		File file1 = new File("src\\helper\\file1.txt"); 		
		byte buffer[]=buffer=new String("Vertex = <\"Computer1001\", \"Computer\", <\"192.147.1.102\">>\n"+"Vertex = <\"Router1001\", \"Router\", <\"192.147.3.102\">>\n"+"Edge = <\"C1001R1001\", \"NetworkConnection\", \"100\", \"Router259\", \"Router1001\", \"No\">\n").getBytes();
		FileOutputStream o=null;
        try {
        	o=new FileOutputStream("src\\helper\\new1.1.txt");
            FileInputStream i=new FileInputStream("src\\helper\\file1.txt");
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
		System.out.println("成功");
	}
}
