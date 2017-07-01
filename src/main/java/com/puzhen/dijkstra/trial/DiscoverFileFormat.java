package com.puzhen.dijkstra.trial;

import java.io.*;

public class DiscoverFileFormat {

	
	/**
	 * I just found out that the test case files
	 * are separated by \t.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File file = new File("testcases/case0");
		BufferedReader rd = new BufferedReader(new FileReader(file));
		String line = rd.readLine();
		String[] elements = line.split("\t");
		for (String element : elements) {
			System.out.println("--" + element + "--");
		}
		rd.close();
	}
}
