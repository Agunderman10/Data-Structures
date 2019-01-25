import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Array <T> implements Iterable <T> //supports generics <T>
{
    private T [] arr; //our generic internal static array
    private int len = 0; //length user thinks array is
    private int capacity = 0; //actual array size
    
    //constructor inits array to be size 16
    public Array() 
    {
    	this(16);
    }
    
    //constructor inits array to be size of capacity(whatever we give it)
    public Array(int capacity) 
    {
    	if(capacity < 0) throw new IllegalArgumentException("Illegal capacity: " + capacity);
    	this.capacity = capacity;
    	arr = (T[]) new Object[capacity]; //init array. cast it to type T
    }

    //get size of array
    public int size() 
    {
    	return len;
    }
    
    //check if array is empty
    public boolean isEmpty() 
    {
    	return size() == 0;
    }
    
    //get a value from the array by index. should include bounds check
    public T get(int index) 
    {
    	return arr[index]; 
    }
    
    //set the value of an index in the array. should include bounds check
    public void set(int index, T elem) 
    {
    	arr[index] = elem;
    }
    
    //clear all data in the array. reset length
    public void clear() 
    {
    	for(int i = 0; i < capacity; i++) 
    	{
    		arr[i] = null;
    	}
    	len = 0;
    }
    
    //adds a new element to the array
    public void add(T elem) 
    {
    	//if adding a new element would make the array go out of bounds then we need to resize array
    	if(len + 1 >= capacity)
    	{
    		if(capacity == 0) 
    		{
    			capacity = 1;
    		}
    		else 
    		{
    			capacity *= 2; // we double the size of the array here
    		}
    		T[] new_arr = (T[]) new Object[capacity];
    		for(int i = 0; i < len; i++) 
    		{
    			new_arr[i] = arr[i]; //copy all elements from old array into new array
    		}
    		arr = new_arr; //sets old array equal to new array. has extra nulls padded
    	}
    	arr[len++] = elem; // add new element into a null space at the back of the new array
    }
    
    //removes the element at the specified index in this list
    public T removeAt(int rm_index) 
    {
    	if(rm_index >= len && rm_index < 0) 
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	
    	T data = arr[rm_index]; // add the remove index to the array
    	T[] new_arr = (T[]) new Object[len-1]; //init new array of size l-1 to account for removal
    	
    	//copy all elements into new array except for rm_index
    	for(int i = 0, j = 0; i < len; i++, j++) 
    	{
    		if(i == rm_index) 
    		{
    			j--; //skip over rm_index by fixing j temporarily
    		}
    		else 
    		{
    			new_arr[j] = arr[i];
    		}
    	}
    	arr = new_arr; //set array to be the new array we just generated
    	capacity = --len;
    	return data;
    }
    
    //look through array, if we find the element while we search we return true, if not, false
    public boolean remove(Object obj) 
    {
    	for(int i = 0; i < len; i++)
    	{
    		if(arr[i].equals(obj))
    		{
    			removeAt(i)
    			return true;
    		}
    	}
    	return false;
    }
    
    //loop through array, if we find element return its index, if not return -1
    public int indexOf(Object obj)
    {
    	for(int i = 0; i < len; i++)
    	{
    		if(arr[i].equals(obj))
    		{
    			return i;
    		}
    	}
    	return -1;
    }
    
    //finds if array contains value. Puts the element into indexOf, if it returns -1 aka didnt find it, return false
    //otherwise return true
    public boolean contains(Object obj)
    {
    	return indexOf(obj) != -1;
    }
    
    //iterator is still fast but not as fast as iterative for loop
    //iterator allows us to iterate over the array providing abstraction for it
    //to use this we have to override the methods hasNext and next
    //should check for concurrent moderation
	@Override
	public Iterator<T> iterator() 
	{
		return new Iterator <T> () 
		{
			int index = 0;
			
			public boolean hasNext()
			{
				//there is another element in the array if the index is less than the len
				return index < len;
			}
			
			public T next() 
			{
				//returns the next element in the array
				return arr[index++];
			}
		};
	}
	
	//we can call this method to get a string representation of the array
	@Override
	public String toString() 
	{
		if(len == 0)
		{
			return "[]";
		}
		else 
		{
			StringBuilder sb = new StringBuilder(len).append("[");
			for(int i = 0; i < len-1; i++)
			{
				sb.append(arr[i] + ", ");
			}
			return sb.append(arr[len-1] + "]").toString();
		}
	}

}
