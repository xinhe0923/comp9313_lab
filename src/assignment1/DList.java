package assignment1;

public class DList {
	 protected int size;			// number of elements
	  protected DNode header, trailer;	// sentinels

	  /** Constructor that creates an empty list */
	  public DList() { 
	    size = 0;
	    header = new DNode(null, null, null);	// create header
	    trailer = new DNode(null, header, null);	// create trailer
	    header.setNext(trailer);	// make header and trailer point to each other
	  }
	  /** Returns the number of elements in the list */
	  public int size() { return size; }

	  /** Returns whether the list is empty */
	  public boolean isEmpty() { return (size == 0); }

	  /** Returns the first node of the list */
	  public DNode getFirst() throws IllegalStateException {
	    if (isEmpty()) throw new IllegalStateException("List is empty");
	    return header.getNext();
	  }
	  /** Returns the last node of the list */
	  public DNode getLast() throws IllegalStateException {
	    if (isEmpty()) throw new IllegalStateException("List is empty");
	    return trailer.getPrev();
	    }
	  
	  
	  public DNode getPrev(DNode v) throws IllegalArgumentException {
		    if (v == header) throw new IllegalArgumentException
		      ("Cannot move back past the header of the list");
		    return v.getPrev();
		  }
		  
	  
	  public DNode getNext(DNode v) throws IllegalArgumentException {
		    if (v == trailer) throw new IllegalArgumentException
		      ("Cannot move forward past the trailer of the list");
		   return v.getNext();
		  }
		 

	  public void addBefore(DNode v, DNode z) throws IllegalArgumentException {
		   DNode u = getPrev(v);	// may throw an IllegalArgumentException
		   z.setPrev(u);
		   z.setNext(v);
		   v.setPrev(z);
		   u.setNext(z);
		   size++;
		 }
		

	  public void addAfter(DNode v, DNode z) {
		   DNode w = getNext(v);	// may throw an IllegalArgumentException
		   z.setPrev(v);
		   z.setNext(w);
		   w.setPrev(z);
		   v.setNext(z);
		   size++;
		 }
		
	  public void addFirst(DNode v) {
		   addAfter(header, v);
		 }

	  public void addLast(DNode v) {
		   addBefore(trailer, v);
		 }
		 
      public void remove(DNode v) {
		   DNode u = getPrev(v);	// may throw an IllegalArgumentException
		   DNode w = getNext(v);	// may throw an IllegalArgumentException
		   // unlink the node from the list 
		   w.setPrev(u);
		   u.setNext(w);
		   v.setPrev(null);
		   v.setNext(null);
		   size--;
		 }

	  public boolean hasPrev(DNode v) { return v != header; }

	  public boolean hasNext(DNode v) { return v != trailer; }

	  public String toString() {
		   String s = "[";
		   DNode v = header.getNext();
		   while (v != trailer) {
		     s += v.getElement();
		     v = v.getNext();
		     if (v != trailer)
			s += ",";
		   }
		   s += "]";
		   return s;
		}
	}