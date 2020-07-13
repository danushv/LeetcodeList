class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder()

        int carry = 0;//at first carry will be zero
        int p1 = num1.length() - 1;// always we add fro the last element
        int p2 = num2.length() - 1;
        while (p1 >= 0 || p2 >= 0) {// this sum function takes place untill the numbers are present
            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;// check if there are element else 0
            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;// value to be appended is the last element
            carry = (x1 + x2 + carry) / 10;// maximunvalue be 18 so only double digit /10 will be carry
            res.append(value);// append the value
            p1--;// go to the next element
            p2--;    
        }
        
        if (carry != 0)// if the msb contains carry value add that too
            res.append(carry);
        
        return res.reverse().toString();// reverse and convert to string
    }
}
