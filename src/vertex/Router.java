package vertex;

import helper.MyException;

public class Router extends Vertex{
	String add;
	public Router(String label) {
		super(label);		
	}
	//���IP��ַ���ַ������á�.���ָ�Ϊ�Ĳ��֣�ÿ���ֵ�ȡֵ��ΧΪ[0,255]��
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		
		this.add=args[0];
	}
}
