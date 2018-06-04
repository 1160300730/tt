package vertex;

import helper.MyException;

public abstract class Vertex {
    public String label;
    Vertex(String label) {
    	this.label=label;
	}
    //Ϊ�ض�Ӧ���еľ���ڵ������ϸ������Ϣ��
    public abstract void fillVertexInfo (String[] args) ;
    //���ؽڵ� label ��ȡֵ
    public String getLabel() {
    	return label;
    }
    public String toString() {
    	return label;
    }
    
}
