public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while(x!=0){
            int pop = x % 10; // remainder
            x/=10; // quotient
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // 2147483647
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // -2147483648
            }
            result = (result * 10) + pop;
        }
        return result;
        
    }
}