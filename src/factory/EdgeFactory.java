package factory;

import java.util.List;

import edge.Edge;
import vertex.Vertex;

public abstract class EdgeFactory {
	//newһ���±ߣ�������addVertices���мӵ�
	//vertices �ǱߵĽڵ㼯�ϣ� loop ��һ���ڵ㣬�򵥱��� 2 ���ڵ㣨������迼�Ǵ��򣩣������Ƕ��� 2 ���� �㡣
	public abstract Edge createEdge(String label, List<Vertex> vertices);
}
