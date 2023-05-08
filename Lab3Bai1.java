package Lab3B3;

import java.time.LocalDate;

class Product {
    private String description;
    private String productID;
    private double price;
    public Product() {}
    public Product(String id, String description, double price) {
      this.productID = id;
      this.description = description;
      this.price = price;
    }
    public double calcTotalPrice(int quantity) {
      return this.price * quantity;
    }
    public String toString() {
      return String.format("[%s] %s: $%.2f", productID, description, price);
    }
    public String getDescription() {
      return description;
    }
    public String getProductID() {
      return productID;
    }
    public double getPrice() {
      return price;
    }
    public void setDescription(String description) {
      this.description = description;
    }
    public void setProductID(String productID) {
      this.productID = productID;
    }
    public void setPrice(double price) {
      this.price = price;
    }
}

class Order {
    private int orderID;
    private LocalDate orderDate;
    private OrderDetail[] lineItems;
    private int count;
public Order(int orderID, LocalDate oderDate){
super();
this.orderID = orderID;
this.orderDate = oderDate;
}


    public int getOrderID() {
        return 
        orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderDetail[] getLineItems() {
        return lineItems;
      }

    public void setLineItems(OrderDetail[] lineItems) {
        this.lineItems = lineItems;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void addLineItem(Product p, int quantity) {
        lineItems[count++] = new OrderDetail(p, quantity);
      }
      public double calcTotalCharge() {
        double total = 0;
        for (int i = 0; i < count; i++) {
          total += lineItems[i].calcTotalPrice();
        }
        return total;
      }
      public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ").append(orderID).append(" (").append(orderDate).append("):\n");
        for (int i = 0; i < count; i++) {
          sb.append("\t").append(lineItems[i]).append("\n");
        }
        sb.append("Total charge: ").append(calcTotalCharge());
        return sb.toString();
      }
    }
class OrderDetail {
        private int quatity;
        private Product product;
    public OrderDetail(Product product, int quatity) {
            this.product = product;
            this.quatity = quatity;
          }
    public double calcTotalPrice() {
            return product.calcTotalPrice(quatity);
          }
    public String toString() {
            return String.format("%s x %d = $%.2f", product, quatity, calcTotalPrice());
          }
    
    
        public int getQuatity() {
            return quatity;
        }
    
        public void setQuatity(int quatity) {
            this.quatity = quatity;
        }
    
        public Product getProduct() {
            return product;
        }
        
        public void setProduct(Product product) {
            this.product = product;
        }
    } 
class Main{
    public static void main(String[] args) {
        Product p1 = new Product("sp4", "Nuoc tuong", 8000);
        Product p2 = new Product("sp3", "Gao", 18000);
        Product p3 = new Product("sp2", "Duong", 10000);
        Product p4 = new Product("sp1", "Gao", 18000);
        Order or = new Order(1, LocalDate.now());
        or.addLineItem(p1, 10);
        or.addLineItem(p2, 5);
        or.addLineItem(p3, 1);
        or.addLineItem(p4, 1);
        System.out.println(or.toString());
      }
}
