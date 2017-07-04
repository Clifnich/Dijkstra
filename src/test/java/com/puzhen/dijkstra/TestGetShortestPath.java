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
	 * Case 0.
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
		assertEquals(3, map.get("4").intValue());
		assertEquals(4, map.get("5").intValue());
		assertEquals(4, map.get("6").intValue());
		assertEquals(3, map.get("7").intValue());
		assertEquals(2, map.get("8").intValue());
	}
	
	/**
	 * Case 1.
	 */
	public void test1() throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("testcases/case1");
		Map<String, Integer> map = dij.getShortestPath("1", graph);
		assertEquals(3, map.get("2").intValue());
		assertEquals(5, map.get("3").intValue());
		assertEquals(8, map.get("4").intValue());
		assertEquals(5, map.get("5").intValue());
		assertEquals(7, map.get("6").intValue());
		assertEquals(11, map.get("7").intValue());
		assertEquals(4, map.get("8").intValue());
		assertEquals(6, map.get("9").intValue());
		assertEquals(10, map.get("10").intValue());
		assertEquals(10, map.get("11").intValue());
	}
}
