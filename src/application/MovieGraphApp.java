package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.SameMovieHyperEdge;
import factory.ActorVertexFactory;
import factory.DirectorVertexFactory;
import factory.GraphPoetFactory;
import factory.MovieActorRelationFactory;
import factory.MovieDirectorRelationFactory;
import factory.MovieGraphFactory;
import factory.MovieVertexFactory;
import factory.SameMovieHyperEdgeFactory;
import graph.GraphPoet;
import graph.MovieGraph;
import helper.GraphMetrics;
import helper.MyException;
import vertex.Actor;
import vertex.Director;
import vertex.Movie;
import vertex.Vertex;

public class MovieGraphApp {
	public  void main() {
		System.out.println("������Ҫ������graphpoet�������ļ�·��"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		MovieGraph g = new MovieGraphFactory().createGraph(str);
		System.out.println("��ͼ�ɹ�"); 
		System.out.println("����������Ҫ���еĲ��������"); 
		System.out.println("1:���ӽڵ�"); 
		System.out.println("2:ɾ���ڵ�"); 
		System.out.println("3:�޸Ľڵ����Ϣ"); 
		System.out.println("4:���ӱ�"); 
		System.out.println("5:ɾ����"); 
		System.out.println("6:�޸ıߵ� label��Ȩ�ء�����"); 
		System.out.println("7:�򳬱������ӽڵ�"); 
		System.out.println("8:�ӳ�����ȥ���ڵ�");
		System.out.println("9:ѡ��ĳһ�ڵ㣬�������������Ķȡ�eccentricity"); 
		System.out.println("10:����ͼ degree centrality��radius �� diameter"); 
		System.out.println("11:ѡ�������ڵ㣬��������֮��� distance"); 
		System.out.println("-1:��������"); 
		int x= sc.nextInt();
		while(x!=-1) {
			switch (x) {
	        case -1:	            
	            break;
	        case 1:
	        	System.out.println("������Ҫ��ӵĶ����label������");	
	        	String s1 =sc.next();
	        	if(s1.equals("Movie")) {
	        		String s12 =sc.next();
	        		String s13 =sc.next();
	        		String s14 =sc.next();
	        		String[] a1= {s12,s13,s14};
	        		Movie w;					
					w = new MovieVertexFactory().createVertex(s1,a1);
					g.addVertex(w);					
	        	}
	        	if(s1.equals("Actor")) {
	        		String s12 =sc.next();
	        		String s13 =sc.next();	        		
	        		String[] a1= {s12,s13};
	        		Actor w=new ActorVertexFactory().createVertex(s1,a1);
					g.addVertex(w);
					}
	        	if(s1.equals("Director")) {
	        		String s12 =sc.next();
	        		String s13 =sc.next();	        		
	        		String[] a1= {s12,s13};
	        		Director w;
					w = new DirectorVertexFactory().createVertex(s1,a1);
					g.addVertex(w);										
	        	}
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
	        	System.out.println("������Ҫ�޸ĵĶ����label��string�ͣ��͸ĺ��label");	
	        	String s31 =sc.next();
	        	Iterator<Vertex> iter3 = g.vertices.iterator();
	        	String s32 =sc.next();
				while (iter3.hasNext())
				{
					Vertex it=iter3.next();
					if(it.label.equals(s31))
						it.label=s32;				
				}
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("����������Ҫ���ӵıߵ�label����㡢�յ㡢�����͡�Ȩֵ");
	        	String s41 =sc.next();	        	
	        	String s42 =sc.next();
	        	String s43 =sc.next();
	        	String s44 =sc.next();
	        	double s45 =sc.nextDouble();
	        	List<Vertex> vers=new ArrayList<Vertex>();				
				Iterator<Vertex> iter = g.vertices.iterator();
				//System.out.println("1"); 
				while (iter.hasNext())
				{
					Vertex it=iter.next();
					if(it.label.equals(s42))
					    vers.add(it);					
				}				
				Iterator<Vertex> iter1 = g.vertices.iterator();
				while (iter1.hasNext())
				{
					Vertex it=iter1.next();
					if(it.label.equals(s43)&&!s43.equals(s42))
					    vers.add(it);					
				}	
				if(s44.equals("MovieActorRelation")) {
					MovieActorRelation edge=new MovieActorRelationFactory().createEdge(s41,vers);
					edge.weight=s45;
					g.addEdge(edge);	            
		            
				}
				if(s44.equals("MovieDirectorRelation")) {
					MovieDirectorRelation edge=new MovieDirectorRelationFactory().createEdge(s41,vers);
					edge.weight=s45;
					g.addEdge(edge);	            
		            
				}
				if(s44.equals("SameMovieHyperEdge")) {
					SameMovieHyperEdge edge=new SameMovieHyperEdgeFactory().createEdge(s41,vers);
					edge.weight=-1;
					g.addEdge(edge);	            
		            
				}
	        case 5:
	        	System.out.println("������Ҫɾ���ıߵ�label��string�ͣ�");
	        	String s5 =sc.nextLine();
	        	for (Edge edge5 : g.edges) {
		    		if (edge5.label.equals(s5))    			
		    			g.removeEdge(edge5);
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
	        	for (Edge edge6 : g.edges) {
	        		if (edge6.label.equals(s61)) {
		    			edge6.label=s62;
		    			edge6.weight=s63;
		    			edge6.start.label=s64;
		    			edge6.end.label=s65;
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
