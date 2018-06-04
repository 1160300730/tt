package helper;

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

import edge.FriendConnection;
import edge.MovieActorRelation;
import edge.NetworkConnection;
import edge.WordEdge;
import factory.ActorVertexFactory;
import factory.ComputerVertexFactory;
import factory.FriendConnectionFactory;
import factory.MovieActorRelationFactory;
import factory.MovieVertexFactory;
import factory.NetworkConnectionFactory;
import factory.PersonVertexFactory;
import factory.RouterVertexFactory;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.GraphPoet;
import graph.MovieGraph;
import graph.NetworkTopology;
import graph.SocialNetwork;
import vertex.Actor;
import vertex.Computer;
import vertex.Movie;
import vertex.Person;
import vertex.Router;
import vertex.Vertex;
import vertex.Word;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		Context context = new Context(new networktopology());        
		NetworkTopology g0 = context.executeStrategy("src\\helper\\file1.txt");
		String[] a01= {"192.147.1.102"};
		Computer v01=new ComputerVertexFactory().createVertex("Computer1001",a01);
		g0.addVertex(v01);
		String[] a02= {"192.147.3.102"};
		Router v02=new RouterVertexFactory().createVertex("Router1001",a01);
		g0.addVertex(v02);
		List<Vertex> vers0=new ArrayList<Vertex>();
		vers0.add(v01);
		vers0.add(v02);
		NetworkConnection edge=new NetworkConnectionFactory().createEdge("C1001R1001",vers0);
		edge.weight=100;
		g0.addEdge(edge);		
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
		
	    context = new Context(new networktopology1());      
	    NetworkTopology g1 = context.executeStrategy("src\\helper\\file1.txt");
	    
	    context = new Context(new graphpoet());       
	    GraphPoet g3=context.executeStrategy("src\\helper\\file4.txt");
	    Word v1 =new WordVertexFactory().createVertex("Word1801", null);
		g3.addVertex(v1);
		Word v2 =new WordVertexFactory().createVertex("Word1802", null);
		g3.addVertex(v2);
		List<Vertex> vers=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		WordEdge edge3=new WordEdgeFactory().createEdge("W1801W1802",vers);
		g3.addEdge(edge3);
		edge3.weight=1.0;
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
		
		
		context = new Context(new graphpoet1());       
	    GraphPoet g4=context.executeStrategy("src\\helper\\file4.txt");
	    Word v41 =new WordVertexFactory().createVertex("Word1801", null);
	    g4.addVertex(v41);
		Word v42 =new WordVertexFactory().createVertex("Word1802", null);
		g4.addVertex(v2);
		List<Vertex> vers4=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		WordEdge edge4=new WordEdgeFactory().createEdge("W1801W1802",vers);
		g4.addEdge(edge4);
		edge4.weight=1.0;
		File file41 = new File("src\\helper\\file4.txt"); 
		File new41 = new File("src\\helper\\new4.txt");
		byte buffer[]=buffer=new String("Vertex = <\"Word1801\", \"Word\">\n"+"Vertex = <\"Word1802\", \"Word\">\n"+"Edge = <\"W1801W1802\", \"WordNeighborhood\", \"1\", \"Word1801\", \"Word1802\", \"Yes\">").getBytes();
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
		
		context = new Context(new moviegraph());       
		MovieGraph g6=context.executeStrategy("src\\helper\\file2.txt");
		String[] a61= {"1997","1","8.6"};
		Movie v61 = new MovieVertexFactory().createVertex("Movie20018",a61);
		g6.addVertex(v61);
		String[] a62= {"M","81"};
		Actor v62 =new ActorVertexFactory().createVertex("Actor201", a62);		
		g6.addVertex(v62);
		List<Vertex> vers6=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		MovieActorRelation edge6=new MovieActorRelationFactory().createEdge("M20018A201",vers6);
		edge4.weight=3;
		g6.addEdge(edge4);		
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
		
		
		context = new Context(new moviegraph1());       
		MovieGraph g7=context.executeStrategy("src\\helper\\file2.txt");
		String[] a71= {"1997","1","8.6"};
		Movie v71 = new MovieVertexFactory().createVertex("Movie20001",a71);
		g7.addVertex(v71);
		String[] a72= {"M","81"};
		Actor v72 =new ActorVertexFactory().createVertex("Actor202", a72);		
		g7.addVertex(v72);
		List<Vertex> vers7=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		MovieActorRelation edge7=new MovieActorRelationFactory().createEdge("M20001A202",vers7);
		edge7.weight=3;
		g7.addEdge(edge4);		
		File file7 = new File("src\\helper\\file2.txt"); 
		File new7 = new File("src\\helper\\new2.1.txt");
		byte buffer7[]=buffer=new String("Vertex = <\"Movie20001\", \"Movie\", <\"1997\", \"1\", \"8.6\">>\n"+"Vertex = <\"Actor202\", \"Actor\", <\"M\", \"81\">>\n"+"Edge = <\"M20001A202\", \"MovieActorRelation\", \"3\", \"Movie20001\", \"Actor202\", \"No\">\n").getBytes();
		FileOutputStream o7=null;
        try {
        	o=new FileOutputStream("src\\helper\\new2.1.txt");
            FileInputStream i=new FileInputStream("src\\helper\\file2.txt");
            while(true){
            	int temp=i.read();
            	if(temp==-1){break;}
            	o7.write(temp);
            	}          
            o7.write(buffer, 0, buffer.length);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                o7.close();
            } catch (IOException ioEx) {
                System.out.println(ioEx.toString());
            }
        }
        
        context = new Context(new socialnetwork());       
        SocialNetwork g9=context.executeStrategy("src\\helper\\file3.txt");
        String[] a91= {"M", "37"};
		Person v91 =new PersonVertexFactory().createVertex("Person1201", a91);
		g9.addVertex(v1);
		String[] a92= {"M", "40"};
		Person v92 =new PersonVertexFactory().createVertex("Person1202", a92);
		g9.addVertex(v2);
		List<Vertex> vers9=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		FriendConnection edge9=new FriendConnectionFactory().createEdge("P1201P1202",vers9);
		g9.addEdge(edge4);
		edge9.weight=0.3;
		File file9 = new File("src\\helper\\file3.txt"); 
		File new9 = new File("src\\helper\\new3.txt");
		try {  
		    BufferedReader reader = new BufferedReader(new FileReader(file9));  
		    BufferedWriter writer  = new BufferedWriter(new FileWriter(new9,true)); 
		    String line = reader.readLine();  
		    while(line!=null){  
		        writer.write(line+"\n");  
		        line = reader.readLine();  
		    } 
		    writer.write("Vertex = <\"Person1201\", \"Person\", <\"M\", \"37\">>\n"); 
		    writer.write("Vertex = <\"Person1202\", \"Person\", <\"M\", \"40\">>\n"); 
		    writer.write("Edge = <\"P1201P1202FriendTie\", \"FriendTie\", \"0.3\", \"Person1201\", \"Person1202\", \"Yes\">\n"); 
		    writer.flush();  
		    reader.close();  
		    writer.close();  
		} catch (FileNotFoundException e) {  
		    e.printStackTrace();  
		} catch (IOException e) {  
		    e.printStackTrace();  
		}
		
		
		context = new Context(new socialnetwork());       
        SocialNetwork g10=context.executeStrategy("src\\helper\\file3.txt");
        String[] a101= {"M", "37"};
		Person v101 =new PersonVertexFactory().createVertex("Person1201", a101);
		g9.addVertex(v1);
		String[] a102= {"M", "40"};
		Person v102 =new PersonVertexFactory().createVertex("Person1202", a102);
		g9.addVertex(v2);
		List<Vertex> vers10=new ArrayList<Vertex>();
		vers.add(v1);
		vers.add(v2);
		FriendConnection edge10=new FriendConnectionFactory().createEdge("P1201P1202",vers10);
		g9.addEdge(edge4);
		edge9.weight=0.3;
		File file10 = new File("src\\helper\\file3.txt"); 
		File new10 = new File("src\\helper\\new3.txt");
		byte buffer10[]=buffer=new String("Vertex = <\"Person1201\", \"Person\", <\"M\", \"37\">>\n"+"Vertex = <\"Person1202\", \"Person\", <\"M\", \"40\">>\n"+"Edge = <\"P1201P1202FriendTie\", \"FriendTie\", \"0.3\", \"Person1201\", \"Person1202\", \"Yes\">\n").getBytes();
		FileOutputStream o10=null;
        try {
        	o10=new FileOutputStream("src\\helper\\new3.1.txt");
            FileInputStream i=new FileInputStream("src\\helper\\file3.txt");
            while(true){
            	int temp=i.read();
            	if(temp==-1){break;}
            	o10.write(temp);
            	}          
            o10.write(buffer, 0, buffer.length);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }finally{
            try {
                o.close();
            } catch (IOException ioEx) {
                System.out.println(ioEx.toString());
            }
        }
		
	}

}
