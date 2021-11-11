public class SinglyLinkedList
{
	Node head;
	
	public SinglyLinkedList()
	{
		head=null;
	}
	
	public String toString()
	{
		if(head==null)
			return "[]";
		
		else{
			String list="";
			Node ptr=head;
			while(ptr.link!=null)
			{
			  list=list+ptr.data+","+" ";
              ptr=ptr.link;			  
			}	
			list=list+ptr.data;
		 return "["+list+"]";
		}
	}
	
	
	private class Node
	{
		String data;
		Node link;
		
		public Node()
		{
			data=null;
			link=null;
		}
	}
	
	void insertLast(String value)
	{
		Node node=this.new Node();
		node.data=value;
		
		if(head==null)
		{
			node.link=null;
			head=node;
		}
			
		else{
			Node ptr=head;
			
			while(ptr.link!=null)
			{
				ptr=ptr.link;
			}
			ptr.link=node;
			node.link=null;
		}
	}
	
	void insertFirst(String value)
	{
		Node node=this.new Node();
		node.data=value;
		
		node.link=head;
		head=node;
	}
	
	void insert(int position,String value)
	{
		Node node=this.new Node();
		node.data=value;
		
		if(position==1)
		{
			node.link=head;
			head=node;
		}
		
		else{
			Node ptr=head;
			for(int i=1;i<position-1;i++)
		    {
			 ptr=ptr.link;
		    }
					
	     	node.link=ptr.link;
		    ptr.link=node;
		}
	}
	
	String deleteLast()
	{
		if(head==null)
		{
		 class EmptyList extends NullPointerException
		   {
			EmptyList(String massage)
			 {
				super(massage);
			 }
		   }
			throw new EmptyList("List is Empty");
		}
       else if(head.link==null)
	   { 
          String value=head.data;
	     head=null;
         return value;		 
	   }
		else{
			Node ptr=head;
			while(ptr.link.link!=null)
			{
				ptr=ptr.link;			
				
			}
				
			String value=ptr.link.data;
		    ptr.link=null;
		  
         return value;		  
		}
   }
   
   String deleteFirst()
   {
	 if(head==null)
         throw new NullPointerException("List is empty");
	 else{
		 String value=head.data;
		 head=head.link;
		 
		 return value;
	 }
   }
   
   String delete(int position)
   {
	   if(position==1)
	   {
		  String value=deleteFirst();
          return value;		  
	   }
		  
	   else{
	    Node ptr=head;
	    for(int i=1;i<position-1;i++)
	     {
			if(ptr.link==null)
			  throw new NullPointerException("there is no element");
		   ptr=ptr.link;
	     }
		 String value=ptr.link.data;
		 ptr.link=ptr.link.link;
		 
		 return value;
	   }
   }
   
   boolean search(String value)
   {
	   Node ptr=head;
	   while(ptr.link!=null)
	   {
		   ptr=ptr.link;
		   if(ptr.data==value)
		   {
			 return true;
		   }

	   }
	   return false;
   }
}