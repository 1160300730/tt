package factory;

import vertex.Vertex;
import vertex.Word;

public class WordVertexFactory  extends VertexFactory{
	@Override
    public Word createVertex(String label, String[] args) {
       Word a = new Word(label);
       return a;
    }
}
