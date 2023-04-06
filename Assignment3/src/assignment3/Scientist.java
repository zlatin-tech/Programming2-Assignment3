
package assignment3;

import java.util.Arrays;


public class Scientist {
    private String sNo;
    private String sName;
    private String[] pNo;
    
    public Scientist(String sNo,String sName, String[] pNo){
        this.sNo = sNo;
        this.sName = sName;
        this.pNo = pNo;
        
    }
    
    

    public String getSNo() {
        return sNo;
    }

    public void setSNo(String sNo) {
        this.sNo = sNo;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String[] getPNo() {
        return pNo;
    }

    public void setSNo(String[] pNo) {
        this.pNo = pNo;
    }
    
    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < pNo.length; i++) {
            str += this.pNo[i]+", ";
        }
        return String.format("Scientist: %-18s%s. His/Her Project(s): %s", sName,sNo,str);
    }
    

    
}
