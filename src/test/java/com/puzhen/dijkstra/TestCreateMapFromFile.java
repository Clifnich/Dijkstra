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
	
	/**
	 * Test adjacent lists
	 */
	public void testAdjacentList() throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("testcases/case0");
		DefaultWeightedEdge edge = (DefaultWeightedEdge)graph.getEdge("1", "2");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("1", "8");
		assertEquals(2, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("2", "3");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("3", "4");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("4", "5");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("5", "6");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("6", "7");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
		
		edge = (DefaultWeightedEdge)graph.getEdge("7", "8");
		assertEquals(1, graph.getEdgeWeight(edge), 1e-6);
	}
}
