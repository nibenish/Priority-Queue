public class Customer {
  public Customer(String n, int p){
    CustomerName = n;
    CustomerPriority = p;
  }
  String CustomerName;
  int CustomerPriority;
  String getCustomerName(){ return CustomerName; }
  int getCustomerPriority(){ return CustomerPriority; }
  void setCustomerName(String newName){ this.CustomerName = newName; }
  void setCustomerPriority(int newPriority) { this.CustomerPriority = newPriority; }
}
