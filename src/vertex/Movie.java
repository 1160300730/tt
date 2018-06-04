package vertex;

import helper.MyException;

public class Movie extends Vertex{
    int year;
    String c;
    float score;
	public Movie(String label) {
		super(label);		
	}
    //加入上映年份（四位正整数，范围为[1900, 2018]）
	//拍摄国家（字符串）
	//IMDb 评分（0-10 范围内的数值，最多 2 位小数）
	@Override
	public void fillVertexInfo(String[] args){
		// TODO Auto-generated method stub		
		this.year=Integer.valueOf(args[0]).intValue();
		this.c=args[1];
		this.score=Float.valueOf(args[2]);
	}

}
