package vertex;

import helper.MyException;

public class Director extends Vertex{
	String sex;
	int age;
	public Director(String label) {
		super(label);				
	}
//�����Ա������
	@Override
	public void fillVertexInfo(String[] args) {
		// TODO Auto-generated method stub		
		this.age=Integer.valueOf(args[0]).intValue();
		this.sex=args[1];
	}
}
