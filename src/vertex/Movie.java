package vertex;

import helper.MyException;

public class Movie extends Vertex{
    int year;
    String c;
    float score;
	public Movie(String label) {
		super(label);		
	}
    //������ӳ��ݣ���λ����������ΧΪ[1900, 2018]��
	//������ң��ַ�����
	//IMDb ���֣�0-10 ��Χ�ڵ���ֵ����� 2 λС����
	@Override
	public void fillVertexInfo(String[] args){
		// TODO Auto-generated method stub		
		this.year=Integer.valueOf(args[0]).intValue();
		this.c=args[1];
		this.score=Float.valueOf(args[2]);
	}

}
