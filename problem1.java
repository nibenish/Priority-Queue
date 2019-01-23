import java.io.*;
import java.util.*;


public class problem1{

  public static void main(String[] args) {
    // set up
    try {
      // create instances of writers/readers
      PrintWriter writer =  new PrintWriter("output.txt", "UTF-8");
      BufferedReader bReader = new BufferedReader(new FileReader(
                                                  new File(args[0])));
      // initial array to read to from input
      List<Customer> unsortedCustomers = new ArrayList<Customer>();
      int count = 0;
      String line = bReader.readLine();
      // fill array with customers, parsed from the input.txt into customers
      while(line != null) {
        String[] arr = line.split("\\s");
        //Customer temp =  new Customer(arr[0],Integer.parseInt(arr[2]));
        unsortedCustomers.add(new Customer(arr[0],Integer.parseInt(arr[2])));
        count++;
        line = bReader.readLine();
      }
      //call sorting functions on customers List
      List<Customer> sortedCustomers = new ArrayList<Customer>();
      for (int j = 0; j < unsortedCustomers.size(); j++) {
        //System.out.println(unsortedCustomers.get(j));
        Insert(sortedCustomers,unsortedCustomers.get(j));
      }

      //write names from sorted list to output.txt
      for (int i = 0; i < sortedCustomers.size()-1; i++) {
        //System.out.println(sortedCustomers.get(i).getCustomerName());
        writer.print(sortedCustomers.get(i).getCustomerName() + " ");
      }
      // no whitespace after final entry!
      writer.print(sortedCustomers.get(sortedCustomers.size()-1).getCustomerName() + '\n');


      bReader.close();
      writer.close();

    } catch(Exception e) {
      System.err.println(e.getMessage());
    }
  }

  private static void Insert(List<Customer> S, Customer x) {
    Customer temp;
    S.add(x);
    for (int i = 1; i < S.size(); i++) {
      for (int j = i; j > 0; j--) {
        if (S.get(j).getCustomerPriority() > S.get(j-1).getCustomerPriority()) {
          temp = S.get(j);
          S.set(j, S.get(j-1));
          S.set(j-1, temp);
        }
      }
    }
    return;
  }


  private Customer Maximum(Customer[] S) {
    Customer max = S[0];
    for (int i = 0; i < S.length; i++) {
      if (S[i].getCustomerPriority() > max.getCustomerPriority()) {
        max = S[i];
      }
    }
    return max;
  }

  private Customer Extract_Max(Customer[] S) {
    Customer[] temp = new Customer[S.length-1];
    Customer max = Maximum(S);
    for (int i = 0; i < S.length; i++) {
      if (S[i] !=  max) {
        temp[i] = S[i];
      }
    }
    return max;
  }
}
