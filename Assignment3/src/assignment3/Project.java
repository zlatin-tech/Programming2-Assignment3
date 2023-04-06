/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment3;

/**
 *
 * @author zlatintsvetkov
 */
public class Project {
    private String pNo;
    private String pName;
    
    public String getPNo(){
        return pNo;
    }
    public String getPName(){
        return pName;
    }
    
    public Project(String pNo, String pName){
        this.pNo = pNo;
        this.pName = pName;
    }
    
    @Override
    public String toString(){
        return String.format("Project: %-20s%s",pName,pNo);
    }
}
