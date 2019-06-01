/**
 * Defines a doubly-linked list class
* @Dang Khoi Nguyen
* @Thinh Nguyen
*/

import java.util.NoSuchElementException;

public class List<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev=null;
        }
    }
    
    private int length;
    private Node first;
    private Node last;
    private Node iterator;
    
    /****CONSTRUCTOR****/
    
    /**
     * Instantiates a new List by copying another List
     * @postcondition a whole new identical List object is created on different part of memory
     */
    public List() {
    	first=null;
    	last=null;
    	length=0;
    	iterator=null;
    }
    
    public List(List original) {
    	if(original.length==0) {
    	first=null;
    	last=null;
    	length=0;
    	iterator=null;
    	
    	} else {
    		Node temp=original.first;
    		while(temp!=null)
    		{
    			addLast(temp.data);
    			temp=temp.next;
    		}
    		iterator=null;
    	}
 
    }
    
    /****ACCESSORS****/
    
    /**
     * Returns the value stored in the first node
     * @precondition !isEmpty() or first!=null or length!=0
     * @return the integer value stored at node first
     * @throws NoSuchElementException when precondition is violated
     */
    public T getFirst() throws NoSuchElementException{
    	if(first==null)
    	{
    		throw new NoSuchElementException("getFirst: List is Empty. No data to access!");
    	}
        return first.data;
    }
    
    /**
     * Returns the value stored in the last node
     * @precondition !isEmpty() or last!=null or length!=0
     * @return the integer value stored in the node last
     * @throws NoSuchElementException when precondition is violated
     */
    public T getLast() throws NoSuchElementException{
    	if (last==null)
    		throw new NoSuchElementException("getLast: List is Empty. No data to access!");
        return last.data;
    }
    
    /**
     * Returns the current length of the list
     * @return the length of the list from 0 to n
     */
    public int getLength() {
        return length;
    }
    
    /**
     * Returns whether the list is currently empty
     * @return whether the list is empty
     */
    public boolean isEmpty() {
        return length==0;
    }
    
    
    /**
     * @precondition iterator!=null or !offEnd()
     * @return
     * @throws NullPointerException when precondition is violated
     */
    public T getIterator() throws NullPointerException
    {
    	if (iterator==null)
    		throw new NullPointerException("getIterator() iterator is null.");
    	else
    	return iterator.data;
    }
    
    /**
     * returns whether the iterator is off the end of the list, i.e. is NULL
     * @return iterator ==null
     */
    public boolean offEnd()
    {
    	return iterator == null;
    }
    
    /**
     * overrides the equals method for object to compares this list to another list to see if they contain the same data in the same order.
     * @return whether the 2 Lists are equal
     */
    @Override public boolean equals(Object o) {
    	if (o==this)
    		return true;
    	else if (!(o instanceof List))
    		return false;
    	else {
    		List L=(List) o;
    		if (this.length!=L.length)
    			return false;
    		else {
    			Node temp1=this.first;
    			Node temp2=L.first;
    			while(temp1 != null) {
    				if(temp1.data!=temp2.data) {
    					return false;
    				}
    				temp1=temp1.next;
    				temp2=temp2.next;
    			}
    			return true;
    		}
    	}
    }
    
    /**
     * Determines whether a List is sorted
     * by calling the recursive helper method
     * isSorted
     * Note: A List that is empty can be
     * considered to be (trivially) sorted
     * @return whether this List is sorted
     */
    public boolean isSorted() {
    	Node n=first;
    	if (isSorted(n)) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Recursively determines whether 
     * a List is sorted in ascending order
     * @return whether this List is sorted
     */
    public boolean isSorted(Node n) {

		boolean checked = true;

		if (n.next == null)
			return true;
		if (n.data.compareTo(n.next.data) <= 0) {
			checked = true;
			if (checked == true)
				isSorted(n.next);
		} else
			return false;
		return isSorted(n.next);
    }
    
    /**
     * Returns the index of the iterator
     * from 1 to n. Note that there is 
     * no index 0.
     * @precondition iterator!=null
     * @return the index of the iterator
     * @throws NullPointerException when
     * the precondition is violated
     */
    public int getIndex() throws NullPointerException{
    	if (iterator==null) {
    		throw new NullPointerException("getIndex(): iterator is null");
    	}
    	
    	Node N = first;
    	int i =1;

        while(N!=iterator) {
    		N=N.next;
    		i++;
    	}
        return i;
    }
    
    /**Accessor Methods*/

    /**
         * Searches the List for the specified
         * value using the iterative linear
         * search algorithm
         * @param value the value to search for
         * @return the location of value in the
         * List or -1 to indicate not found
         * Note that if the List is empty we will
         * consider the element to be not found
         * @postcondition: position of the iterator remains
         * unchanged!
         */
        public int linearSearch(T value) {
        	if (this.getLength()==0) {
        		return -1;
        	}
        	
        	Node N=first;
        	for(int i = 0; i < this.length; i++)
            {
                if (N.data.equals(value))
                {
                    return i+1;
                }
                N=N.next;
            }
            return -1;
        }

        /**
             * Returns the index from 1 to length
             * where value is located in the List
             * by calling the private helper method
             * binarySearch
             * @param value the value to search for
             * @return the index where value is 
             * stored from 1 to length, or -1 to
             * indicate not found
             * @precondition isSorted()
             * @postcondition the position of the
             * iterator must remain unchanged! 
             * @throws IllegalStateException when the
             * precondition is violated.
             */
            public int binarySearch(T value) throws IllegalStateException {
            	if(!this.isSorted()) {
            		throw new IllegalStateException("binarySearch(): List is not sorted.");
            	} else if (binarySearch(1,this.getLength(),value)==-1){
            		return -1;
            	}
            	else {
            		return binarySearch(1,this.getLength(),value);
            	}
            }
            
            /**
             * Searches for the specified value in
             * the List by implementing the recursive
             * binarySearch algorithm
             * @param low the lowest bounds of the search
             * @param high the highest bounds of the search
             * @param value the value to search for
             * @return the index at which value is located
             * or -1 to indicate not found
             * @postcondition the location of the iterator
             * must remain unchanged
             */
            private int binarySearch(int low, int high, T value) {
            	if (high < low) {
            		return -1;
            	}
        	Node N=this.first;
            int mid = low + (high-low)/2;
            
            for(int i=1;i<mid;i++){
            	N=N.next;
            }
            if (N.data == value)
                return mid;
            else if (value.compareTo(N.data)<0) //search the left half
                return binarySearch(low, mid-1,value);
            else //search the right half
                return binarySearch(mid+1, high,value);
            }
    
    /****MUTATORS****/
    
    /**
     * Creates a new first element
     * @param data the data to insert at the 
     * front of the list
     * @postcondition a new first node created
     */
    public void addFirst(T data) {
    	if(first==null)
    	{
    		first=last= new Node(data);
    	}
    	else
    	{
    		Node N = new Node(data);
    		N.next=first;
    		first.prev=N;
    		first=N;
    	}
    	length++;
    }
    
    /**
     * Creates a new last element
     * @param data the data to insert at the 
     * end of the list
     * @postcondition a new last node created
     */
    public void addLast(T data)
    {
		if (last == null)
		{
			last=first=new Node(data);
		}
		else
		{
			Node N = new Node(data);
			last.next = N;
			N.prev=last;
			last = N;
		}
		length++;
	}

    
    /**
    * removes the element at the front of the list
    * @precondition first!=null or length!=0
    * @postcondition the first node is removed
    * @throws NoSuchElementException when precondition is violated
    */
    public void removeFirst() throws NoSuchElementException
    {
        if (length == 0) {
            throw new NoSuchElementException("removeFirst(): Cannot remove from an empty List!");
        } else if (length == 1) {
            first = last = null;
            length=0;
        } else {
            first = first.next;
            first.prev=null;
            length--;
        }
    }
    
    /**
     * removes the element at the end of the list
     * @precondition last!=null or length!=0
     * @postcondition the last node is removed
     * @throws NoSuchElementException when precondition is violated
     */
    public void removeLast() throws NoSuchElementException {
    	//add your if statement here
    	if(length==0)
    	{
    		throw new NoSuchElementException("removeLast(): Cannot remove from an empty List!");
    	}
        else if (length == 1) {
            //add a line of code here
        	first=last=null;
        	length=0;
        } else {
            last=last.prev;
            last.next=null;
            length--;
        }
        return;
    }
    
    /** moves the iterator to the start of the list
     * @precondition first!=null;
     * @throws NullPointerException when precondition is violated
     * @ postcondition iterator is pointing to the first Node
    */
    public void pointIterator() throws NullPointerException
    {
    	if (first==null)
    	{
    		throw new NullPointerException("pointIterator(): first is null.");
    	}
    	else
    		iterator=first;
    }
    
    /** 
     * moves the iterator up by one node
     * @precondition !offEnd()
     * @throws NullPointerException when precondition is violated
     */
    public void advanceIterator() throws NullPointerException
    {
    	if(offEnd())
    		throw new NullPointerException("advanceIterator(): iterator is off end or null.");
    	else
    		iterator=iterator.next;
    }
    
    /** 
     * moves the iterator down by one node
     * @precondition !offEnd()
     * @postcondition iterator is moved to the previous Node
     */
    public void reverseIterator() throws NullPointerException
    {
    	if(offEnd())
    		throw new NullPointerException("advanceIterator(): iterator is off end or null.");
    	else
    		iterator=iterator.prev;
    }
    
    /**
     * inserts an element after the node currently pointed to by the iterator
     * @precondition iterator!=null
     * @throws NullPointerException when precondition is violated
     * @postcondition new element is add to the right of the iterator
     * @param data
     */
    public void addIterator(T data) throws NullPointerException
    {
    	if(iterator==null)
    		throw new NullPointerException("addIterator: iterator is null.");
    	else if (iterator==last)
    	{
    		addLast(data);
    	}
    	else
    	{
    		Node N=new Node(data);
    		iterator.next.prev=N;
    		N.next=iterator.next;
    		
    		iterator.next=N;
    		N.prev=iterator;
    		length++;
    	}
    }
    
    public void addBeforeIterator(T data) throws NullPointerException
    {
    	if(iterator==null)
    		throw new NullPointerException("addIterator: iterator is null.");
    	else if (iterator==first)
    	{
    		addFirst(data);
    	}
    	else
    	{
    		Node N=new Node(data);
    		iterator.prev.next=N;
    		N.next=iterator;
    		
    		iterator.prev=N;
    		N.prev=iterator.prev;
    		length++;
    	}
    }
    
    /**
     * removes the element currently pointed to by the iterator. Postcondition: Iterator then points to NULL.
     * @precondition iterator!=null
     * @throws NullPointerException when precondition is violated
     * @postcondition iterator==null
     * @param data
     */
    public void removeIterator() throws NullPointerException
    {
    	if(iterator==null)
    		throw new NullPointerException("removeIterator: iterator is null.");
    	else if (iterator==last)
    	{
    		removeLast();
    	}
    	else if (iterator==first)
    	{
    		removeFirst();
    	}
    	else
    	{
    		iterator.prev.next=iterator.next;
    		iterator.next.prev=iterator.prev;
    		length--;
    	}
    	iterator=null;
    }
    
    /**
     * Points the iterator at first
     * and then iteratively advances 
     * it to the specified index
     * @param index the index where
     * the iterator should be placed
     * @precondition 1 <= index <= length
     * @throws IndexOutOfBoundsException
     * when precondition is violated
     */
    public void moveToIndex(int index) throws IndexOutOfBoundsException{
    	
    	if(index<1 || index>this.getLength())
    		throw new IndexOutOfBoundsException("moveToIndex(): index smaller than 1 or larger than length.");
    	pointIterator();
    	for(int i=1;i<index;i++) {
    		advanceIterator();
    	}
        return;
    }
    
    /****ADDITIONAL OPERATIONS****/
    
    /**
     * List with each value separated by a blank space
     * At the end of the List a new line
     * @return the List as a String for display
     */
    @Override public String toString() {
        String result = "";
        Node temp = first;
        while(temp != null) {
            result += temp.data + "\n";
            temp=temp.next;
        }
        result += "\n";
        return result;
    }
    
    public String printNumberedList() {
        String result = "";
        Node temp = first;
    	int number=1;
        while(temp != null) {
            result += "\n"+number+ "." + temp.data+"\n";
            temp=temp.next;
            number++;
        }
        return result;
    }
    
    /**
     * Prints a linked list to the console
     * in reverse by calling the private 
     * recursive helper method printReverse
     */
    public void printReverse() {
    	Node n=last;
    	printReverse(n);
    	return;
    }
    
    /**
     * Prints a linked list to the console
     * recursively (no loop)
     * in reverse order from last to first
     * Each element separated by a space
     * Should print a new line after all
     * elements have been displayed
     */    

    private void printReverse(Node n) {
    	if (n.prev==null) {
    		System.out.println(n.data);
    		return;
    	}
    	System.out.println(n.data+" ");
    	printReverse(n.prev);
    	
        return;
    }     

}