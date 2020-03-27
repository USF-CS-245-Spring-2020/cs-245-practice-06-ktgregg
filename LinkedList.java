public class LinkedList<T> implements List<T>
{
	Node head; // head of the list
	int size; // size of the list

	class Node // node class
	{
		T data; // data of the node
		Node next; // points to the next node
		public Node(T item) // constructor
		{
			data = item;
			next = null;
		}
	}

	public LinkedList() // constructs the linkedlist
	{
		this.head = new Node(null);
		this.size = 0;
	}

	@Override
	public void add(T item) //adds an item at the end of a list
	{
		Node node = new Node(item);
		if (size == 0)
		{
			head = node;
		}
		else
		{
			Node temp = head;
			for(int i = 0; i < size - 1; i++)
			{
				temp = temp.next;
			}
			temp.next = node;
		}
		size++;
	}

	@Override
	public void add(int pos, T item) // adds item at a position
	{
		if(pos > size || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		if (pos >= 0 && pos < size)
		{
			Node node = new Node(item);
			Node temp = head;
			for(int i = 0; i < pos; i++)
			{
				temp = temp.next;
			}
			node.next = temp.next.next;
			temp.next = node;
			size++;
		}
		else
		{
			add(item);
		}
	}

	@Override
	public T get(int pos) // returns an item at a position in the list
	{
		if(pos >= size || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		Node temp = head;
		for(int i = 0; i < pos - 1; i++)
		{
			temp = temp.next;
		}
		return temp.data;
	}

	@Override
	public T remove(int pos) // removes an item in the list, return data of the removed element
	{
		if(pos >= size || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}

		if(pos == 0)
		{
			Node node = head;
			head = head.next;
			size--;
			return node.data;
		}
		Node temp = head;
		for(int i = 0; i < pos - 1; i++)
		{
			temp = temp.next;
		}
		Node node = temp.next;
		temp.next = node.next;
		size--;
		return node.data;
	}

	@Override
	public int size() //returns the size of the list.
	{
		return size;
	}
}
