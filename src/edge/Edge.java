package edge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vertex.Vertex;

public abstract class Edge {
	public List<Edge> edges = new ArrayList<>();
	public List<Vertex> vertices = new ArrayList<>();
	public String label;
	public Vertex start;
	public Vertex end;
	public double weight ;
	Edge(String label, double weight){
		this.label=label;
		this.weight=weight;
		this.start=start;
		this.end=end;
		this.vertices=vertices;
		this.edges=edges;
	}
	
	abstract public boolean addVertices(List<Vertex> vertices);
	//该边中是否包含指定的点 v
	public boolean containVertex(Vertex v) throws Exception {		
		for(Edge e : edges ) {
			if(e.start.equals(v)||e.end.equals(v))
			    return true;		    
			}
		throw new Exception("顶点不存在");					
	}
	//边包含的点集
	public Set<Vertex> vertices(){
		Set<Vertex> a=new HashSet<Vertex>();
		for(int i=0;i<vertices.size();i++)
			a.add(vertices.get(i));
		return a;		
	}
	//返回该边的源节点集合，如果是超边则将所有的点都加入，如果是有向边就返回start，如果无向边就加入两个顶点
	abstract Set<Vertex> sourceVertices();
	//返回该边的目标节点集合，如果是超边则将所有的点都加入，如果是有向边就返回end，如果无向边就加入两个顶点
	abstract Set<Vertex> targetVertices();
}
