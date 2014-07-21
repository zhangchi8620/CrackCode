package org.crackcode.ch4.prob2;

import java.util.LinkedList;

public class Graph {
	private static Node vertices[];
	public int count;

	public Graph(){
		vertices = new Node[6];
		count = 0;
	}
	
	public void addNode(Node x){
		if (count < 30){
			vertices[count] = x;
			count++;
		}
		else
			System.out.println("Graph full.");
	}
	
	public Node[] getNode(){
		return vertices;
	}
	
	public  Graph createNewGraph(Node[] temp, int count)
	{
		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
//		temp[5].addAdjacent(temp[3]);
		
		for (int i = 0; i < count; i++) {
			this.addNode(temp[i]);
		}
		return this;
	}
	
	public void printGraph(){
		for(int i = 0; i < 6; i++){
			System.out.print(vertices[i].getVertex());
			Node[] a = vertices[i].getAdjacent();
			for(int j = 0; j < vertices[i].adjacentCount; j++){
				System.out.print("->" + a[j].getVertex());
			}
			System.out.println();
		}
	}

	/*
	public boolean searchGraph(Node start, Node end){
		System.out.println("start: " + start.getVertex());
		while(start!=null && start.state == false){
			if (start.getVertex() == end.getVertex()){
				System.out.println("Equal!!!");
				return true;
			}
			else{
				Node[] adj = start.getAdjacent();
				for(Node n: adj){
					System.out.println("adj: " + n.getVertex());
					if (n.state == false){
						n.state = true;
						if (searchGraph(n, end))
							return true;
					}
				}
			}
			start.state = true;
		}
		return false;
	}
	*/
	public boolean searchGraph2(Node start, Node end){
		LinkedList<Node> q = new LinkedList<Node>();
		for (Node u : this.getNode()){
			u.state = false;
		}
		
		start.state = true;
		q.add(start);
		System.out.println("add start: " + start.getVertex());
		Node u;
		while( !q.isEmpty()){
			u = q.removeFirst();
			System.out.println("remove u: " + u.getVertex());

			if(u != null){
				for (Node v : u.getAdjacent()){
					if (v.state == false){
						System.out.println("now v: " + v.getVertex());

						if (v == end)
							return true;
						else{
							v.state = true;
							q.add(v);
							System.out.println("add v: " + v.getVertex());

						}
					}
				}
				u.state = true;
			}
		}
		return false;
	}
	
	
}
