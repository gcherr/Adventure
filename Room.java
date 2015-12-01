import java.util.*; 

/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */

public class Room {
  private Room north, south, east, west;
  private String name;
  private Item item;
  private Trap trap;
  private ArrayList <Item> droppedItems;
  
  Room(String name) {
    this.name = name;
  }  
  
  Room north() {
    return north;
  }
  
  Room south() {
    return south;
  }
  
  Room west() {
    return west;
  }
  
  Room east() {
    return east;
  }
  
  void connectNorth(Room room) {
    north = room;
    }
  
  void connectSouth(Room room) {
    south = room;
  }
  
  void connectEast(Room room) {
    east = room;
  }
  
  void connectWest(Room room) {
    west = room;
  }
  
  String getName(){
   return name; 
  }
  
  Item getItem(){
   return item;
  }
  
  Trap getTrap(){
   return trap; 
  }
  
  void removeItem(){
    this.item = null;
  }
  
  void putItem(String s){
    this.item = new Item (s);
  }
  
  void putItem(Item i){
    this.item = i;
  }
  
  void putTrap(Trap t){
    this.trap = t;
  }
  
  /*
   //checks conditions for locked rooms and other events
  void conditionCheck(Player p, Item item, Room nextRoom){
    //if()
    //for(Item i : p.getInv()){
      if (!p.getInv().contains(item)) {
       System.out.println("Cannot enter, " + p.getRoom().getName() + " is required");
    }
     else{
       p.moveTo(nextRoom); 
    }
    //p.moveTo(nextRoom);
  }
  */
    
}

