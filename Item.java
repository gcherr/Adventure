import java.util.*; 

/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */

public class Item {
  private String name;
  private String detail;
  
  public Item() { 
    name = " ";
  }
  
  public Item(String title){
    name = title;
  }
  
  public Item(String title, String desc){
    name = title;
    detail = desc;
  }
  
  public String getName(){
   return name; 
  }
  
  public String returnDesc(){
    return detail;
  }
  
  public String toString(){
   return name; 
  }
  
}
