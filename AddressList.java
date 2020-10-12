/**
 * @Author - Colin Ryan
 * @Date - 12/6/2017
 * @Class - ITEC 324
 */

public class AddressList
{
	/**
 This nested, private class represents a node of a singly linked list.
	 */

	public ListNode head;
	public ListNode currentNode;
	private int size = 0;

	private class ListNode
	{
		private String name;
		private String tel; // Telephone number
		private String email;
		private String addr; // Address
		private String dob; // Date of birth
		private ListNode next; // Pointer to the next node

		private ListNode(String name, String tel, String email, String addr, String dob)
		{
			this.name = name;
			this.tel = tel;
			this.email = email;
			this.addr = addr;
			this.dob = dob;
		} // end of the constructor

		public String getName() { return name; }
		public String getTel() { return tel; }
		public String getEmail() { return email; }
		public String getAddr() { return addr; }
		public String getDob() {return dob; }

		public void setName(String name) { this.name = name; }
		public void setTel(String tel) { this.tel = tel; }
		public void setEmail(String email) { this.email = email; }
		public void setAddr(String addr) { this.addr = addr; }
		public void setDob(String dob) { this.dob = dob; }

		public ListNode getNext() 
		{ 
			return next; 
		}
		public void setNext(ListNode link) 
		{
			next = link;
		}
	} 
	public AddressList()
	{
		head = null;
	}
	public boolean isEmpty()
	{
		return head == null;
	}
	//checks if the head node is empty, if it is then it adds it 
	//else it will move the nodes down the line.
	public void addToFront(String name, String tel, String email, String addy, String dob)
	{
		size++;
		if(head == null)
			head = new ListNode(name, tel, email, addy, dob);
		else
		{
			ListNode newNode = new ListNode(name, tel, email, addy, dob);
			ListNode temp = head;
			newNode.setNext(temp);
			head = newNode;
		}
	}
	public void addToBack(String name, String tel, String email, String addy, String dob)
	{
		size++;
		ListNode newNode = new ListNode(name, tel, email, addy, dob);
		if(head.getNext() != null)
		{
			currentNode = head.getNext();
			addToBackHelper(currentNode, newNode);
		}
		else
			head.setNext(newNode);
	}
	private void addToBackHelper(ListNode currentNode, ListNode newNode) 
	{
		if(currentNode.getNext() != null)
			addToBackHelper(currentNode.getNext(), newNode);
		else
			currentNode.setNext(newNode);
	}
	public String toString()
	{
		String list = "";
		if(head != null)
		{
			currentNode = head;
			list = toStringHelper(currentNode, list);
		}
		return list;
	}
	private String toStringHelper(ListNode currentNode2, String list) 
	{
		if(currentNode2.getNext() != null)
		{
			list+= currentNode2.getName() + "\n";
			list+= currentNode2.getTel() + "\n";
			list+= currentNode2.getEmail() + "\n";
			list+= currentNode2.getAddr() + "\n";
			list+= currentNode2.getDob() + "\n\n";
			return toStringHelper(currentNode2.getNext(), list);
		}
		return list;

	}
	public int getSize()
	{
		return size -1;
	}
	public String phoneToName(String name) 
	{
		String output = "";
		if(head != null)
		{
			currentNode = head;
			output = phoneToNameHelper(name, currentNode);
		}
		else
			output = "No Matching Data";
		return output;

	}
	public String phoneToNameHelper(String name, ListNode currentNode) 
	{
		String output = "";
		if(currentNode != null)
		{
			if(currentNode.getName().compareTo(name) == 0)
			{
				output = currentNode.getTel();
				return output;
			}
			return phoneToNameHelper(name, currentNode.getNext());
		}
		return output;
	}
	public String emailToName(String name) 
	{
		String output = "";
		if(head != null)
		{
			currentNode = head;
			output = emailToNameHelper(name, currentNode);
		}
		else
			output = "No Matching Data";
		return output;

	}
	public String emailToNameHelper(String name, ListNode currentNode) 
	{
		String output = "";
		if(currentNode != null)
		{
			if(currentNode.getName().compareTo(name) == 0)
			{
				output = currentNode.getEmail();
				return output;
			}
			return emailToNameHelper(name, currentNode.getNext());
		}
		return output;
	}
	public String nameByPhone(String tel) 
	{
		String output = "";
		if(head != null)
		{
			currentNode = head;
			output = nameByPhoneHelper(tel, currentNode);
		}
		else
			output = "No Matching Data";
		return output;

	}
	public String nameByPhoneHelper(String tel, ListNode currentNode) 
	{
		String output = "";
		if(currentNode != null)
		{
			if(currentNode.getTel().compareTo(tel) == 0)
			{
				output = currentNode.getName();
				return output;
			}
			return nameByPhoneHelper(tel, currentNode.getNext());
		}
		return output;
	}
	public String dobByName(String dob) 
	{
		String output = "";
		if(head != null)
		{
			currentNode = head;
			output = dobHelper(dob, currentNode);
		}
		else
			output = "No Matching Data";
		return output;

	}
	public String dobHelper(String dob, ListNode currentNode) 
	{
		String output = "";
		if(currentNode != null)
		{
			if(currentNode.getName().compareTo(dob) == 0)
			{
				output = currentNode.getDob();
				return output;
			}
			return dobHelper(dob, currentNode.getNext());
		}
		return output;
	}

 
	public void reverseLinkedList() 
	{
		ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
	}







} // end of class AddressList