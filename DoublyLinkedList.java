public class DoublyLinkedList
{
  Node head;
  
  DoublyLinkedList()
  {
	  head=null;
  }
  private class Node
  {
	  String data;
	  Node prev;
	  Node next;
	  
	  Node()
	  {
		  data=null;
		  prev=null;
		  next=null;
	  }
  }
  
  public String toString()
  {
	  if(head==null)
		  return "[]";
	  else{
		  String list="";
		  Node ptr=head;
		  
		  while(ptr.next!=null)
		  {
			 list=list+ptr.data+", ";
			 ptr=ptr.next;
		  }
		  list=list+ptr.data;
		  
		  return "["+list+"]";
	  }
  }
  
  void insertLast(String value)
  {
	  Node node=this.new Node();
	  node.data=value;
	  if(head==null)
	  {
		  head=node;
		  node.prev=null;
		  node.next=null;
	  }
	  else if(head.next==null)
	  {
		  head.next=node;
		  node.prev=head;
		  node.next=null;
	  }
	  else{
		  Node ptr=head;
		  while(ptr.next!=null)
		  {
			  ptr=ptr.next;
		  }
		  
		  ptr.next=node;
		  node.prev=ptr.prev.next;
		  node.next=null;
	  }
		  
  }
  
  void insertFirst(String value)
  {
	 Node node=this.new Node();
     node.data=value;
     
     if(head==null)
	 {
		 head=node;
		 node.prev=null;
		 node.next=null;
	 }
	 
	 else{
		 node.next=head;
		 node.prev=null;
		 head.prev=node;
		 head=node;
	 }
  }
  
  void insert(int position,String value)
  {
	  if(position==1)
		  insertFirst(value);
	  else
	  {
		  Node node=this.new Node();
	      node.data=value;
		  
		  Node ptr=head;
		  for(int i=1;i<position-1;i++)
		  {
			  if(ptr==null)
			    throw new NullPointerException("cannot insert in this position");
			 ptr=ptr.next; 
		  }
		  if(ptr.next==null)
		  {
			 ptr.next=node;
             node.prev=ptr;
             node.next=null;			 
		  }
		  else{
			  node.prev=ptr;
			  node.next=ptr.next;
			  ptr.next.prev=node;
			  ptr.next= node; 
		  }
		  
	  }
  }
  
  String deleteFirst()
  {
	  if(head==null)
		  throw new NullPointerException("List is empty");
	  else{
		  String value=head.data;
		  head.next.prev=null;
		  head=head.next;
		  return value;
	  }
  }
  
  String deleteLast()
  {
	  if(head==null)
		  throw new NullPointerException("list is empty");
	  else if(head.next==null)
	  {
		  String value=head.data;
		  head=null;
		  
		  return value;
	  }
	  else{
		  Node ptr=head;
		  while(ptr.next.next!=null)
			  ptr=ptr.next;
		  String value=ptr.next.data;
		  ptr.next=null;
		  
		  return value;
	  }
  }
  
  String delete(int position)
  {
	  if(head==null)
		  throw new NullPointerException("list is empty");
	 else if(position==1)
	  {
		  String value=deleteFirst();
		  
		  return value;
	  }
	  else{
		  Node ptr=head;
		  
		  for(int i=1;i<position-1;i++)
		  {
			  if(ptr.next==null)
			  {
				  throw new NullPointerException("There is no element in this position");
			  }
			  ptr=ptr.next;
		  }
		  String value=ptr.next.data;
		  ptr.next=ptr.next.next;
		  ptr.next.prev=ptr;
		  
		  return value;
	  }
  }
  boolean search(String value)
  {
	  if(head!=null)
	  {
	    Node ptr=head;
		while(ptr!=null)
		{
			if(ptr.data==value)
				return true;
			ptr=ptr.next;
		}
		  
	  }
	 
	  return false;
  }
}