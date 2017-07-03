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
			String[] elements = line.split("\t");
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
				map.put(vex, new Integer(1000000));
			}
		}
		while (x.size() != vertexSetSize) {
			// grow x by one node
			// TODO solve the ConcurrentModificationException here.
			for (String vex : x) {
				List<String> neighbors = Graphs.neighborListOf(graph, vex);
				for (String neighbor : neighbors) {
					// vex in X, neighbor not in X
					if (!x.contains(neighbor)) {
						int pathLength =  map.get(vex).intValue()
								+ (int)(graph.getEdgeWeight(graph.getEdge(vex, neighbor)));
						if (pathLength < map.get(neighbor))
							map.replace(neighbor, new Integer(pathLength));
						x.add(neighbor);
					}
				}
			}
		}
		return map;
	}
}
