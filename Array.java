public class Array 
{
   String array[]; //this is the array which is initialized after creating an object of Array class. 
   int length;  //it store the capacity(how many element can be stored this array) of array.
   int size=0; //it store  how many element present in this array 

//Constructor..........here we recieve the size of array and create an String type array.
   Array(int length)
    {
      this.array=new String[length]; //initialization of array
      this.length=length; //passing the length of array.
    }

// Overriding the toString method of Object class    
    public String toString()
    {
      String printarray="";//here declared a local variable for margin the array element
      
	  for(int i=0;i<size;i++) // if the number of size is greater than zero(0), then it will execute. 
         {
            if(i==size-1) //if only a element is present ,then it will execute
                printarray+=array[i];
            else   //if more than one element is present, then it will execute.  
                printarray+=array[i]+", ";     
         }
      return "[" +printarray+"]";
    }

//to get an specific index element from array
    String getElement(int index)
     {
      return array[index];
     }

//to insert an element in array

    void insert(String value)
     {
	    if(size>=length)
           throw new ArrayIndexOutOfBoundsException("index is bigger than array length");
	   
       array[size]=value;
       size++;
     }

    void insert(int index,String value)
      {
        if(index==size)
         {
           array[index]=value;
           size++;
         }

        else if(index<size)
         {
           for(int i=size-1;i>=index;i--)
            {
             array[i+1]=array[i];
            }
			
           array[index]=value;
           size++;
         }
		 
	    else if(index>=length)
		  throw new ArrayIndexOutOfBoundsException("index is bigger than array length");
        
		else
         {
           throw new IndexOutOfBoundsException("index is bigger than array size");
         }

          
      }


 //delete an element from array
     void delete()
       {
		 if(size==0)
            throw new ArrayIndexOutOfBoundsException("No element is present in this array");	
		
         array[size-1]=null;
         size--;
       } 

//delete a spacific element from an array
     void delete(int index)
       {
        if(index==size-1)
          {
            array[index]=null;
            size--;
          }

        else if(index<size-1)
         {
            array[index]=null;
            for(int i=index;i<size;i++)
             {
               array[index]=array[index+1];
               size--;
             }
         } 

        else
          {
            throw new NullPointerException("There is no element");
          }
       }
//search an element from an element
     int search(String element)
      {
       for(int i=0;i<size-1;i++)
        {
          if(array[i]==element)
            return i;
        }
        return -1;
      }  

//update an element of spacific index
   boolean update(int index,String value)
     {
       if(index<size)
         {
           array[index]=value;
           return true;
         }
       else
         {
           return false;
         }
          
     }
}


