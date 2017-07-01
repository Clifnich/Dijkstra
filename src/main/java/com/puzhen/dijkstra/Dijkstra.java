package com.puzhen.dijkstra;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.*;

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
		for (int i = 0; i < line_count; i++)
			graph.addVertex(String.valueOf(i));
		rd.close();rd = new BufferedReader(new FileReader(file));
		rd.close();
		return graph;
	}
}
