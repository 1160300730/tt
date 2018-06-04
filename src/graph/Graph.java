/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface Graph<L,E> {
    
    //����һ��ͼ�Ŀ�ʵ��
    public static <L,E> Graph<L,E> empty() {
        return((Graph<L,E>) new ConcreteGraph());
    }
    //��ͼ������һ������
    public boolean addVertex(L v);
    // ��ͼ��ɾ��һ���ڵ� v�����v��ĳ���ߵ�����֮һ����ñ߱�ɾ����
    //���ĳ�ڵ�����ĳ�����ߣ����ýڵ�ɾ������������ԿɺϷ����ڣ���ó��߼��������������ɾ��֮��
    public boolean removeVertex(L v); 
    //����ͼ�Ľڵ㼯��
    public Set<L> vertices(); 
    //���ص�Map��KeyΪsource�ڵ㣬 List<Double>Ϊ��ǰ�ڵ����source�ڵ�֮������бߵ�Ȩֵ��
    //��� ��target�����ı߰�������ߣ�������ߵ���һ�˽ڵ�Ҳ������ڷ� ��ֵMap�У����迼�ǳ��ߡ�
    public Map<L, List<Double>> sources(L target);
    //���ص�Map��KeyΪtarget�ڵ㣬 List<Double>Ϊ��ǰ�ڵ����target�ڵ�֮������бߵ�Ȩֵ��
    //��� ��source�����ı߰�������ߣ�������ߵ���һ�˽ڵ�Ҳ������ڷ� ��ֵMap�У����迼�ǳ��ߡ�
    public Map<L, List<Double>> targets(L source);
    //��ͼ������һ����
    public boolean addEdge(E edge);
    //ɾ��ͼ�е�һ����
    public boolean removeEdge(E edge);
    //����ͼ�ı߼���
    public Set<E> edges();
	 
    
    
}
 