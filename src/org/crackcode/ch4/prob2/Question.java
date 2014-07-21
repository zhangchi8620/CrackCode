package org.crackcode.ch4.prob2;

public class Question {
	public static void main(String[] args)
	{
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);
		
		Graph g = new Graph();
		g.createNewGraph(temp, 6);
		g.printGraph();
		
		Node[] n = g.getNode();
		Node start = n[0];
		Node end = n[4];
		System.out.println("Check: "+ start.getVertex() + " " + end.getVertex());
		System.out.println( "Result:" +  g.searchGraph2(start, end));
//		System.out.println( "Result:" +  g.searchGraph(start, end));

	}

}
