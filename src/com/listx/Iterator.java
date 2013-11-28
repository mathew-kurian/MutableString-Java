package com.listx;

//ListX Hierarchy
//@author Mathew Kurian

public interface Iterator extends Iterable 
{
	public abstract void next();
	public abstract boolean hasNext();
	public abstract void remove();
}