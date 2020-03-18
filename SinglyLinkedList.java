class SinglyLinkedList<Item> {


    public int size;
    public Node<Item> head;

    // -----------------------------------------------------------------------------------
    /**
     * ----------------- Helper methods -------------------------------------
     */
    /**
     * Linked list node helper data type
     *
     * @param <Item>
     */
    public static class Node<Item> {

        Node<Item> next = null;
        Item el = null;

        public Node(Item el, Node<Item> next) {

            this.next = next;
            this.el = el;
        }
    }

    public int size() {
        return size;
    }

    // -----------------------------------------------------------------------------------
    /**
     * ----------------- ToDo: methods for you to implement
     * ---------------------------
     *
     */
    // -----------------------------------------------------------------------------------
    /**
     * Constructor of an empty Singly linked list
     *
     */


    public void display() {
        //Node current will point to head
        Node<Item> current =  head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            //Prints each node by incrementing pointer
            System.out.print(current.el + " ");
            current = current.next;
        }
        System.out.println();
    }

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public void addFirst(Item item){
        head = new Node<Item>(item, head);
    }

    public Item get(int index) throws IllegalArgumentException {
        try {
            Node<Item> tmp = head;

            for (int i = 0; i < index; i++) {

                tmp = tmp.next;

            }
            return tmp.el;
        } catch (Exception e) {
            System.out.println("Out of bounds");
        }
        return null;
    }

    /**
     * Method to insert element newElement at specified index in the list
     *
     * @param index where you want to insert new element
     * @param newElement the object of type Item you want to insert
     */
    public void insertAt(int index, Item newElement) throws IllegalArgumentException {

        try {
            if (head == null) {
                addFirst(newElement);
            } else {

                Node<Item> newNode = new Node<Item>(newElement, null);

                Node<Item> tmp = head;

                int size = 0;

                while (tmp != null) {
                    size++;
                    tmp = tmp.next;
                }

                int count = size - (size - index);

                if (count == 0) {

                    addFirst(newElement);

                } else {

                    tmp = head;

                    while (count-- > 1) {
                        tmp = tmp.next;
                    }

                    newNode.next = tmp.next;
                    tmp.next = newNode;

                }
            }
        } catch (Exception e) {
            System.out.println("out of bounds");
        }

    }

    /**
     * Method to remove the element at the specified index from the list
     *

     */

    public void removeAt(int index) throws IllegalArgumentException {

        try {
            Node<Item> tmp = head;

            Node<Item> tmp1 = null;

            if (index == 0) {

                Node<Item> temp = head;
                head = head.next;

            } else {

                for (int i = 0; i < index; i++) {

                    tmp1 = tmp;
                    tmp = tmp.next;
                }

                tmp1.next = tmp.next;

            }

        } catch (Exception e) {
            System.out.println("out of bounds");
        }
    }

    /**
     * Reverse the list
     *
     */

    public void reverse() {
        this.head=reverse(head);
    }

    private Node<Item> reverse(Node<Item> node) {
       try {
           if (head == null || head.next == null)
               return head;

           Node<Item> theNext = head.next;
           head.next = null;

           Node<Item> other = reverse(theNext);
           theNext.next = head;

           return other;
       } catch (Exception e) {
           System.out.println("out of bounds");
       }
       return null;
    }
    public static void main(String[] args) {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        testList.addFirst(4);
        testList.addFirst(3);
        testList.addFirst(2);
        testList.addFirst(1);
        testList.display();




    }
}
