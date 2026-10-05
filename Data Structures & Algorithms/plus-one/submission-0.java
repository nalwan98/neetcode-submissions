class Solution {
    public int[] plusOne(int[] digits) {
       List<Integer> list = new ArrayList<>();
       int carry =1;
       for(int i=digits.length-1; i>=0; i--){
        list.add((digits[i]+carry)%10);
        carry= (digits[i]+carry)/10;
       } 
       if(carry!=0){
        list.add(carry);
       }

       int[] res = new int[list.size()];
       for(int i=0; i< list.size(); i++){
        res[list.size()-1-i] = list.get(i);
       }
       return res;
    }
    public int getFirstDigitLog(int number) {
    if (number == 0) return 0;
    
    number = Math.abs(number);
    int digits = (int) Math.log10(number);
    return (int) (number / Math.pow(10, digits));
}
}


