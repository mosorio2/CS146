/** @author 		Anthony Picone
	I pledge my honor that I have abided by the Stevens Honor System. Anthony Picone
*/

//DLCList class
public class DLCList {

	
	private DLNode head; //instance of a node that's the first node of the list
	private int size; //private variable containing the size of the list

	private class DLNode //class inside the DLCList that is creates an indivi
	{
		public Object data; //The data in the node
		public DLNode next;//the next node
		public DLNode prev;//the previous node

		//Creates a node holding o
		public DLNode(Object o)
		{
			data = o;
			next = this;
			prev = this;
		}

		// Creates a node holding o, with n as next and p as prev
		public DLNode(Object o, DLNode n, DLNode p)
		{
			data=o;
			next = n;
			prev = p;
		}
	}
	
	//Creates an empty list
	public DLCList()
	{
		size=0;
	}
	
	/** add(int i, Object o) This method gets the adds an object to index i

	@param i 				The index desired, int
	@param o 				The object that gets put in, Object
	@return 				Boolean that confirms the addition
	*/
	public boolean add(int i, Object o)
	{
		if (o ==null)
			return false;
		if (i == 0)
			return add(o);
		DLNode current = head;
		if (i>0)
		{
			if(i >= size)
				i = i % size;
			for(current=head; i>1; i--)
				current=current.next;
			current.next=new DLNode(o, current.next, current);
			current.next.next.prev = current.next;
			size++;
		}

		if (i<0)
		{
			for(current=head; i< -1; i++)
				current=current.prev;
			current.prev = new DLNode(o,current, current.prev);
			current.prev.prev.next = current.prev;
			size++;
		}

		return true;

	}


	/** add(Object o) This method gets the adds an object to the beginning

	@param o 				The object that gets put in, Object
	@return 				Boolean that confirms the addition
	*/
	
	public boolean add(Object o)
	{
		if (o == null)
			return false;
		if (size <= 0)
		{
			head = new DLNode(o);
			size++;
			return true;
		}

		head = new DLNode(o, head.next, head.prev);
		head.next.prev = head;
		head.prev.next = head;
		size++;
		return true;

	}

	/** append(Object o) This method gets the appends an object to the end

	@param o 					The object that gets put in, Object
	@return boolean				Boolean that confirms the appendation
	*/
	
	public boolean append(Object o)
	{
		if (o == null)
			return false;
		if (head == null)
			return add(o);
		DLNode current = new DLNode(o, head, head.prev);
		head.prev = current;
		current.prev.next = current;
		size++;
		return true;
		
	}

	/** get(int i) This method gets the gets an object at index i

	@param i 				The index of the desired result, int
	@return ans				The Object returned, Object
	*/
	
	public Object get(int i)
	{
		DLNode current;
		Object ans = null;
		if (size<= 0)
			return null;

		if (i >= 0)
		{
			for(current=head; i > 0; i--)
				current = current.next;
			ans = current.data;
		}

		if (i<0)
		{
			for(current=head; i < 0; i++)
				current=current.prev;
			ans = current.data;
		}

		return ans;

	}

	/** get() This method gets the gets an object at the head

	
	@return ans				The Object returned, Object
	*/

	public Object get()
	{
		return get(0);
	}

	/** get() This method gets the gets an object at the tail

	
	@return ans				The Object returned, Object
	*/

	public Object getLast()
	{
		return get(-1);
	}

	/**  size() This method gets the size of the list

	
	@return size			The size returned, int
	*/

	public int size()
	{
		return size;
	}

	/**  remove() This method removes and returns the element in the head

	
	@return ans			The item removed, Object
	*/

	public Object remove()
	{
		return remove(0);
	}

	/**  removeLast() This method removes and returns the last element in the list

	
	@return ans			The item removed, Object
	*/

	public Object removeLast()
	{
		return remove(-1);
	}

	/**  remove(int i) This method removes and returns the element at index i in the list

	
	@return ans			The item removed, Object
	*/

	public Object remove(int i)
	{
		Object ans = null;
		
		if (size > 0)
		{
			DLNode current = head;
			if (size == 1)
			{
				ans = current.data;
				head = null;
			}

			if (i == 0)
			{
				ans = current.data;
				current.next.prev = current.prev;
				current.prev.next = current.next;
				head = current.next;
			}
			else
			{
				if (i>0)
				{
					for(current=head; i>=1; i--)
						current=current.next;

				}

				if (i<0)
				{
					for(current = head; i<= -1; i++)
						current = current.prev;
				}

				ans = current.data;
				current.prev.next = current.next;
				current.next.prev = current.prev;

			}

			size--;

		}

		return ans;
	}

	/**  remove(Object o) This method removes the specified element from the list and confirms

	
	@return boolean		Confirmation of the removal, boolean
	*/

	public boolean remove (Object o)
	{
		if (head == null)
		{
			return false;
		}

		DLNode current;
		int i = 0;
		for (current = head; i <= size-1; i++)
		{
			if (o.equals(current.data))
			{
				remove(i);
				return true;
			}

			current = current.next;

		}

		return false;

	}

	/**  showList() This uses the toString() 

	Prints the items in the list
	
	*/
	
	public void showList()
	{
		if (head == null)
			System.out.println("Empty List");
		DLNode current;
		int i = 0;
		for(current = head; i <= size-1; i++)
		{
			System.out.println("Element " + i + ": " + current.data.toString());
			current = current.next;
		}
	}

	public static void main(String[] args) 
	{
		
		//create a list...
		DLCList list1 = new DLCList();

		//Test out an empty print
		System.out.println("Empty List: ");
		list1.showList();
		System.out.println();
		//Add a head
		System.out.println("Creating a new head with int 23");
		list1.add(23);
		System.out.println();
		//Tests to see if it was added
		System.out.println("EXPECTED:  Element 0: 23");
		list1.showList();
		System.out.println();
		//Appends 5 to the end of the list
		System.out.println("Appending 5 to the list");
		list1.append(5);
		System.out.println();
		//Prints the first item
		System.out.println("Getting the first element of the list" + "\n" + "EXPECTED: 23 \n" + list1.get());
		System.out.println();
		//Appending multiple numbers
		System.out.println("Appending 34, 24, 233, and 356 to the list");
		list1.append(34);
		list1.append(24);
		list1.append("233");
		list1.append(356);
		System.out.println();
		//Prints the new list
		System.out.println("Result: ");
		list1.showList();
		System.out.println();
		//Get an item at given index
		System.out.println("Getting element at index 2...");
		System.out.println(list1.get(2));
		System.out.println();
		//Getting the last item
		System.out.println("Getting last element of the list....");
		System.out.println(list1.getLast());
		System.out.println();
		//Removes the last item
		System.out.println("Removing last item...");
		list1.removeLast();
		System.out.println();
		//New Result
		System.out.println("Result: ");
		list1.showList();
		System.out.println();
		//Removes the first time 233 is found
		System.out.println("Removing first instance of 233...");
		list1.remove("233");
		System.out.println();
		//Prints list sans 233
		System.out.println("Result: ");
		list1.showList();
		System.out.println();
		//Test to see if circular
		System.out.println("Removing an big index...");
		list1.remove(1234543);
		list1.showList();
		System.out.println();
		//Test negative index
		System.out.println("Removing a negative index...");
		list1.remove(-123422);
		list1.showList();
		System.out.println();
		System.out.println("*****ALL TESTS WORK, YAY!*******");


	}

}
