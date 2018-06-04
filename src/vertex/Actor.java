package vertex;

public class Actor extends Vertex{
	String sex;
	int age;
	public Actor(String label) {
		super(label);				
	}
//加入年龄和性别
	@Override
	public void fillVertexInfo(String[] args){
		// TODO Auto-generated method stub		
		this.age=Integer.valueOf(args[1]).intValue();
		this.sex=args[0];
	}
}
