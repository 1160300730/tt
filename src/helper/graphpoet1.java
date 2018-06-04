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

import edge.Edge;
import edge.WordEdge;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.Graph;
import graph.GraphPoet;
import vertex.Vertex;
import vertex.Word;

public class graphpoet1 implements Strategy{

	@Override
	public GraphPoet createGraph(String filePath) {
		GraphPoet g=new GraphPoet();
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
				String[] a = demo.replaceAll("[\\pP\\p{Punct}]","").split(" ");							
				Word w=new WordVertexFactory().createVertex(a[2], null);
		        g.addVertex(w);		        			
			}					
		}
		for(int i=0;i<list.size();i++) {
			String demo = list.get(i);
			pattern1 = Pattern.compile(e);
			matcher1 = pattern1.matcher(demo);
			if(matcher1.lookingAt()){
				String[] a = demo.replaceAll("[\\pP\\p{Punct}]","").split(" ");				
				List<Vertex> vers=new ArrayList<Vertex>();
				Iterator<Word> iter = g.vertices.iterator();
				while (iter.hasNext())
				{
					Word it=iter.next();
					if(it.label.equals(a[5]))
					    vers.add(it);					
				}				
				Iterator<Word> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Word it=iter1.next();
					if(it.label.equals(a[6])&&!a[6].equals(a[5]))
					    vers.add(it);					
				}				
				WordEdge edge=new WordEdgeFactory().createEdge(a[2],vers);
				int f=0;
				for (Edge es : g.edges) {
	            	if(es.end.equals(edge.end)&&es.start.equals(edge.start))
	            		f=1;
	            }
				if(f!=1) {
				    g.addEdge(edge);				
	                edge.weight=1.0;
	                }	            				
			}	
		}
		//System.out.println(g.toString()); 	
		return g;
	}

}
