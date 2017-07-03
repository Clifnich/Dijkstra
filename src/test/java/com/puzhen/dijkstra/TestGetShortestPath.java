package com.puzhen.dijkstra;

import java.io.*;
import java.util.*;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import junit.framework.TestCase;

public class TestGetShortestPath extends TestCase {

	public TestGetShortestPath(String name) {
		super(name);
	}
	
	/**
	 * Case 1.
	 * Every element in the map should match.
	 * @throws IOException 
	 */
	public void test0() throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("testcases/case0");
		Map<String, Integer> map = dij.getShortestPath("1", graph);
		assertEquals(1, map.get("2").intValue());
		assertEquals(2, map.get("3").intValue());
		assertEquals(2, map.get("8").intValue());
	}
}
