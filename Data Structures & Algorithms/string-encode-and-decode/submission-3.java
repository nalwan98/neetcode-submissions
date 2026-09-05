class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int length = str.length();
            sb.append(Integer.toString(length));
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
       List<String> res = new ArrayList<String>();
       int i =0;
       while(i<str.length()){
        int j=i;
        for (j=i; j<str.length(); j++){
            if(str.charAt(j)== '#'){
                break;
            }

        }
        int len = Integer.parseInt(str.substring(i, j));
        res.add(str.substring(j+1, j+1+len));
        i = j+1+len;
       }
       return res;
    }
}
