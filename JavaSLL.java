
class node
{
	public int data;
	public node next;

	public node(int someVal)
	{
		data = someVal;
		next = null;
	}
}

class SinglyLL
{
	private node first;
	private int count;

	public SinglyLL()
	{
		this.first = null;
		this.count = 0;
	}

	public void Display()
	{
		node tempNode = first;

		while (tempNode != null)
		{
			System.out.print(tempNode.data + "\t");

			tempNode = tempNode.next;
		}

		System.out.println();
	}

	public void InsertAtFirst(int someVal)
	{

		node tempNode = new node(someVal);

		tempNode.next = first;

		first = tempNode;

		count++;

	}

	public void InserAtLast(int someVal)
	{
		if(first == null)
		{
			first = new node(someVal);

			count++;
			
			return;
		}

		node tempNode = first;

		while (tempNode.next != null)
		{
			tempNode = tempNode.next;
		}

		tempNode.next = new node(someVal);

		count++;

	}

	void InserAtPos(int someVal,int somePos)
	{
		int tempVal = 0;
		node tempNode = first;
		node dummyNode = null;

		if(somePos > count+1 || somePos < 1)
		{
			System.out.println("Invalid Position");
			return;
		}
		else if(somePos == 1)
		{
			InsertAtFirst(someVal);
		}
		else if(somePos == count+1)
		{
			InserAtLast(someVal);
		}
		else
		{
			while (tempVal < (somePos - 2))
			{
				tempVal++;
				tempNode = tempNode.next;
			}

			dummyNode = new node(someVal);

			dummyNode.next = tempNode.next;

			tempNode.next = dummyNode;

			count++;
		}
	}

	void DeleteFirst()
	{

		if(first == null)
		{
			return;
		}
		else if(first.next == null)
		{
			first = null;
			count--;
		}
		else
		{
			first = first.next;
			count--;
		}
	}

	void DeleteLast()
	{

		node tempNode = first;

		if(first == null)
		{
			return;
		}
		else if(first.next == null)
		{
			first = null;
			count--;
		}
		else
		{
			while (tempNode.next.next != null)
			{
				tempNode = tempNode.next;	
			}

			tempNode.next = null;

			count--;
		}
	}

	void DeleteAtPos(int somePos)
	{
		int tempVal = 0;
		node tempNode = first;

		if(somePos > count || somePos < 1)
		{
			System.out.println("Invalid Position");
			return;
		}
		else if(somePos == 1)
		{
			DeleteFirst();
		}
		else if(somePos == count)
		{
			DeleteLast();
		}
		else
		{
			while (tempVal < (somePos - 2))
			{
				tempVal++;
				tempNode = tempNode.next;
			}

			tempNode.next = tempNode.next.next;

			count--;
		}
	}

	int Count()
	{
		return count;
	}
}