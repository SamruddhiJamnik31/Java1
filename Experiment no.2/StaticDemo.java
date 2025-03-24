public class StaticDemo {

    
    static int count = 0;

   
    static {
        System.out.println("Static block is executed.");
        count = 100;  
    }

    
    public static void displayCount() {
        System.out.println("The value of count is: " + count);
    }

    public static void main(String[] args) {
       
        System.out.println("Initial value of count: " + count);
        
        
        displayCount();

        
        count = 200;
        
       
        displayCount();

       
        StaticDemo obj = new StaticDemo();
        System.out.println("Object created: " + obj);
    }
}
