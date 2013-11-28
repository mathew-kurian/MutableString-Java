package com.langx;

//LangX Hierarchy
//@author Mathew Kurian

import com.listx.linkedlist.AbstractLinkedList;
import com.listx.linkedlist.Node;
import com.listx.linkedlist.NodeIterator;

public class MutableString extends AbstractLinkedList 
{
	private Node root = new Node();
	private Node last;

	public MutableString(String s) 
	{		
		last = root;
		append(s);
	}

	public void append(String s) 
	{

		NodeIterator iterator = (NodeIterator) last.iterator();

		for(Character c : s.toCharArray()) {
			iterator.set(c);

			if(iterator.hasNext())
			{
				iterator.next();

			} else {

				((Node) iterator.get()).attach();
				iterator.next();
			}

			last = (Node) iterator.get();

			++length;
		}
	}

	public String toString()
	{

		char [] string = new char[length];		
		int i = 0;		
		NodeIterator iterator = (NodeIterator) root.iterator();

		while(iterator.hasNext())
		{
			string[i++] = ((Node) iterator.get()).get();
			iterator.next();
		}

		return new String(string);
	}

	@Override
	public boolean contains(char c) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int length() 
	{			
		return length;
	}

	public void toUpperCase() 
	{		
		NodeIterator iterator = (NodeIterator) root.iterator();

		while(iterator.hasNext()){
			iterator.set(Character.toUpperCase((Character) ((Node) iterator.get()).get()));
			iterator.next();
		}

	}

	public void splice(int start, int length)
	{
		if(length <= 0) return;

		NodeIterator iterator = (NodeIterator) root.iterator();

		Node leftSide = null;

		int i = 0;

		while(iterator.hasNext())
		{
			if(start == i) leftSide = ((Node) iterator.get());
			if(start == (i + length)) {
				leftSide.right = ((Node) iterator.get());
				break;
			}

			iterator.next();

			++i;
		}

	}
}