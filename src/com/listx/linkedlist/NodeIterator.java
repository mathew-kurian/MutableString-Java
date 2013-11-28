package com.listx.linkedlist;

//ListX.LinkedList Hierarchy
//@author Mathew Kurian

import com.listx.AbstractIterator;
import com.listx.Iterator;

public class NodeIterator extends AbstractIterator
{
	boolean firstEvent = false;

	public NodeIterator(Node a)
	{
		super(a);
	}

	@Override
	public void next() 
	{
		if(!hasNext()) throw new java.util.NoSuchElementException("Exceeded length");
		iterable = ((Node) iterable).right;
	}

	public Object get()
	{
		return iterable;
	}

	@Override
	public boolean hasNext() 
	{
		if(iterable != null && !firstEvent)
			return firstEvent = true;		
		return ((Node) iterable).right != null;
	}

	@Override
	public Iterator iterator()
	{
		return this;
	}

	@Override
	public void set(Object c) 
	{
		firstEvent = true;		
		((Node) iterable).set(c);
	}

	public boolean insert(Object c, int index)
	{
		return true;
	}

	@Override
	public void remove() 
	{
		if(iterable != null && hasNext())
		{
			next();
			((Node) iterable).left = null;
		}
	}
}
