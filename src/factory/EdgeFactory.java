package factory;

import java.util.List;

import edge.Edge;
import vertex.Vertex;

public abstract class EdgeFactory {
	//new一个新边，并调用addVertices进行加点
	//vertices 是边的节点集合， loop 是一个节点，简单边是 2 个节点（有向边需考虑次序），超边是多于 2 个节 点。
	public abstract Edge createEdge(String label, List<Vertex> vertices);
}
