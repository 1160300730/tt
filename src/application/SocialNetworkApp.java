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
		System.out.println("������Ҫ������SocialNetwork�������ļ�·��"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		SocialNetwork g = new SocialNetworkFactory().createGraph(str);
		System.out.println("��ͼ�ɹ�"); 
		System.out.println("����������Ҫ���еĲ��������"); 
		System.out.println("1:���ӽڵ�"); 
		System.out.println("2:ɾ���ڵ�"); 
		System.out.println("3:�޸Ľڵ����Ϣ"); 
		System.out.println("4:���ӱ�"); 
		System.out.println("5:ɾ����"); 
		System.out.println("6:�޸ıߵ� label��Ȩ�ء�����"); 		
		System.out.println("7:ѡ��ĳһ�ڵ㣬�������������Ķ�"); 
		System.out.println("8:����ͼ degree centrality");
		System.out.println("-1:��������"); 
		int x= sc.nextInt();
		while(x!=-1) {
			switch (x) {
	        case -1:	            
	            break;
	        case 1:
	        	System.out.println("������Ҫ��ӵĶ����label���Ա�M/F��������");	
	        	String s11 =sc.next();
	        	String s12 =sc.next();
	        	String s13 =sc.next();
	        	String[] a1= {s12,s13};
	        	Person v1 =new PersonVertexFactory().createVertex(s11, a1);
				g.addVertex(v1);
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 2:
	        	System.out.println("������Ҫɾ���Ķ����label��string�ͣ�");	
	        	String s2 =sc.next();
	        	Iterator<Vertex> iter2 = g.vertices.iterator();
				while (iter2.hasNext())
				{
					Vertex it=iter2.next();
					if(it.label.equals(s2))
						g.removeVertex(it);				
				}				
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 3:
	        	System.out.println("������Ҫ�޸ĵĶ����label�͸ĺ��label���Ա�M/F��������");	
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
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("����������Ҫ���ӵıߵ����͡�label����㡢�յ㡢Ȩֵ");	
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
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 5:
	        	System.out.println("������Ҫɾ���ıߵ�label��string�ͣ�");	
	        	String s5 =sc.nextLine();	        	
				for (Edge edge : g.edges) {
		    		if (edge.label.equals(s5))    			
		    			g.removeEdge(edge);
		            }
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 6:
	        	System.out.println("����������Ҫ���ĵıߵ�label�͸ĺ�� label��Ȩ�ء���㡢�յ�");	
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
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 7:	        	
	        	System.out.println("�����붥���label");	
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
	        	//System.out.println("�ɹ�");
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
