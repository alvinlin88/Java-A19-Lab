import java.util.*;

/**
 *Class to test out different sorting algorithms
 *
 * @author     Alvin Lin
 * period     #3
 */
public class Sorts {
    private long steps;

    /**
     * Creats new sort object with steps set to 0
     *
     */
    public Sorts() {
        steps = 0;
    }

    /**
     * Sorts list using the bubbleSort Algorithm
     *
     * @param list reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList<Comparable> list) {
        steps = 0;
        for (int outer = 0; outer < list.size() - 1; outer++) {
            for (int inner = 0; inner < list.size() - outer - 1; inner++) {
                steps += 3;// count one compare and 2 gets
                if (list.get(inner).compareTo(list.get(inner + 1)) > 0) {
                    steps += 4;// count 2 gets and 2 sets
                    // swap list[inner] & list[inner+1]
                    Comparable temp = list.get(inner);
                    list.set(inner, list.get(inner + 1));
                    list.set(inner + 1, temp);
                }
            }
        }
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
    }

    /**
     * Sort list using the selectionSort algorithm
     *
     * @param list reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList<Comparable> list) {
        Comparable temp;
        int min;
        steps = 0;

        for (int outer = 0; outer < list.size() - 1; outer++) {
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++) {
                steps += 3; // count one compare and 2 gets
                if (list.get(inner).compareTo(list.get(min)) < 0) {
                    min = inner; // a new smallest item is found
                }
            }
            steps += 4;// count 2 gets and 2 sets
            // swap list[outer] & list[min]
            temp = list.get(outer);
            list.set(outer, list.get(min));
            list.set(min, temp);
        }
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
    }

    /**
     * Sort list using the insertionSort algorithm
     *
     * @param list reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList<Comparable> list) {
        steps = 0;
        for (int outer = 1; outer < list.size(); outer++) {
            int position = outer;
            steps+=3;
            Comparable key = list.get(position);

            // Shift larger values to the right
            while (position > 0 && list.get(position - 1).compareTo(key) > 0) {
                steps += 4;
                list.set(position, list.get(position - 1));
                position--;
            }
            steps++;
            list.set(position, key);
        }
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();
    }

    /**
     * Takes in entire vector, but will merge the following sections together:
     * Left sublist from a[first]..a[mid], right sublist from a[mid+1]..a[last].
     * Precondition: each sublist is already in ascending order
     *
     * @param a reference to an array of integers to be sorted
     * @param first starting index of range of values to be sorted
     * @param mid midpoint index of range of values to be sorted
     * @param last last index of range of values to be sorted
     */
    private void merge(ArrayList<Comparable> a,int first,int mid,int last){
        ArrayList<Comparable> temp= new ArrayList<Comparable>(a.size());
        int i=first,j=mid;
        while(i<mid&&j<=last){
            temp.add(a.get(i).compareTo(a.get(j))>0?(a.get(j++)):(a.get(i++)));
            steps+=5;//1 compare, 1 add, 3 gets
        }
        while(i<mid){
            temp.add(a.get(i++));
            steps+=2;//1 add, 1 get
        }
        while(j<=last){
            temp.add(a.get(j++));
            steps+=2;//1 add, 1 get
        }
        for(int o=first;o<=last;o++){
            a.set(o,temp.get(o-first));
            steps+=2;//1 add, 1 get
        }
    }

    /**
     * Recursive mergesort of an array of integers
     * @param a reference to an array of integers to be sorted
     * @param first starting index of range of values to be sorted
     * @param last ending index of range of values to be sorted
     */
    public void mergeSort(ArrayList<Comparable> a,int first,int last){
        steps = 0;
        if(!(last-first<1)){
            int mid=(last+first)/2;
            mergeSort(a,first,mid);
            mergeSort(a,mid+1,last);
            merge(a,first,mid+1,last);
        }
    }

    /**
     * Sort list using quickSort Algorithm
     *
     * @param a reference to an array of integers to be sorted
     * @param first starting index of range of values to be sorted
     * @param last ending index of range of values to be sorted
     */
    public void quickSort(ArrayList<Comparable> a,int first,int last){
//         steps = 0;
        int i=first,j=last;
        Comparable pivot=a.get((first+last)/2);
        steps+=1;//1 get
        while(i<=j){
            while(a.get(i).compareTo(pivot)<0){
                steps+=3;//2 comparisons, 1 get
                i++;
            }
            while(a.get(j).compareTo(pivot)>0){
                steps+=3;//2 comparisons, 1 get
                j--;
            }
            if(i<=j){
                swap(a,i++,j--);
            }
        }
        if(i<=last){
            quickSort(a,i,last);

        }if(j>=first){
            quickSort(a,first,j);

        }

    }

    /**
     * Accessor method to return the current value of steps
     *@return number of steps
     */
    public long getStepCount() {
        return steps;
    }

    /**
     * Modifier method to set or reset the step count. Usually called prior to
     * invocation of a sort method.
     *
     * @param stepCount
     *            value assigned to steps
     */
    public void setStepCount(long stepCount) {
        steps = stepCount;
    }

    /**
     * Interchanges two elements in an ArrayList
     *
     * @param list reference to an array of integers
     * @param a index of integer to be swapped
     * @param b index of integer to be swapped
     */
    public void swap(ArrayList<Comparable> list, int a, int b) {
        Comparable c = list.get(a);
        list.set(a, list.get(b));
        list.set(b, c);
        steps += 4;
    }
}