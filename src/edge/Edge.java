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
	//�ñ����Ƿ����ָ���ĵ� v
	public boolean containVertex(Vertex v) throws Exception {		
		for(Edge e : edges ) {
			if(e.start.equals(v)||e.end.equals(v))
			    return true;		    
			}
		throw new Exception("���㲻����");					
	}
	//�߰����ĵ㼯
	public Set<Vertex> vertices(){
		Set<Vertex> a=new HashSet<Vertex>();
		for(int i=0;i<vertices.size();i++)
			a.add(vertices.get(i));
		return a;		
	}
	//���ظñߵ�Դ�ڵ㼯�ϣ�����ǳ��������еĵ㶼���룬���������߾ͷ���start���������߾ͼ�����������
	abstract Set<Vertex> sourceVertices();
	//���ظñߵ�Ŀ��ڵ㼯�ϣ�����ǳ��������еĵ㶼���룬���������߾ͷ���end���������߾ͼ�����������
	abstract Set<Vertex> targetVertices();
}
