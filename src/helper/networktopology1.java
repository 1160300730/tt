package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edge.NetworkConnection;
import factory.ComputerVertexFactory;
import factory.NetworkConnectionFactory;
import factory.RouterVertexFactory;
import factory.ServerVertexFactory;
import graph.NetworkTopology;
import vertex.Computer;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;

public class networktopology1 implements Strategy {
	@Override
	public NetworkTopology createGraph(String filePath) {
		NetworkTopology g=new NetworkTopology();
		List<String> list = new ArrayList<String>();
		File file = new File(filePath);	
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
			reader.close();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		    	for(int x=0;x<a.length;x++)
				{
					if(x==4)
						a[x]=a[x].replaceAll("<","").replaceAll("\"", "").replaceAll(">","");
					else
					    a[x]=a[x].replaceAll("[\\pP\\p{Punct}]","");
					//System.out.println(a[x]);
				}		    	
				if(a[3].equals("Computer")) {
					String[] a1= {a[4]};
					Computer w=new ComputerVertexFactory().createVertex(a[2],a1);
					g.addVertex(w);
					
				}
				if(a[3].equals("Router")) {
					String[] a1= {a[4]};
					Router w;					
					w = new RouterVertexFactory().createVertex(a[2],a1);
					g.addVertex(w);										
				}
				if(a[3].equals("Server")) {
					String[] a1= {a[4]};
					Server w;
					w = new ServerVertexFactory().createVertex(a[2],a1);
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
				List<Vertex> vers=new ArrayList<Vertex>();				
				Iterator<Vertex> iter = g.vertices.iterator();				
				while (iter.hasNext())
				{
					Vertex it=iter.next();
					if(it.label.equals(a[5]))
					    vers.add(it);					
				}				
				Iterator<Vertex> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Vertex it=iter1.next();
					if(it.label.equals(a[6])&&!a[6].equals(a[5]))
					    vers.add(it);					
				}					
				NetworkConnection edge=new NetworkConnectionFactory().createEdge(a[2],vers);
				//System.out.println(a[4]);
				edge.weight=Double.parseDouble(a[4]);
				g.addEdge(edge);	            	            
			}	
		}			
		return g;	
	}

}
