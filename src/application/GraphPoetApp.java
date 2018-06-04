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
		System.out.println("������Ҫ������graphpoet�������ļ�·��"); 
		Scanner sc =new Scanner(System.in);
		String str =sc.nextLine();
		GraphPoet g = new GraphPoetFactory().createGraph(str);
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
	        	System.out.println("������Ҫ��ӵĶ����label��string�ͣ�");	
	        	String s1 =sc.next();
	        	Word v1 =new WordVertexFactory().createVertex(s1, null);
				g.addVertex(v1);
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 2:
	        	System.out.println("������Ҫɾ���Ķ����label��string�ͣ�");	
	        	String s2 =sc.next();
	        	Iterator<Word> iter2 = g.vertices.iterator();
				while (iter2.hasNext())
				{
					Word it=iter2.next();
					if(it.label.equals(s2))
						g.removeVertex(it);				
				}				
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 3:
	        	System.out.println("������Ҫ�޸ĵĶ����label��string�ͣ��͸ĺ��label");	
	        	String s31 =sc.next();
	        	Iterator<Word> iter3 = g.vertices.iterator();
	        	String s32 =sc.next();
				while (iter3.hasNext())
				{
					Word it=iter3.next();
					if(it.label.equals(s31))
						it.label=s32;				
				}
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 4:
	        	System.out.println("����������Ҫ���ӵıߵ�label����㡢�յ㡢Ȩֵ");	
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
				
	        	System.out.println("�ɹ�");
	        	x= sc.nextInt();
	            break;
	        case 5:
	        	System.out.println("������Ҫɾ���ıߵ�label��string�ͣ�");	
	        	String s5 =sc.nextLine();	        	
				for (WordEdge edge : g.edges) {
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
	        	for (WordEdge edge : g.edges) {
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
//C:\Users\lenovo\Desktop\1.txt1 4 8.0 to seek