package factory;

import vertex.Vertex;

public abstract class VertexFactory {
	//new一个新顶点并调用fillVertexInfo函数进行附加属性的添加  
    public abstract Vertex createVertex(String label, String[] args) throws Exception;
    	
}
