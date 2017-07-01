package com.puzhen.dijkstra;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import junit.framework.TestCase;

public class TestCreateMapFromFile extends TestCase {

	public TestCreateMapFromFile(String name) {
		super(name);
	}
	
	/**
	 * Test map creation
	 */
	public void test0() {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("");
		assertTrue(graph != null);
	}
}
