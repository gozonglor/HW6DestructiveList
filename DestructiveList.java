public class DestructiveList<T>
	extends MyLinkedList<T>
{
    private MyLinkedNode<T> head;
    private MyLinkedNode<T> tail;
    private int numElements = 0;

    public DestructiveList(){
        head = new MyLinkedNode<T>(null);
        tail = new MyLinkedNode<T>(null);
        clear();
    }

    public void removeEvery(int number){
        MyLinkedNode<T> currentNode = head.getNext();
        while (currentNode != tail){
            for (int i=0; i <= getSize(); i++){//Go through the entire list
                if ((i % number) == 0){
                MyLinkedNode<T> prevNode = currentNode.getPrev();
                MyLinkedNode<T> nextNode = currentNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
            }

                currentNode = currentNode.getNext();
        }
    }
    }

    public void removeEvery(int number, int startingIndex){
        MyLinkedNode<T> currentNode = head.getNext();
        while (currentNode != tail){ //Cipher through list for our starting index element
            currentNode = currentNode.getNext();
            for (int i=0; i < startingIndex; i++){
                while (currentNode != tail){
                    if (i% number == 0){
                       MyLinkedNode<T> prevNode = currentNode.getPrev(); //Create instances
                       MyLinkedNode<T> nextNode = currentNode.getNext(); //Create instances
                       prevNode.setNext(null); //???I think we're deleting the current node
                       nextNode.setPrev(null);
                       prevNode.setNext(nextNode); //connect the previous node to the next node
                       nextNode.setPrev(prevNode);

            }
        }
    }
        }
    }


    public int getSize(){
        return size();
    }

    public int persistentlyRemoveGroupsOf(int size){
           return 0;
    }

    public void rotate (int groupSize){
        MyLinkedNode<T> currentNode = head.getNext();
        MyLinkedNode<T> nextNode = currentNode.getNext();
        MyLinkedNode<T> prevNode = currentNode.getPrev();
        MyLinkedNode<T> pointerNode = head.getNext();
        int elementsCounter =0;
        while (currentNode != tail){
            elementsCounter++;
            if (elementsCounter == groupSize){
                //current node
                currentNode.setNext(pointerNode);
                pointerNode.setPrev(currentNode);
                pointerNode.getNext().setPrev(pointerNode.getPrev());
                pointerNode.getPrev().setNext(pointerNode.getNext());
                pointerNode.setNext(nextNode);
                nextNode.setPrev(pointerNode);
                currentNode = pointerNode;
                pointerNode = pointerNode.getNext();
                elementsCounter =0;
            }
        }
    }


    public int removeGroupsOf(int size){
        MyLinkedNode<T> currentNode = head.getNext();
        int removedCounter = 0;
        int sameElementsCounter = 1;
           while (tail != currentNode){
                MyLinkedNode<T> prevNode = currentNode.getPrev();
                MyLinkedNode<T> nextNode = currentNode.getNext();
                MyLinkedNode<T> lastNode = head;
                if ((currentNode.getValue()) == (prevNode.getValue())){
                    sameElementsCounter++;
                }

                if ((currentNode.getValue()) != nextNode.getValue()){
                    if (sameElementsCounter >= size){
                        nextNode.setPrev(lastNode);
                        lastNode.setNext(nextNode);
                        removedCounter++;
                        numElements -= sameElementsCounter;
                        currentNode = lastNode;

                    }
                    else{
                      lastNode = currentNode;
                      currentNode = lastNode;

                    }
                    sameElementsCounter = 1;
                }
               currentNode = currentNode.getNext();
    }
        return removedCounter;

    }
}

