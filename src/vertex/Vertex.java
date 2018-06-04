package vertex;

import helper.MyException;

public abstract class Vertex {
    public String label;
    Vertex(String label) {
    	this.label=label;
	}
    //为特定应用中的具体节点添加详细属性信息，
    public abstract void fillVertexInfo (String[] args) ;
    //返回节点 label 的取值
    public String getLabel() {
    	return label;
    }
    public String toString() {
    	return label;
    }
    
}
