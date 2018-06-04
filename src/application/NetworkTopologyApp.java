package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edge.Edge;
import edge.NetworkConnection;
import edge.WordEdge;
import factory.ComputerVertexFactory;
import factory.NetworkConnectionFactory;
import factory.NetworkTopologyFactory;
import factory.RouterVertexFactory;
import factory.ServerVertexFactory;
import graph.NetworkTopology;
import helper.GraphMetrics;
import helper.MyException;
import vertex.Computer;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;
import vertex.Word;

public class NetworkTopologyApp {
	public  void main()  {
		System.out.println("请输入要建立的NetworkTopology的输入文件路径"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		NetworkTopology g = new NetworkTopologyFactory().createGraph(str);
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
		int x= sc.nextInt();
		while(x!=-1) {
			switch (x) {
	        case -1:	            
	            break;
	        case 1:
	        	System.out.println("请输入要添加的顶点的类型、label、IP地址");	
	        	String s11 =sc.next().toLowerCase();
	        	String s12 =sc.next();
	        	String s13 =sc.next();
	        	if(s11.equals("computer")) {
	        		String[] a1= {s13};
	        		Computer w=new ComputerVertexFactory().createVertex(s12,a1);
	        		g.addVertex(w);
	        	}
	        	if(s11.equals("router")) {
	        		String[] a1= {s13};	        		
					Router w=new RouterVertexFactory().createVertex(s12,a1);
					g.addVertex(w);					
	        	}
	        	if(s11.equals("server")) {
	        		String[] a1= {s13};        		
					Server w=new ServerVertexFactory().createVertex(s12,a1);
					g.addVertex(w);					        			
	        	}	        	
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 2:
	        	System.out.println("请输入要删除的顶点的label（string型）");
	        	String s2 =sc.next();
	        	Iterator<Vertex> iter2 = g.vertices.iterator();
				while (iter2.hasNext())
				{
					Vertex it=iter2.next();
					if(it.label.equals(s2))
						g.removeVertex(it);				
				}				
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 3:
	        	System.out.println("请输入要修改的顶点的label（string型）和改后的label");	
	        	String s31 =sc.next();
	        	Iterator<Vertex> iter3 = g.vertices.iterator();
	        	String s32 =sc.next();
				while (iter3.hasNext())
				{
					Vertex it=iter3.next();
					if(it.label.equals(s31))
						it.label=s32;				
				}
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("请依次输入要增加的边的label、起点、终点、权值");
	        	String s41 =sc.next();	        	
	        	String s42 =sc.next();
	        	String s43 =sc.next();
	        	double s44 =sc.nextDouble();
	        	List<Vertex> vers4=new ArrayList<Vertex>();				
				Iterator<Vertex> iter = g.vertices.iterator();			
				while (iter.hasNext())
				{
					Vertex it=iter.next();
					if(it.label.equals(s42))
					    vers4.add(it);					
				}				
				Iterator<Vertex> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Vertex it=iter1.next();
					if(it.label.equals(s43)&&!s43.equals(s42))
					    vers4.add(it);					
				}
				NetworkConnection edge=new NetworkConnectionFactory().createEdge(s41,vers4);
				edge.weight=s44;
				g.addEdge(edge);
	        case 5:
	        	System.out.println("请输入要删除的边的label（string型）");
	        	String s5 =sc.nextLine();
	        	for (Edge edge5 : g.edges) {
		    		if (edge5.label.equals(s5))    			
		    			g.removeEdge(edge5);
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
	        	for (Edge edge6 : g.edges) {
	        		if (edge6.label.equals(s61)) {
		    			edge6.label=s62;
		    			edge6.weight=s63;
		    			edge6.start.label=s64;
		    			edge6.end.label=s65;
		    		}	
		            }
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 7:	        	
	        	System.out.println("请输入顶点的label");	
	        	String s7 =sc.nextLine();
	        	Iterator<Vertex> iter7 = g.vertices.iterator();
	        	while (iter7.hasNext())
				{
					Vertex it=iter7.next();
					if(it.label.equals(s7)) {						
						System.out.println("degreeCentrality   "+GraphMetrics.degreeCentrality(g,it));	
						System.out.println("closenessCentrality   "+GraphMetrics.closenessCentrality(g,it));
						System.out.println("betweennessCentrality   "+GraphMetrics.betweennessCentrality(g,it));						
					}									
				}		        		        	
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
