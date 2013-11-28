package com.listx;

//ListX Hierarchy
//@author Mathew Kurian

public abstract class AbstractIterator implements Iterator 
{
	protected Iterable iterable;

	public AbstractIterator(Iterable a) 
	{
		if(a instanceof Iterator)
			throw new java.lang.ClassCastException("Cannot copy an Iterator.");
		iterable = a;
	}

	public abstract void set(Object c);
}