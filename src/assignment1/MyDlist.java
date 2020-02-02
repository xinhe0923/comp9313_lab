package assignment1;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;
import assignment1.DNode;

public class MyDlist extends DList{
	public MyDlist(){
		super();
	}

	
    public MyDlist(String f) throws FileNotFoundException {
    	
         	if(f=="stdin"){
    		
    	    ReadFromInput();
    	    }else{
    	    ReadFromFile(f);
    	    }
    }	
    	    

	
	public void ReadFromInput(){
   //read strings from input
    	Scanner scani=new Scanner(System.in);

    	while(true){
    		
    		String s=scani.nextLine();
    		DNode node=new DNode(s,null,null);
    		if(s.isEmpty()){
    			break;
    		}
    			this.addLast(node);
    		
    		
    	}scani.close();
	}
	
    
//read strings from file
	public void ReadFromFile(String f){
		File file=new File(f);
		Scanner scanf=null;
		try {
			scanf=new Scanner(file);
			}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			while(scanf.hasNext()){
				String sf=scanf.next();
				DNode node=new DNode(sf,null,null);
				this.addLast(node);
			}
			scanf.close();
}

	
//print the element of the list
    public static void printList(MyDlist u){
    	if (u!=null){
    	DNode current=new DNode(null,null,null);
    	current=u.getFirst();
    	while(u.size!=0){
    		if (current.getElement()!=null){
    		System.out.println(current.getElement());
    		current=current.getNext();
    }
   }
    	}
    	else{
    		 System.out.println("fail");
    	}
    }
    	
 //make a new list same as the old one   
    public static MyDlist cloneList(MyDlist u){
       MyDlist cl=new MyDlist();
       DNode current=u.header.next;
       while(true){
    	   if(current!=u.trailer){
    		   DNode node=new DNode(null,null,null);
    		   node.element=current.getElement();
    		   cl.addLast(node);
    		   current=current.next;
    	   }
    	   else{
    		   break;
    	   }
       }return cl;
    		   
    }
    
    //union two lists
    public static MyDlist union(MyDlist u,MyDlist v){
    	if(u.isEmpty())
    		return v;
    	else if(v.isEmpty())
    		return u;
    	else{
    	     MyDlist cl=cloneList(u);
    	     
    	      DNode current=v.header.next;
    	       while(true){
    	    	   if(current!=v.trailer){
    	    		   DNode node=new DNode(null,null,null);
    	    		   node.element=current.getElement();
    	    		   cl.addLast(node);
    	    		   current=current.next;
    	    	   }
    	    	   else{
    	    		   break;
    	    	   }
    	       }
    	
    	     
       	     
    	     
    	     return cl;
}}
    //have the intersection of 2 different lists
  
    /*Analysis=8(n^2)+4n+4
     * time complexity is O(N^2)*/
    public static MyDlist intersection(MyDlist u,MyDlist v){
    	if(u.isEmpty()){
    		return u;}
    	else if(v.isEmpty()){
    		return v;}
    	else{	     
    	DNode currentnode=u.header.next;
    	MyDlist list=new MyDlist();
		DNode node=v.header.next;
/*analysis=4,  3 for assignment and 1 for reference*/
    	while(currentnode!=u.trailer){
              
    		   while(node!=v.trailer){
    			   
    		         if(currentnode.getElement().equals(node.getElement())){
    		        	//if the elements are the same then add it into the list
    		        	 DNode newnode=new DNode(node.getElement(),null,null);
    		        	 list.addLast(newnode);
      		    	     break;
      		    	     }node=node.next;
      		    	     /*analysis of loop=8(n^2)-n^2
      		    	      * 3 for the if loop(2 for reference and a comparison)
      		    	      * 2 for newnode
      		    	      * 1 for adding node to list
      		    	      * 2 for move the node and assignment*/
    			   }
    	currentnode=currentnode.next;	
    	/*analysis=4n*/
    	}
    		   
    		return list;
    		
    		   }}
    


    	
    
  public static void main(String[] args) throws Exception{
    	 
    	   System.out.println("please type some strings, one string each line and an empty line for the end of input:");
    	    /** Create the first doubly linked list
    	    by reading all the strings from the standard input. */
    	    MyDlist firstList = new MyDlist("stdin");
    	    
    	   /** Print all elememts in firstList */
    	    printList(firstList);
    	   
    	   /** Create the second doubly linked list                         
    	    by reading all the strings from the file myfile that contains some strings. */
    	  
    	   /** Replace the argument by the full path name of the text file */  
    	    MyDlist secondList=new MyDlist("/Users/yangxinhe/Desktop/test.txt");
//    	   /** Print all elememts in secondList */                     
    	    printList(secondList);


    	    MyDlist thirdList = cloneList(firstList);

    	   /** Print all elements in thirdList. */
    	    printList(thirdList);
//
//    	  /** Clone secondList */
    	    MyDlist fourthList = cloneList(secondList);
//
//    	   /** Print all elements in fourthList. */
    	    printList(fourthList);
//    	    
//    	   /** Compute the union of firstList and secondList */
    	    MyDlist fifthList = union(firstList,secondList);
//
//    	   /** Print all elements in thirdList. */ 
    	    printList(fifthList); 
//
//    	   /** Compute the intersection of thirdList and fourthList */
    	    MyDlist sixthList = intersection(firstList, secondList);
//
//    	   /** Print all elements in fourthList. */
    	    printList(sixthList);
 }
}