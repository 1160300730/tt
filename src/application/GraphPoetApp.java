package application;
//src/helper/file8.txt
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edge.WordEdge;
import factory.GraphPoetFactory;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.Graph;
import graph.GraphPoet;
import helper.GraphMetrics;
import helper.graphpoet;
import vertex.Vertex;
import vertex.Word;

public class GraphPoetApp {
	public static void main(String[] args){
		System.out.println("请输入要建立的graphpoet的输入文件路径"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		GraphPoet g = new GraphPoetFactory().createGraph(str);
		System.out.println("建图成功"); 
		System.out.println("请输入您想要进行的操作的序号"); 
		System.out.println("1:增加节点"); 
		System.out.println("2:删除节点"); 
		System.out.println("3:修改节点的信息"); 
		System.out.println("4:增加边"); 
		System.out.println("5:删除边"); 
		System.out.println("6:修改边的 label、权重、方向"); 		
		System.out.println("7:选定某一节点，计算其三种中心度"); 
		System.out.println("8:计算图 degree centrality"); 
		System.out.println("-1:结束操作"); 
		int x= sc.nextInt();
		while(x!=-1) {
			switch (x) {
	        case -1:	            
	            break;
	        case 1:
	        	System.out.println("请输入要添加的顶点的label（string型）");	
	        	String s1 =sc.next();
	        	Word v1 =new WordVertexFactory().createVertex(s1, null);
				g.addVertex(v1);
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 2:
	        	System.out.println("请输入要删除的顶点的label（string型）");	
	        	String s2 =sc.next();
	        	Iterator<Word> iter2 = g.vertices.iterator();
				while (iter2.hasNext())
				{
					Word it=iter2.next();
					if(it.label.equals(s2))
						g.removeVertex(it);				
				}				
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 3:
	        	System.out.println("请输入要修改的顶点的label（string型）和改后的label");	
	        	String s31 =sc.next();
	        	Iterator<Word> iter3 = g.vertices.iterator();
	        	String s32 =sc.next();
				while (iter3.hasNext())
				{
					Word it=iter3.next();
					if(it.label.equals(s31))
						it.label=s32;				
				}
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("请依次输入要增加的边的label、起点、终点、权值");	
	        	String s41 =sc.next();
	        	List<Vertex> vers=new ArrayList<Vertex>();
	        	String s42 =sc.next();
	        	String s43 =sc.next();
	        	double s44 =sc.nextDouble();
	        	Word v42 =new WordVertexFactory().createVertex(s42, null);
	        	vers.add(v42);
				Word v43 =new WordVertexFactory().createVertex(s43, null);
				vers.add(v43);
	        	WordEdge edge4=new WordEdgeFactory().createEdge(s43,vers);
				g.addEdge(edge4);
				
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 5:
	        	System.out.println("请输入要删除的边的label（string型）");	
	        	String s5 =sc.nextLine();	        	
				for (WordEdge edge : g.edges) {
		    		if (edge.label.equals(s5))    			
		    			g.removeEdge(edge);
		            }
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 6:
	        	System.out.println("请依次输入要更改的边的label和改后的 label、权重、起点、终点");	
	        	String s61 =sc.next();
	        	String s62 =sc.next();
	        	double s63 =sc.nextDouble();
	        	String s64 =sc.next();
	        	String s65 =sc.next();	        	
	        	for (WordEdge edge : g.edges) {
		    		if (edge.label.equals(s61)) {
		    			edge.label=s62;
		    			edge.weight=s63;
		    			edge.start.label=s64;
		    			edge.end.label=s65;
		    		}		    			
		            }
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 7:	        	
	        	System.out.println("请输入顶点的label");	
	        	String s7 =sc.nextLine();
	        	Iterator<Word> iter7 = g.vertices.iterator();
				while (iter7.hasNext())
				{
					Word it=iter7.next();
					if(it.label.equals(s7)) {						
						System.out.println("degreeCentrality   "+GraphMetrics.degreeCentrality(g,it));	
						System.out.println("closenessCentrality   "+GraphMetrics.closenessCentrality(g,it));
						System.out.println("betweennessCentrality   "+GraphMetrics.betweennessCentrality(g,it));
						System.out.println("inDegreeCentrality   "+GraphMetrics.inDegreeCentrality(g,it));
						System.out.println("outDegreeCentrality   "+GraphMetrics.outDegreeCentrality(g,it));					
					}
									
				}		        	
	        	//System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 8:
	        	//System.out.println("");	
	        	System.out.println("degreeCentrality   "+GraphMetrics.degreeCentrality(g));	
	        	x= sc.nextInt();
	            break;	        
	            
	        }
		}
		
	}
	
}
//C:\Users\lenovo\Desktop\1.txt1 4 8.0 to seek