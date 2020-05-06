package mainClasses;
/*
 * The purpose of this class was to allow the user to use the methods in the
 * class to add or remove Objects from the object's class, which has an array
 * of type Object. There are multiple methods in the class like add at
 * particular index for adding, remove for removing, shift right and
 * left since both are used respectively for add and remove methods. Size for
 * the number of elements, toString() to print appropriate message and .equals()
 * for compare two arrayList, the parameter one caste after passing appropriate
 * conditions inside the method. indexOf is there to check if there is the
 * appropriate character in the array and isEmpty() checks whether the number
 * of elements are 0.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class ArrayList<TBA extends Comparable> {
    // starts the array with size of 100 and then the size will be increased
    // as needed using the double size array.
    private Object[] arrayList = new Object[100];
    // number of elements starts at 0 and then will be incremented when the
    // add method is used.
    private int numElements = 0;

    public static void main(String[] args)
    {
        ArrayList a = new ArrayList();
        a.insert("d",0);
        a.insert("g",1);
        a.insert("o",1);
        a.insert("g",2);
        a.insert("e",4);
        a.insert("i",4);
        a.insert("e",2);
        a.remove(2);
        System.out.println(a.indexOf("i"));
        System.out.println(a.toString());
    }

    /*
     * The purpose of the method was to first make sure that the object given
     * in the parameter is not invalid, in the sense that the Object is not
     * null and is an instance of the ArrayList class. Then, if it is, then
     * the Object is cast to be of type ArrayList. Then, if the numElements
     * of this ArrayList is equal to that parameter's numElements, then
     * return 0, else if this class's numElements is bigger than that, then
     * returns 1, else returns -1.
     *
     * @param Object other
     */
    public int compareTo(Object other)
    {
        // makes sure the Object is valid and is an instance, else throws a
        // RuntimeException
        if(other == null || !(other instanceof ArrayList))
        {
            throw new RuntimeException("Bad Object!");
        }

        // now that the object is valid, cast the object to be of type ArrayList
        ArrayList that = (ArrayList)(other);

        // if the numElements for both are equal then return 0, indicating
        // they are equal
        if(this.numElements == that.numElements)
        {
            return 0;
        }
        // if the numElements for this class is bigger than the parameter's
        // numElements, then return 1, indicating this class has bigger
        // numElements
        else if(this.numElements > that.numElements)
        {
            return 1;
        }
        // returns -1 in all other cases, meaning that this class will be
        // less than the parameter class.
        else
        {
            return -1;
        }
    }

    /*
     * First checks to make sure the index is valid, but if not, then prints
     * an error message. If the index is valid, then a check is made to be
     * sure that the length of the array is not full and if so, then the size
     * of the array is doubled. Then, the number of elements variable is
     * incremented since one extra object is being added. Then, the shift
     * right method is called, which shifts all the elements from the index
     * till the end of the array to the right.
     *
     * @param TBA ob, int index
     */
    public void insert(TBA newObj, int index)
    {
        //the condition here is that if an index of 5 is given when there is
        // only 1 spot filled in the array, then the object will not be added
        // . Also if the index is less than 0, then also the message prints
        // that the index is out of bounds. if not, then goes on to the else
        // statement, where first the size of the array is checked and then
        // if needed, doubles the size of the array. then, the shiftRight()
        // method is called and then value of the object is saved at the
        // particular index.
        if(newObj == null)
        {
            throw new RuntimeException("Invalid object!");
        }
        else if(index > numElements || index < 0)
        {
            throw new RuntimeException("Index out of bounds!");
        }
        else {
            //if the array size is not enough to fit all the Objects, then it
            // is doubled inside the if statement if the statement is fulfilled.
            if (numElements == arrayList.length)
            {
                doubleArraySize();
            }
            //increments since one more element is added
            numElements++;
            //shifts right from the particular index to the end
            shiftRight(index);
            //sets the object at the particular index to the object given in
            // the parameter
            arrayList[index] = newObj;
        }
    }

    /*
     * The purpose of this method was to shift all the elements from the end
     * that was taken as a parameter to the number of elements - 2, since we
     * will be using i+1, so to avoid out of bounds error, we have to do num
     * elements - 2, in this case, to get upto the last digit. We will set
     * the object value at i+1 to the value at i, since we are shifting all
     * the values to the right. After doing this, the object value at the
     * particular index will be set to the desired object in the above add
     * method, now that the array has been shifted to the right.
     *
     * @param int end
     */
    private void shiftRight(int end)
    {
        //shifts each element to the right by 1, meaning that the current
        // element will be set as the value of the previous element, shifting
        // the whole array to the right by 1, this loop repeating from the
        // index given by the user to the end of the number of elements in
        // the array.
        for(int i = numElements-1-1; i >= end; i--)
        {
            //sets the next element equal to the current element
            arrayList[i+1] = arrayList[i];
        }
    }

    /*
     * The purpose of the array was to double the array size, and its private
     * because its never used by other methods outside the class.
     *
     * @param none
     */
    private void doubleArraySize()
    {
        Object[] tempArray = new Object[arrayList.length*2];
        for(int count = 0; count < arrayList.length; count++)
        {
            tempArray[count] = arrayList[count];
        }
        arrayList = tempArray;
    }

    /*
     * First there is an if loop that checks to see if the index is greater
     * returns the object at the particular index, which first gets saved in
     * a variable and then the number of elements variable is reduced by one
     * since we are removing at that particular index. then, the object saved
     * before shifting left is returned, since the number of elements was
     * reduced by 1 after shifting all the elements.
     *
     * @param int index
     */
    public TBA remove(int index)
    {
        //number of elements is one more than the index of the array, so if
        // the index is equal to the number of elements, it means the number
        // is one more than the index of the last element, so out of bounds
        // should be printed. Likewise, if index is less than 0, then same
        // error should be printed. Else, go on to save the current object at
        // the particular index that will be removed, shift the array from
        // that index till the end, reduce number of elements by 1, and then
        // return the object that was removed.
        if(index >= numElements || index < 0)
        {
            throw new RuntimeException("Out of bounds! Index doesn't exist!");
        }
        else
        {
            //saves the object that will be removed here, since the array is
            // going to be shifted to the left soon, so we want to save the
            // original value at the index before it is shifted.
            TBA obRemoved = (TBA)(arrayList[index]);
            shiftLeft(index);
            // might need this here: arrayList[numElements] = null;
            numElements--;
            return obRemoved;
        }
    }

    /*
     * The purpose of this method was to shift all the elements from the
     * position given by the user which is to be removed, to the end of the
     * number of elements filled in the array, where the value at the current
     * index will be set equal to the value at the next index.
     *
     * @param int index
     */
    private void shiftLeft(int index)
    {
        //repeats from the index given to the number of elements - 1, since
        // we only want that portion of the values shifted, since at that
        // index is where the new value being basically replaced, and then
        // the number of elements decreases by 1, since the last value in the
        // array before the for loop is now the second last value, so the
        // number of elements can be reduced by 1, and still have all the
        // elements intact.
        for(int i = index; i < numElements-1; i++)
        {
            //current element is set equal to the next element, hence moving
            // left
            arrayList[i] = arrayList[i+1];
        }
    }

    /*
     * returns the number of elements in the array.
     *
     * @param none
     */
    public int size()
    {
        return numElements;
    }

    /*
     * The purpose of the swap method was to swap the element in the array at
     * idx1 with idx2. This cannot be done by just simply assigning the
     * element at the first index with the second index, since the value
     * will be changed permanently, so the use of a temporary variable is
     * done. First, the variable temp is made. Then, the temp is assigned to
     * the element at idx1. Then, the element at idx1 in the array is
     * assigned to the element at idx2, keeping in mind that the element at
     * idx1 is saved in temp. Then, the element at idx2 is assigned to temp,
     * which was the original element at idx1, hence swapping the current and
     * the next elements at the first and second index.
     *
     * @param int[] data, int idx1, int idx2
     */
    public void swap(int idx1, int idx2)
    {
        // temp variable made to temporarily store the element at idx1, which
        // will later be used to assign as the element value at idx2.
        TBA temp = (TBA)arrayList[idx1];
        // element at idx1 is set to the element at idx2, hence the first
        // element taking the value of the second element.
        arrayList[idx1] = arrayList[idx2];
        // now, since the first element was saved in temp, it can be set as
        // the new element value at idx2, hence successfully swapping the
        // current and next element.
        arrayList[idx2] = temp;
    }

    public TBA get(int index)
    {
        if(index > numElements)
        {
            throw new RuntimeException("Bad index!");
        }
        return (TBA)arrayList[index];
    }

    /*
     * prints each element in the Object array, so far, if the user intends
     * to add or remove arrayList from the array.
     *
     * @param none
     */
    @Override
    public String toString()
    {
        //String variable which saves all the Objects from the Objects array
        // through the for loop
        String allObjects = "";
        for(int i = 0; i < numElements; i++)
        {
            //saves all the arrayList in the String
            allObjects += (TBA)arrayList[i] + " ";
        }
        //returns the String which has saved all the Objects using String
        // concatenation above
        return allObjects;
    }

    /*
     * returns number of elements variable numElements is equal to 0
     * condition, which means that if the number of elements are 0, then that
     * means the array is empty, so the condition returns true, and then the
     * method returns true consequently, else the method will return false
     * meaning the array is not empty.
     *
     * @param none
     */
    public boolean isEmpty()
    {
        return (numElements == 0);
    }

    /*
     * compares each object in the instance array to the object in the
     * parameter to check if any of them match and if they do, then returns
     * the index there, which would be i, since i goes through all the
     * elements in the array, one at a time.
     *
     * @param Object ob
     */
    public int indexOf(Object newObj)
    {
        for(int i = 0; i < numElements; i++)
        {
            //if the value at the current index i is equal to the object in
            // the parameter, then return the current index, which would be
            // the current i value during the for loop.
            if(arrayList[i].equals(newObj))
            {
                return i;
            }
        }
        //if the index isn't found, then returns -1, indicating that Object
        // doesn't exist in this class's array
        return -1;
    }

    /*
     * First checks to make sure the Object in the parameter is not null or
     * is an instance of, but if either are false, then returns false. Then,
     * the object is caste to the Stack object, and the size and object
     * arrays are checked through each index of each, and if the values of both
     * are the same, then the method returns true else returns false.
     *
     * @param Object ob
     */
    @Override
    public boolean equals(Object newObj)
    {
        //first checks if the object in the parameter is null or if its not
        // an instance of the current class, then returns false.
        if((TBA)(newObj) == null || !((TBA)(newObj) instanceof ArrayList))
        {
            return false;
        }
        //casts to ArrayList type
        ArrayList other = (ArrayList)(TBA)(newObj);

        //checks if the number of elements for both are not equal, then
        // returns false.
        if(this.numElements != other.numElements) {
            return false;
        }
        //checks each element in the array for each class and if any of the
        // Objects at any index are not equal, then returns false.
        for(int i = 0; i < this.numElements; i++) {
            if((TBA)this.arrayList[i] != (TBA)other.arrayList[i]) {
                return false;
            }
        }
        return true;
    }
}