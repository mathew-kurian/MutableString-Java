package com.listx.linkedlist;

//ListX.LinkedList Hierarchy
//@author Mathew Kurian

import com.listx.Iterator;
import com.listx.Iterable;

//Make an abstract Node;
//and then set NodeIterator input as AbstractNode
public class Node implements Iterable
{	
	public static final Character UNDEFINED = 0x8;

	private volatile Character data;

	public Node left, right;

	int index = 0;

	public Node()
	{
		data = Node.UNDEFINED;
	}

	public Node(Object c)
	{
		set(c);
	}
	
	public void set(Object c)
	{
		if(c instanceof Character)
			data = (Character) c;
	}

	public Character get()
	{
		return data;
	}

	public void attach()
	{
		right = new Node();
	}

	@Override
	public Iterator iterator()
	{		
		return new NodeIterator(this);
	}
}