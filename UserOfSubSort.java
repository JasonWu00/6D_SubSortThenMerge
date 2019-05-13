import java.util.ArrayList;

public class UserOfSubSort {
  public static ArrayList<String> list = new ArrayList<String>();
  public static void main(String[] commandLine) {
    //populating list
    list.add("9");
    SubSortThenMerge baseCase = new SubSortThenMerge(list);
    System.out.println(baseCase.merge()); //testing base case

    list.add("7");
    list.add("A");
    SubSortThenMerge smallestRecursiveCase = new SubSortThenMerge(list);
    System.out.println(smallestRecursiveCase.merge());

    list.add("3");
    list.add("8");
    list.add("5");
    list.add("k");
    list.add("J");

    SubSortThenMerge showoff = new SubSortThenMerge(list);
    System.out.println(showoff.merge());
  }
}
