package mainClasses;
import java.util.Scanner;
/*
 * The purpose of the MyPizzaManager class was to implement and override the
 * methods from the PizzaManager class, which will be the source of the
 * output, when the objects of this class are used and the methods are called
 * through the objects. The adding one Pizza or a random pizza are pretty
 * much the same functionality inside, where One random Pizza object is added
 * in the ArrayList of type Pizza, and the counter keeping track of the
 * Pizzas is incremented by 1. The getNextChar had the purpose of returning
 * the char entered by the user, if the char is a valid one from one of the
 * options. Then, there were 3 quickSort methods, one for the cost, size and
 * calories. There was a usage of the middle method in order to get the pivot
 * point and then inside the quicksort method, check to make sure and sort
 * either sides of the pivot point. Then, there was another method called
 * linearSearch, which checks the days of the parameter and each object in
 * the allPizzas ArrayList and if they are equal, then that object's index is
 * returned. Then, there was another method for removing if a pizza is one
 * day old, which is checked by comparing the day of each of the objects in
 * the allPizzas arrayList to the date given in the super class, or the
 * PizzaManager class. Finally, there was also a method that reversed the
 * whole order of the ArrayList, which represented the reversing of the array
 * . All the protected methods are overridden in this class and are assigned
 * values inside the methods.
 *
 * Author: Madhav Rajkondawar
 *
 * Date: 6/9/19
 */
public class MyPizzaManager extends PizzaManager {

    // saves all the Pizza objects in an ArrayList, which has generics, and
    // gives the abilities to have arrays of type Pizza.
    private ArrayList<Pizza> allPizzas = new ArrayList<Pizza>();
    // variable to keep track of the number of pizzas in the ArrayList above
    int countPizzas = 0;

    /*
     * The purpose of the method was to add one pizza to the arraylist of
     * type Pizza above. This is done so by first making an Object of type
     * Pizza, which would randomly assign cost to Ingredients, and then, this
     * object is added to the ArrayList created above and the counter
     * variable is incremented since one pizza was added.
     *
     * @param none
     */
    protected void addOnePizza()
    {
        // a random Pizza object is created and the values are set randomly
        // inside the constructor of the class
        Pizza onePiz = new Pizza();
        // a random Pizza object created above was added to the ArrayList
        // instance variable, at index countPizzas, which keeps track of the
        // number of pizzas in the ArrayList of Pizzas so far.
        allPizzas.insert(onePiz,countPizzas);
        // counter incremented since one pizza has been added to the ArrayList
        countPizzas++;
    }

    /*
     * The purpose of the getNextChar method was to return the next char that
     * was entered, when the Scanner was used to get the input from the
     * keyboard. If the char given by the user is a valid one, then we return
     * that character, while going through the loop that goes through all
     * the elements in the options array.If the character was not found,
     * then a PizzaException, or RuntimeException, is thrown, indicating
     * that the character is not a valid character.
     *
     * @param none
     */
    protected char getNextChar() {
        char[] options = {'A','a','H','h','E','e','P','p','S','s','C','c','L','l'
                ,'D','d','B','b','R','r','Q','q'};
        // scanner opened to take user input from the their keyboard
        Scanner input = new Scanner(System.in);
        // saves the user's next String's first character, or character at
        // the 0 index, which will then be used to determine whether valid
        // option and if so, will be returned.
        char userChoice = input.next().charAt(0);

        // for loop to go through all the elements in the options array above
        // and if the userChoice is not one of them, then throw a
        // PizzaException after the loop ends, else return the char inside
        // the loop and complete the method return.
        for(int i = 0; i < options.length; i++)
        {
            if(options[i] == userChoice)
            {
                return userChoice;
            }
        }

        // throws a PizzaException if the choice made by the user is not valid
        // and prints a message saying choice is not valid.
        throw new PizzaException("Not a valid choice from list of options!");
    }

    /*
     * The purpose of the method below was to ask the user for an input
     * integer and return that integer. I do so by saving the next Integer
     * given by the user in a local variable and then return that, just to
     * make it look more elegant than simply returning input.nextInt().
     *
     * @param none
     */
    protected int getNextInt() {
        // asks the user for an input and then saves the nextInt in that input
        // in the variable below
        Scanner input = new Scanner(System.in);
        // saves the next integer in the input given by the user in the
        // retVal variable
        int retVal = input.nextInt();

        // returns the next integer given from the user, which is returned below
        return retVal;
    }

    /*
     * The purpose of the method below was to print all the pizzas that are
     * in the ArrayList of type Pizza, we created above. This is done so by
     * using the toString method of the ArrayList class we made, which prints
     * all the elements in the array.
     *
     * @param none
     */
    protected void displayAllPizzas() {
        System.out.println(allPizzas.toString());
    }

    /*
     * The purpose of the method below was to subtract the fraction given by
     * the user from the current fraction. This is done so by first taking
     * input from the user and then asking the user for what fraction they
     * would like to eat, then asking them what index of the Pizza they want
     * to eat. Then, the Fraction is parse into the Integer we need, into the
     * numerator and denominator separators we need. Then, we create a
     * temporary Pizza object that is created really only to represent the
     * object at the specific index specified by the user. Then, we use the
     * eat method in the Pizza class to reduce the Fraction of the particular
     * object Pizza. Then we check to make sure that if the numerator is 0,
     * then we print the message that the Pizza is over and we remove the
     * Pizza Object from our total number of Pizzas and our ArrayList of
     * Pizzas.
     *
     * @param none
     */
    protected void eatSomePizza() {
        // first we take input from the user about what fraction values they
        // want and the index they want to eat the pizza at
        Scanner input = new Scanner(System.in);

        // Asks the user what Fraction of the pizza they want to eat and
        // accordingly that Fraction will be parse to use.
        System.out.println("What fraction of the pizza would you like to eat?");
        String fraction = input.next();

        // asks the user what index they want to eat their pizza at and
        // accordingly saves that location
        System.out.println("What index would you like to eat the pizza at?");
        int index = input.nextInt();

        // splits the String taken above by the /, hence splitting into the
        // numerator and denominator numbers.
        String[] sepFrac = fraction.split("/");
        int num = Integer.parseInt(sepFrac[0]);
        int denom = Integer.parseInt(sepFrac[1]);

        // Object of type Pizza made to be used in the try-catch block below
        // to update the index that the user asked for and instead of
        // directly touching the original object, we take a leash and update
        // through that one instead
        Pizza thisPizza = null;

        if(index < 0 || index >= allPizzas.size())
        {
            throw new PizzaException("Bad index");
        }

        // go into the loop only if there is not Exceptions
        try {
            // casts to type Pizza just be sure, and takes the Object at the
            // particular index specified by the user
            thisPizza = (Pizza)(allPizzas.get(index));

            // uses the eatSomePizza method from the Pizza class, which
            // reduces the original Fraction by the numerator and denominator
            // desired by the input user.
            thisPizza.eatSomePizza(new Fraction(num, denom));
            // reports the Fraction of the Pizza that was just eaten
            System.out.println("Ate " + fraction + " of the pizza.");

            // if the numerator is 0, then state that the Pizza is over and
            // that no more Pizza can be eaten. Removes the one index from
            // the ArrayList and reduces total number of pizzas by 1 to
            // account for the one Pizza that was eaten completely.
            if (thisPizza.getRemainingFraction().getNumerator() == 0) {
                // prints a message saying hte Pizza is all over
                System.out.println("Pizza is all over at index " + index);
                // removes the particular index of the pizza
                allPizzas.remove(index);
                // reduces the total number of pizzas by 1 since 1 was just
                // finished
                countPizzas--;
            } else if(thisPizza.getRemainingFraction().getNumerator() < 0) {
                // if the numerator is less than 0, this means that there was
                // an attempt to eat even beyond when all of the Pizza was
                // eaten.
                try
                {
                    // throw an exception in this case for the case that
                    // since there is no more Pizza to eat, cannot eat more.
                    throw new PizzaException("Impossible to eat more pizza " +
                            "than available at index " + index);
                } catch (PizzaException pExcep) {
                    // prints the Stacktrace if the above try block is not
                    // executed in case something major error happens.
                    pExcep.printStackTrace();
                    System.exit(0);
                }
            } else
            {
                // prints the remaining amount of fraction in the current
                // Pizza object.
                System.out.println("Remaining fraction: " + thisPizza.getRemainingFraction());
                System.out.println();
            }
        } catch (PizzaException pException) {
            // prints the error message if the whole try block is ignored,
            // then this error message will pop and the system will be exited
            // immediatly as follows.
            System.err.println(pException);
            System.exit(0);
        }
    }

    /*
     * The purpose of the method below was to just add a Random Pizza to the
     * ArrayList, which is done rightly by first making a Pizza variable that
     * will make a random Pizza, which is done through the empty Pizza
     * constructor. Then, the arrayList that has all the Objects will save
     * this particular Pizza at the particular index, which would be the
     * counter that is keeping track of the number of pizzas noted so far.
     *
     * @param none
     */
    protected void addRandomPizza() {
        // gets a random pizza by getting one Object of the Pizza class
        Pizza random = new Pizza();
        // adds the newly made variable above to the arrayList we have that
        // stores all the Objects so far
        allPizzas.insert(random, countPizzas);
        // increments the variable by 1, since it represents the number of
        // pizzas so far.
        countPizzas++;
    }

    /*
     * The purpose of the method below was to sort all the Objects of type
     * Pizza in the arrayList by their size, which would mean that their
     * money amount was checked in order to decide whether one was bigger
     * than the other.
     *
     * @param none
     */
    protected void quickSortByPrice() {
        sortByPriceRec(0,allPizzas.size()-1);
    }

    /*
     * The purpose of the method below was to sort the prices recursively by
     * first getting the pivot point of the arrayList and then checking if
     * the start is less than that point, then sort the left side of the
     * ArrayList, else sort the right side of the list, hence eventually
     * sorting both sides of the list.
     *
     * @param int start, int end
     */
    private void sortByPriceRec(int start, int end)
    {
        // get the pivot point by calling the get middle method
        int split = getMiddlePrice(start,end);

        // if the start is less, then sort the left side of the list recursively
        if(start < split)
        {
            sortByPriceRec(start,split-1); // go left recursively
        }

        // if the end is bigger than the split, then we need to sort the
        // right side of the list recursively
        if(end > split)
        {
            sortByPriceRec(split,end); // go right recursively
        }
    }

    /*
     * The purpose of the method below was to return the middle pivot for the
     * method above. This is done so by first assigning a mid value, which
     * is just the cost at the low index, and will be compared to by each
     * index from low to high in the list. The while loop will loop till the
     * size of low and high combined is bigger than 1, and they are changed
     * inside the while loop in order to give a stopping point for the
     * loop. Inside this loop, we check that if the Pizza cost at the
     * specified index is less than the mid, then keep going until that's
     * false and increment the low. Then we check that if the value of the
     * Pizza cost is bigger than the mid, then the high will be decremented
     * since we need to get the truly high values. Then if the low is less
     * than the high, then swap the values at the indexes and then increment
     * low and decrement high. Return the low in the end as the pivot point.
     */
    private int getMiddlePrice(int low, int high)
    {
        // mid is assigned to the first element's money value, which will be
        // compared to each value in the arrayList to find the pivot
        double mid = ((Pizza)(allPizzas.get(low))).getCost().getMoney();

        // loops till the size is bigger than 1
        while(size(low,high) > 1)
        {
            // if the value at the low index in the list is less than the
            // mid, then the low is incremented since they are in the right
            // order
            while(allPizzas.get(low).getCost().getMoney() < mid)
            {
                low++;
            }

            // if the value at the index high is bigger than the mid, then
            // the high variable is decremented, also so that we satisfy the
            // low-high+1 condition in the size method above and give a
            // chance to end the loop
            while(allPizzas.get(high).getCost().getMoney() > mid)
            {
                high--;
            }

            // if the low is less than high, then we need to swap the
            // elements at those indexes, so they are swapped, low is
            // incremented and high is decremented
            if(low <= high)
            {
                allPizzas.swap(low,high);
                low++;
                high--;
            }
        }

        // returns low, which is the pivot point
        return low;
    }

    /*
     * The purpose of the method below was to sort the whole ArrayList so far
     * by the size or the area remaining. The method does so recursively, by
     * callign the sortBySizeRecursive method, which takes input from 0 to
     * the total size-1, and all the work is done in that method, which has
     * explanation above that method.
     *
     * @param none
     */
    protected void quickSortBySize() {
        sortBySizeRecursive(0,allPizzas.size()-1);
    }

    /*
     * The purpose of this method was to first get the pivot point where the
     * arrayList can be sorted on the left and right side. This is done so by
     * first finding the pivot point, then checking that if the start is less
     * than that point, then recursively sort to the left, else we have
     * another condition of if the end is bigger than the split then
     * recursively sort to the right, hence in this fashion sorting the two
     * sides of the split index in the quicksort method.
     *
     * @param int start, int end
     */
    private void sortBySizeRecursive(int start, int end) {
        // the split index will be found using the get middle method to get
        // the pivot point where that point is right but all other elements
        // are not sorted
        int split = getMiddleSize(start,end);

        // recursively sort to the left if the start indeed is less than the
        // split and sorts the left side of the arrayList recursively
        if(start < split)
        {
            sortBySizeRecursive(start,split-1); // sorts recursively to the left
        }

        // recursively sort to the right if the end is bigger than the split
        // index, and now successfully sorting the two sides of the list
        // using quicksort
        if(end > split)
        {
            sortBySizeRecursive(split,end); // sorts recursively to the right
        }
    }

    /*
     * The purpose of the method below was to take the mid variable as the
     * area at the specified index low, and then compare each value in the
     * arraylist to that mid, and increment and decrement low and high
     * accordingly. Then, there is also a check made to see that if the low
     * is indeed less than or equal to high, then swap the elements at the
     * two indexes. Then, the low and high are incremented and decremented
     * respectively. Then, low is returned, which is the pivot point to sort
     * the left and right side of the array.
     *
     * @param int low, int high
     */
    private int getMiddleSize(int low, int high)
    {
        // mid is assigned to the first value in the arrayList, at index low,
        // which will be compared to each value in the list inside the while
        // loop below
        double mid = ((Pizza)(allPizzas.get(low))).getRemainingArea();

        // repeats until the size is bigger than 1
        while(size(low,high) > 1)
        {
            // repeats until the element at the low index is still less than
            // the mid and while true, low is incremented
            while(allPizzas.get(low).getRemainingArea() < mid)
            {
                low++;
            }

            // repeats till the high is bigger than the mid value and for the
            // time that is true, high is decremented
            while(allPizzas.get(high).getRemainingArea() > mid)
            {
                high--;
            }

            // if low is less than high, then swap the elements at the
            // indexes low and high and increment and decrement low and high,
            // to account for the swap.
            if(low <= high)
            {
                allPizzas.swap(low,high);
                low++;
                high--;
            }
        }

        // returns low, which will be the pivot where the array can be sorted
        // on the two sides of the list
        return low;
    }

    /*
     * The purpose of the method below was just to call the recursive sorting
     * calories method below, but given it input parameters, which were just
     * going from 0 to the total size - 1, hence accounting all the
     * elements in the arrayList.
     *
     * @param none
     */
    protected void quickSortByCalories() {
        sortByCaloriesRecursive(0,allPizzas.size()-1);
    }

    /*
     * The purpose of the method below was to use the getMiddle method to get
     * the pivot point, where we can split and sort the two sides of the
     * array. This is done by first getting the middle of list by calling
     * the getMiddleCal method. Then, we check that if start is less than the
     * split, then we sort recursively to the left, else we put another
     * condition which should be true to recursively sort to the right,
     * hence sorting the two sides of the arrayList in quicksort fashion.
     *
     * @param int start, int end
     */
    private void sortByCaloriesRecursive(int start, int end)
    {
        // gets the middle pivot point to sort the two sides on
        int split = getMiddleCal(start,end);

        // if the start is less than split, then we need to recursively sort
        // left
        if(start < split)
        {
            sortByCaloriesRecursive(start,split-1); // sort left recursively
        }

        // if the end is bigger than the split, then we know we need to sort
        // the right side of the list
        if(end > split)
        {
            sortByCaloriesRecursive(split,end); // sort right recursively
        }
    }

    /*
     * The purpose of the method below was to return the middle of the
     * ArrayList, so that it can be used in the method above to sort the
     * whole arrayList. This is done so by chosing a mid point on the array
     * and then we compare it to each element from the start to end inside
     * the while loop, and while doing so, increment and decrement low and
     * high based on the condition fulfilled and return low in the end, which
     * is the index of the middle element where we can sort the arrayList on
     * the two sides.
     *
     * @param int low, int high
     */
    private int getMiddleCal(int low, int high)
    {
        // the mid value is currently set to the Pizza calories at the low
        // index, but since we only need it to compare, we don't really need
        // the middle of list, since its not sorted yet. The variable is set
        // to the calories of the ArrayList at the specified low index, and
        // we get the calories at that index
        int mid = ((allPizzas.get(low))).getCalories();

        // loop will repeat till the size of the array by the specified
        // indexes is bigger than 1
        while(size(low,high) > 1)
        {
            // loop will repeat till the index at low is still less than the
            // mid and while that's true, the low gets incremented to go
            // through all the elements in the array
            while(allPizzas.get((low)).getCalories() < mid)
            {
                low++;
            }

            // loop repeats till the high value still is greater than the
            // calories at mid, which will decrement the high variable, since
            // we want to reduce to all the elements that truly are bigger
            // than the mid we chose
            while(allPizzas.get((high)).getCalories() > mid)
            {
                high--;
            }

            // if the low is less than the high, then swap them and increment
            // low and decrement high, since we swapped once and need to
            // account for that
            if(low <= high)
            {
                allPizzas.swap(low,high);
                low++;
                high--;
            }
        }

        // returns the low
        return low;
    }

    /*
     * The purpose of size method was to return the total size of the
     * interval we are sorting, which would be the end - the start, which in
     * our case would be the high-low, and the +1 is so that we don't have
     * the size as 0, since if the low and high are both 0, then it means
     * that 1 element is to be compared, so the size method below should not
     * return 0, so the +1 is added to the difference.
     *
     * @param int low, int high
     */
    private int size(int low, int high)
    {
        return (high-low)+1;
    }

    /*
     * The purpose of the binarySearchByCalories method was to first sort the
     * whole ArrayList, then go through all the elements and look for the
     * parameter calories given and if true, then return the index at which
     * the above is true.
     *
     * @param int cals
     */
    protected int binarySearchByCalories(int cals)
    {
        // sorts the whole arrayList in order first
        quickSortByCalories();

        // takes the low to be the first index
        int low = 0;
        // high will be the last index
        int high = allPizzas.size()-1;

        // mid will be the main return value, the index at which the
        // condition is true
        int mid;

        // loops till the low is still less than high
        while(low <= high)
        {
            // mid is the middle of the arrayList, since now assuming that
            // the arrayList is properly been sorted
            mid = (low+high)/2;

            // if the Pizza at the mid value is less than the cals, then we
            // need to check the right side of the list, so low becomes the
            // mid+1
            if(allPizzas.get(mid).getCalories() < cals)
            {
                low = mid+1;
            }
            // if the Pizza at the mid value is equal to the cals, then
            // return the mid and I just printed the mid too, to check if the
            // right value is printed.
            else if(allPizzas.get(mid).getCalories() == cals)
            {
                System.out.println(mid);
                return mid;
            }
            // if the Pizza's calories at the specified index is greater than
            // the parameter value, then we need to check the left side of
            // the list, so high becomes mid-1
            else if(allPizzas.get(mid).getCalories() > cals)
            {
                high = mid-1;
            }
        }

        // if there was nothing returned inside the while loop above, then
        // just throw an exception that Pizza was that specified calories
        // doesn't exist
        throw new PizzaException("Pizza with " + cals + " cals doesn't exist " +
                "in our list!");
    }

    /*
     * The purpose of the method below was to go through all the elements of
     * the ArrayList and if there is a day where the Pizza at the particular
     * index has a day that is equal to the day specified by the user, then
     * print that the specific Pizza was made on that particular day. If
     * there were no pizzas made on that day, then knowing that there was no
     * return value indicates there were no pizzas made on that day, so that
     * message will be printed outside the loop and -1 is returned.
     *
     * @param int day
     */
    protected int linearSearchByDay(int day) {
        // loops through all the elements in the ArrayList
        for(int i = 0; i < countPizzas; i++)
        {
            // if the Pizza at the specified index has a day equal to the
            // parameter day, then print that the Pizza was made on that
            // parameter day, and return the index at which this is true.
            if(allPizzas.get(i).getMadeDate().getDay() == day)
            {
                System.out.println(allPizzas.get(i) + " was made on " + day + "day.");
                return i;
            }
        }

        // if no pizzas were made on the parameter day, then the below will
        // be printed and return -1 as a result.
        System.out.println("No pizzas were made on the desired day!");
        return -1;
    }

    /*
     * The purpose of the method below was to get rid of Pizzas that have
     * made dates 1 day or more compared to the current date, which is gotten
     * from the Pizza manager class. for that, first there is a for loop
     * which goes through all the elements so far, or the countPizzas, and
     * inside the loop, we have an if loop which states that if the different
     * between the current date's day and the day of the Pizza at the
     * particular index is bigger than 1, then there is print that the pizza
     * will be removed now, the Pizza object is removed from the ArrayList,
     * and the total number of pizzas counter is decremented. If there are no
     * pizzas to remove, then the loop will be complete and there is a
     * println outside the loop, saying that there were no pizzas to remove.
     *
     * @param none
     */
    protected void removeDayOldPizzas() {
        // loops through all the elements added to the arrayList so far
        for(int i = 0; i < countPizzas; i++)
        {
            // if the Pizza at the specified index's day minus the current
            // date day is bigger than 1, then the Pizza is more than a day
            // old, so should be removed.  and the Pizza at the specified index will be removed.
            if((allPizzas.get(i).getMadeDate().getDay()-super.getCurrentDate().getDay()) >= 1)
            {
                // the object at the particular index is removed on the step
                // below
                allPizzas.remove(i);
                // The arrayList counter will be
                // reduced by 1,
                countPizzas--;
            }
        }

        // if the current date's day is at least a day older than the
        // Pizza in the ArrayList, then the pizza should be thrown out, so
        // the appropriate message is printed below
        System.out.println("All pizzas, if any, that were a day old were " +
                "successfully removed!");
    }

    /*
     * The purpose of the method below was to reverse the order of the
     * current ArrayList created above, which basically means converting the
     * List above into a Stack. This is done so by first creating a temporary
     * ArrayList of type Pizza, which will be used to save the current order
     * of the pizzas in the current ArrayList above, in the reverse order.
     * Then, there is a for loop created which will loop over the total size
     * of the arrayList above. Inside the loop, each index in the stack Array
     * will set to the last index of the original array, then the second last
     * and so on. This is looped until the original array above is fully
     * gone through, and then the temporary array is set to the original
     * array, since we want to permanently reverse the order of the array.
     *
     * @param none
     */
    protected void reversePizzasWithStack() {
        // made a temporary arrayList to store all the Pizzas that we will be
        // saving in Stack order
        ArrayList<Pizza> tempList = new ArrayList<Pizza>();

        // loop repeats for the total size of the ArrayList, to get all the
        // elements
        for(int i = 0; i < allPizzas.size(); i++)
        {
            // adds the element at index ArrayList above at the size
            // of that - (1+i), which means that it will be the last, the
            // second last, the third last element of the ArrayList and these
            // will be added in the normal order 0,1,2 in the ArrayList,
            // hence adding all the Pizzas in the reverse order.
            tempList.insert(allPizzas.get(allPizzas.size()-(1+i)),i);
        }

        // sets the current ArrayList to the new reverse ordered ArrayList.
        allPizzas = tempList;
    }
}