package factory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edge.CommentConnection;
import edge.ForwardConnection;
import edge.FriendConnection;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.SameMovieHyperEdge;
import graph.Graph;
import graph.MovieGraph;
import graph.SocialNetwork;
import helper.MyException;
import vertex.Actor;
import vertex.Director;
import vertex.Movie;
import vertex.Person;
import vertex.Vertex;

public class MovieGraphFactory extends GraphFactory{

	//读入文件并根据文件中的信息建造一个新的MovieGraph
    //MovieGraph中的顶点有Movie，Actor，Director三种，在判断的时候要对顶点类型进行判断
	//边是有MovieActorRelation，MovieDirectorRelation，SameMovieHyperEdge3种，也需要分情况进行处理
	@Override
	public MovieGraph createGraph(String filePath){
		MovieGraph g=new MovieGraph();
		List<String> list = new ArrayList<String>(); 
		try {		   
		   InputStream fis = new FileInputStream(filePath);
		   BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		   String line = null;
		   line = reader.readLine(); 
		   while (line != null) { 
			   list.add(line); 
			   list.add("\n"); 
		    line = reader.readLine(); 
		   }
		   System.out.println(list); 
		   fis.close();
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
			
			e.printStackTrace();
		}
		String v = "Vertex =";
		String e = "Edge =";
		Pattern pattern;
	    Matcher matcher;
	    Pattern pattern1;
	    Matcher matcher1;
		for(int i=0;i<list.size();i++) {
			String demo = list.get(i);
			pattern = Pattern.compile(v);			
		    matcher = pattern.matcher(demo);		    
			if(matcher.lookingAt()){
				String[] a = demo.split(" ");
				if(!a[3].equals("Movie")&&!a[3].equals("Actor")&&a[3].equals("Director")) {
					try {
						throw new MyException("顶点类型错误");
					} catch (MyException e1) {
						// TODO Auto-generated catch block
						System.out.println("请重新选择文件"); 							
						e1.printStackTrace();
						System.exit(0);
					}
				}
				if(a[3].equals("Movie")) {
					for(int x=0;x<a.length;x++)
					{
						if(x==6)
							a[x]=a[x].replaceAll("\"","").replaceAll(",", "");
						else
						    a[x]=a[x].replaceAll("[\\pP\\p{Punct}]","");
						
					}
					
					String[] a1= {a[4],a[5],a[6]};
					Movie w;
					
						w = new MovieVertexFactory().createVertex(a[2],a1);
						g.addVertex(w);
					
					
				}
				if(a[3].equals("Actor")) {
					for(int x=0;x<a.length;x++)																
						a[x]=a[x].replaceAll("[\\pP\\p{Punct}]","");											
					String[] a1= {a[4],a[5]};
					Actor w=new ActorVertexFactory().createVertex(a[2],a1);
					g.addVertex(w);
				}
				if(a[3].equals("Director")) {
					for(int x=0;x<a.length;x++)																
						a[x]=a[x].replaceAll("[\\pP\\p{Punct}]","");
					String[] a1= {a[4],a[5]};
					Director w;
					
						w = new DirectorVertexFactory().createVertex(a[2],a1);
						g.addVertex(w);
					
					
				}					        			
			}					
		}
		for(int i=0;i<list.size();i++) {
			String demo = list.get(i);
			pattern1 = Pattern.compile(e);
			matcher1 = pattern1.matcher(demo);
			if(matcher1.lookingAt()){
				String[] a = demo.replaceAll("[\\pP\\p{Punct}]","").split(" ");		
				if((!a[3].equals("MovieActorRelation")&&!a[4].equals("MovieDirectorRelation")&&!a[4].equals("SameMovieHyperEdge"))||!a[7].equals("Yes")) {
					try {
						throw new MyException("边信息错误");
					} catch (MyException e1) {
						// TODO Auto-generated catch block
						System.out.println("请重新选择文件"); 							
						e1.printStackTrace();
						System.exit(0);
					}
				}
				List<Vertex> vers=new ArrayList<Vertex>();				
				Iterator<Vertex> iter = g.vertices.iterator();
				//System.out.println("1"); 
				while (iter.hasNext())
				{
					Vertex it=iter.next();
					if(it.label.equals(a[5]))
					    vers.add(it);					
				}
				if(vers.size()!=1)
				{
					try {
						throw new MyException("顶点不存在");
					} catch (MyException e1) {
						// TODO Auto-generated catch block
						System.out.println("请重新选择文件"); 							
						e1.printStackTrace();
						System.exit(0);
					}
				}
				Iterator<Vertex> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Vertex it=iter1.next();
					if(it.label.equals(a[6])&&!a[6].equals(a[5]))
					    vers.add(it);					
				}	
				if(a[3].equals("MovieActorRelation")) {
					MovieActorRelation edge=new MovieActorRelationFactory().createEdge(a[2],vers);
					edge.weight=Double.parseDouble(a[4]);
					g.addEdge(edge);	            
		            
				}
				if(a[3].equals("MovieDirectorRelation")) {
					MovieDirectorRelation edge=new MovieDirectorRelationFactory().createEdge(a[2],vers);
					edge.weight=Double.parseDouble(a[4]);
					g.addEdge(edge);	            
		            
				}
				if(a[3].equals("SameMovieHyperEdge")) {
					SameMovieHyperEdge edge=new SameMovieHyperEdgeFactory().createEdge(a[2],vers);
					edge.weight=Double.parseDouble(a[4]);
					g.addEdge(edge);	            
		            
				}
			}	
		}
			
		return g;
	}

}
