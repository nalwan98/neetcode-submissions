class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String l: strs){
            res.append(Integer.toString(l.length()));
            res.append("#");
            res.append(l);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<String>();
        int i =0;
        while(i<str.length()){
            int j=i;
            for(j=i; j<str.length(); j++){
                if(str.charAt(j)== '#'){
                    break;
                }
            }
            int len = Integer.parseInt(str.substring(i,j));
            res.add(str.substring(j+1, j+1+len));
            i=j+1+len;
        }
        return res;
    }
}
