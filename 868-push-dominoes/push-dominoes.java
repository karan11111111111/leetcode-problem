class Solution {
    public String pushDominoes(String d) {
        int nl[]=new int[d.length()];
        int nr[]=new int[d.length()];
        for( int i=0;i<d.length();i++){
            if(i==0){
                if(d.charAt(i)!='R'){
                    nr[0]=-1;
                }
            }
            else{
    if(d.charAt(i)=='.'){
        nr[i]=nr[i-1]==-1?nr[i]=-1:nr[i-1]+1;
               }
                else if(d.charAt(i)=='L'){
             nr[i]=-1;
               }
               else nr[i]=0;
            }
        }
        


        for( int i=d.length()-1;i>=0;i--){
            if(i==d.length()-1){
                if(d.charAt(i)!='L'){
                    nl[i]=-1;
                }
            }
            else{
    if(d.charAt(i)=='.'){
        nl[i]=nl[i+1]==-1?nl[i]=-1:nl[i+1]+1;
               }
                else if(d.charAt(i)=='R'){
             nl[i]=-1;
               }
               else {
                 nl[i]=0;
               }
            }
        }

    String ans="";
    for(int i=0;i<nl.length;i++){
        if(nl[i]==nr[i])ans+=".";
        else if(nl[i]==0)ans+="L";
        else if(nr[i]==0)ans+="R";
        else if(nr[i]==-1)ans+="L";
        else if(nl[i]==-1)ans+="R";
        else {
            if(nl[i]<nr[i])ans+="L";
            else ans+="R";
        }
    }
    return ans;
         
    }
}