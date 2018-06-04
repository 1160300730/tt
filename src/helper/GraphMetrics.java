package helper;

import java.util.Iterator;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;
import vertex.Word;

public class GraphMetrics {
	//����ͼ g�нڵ� v�� degree centrality,��������������Ⱥͳ�����ӽ������n-1
	public static <L extends Vertex, E extends Edge> double degreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.vertices.contains(v))
				d++;			
		}
		return d/(g.vertices().size()-1);		
	}
	//����ͼ g������ degree centrality ��v*��g�ж���������ߵĽ�㣬����X=(Y,Z)Ϊ
	//����ͼ��n���ڵ�����������H����y*ΪX�ж���������ߵĽ��	
	//ͼg�Ķ�������Ϊ   D=ȡ�ͣ�d��v*��-d��vj����/(|V|^2-3|V|+2)  ��j=1~|V|��
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
	///����ͼ g�нڵ� v��closeness centrality
	//C=n-1���Դ˵㵽������ľ���͵ĵ���
	public static <L extends Vertex, E extends Edge> double closenessCentrality(Graph<L,E> g, L v) {
		return 0;
		
	}
	//����ͼ g�нڵ� v��betweenness centrality
	//B=�˶��㱻��������/ͼ��ties�ĸ���
	public static <L extends Vertex, E extends Edge> double betweennessCentrality(Graph<L,E> g, L v) {
		return 0;
		
	}
	//����ͼ g �нڵ� v �� indegree centrality
	public static <L extends Vertex, E extends Edge> double inDegreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.end.equals(v))
				d++;			
		}
		return d;
		
	}
	//����ͼ g �нڵ� v �� outdegree centrality
	public static <L extends Vertex, E extends Edge> double outDegreeCentrality(Graph<L,E> g, L v) {
		double d = 0;
		for (E edge : g.edges()) {
			if(edge.start.equals(v))
				d++;			
		}
		return d;
		
	}
}
