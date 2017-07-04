package com.puzhen.dijkstra;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graphs;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.*;
import java.util.*;

public class Dijkstra {

	/**
	 * Create a weighted undirected graph from file
	 */
	public SimpleWeightedGraph<String, DefaultWeightedEdge>
		createMapFromFile(String filename) throws IOException{
		EdgeFactory<String, DefaultWeightedEdge> ef = 
				new ClassBasedEdgeFactory<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= new SimpleWeightedGraph<String, DefaultWeightedEdge>(ef);
		
		File file = new File(filename); 
		BufferedReader rd = new BufferedReader(new FileReader(file));
		// #1 count the lines and create vertices
		int line_count = 0;
		while ((rd.readLine()) != null) 
			line_count++;
		for (int i = 1; i <= line_count; i++)
			graph.addVertex(String.valueOf(i));
		rd.close();rd = new BufferedReader(new FileReader(file));
		// #1 add the weighted edges
		String line = "";
		while ((line = rd.readLine()) != null) {
			String[] elements = line.contains("\t") ? line.split("\t") : line.split(" ");
			String root_vex = elements[0];
			// skip the first element which is the vertex itself
			for (int i = 1; i< elements.length; i++) {
				// first is vertex name, second edge weight
				String[] vertexNWeight = elements[i].split(",");
				DefaultWeightedEdge e = graph.addEdge(root_vex, vertexNWeight[0]);
				if (e != null)
					graph.setEdgeWeight(e, Double.valueOf(vertexNWeight[1]));
			}
		}
		rd.close();
		return graph;
	}
	
	/**
	 * Compute the shortest path from the given vertex
	 * to each of the other vertices.
	 */
	public Map<String, Integer> getShortestPath(String start_vex, 
			SimpleWeightedGraph<String, DefaultWeightedEdge> graph) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put(start_vex, new Integer(0));
		// x is our territory so far.
		List<String> x = new ArrayList<String>(); x.add(start_vex);
		// initialize the map, set every path to "infinity"
		int vertexSetSize = graph.vertexSet().size();
		for (String vex : graph.vertexSet()) {
			if (!vex.equals(start_vex)) {
				map.put(vex, new Integer(9999999));
			}
		}
		while (x.size() != vertexSetSize) {
			int greedyScore = 99999999;
			String wStar = null;
			// grow x by one node
			for (String v : x) {
				List<String> neighbors = Graphs.neighborListOf(graph, v);
				for (String w : neighbors) {
					// v in X, w not in X
					if (!x.contains(w)) {
						int pathLength =  map.get(v).intValue()
								+ (int)(graph.getEdgeWeight(graph.getEdge(v, w)));
						if (pathLength < greedyScore) {
							greedyScore = pathLength;
							wStar = w;
						}
						/*
						if (pathLength < map.get(neighbor))
							map.replace(neighbor, new Integer(pathLength));
						if (!newTerritory.contains(neighbor))
							newTerritory.add(neighbor);*/
						
					}
				}
			}
			x.add(wStar);
			map.replace(wStar, greedyScore);
		}
		return map;
	}
	
	public static void main(String[] args) throws IOException {
		Dijkstra dij = new Dijkstra();
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= dij.createMapFromFile("assignment.txt");
		Map<String, Integer> map = dij.getShortestPath("1", graph);
		System.out.println(map.get("7")
				+ "," + map.get("37")
				+ "," + map.get("59")
				+ "," + map.get("82")
				+ "," + map.get("99")
				+ "," + map.get("115")
				+ "," + map.get("133")
				+ "," + map.get("165")
				+ "," + map.get("188")
				+ "," + map.get("197"));
	}
}
