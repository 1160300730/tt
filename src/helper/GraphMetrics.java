package helper;

import java.util.Iterator;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;
import vertex.Word;

public class GraphMetrics {
	//计算图 g中节点 v的 degree centrality,即将这个顶点的入度和出度相加结果除以n-1
	public static <L extends Vertex, E extends Edge> double degreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.vertices.contains(v))
				d++;			
		}
		return d/(g.vertices().size()-1);		
	}
	//计算图 g的总体 degree centrality 令v*是g中度中心性最高的结点，定义X=(Y,Z)为
	//连接图的n个节点最大化下面的量H（令y*为X中度中心性最高的结点	
	//图g的度中心性为   D=取和（d（v*）-d（vj））/(|V|^2-3|V|+2)  （j=1~|V|）
	public static <L extends Vertex, E extends Edge> double degreeCentrality(Graph<L,E> g) {
		double[] a = {0};
		double max=0,d=0,sum=0;
		int i=0;
		Iterator<L> iter = g.vertices().iterator();
		while (iter.hasNext())
		{			
			a[i]=degreeCentrality(g,iter.next());
			i++;
		}
		max=a[0];
		for(i=1;i<a.length;i++)
		{
			if(a[i]>max)
				max=a[i];
		}
		for(i=0;i<a.length;i++) {
			sum+=max-a[i];
		}
		d=max/(g.vertices().size()*g.vertices().size()-3*g.vertices().size()+2);
		return d;
		
	}
	///计算图 g中节点 v的closeness centrality
	//C=n-1乘以此点到其他点的距离和的倒数
	public static <L extends Vertex, E extends Edge> double closenessCentrality(Graph<L,E> g, L v) {
		return 0;
		
	}
	//计算图 g中节点 v的betweenness centrality
	//B=此顶点被经过次数/图中ties的个数
	public static <L extends Vertex, E extends Edge> double betweennessCentrality(Graph<L,E> g, L v) {
		return 0;
		
	}
	//计算图 g 中节点 v 的 indegree centrality
	public static <L extends Vertex, E extends Edge> double inDegreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.end.equals(v))
				d++;			
		}
		return d;
		
	}
	//计算图 g 中节点 v 的 outdegree centrality
	public static <L extends Vertex, E extends Edge> double outDegreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.start.equals(v))
				d++;			
		}
		return d;
		
	}
}
