package factory;

import vertex.Vertex;

public abstract class VertexFactory {
	//newһ���¶��㲢����fillVertexInfo�������и������Ե����  
    public abstract Vertex createVertex(String label, String[] args) throws Exception;
    	
}
