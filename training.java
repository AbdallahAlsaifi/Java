public class training {
    public static void main(String[] args) {
        
        String n = "Hello world";
        int counter = 0, count = 0;
        char x = 'l';
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(counter) == x) {
                count += 1;
            }
            counter +=1;
        }
        System.out.println(count);
        
        




    }
}
