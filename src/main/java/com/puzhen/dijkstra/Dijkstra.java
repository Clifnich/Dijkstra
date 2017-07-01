package com.puzhen.dijkstra;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Dijkstra {

	/**
	 * Create a weighted undirected graph from file
	 */
	public SimpleWeightedGraph<String, DefaultWeightedEdge>
		createMapFromFile(String filename) {
		EdgeFactory<String, DefaultWeightedEdge> ef = 
				new ClassBasedEdgeFactory<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		SimpleWeightedGraph<String, DefaultWeightedEdge> graph
			= new SimpleWeightedGraph<String, DefaultWeightedEdge>(ef);
		return graph;
	}
}
