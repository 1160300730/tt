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
    
    //构造一张图的空实例
    public static <L,E> Graph<L,E> empty() {
        return((Graph<L,E>) new ConcreteGraph());
    }
    //向图中增加一个顶点
    public boolean addVertex(L v);
    // 从图中删除一个节点 v。如果v是某条边的两端之一，则该边被删除；
    //如果某节点属于某条超边，若该节点删除后该条超边仍可合法存在，则该超边继续保留，否则就删除之。
    public boolean removeVertex(L v); 
    //返回图的节点集合
    public Set<L> vertices(); 
    //返回的Map中Key为source节点， List<Double>为当前节点与该source节点之间的所有边的权值；
    //如果 与target相连的边包括无向边，则无向边的另一端节点也需包含在返 回值Map中；不需考虑超边。
    public Map<L, List<Double>> sources(L target);
    //返回的Map中Key为target节点， List<Double>为当前节点与该target节点之间的所有边的权值；
    //如果 与source相连的边包括无向边，则无向边的另一端节点也需包含在返 回值Map中；不需考虑超边。
    public Map<L, List<Double>> targets(L source);
    //向图中增加一条边
    public boolean addEdge(E edge);
    //删除图中的一条边
    public boolean removeEdge(E edge);
    //返回图的边集合
    public Set<E> edges();
	 
    
    
}
 