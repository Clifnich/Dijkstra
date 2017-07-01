package com.puzhen.dijkstra;

import java.io.IOException;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import junit.framework.TestCase;

public class TestCreateMapFromFile extends TestCase {

	public TestCreateMapFromFile(String name) {
		super(name);
	}
	
	/**
	 * Test map creation, not null
	 */
	public void test0() throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("testcases/case0");
		assertTrue(graph != null);
	}
	
	/**
	 * Test vertices size
	 */
	public void test1() throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("testcases/case0");
		assertEquals(8, graph.vertexSet().size());
	}
}
