package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import edge.WordEdge;
import factory.CommentConnectionFactory;
import factory.ForwardConnectionFactory;
import factory.FriendConnectionFactory;
import factory.PersonVertexFactory;
import factory.SocialNetworkFactory;
import factory.WordEdgeFactory;
import factory.WordVertexFactory;
import graph.SocialNetwork;
import helper.GraphMetrics;
import helper.MyException;
import vertex.Person;
import vertex.Vertex;
import vertex.Word;

public class SocialNetworkApp {
	public  void main() throws MyException {
		System.out.println("请输入要建立的SocialNetwork的输入文件路径"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		SocialNetwork g = new SocialNetworkFactory().createGraph(str);
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
	        	System.out.println("请输入要添加的顶点的label、性别（M/F）、年龄");	
	        	String s11 =sc.next();
	        	String s12 =sc.next();
	        	String s13 =sc.next();
	        	String[] a1= {s12,s13};
	        	Person v1 =new PersonVertexFactory().createVertex(s11, a1);
				g.addVertex(v1);
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
	        	System.out.println("请输入要修改的顶点的label和改后的label、性别（M/F）、年龄");	
	        	String s31 =sc.next();
	        	Iterator<Vertex> iter3 = g.vertices.iterator();
	        	String s32 =sc.next();
	        	String s33 =sc.next();
	        	String s34 =sc.next();
				while (iter3.hasNext())
				{
					Vertex it=iter3.next();
					if(it.label.equals(s31)) {
						it.label=s32;
						String[] a3= {s33,s34};
						it.fillVertexInfo(a3);
					}
				}
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("请依次输入要增加的边的类型、label、起点、终点、权值");	
	        	String s41 =sc.next();
	        	List<Vertex> vers=new ArrayList<Vertex>();
	        	String s42 =sc.next();
	        	String s43 =sc.next();
	        	String s44 =sc.next();
	        	double s45 =sc.nextDouble();
	        	List<Vertex> vers4=new ArrayList<Vertex>();				
				Iterator<Vertex> iter = g.vertices.iterator();				
				while (iter.hasNext())
				{
					Vertex it=iter.next();
					if(it.label.equals(s43))
					    vers4.add(it);					
				}				
				Iterator<Vertex> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Vertex it=iter1.next();
					if(it.label.equals(s44)&&!s44.equals(s43))
					    vers4.add(it);					
				}	
	        	if(s41.equals("FriendConnection")) {
					FriendConnection edge=new FriendConnectionFactory().createEdge(s42,vers);
					edge.weight=s45;					
					g.addEdge(edge);	            
		            
				}
				if(s41.equals("CommentConnection")) {
					CommentConnection edge=new CommentConnectionFactory().createEdge(s42,vers);
					edge.weight=s45;
					g.addEdge(edge);	            		            
				}
				if(s41.equals("ForwardConnection")) {
					ForwardConnection edge=new ForwardConnectionFactory().createEdge(s42,vers);
					edge.weight=s45;
					g.addEdge(edge);	            		            
				}
	        	System.out.println("成功");
	        	x= sc.nextInt();
	            break;
	        case 5:
	        	System.out.println("请输入要删除的边的label（string型）");	
	        	String s5 =sc.nextLine();	        	
				for (Edge edge : g.edges) {
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
	        	for (Edge edge : g.edges) {
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
	        	Iterator<Vertex> iter7 = g.vertices.iterator();
				while (iter7.hasNext())
				{
					Vertex it=iter7.next();
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
