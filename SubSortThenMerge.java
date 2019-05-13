//Given one unsorted list, sort the list recursively.
//Uses Merger.java from solutionsHolmes
import java.util.ArrayList;
import java.util.Arrays;
public class SubSortThenMerge {
  public ArrayList<String> unsortedDeck;

  public SubSortThenMerge(ArrayList<String> array) {
    unsortedDeck = array;
  }

  public ArrayList<String> merge() {
    return SubSortMergeSorter(unsortedDeck);
  }

  public ArrayList<String> SubSortMergeSorter(ArrayList<String> unsorted) {
    //reminder to self: array.sublist(int a, int b)
    //a and b denotes the start and end of the subsection to be taken

    //To sort the array, ask this question: Is the array of size 1?
    //If yes, it is the base case. Return the array.
    //If not, it is the recursive case. Split the array into two, have
    //the two arrays sorted, then combine them with Merger. Then return
    //the sorted array.
    ArrayList<String> output;

    if (unsorted.size() <= 1) {//binary decision
      //base case
      output = unsorted;
    }
    else {//recursive solution
      //recursive abstraction here
      int size = unsorted.size();
      //creates the unsorted halves of the ArrayList
      ArrayList<String> unsortedFrontHalf = new ArrayList<String> ();
      ArrayList<String> unsortedBackHalf = new ArrayList<String> ();
      for (int index = 0; index < size/2; index++) {
        unsortedFrontHalf.add(unsorted.get(index));
      }
      for (int index = size/2; index < size; index++) {
        unsortedBackHalf.add(unsorted.get(index));
      }
      //debug: see if the unsorted halves are properly made
      System.out.println("Debug: entire ArrayList: " + unsorted
                        + System.lineSeparator()
                        + "Unsorted front half: " + unsortedFrontHalf
                        + System.lineSeparator()
                        + "Unsorted back half: " + unsortedBackHalf
                        + System.lineSeparator());
      ArrayList<String> sortedFrontHalf = SubSortMergeSorter(unsortedFrontHalf);
      ArrayList<String> sortedBackHalf = SubSortMergeSorter(unsortedBackHalf);

      //debug: see if halves are properly sorted
      System.out.println("Debug: entire ArrayList: " + unsorted
                        + System.lineSeparator()
                        + "Sorted front half: " + sortedFrontHalf
                        + System.lineSeparator()
                        + "Sorted back half: " + sortedBackHalf
                        + System.lineSeparator());

      //leftover or combining here
      ArrayList<String> combinedList = new ArrayList<String> (); //for use with Merger

      //populates combinedList with the two sorted arrays
      for (int index = 0; index < sortedFrontHalf.size(); index++) {
        combinedList.add(sortedFrontHalf.get(index));
      }
      for (int index = 0; index < sortedBackHalf.size(); index++) {
        combinedList.add(sortedBackHalf.get(index));
      }

      Merger sortedList = new Merger(combinedList);
      sortedList.merge(0, combinedList.size() / 2, combinedList.size());
      output = sortedList.returnArray();
    }//end recursive case
    return output;
  }
}
