import java.util.*; 

/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */

public class Player {
  private int damage;
  private int health;
  private int defense;
  private ArrayList <Item> inv; // list of items for the player
  private Room playerRoom;
  private Room prevRoom;
  
    
  Player(){
   damage = 1;
   defense = 0;
   health = 10;
   inv  = new ArrayList <Item>();
  
   
  }
  void moveTo(Room room) {
    prevRoom = playerRoom;
    playerRoom = room;
    
  }
  
  //Prints a list of items in inventory
  void printInv(){
    for(int i = 0; i < inv.size(); i++){
      System.out.println(" " + inv.get(i));
    }
  }
  
  ArrayList<Item> getInv(){
   return inv; 
  }
  
  int getHealth(){
   return health;
  }
  
  int getDamage(){
   return damage;
  }
  
  int getDefense(){
   return defense;
  }
  
  Room getRoom(){
   return playerRoom; 
  }
  
  Room previous(){
   return prevRoom;
  }
  
  void addInv(Item s){
    inv.add(s);
  }
  
  /* Methods for engaging the monster in battle
   * works in conjunction with the monster's takeDamage and attack classes
   */
  void attack(Monster target){
    target.takeDamage(damage);
  }
  
  void takeDamage(int dam){
    int loss = dam - defense;
    if(loss < 0)
      loss = 0;
    health = health - loss;
  }
  
  void heal(int amount){
    health += amount;
  }
  
  //Assigns stat boosts to player depending on items held
  void itemBuffs(){
    for(int i = 0; i < inv.size(); i++){
     if(inv.get(i).getName().equals("Sword"))
       damage = 3;
     if(inv.get(i).getName().equals("Armor"))
       defense = 3;
    }
  }
  
}
