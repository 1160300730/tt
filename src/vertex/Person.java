package vertex;

import helper.MyException;

public class Person extends Vertex{
	String sex;
	int age;
	public Person(String label) {
		super(label);				
	}
//�����Ա������
	@Override
	public void fillVertexInfo(String[] args)  {
		// TODO Auto-generated method stub		
		this.age=Integer.valueOf(args[1]).intValue();
		this.sex=args[0];
	}
}
