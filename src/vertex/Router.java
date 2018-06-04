package vertex;

import helper.MyException;

public class Router extends Vertex{
	String add;
	public Router(String label) {
		super(label);		
	}
	//添加IP地址（字符串，用“.”分割为四部分，每部分的取值范围为[0,255]）
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub
		
		this.add=args[0];
	}
}
