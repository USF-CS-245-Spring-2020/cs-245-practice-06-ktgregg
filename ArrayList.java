public class ArrayList<T> implements List<T>
{
	T [] array; //array
	int size = 0; // size

	public ArrayList()
	{
		array = (T[]) new Object[10]; //constructs an array with size 10
	}

	@Override
	public void add(T item)
	{
		if (size == array.length) //if the array is "full"
		{
			growArray(); // double the size of the array
		}
		array[size++] = item; // adds the item to the array, and increases the size afterwards
	}
	void growArray() // doubles the size of the array
	{
		T [] tempArr = (T[]) new Object[array.length * 2]; // creates a temporary array, empty, with double the space
		for(int i = 0; i < array.length; i++) // fills the temp array with the elements of the original array
		{
			tempArr[i] = array[i];
		}
		array = tempArr; // sets array to point to the new, bigger array
	}

	@Override
	public void add(int pos, T item) // adds at a position
	{
		if(pos > size || pos < 0) // error if out of bounds
		{
			throw new IndexOutOfBoundsException();
		}
		if (pos >= 0 && pos < size)
		{
			if (size == array.length)
			{
				growArray();
			}
			for (int i = size - 1; i > pos - 1; i--)
			{
				array[i] = array[i - 1];
			}
			array[pos] = item;
			size++;
		}
		else // adds at end
		{
			add(item);
		}
	}

	@Override
	public T get(int pos) // returns element at a position
	{
		if(pos >= size || pos < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return array[pos];
	}

	@Override
	public T remove(int pos) // removes element at position
	{
		if(pos >= size || pos < 0) // error if out of bounds
		{
			throw new IndexOutOfBoundsException();
		}
		T data = array[pos];

		for (int i = pos; i < size - 1; i++)
		{
			array[i] = array[i + 1];
		}
		size--;
		return data;
	}

	@Override
	public int size() // returns size of the array
	{
		return size;
	}
}
