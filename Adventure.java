import java.util.*;
/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */
class Adventure {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    Scanner scanBattle = new Scanner(System.in);
    Player player = new Player();
    Monster monster = new Monster(20, "Dragon", 4);
    Room entryWay = buildWorld();
    player.moveTo(entryWay);
    printInstructions();
    play(player, scan, scanBattle, monster);
  }
  
  static void play(Player player, Scanner scan, Scanner scanBattle, Monster monster) {
       boolean healingUsed = false;
    while(player.getHealth() > 0 && monster.getHealth() > 0){
       System.out.println(">What will you do?");
       String s = scan.next();
       Room currRoom = player.getRoom();// gets room that player is in
       String roomName = currRoom.getName(); // gets name of current room
       Room nextRoom = currRoom; //initializes the next room to go to
       Item currItem = currRoom.getItem(); //gets item in current room
     
       //Assigns the player status boosts depending on items held
       player.itemBuffs();

       //move north
       if(s.equals("north")){
         nextRoom = currRoom.north();
         if(nextRoom != null){ // checks if it is possible to move to this room
           player.moveTo(nextRoom);
           System.out.println(">You moved north");
         }
         else
           System.out.println(">This path is blocked");
       }
       
       //move west
       else if(s.equals("west")){
         nextRoom = currRoom.west();
         if(nextRoom != null){
           player.moveTo(nextRoom);
           System.out.println(">You moved west");
         }
         else
           System.out.println(">This path is blocked");
       }
       
       //move east
       else if(s.equals("east")){
         nextRoom = currRoom.east();
         if(nextRoom != null){
           player.moveTo(nextRoom);
           System.out.println(">You moved east");
         }
         else
           System.out.println(">This path is blocked");
       }
       
       //move south
       else if(s.equals("south")){
         nextRoom = currRoom.south();
         if(nextRoom != null){
           player.moveTo(nextRoom);
           System.out.println(">You moved south");
         }
         else
           System.out.println(">This path is blocked");
       }
       
       //looks around current room & gives description
       else if(s.equals("look")){
         System.out.println(">You are in " + roomName);
         System.out.println(">You currently have " + player.getHealth() + " health");
         if(currItem != null)
           System.out.println(">There is" + currItem.returnDesc());
         else
           System.out.println(">The room is empty");
       }
       
       //picks up item in room of there is one
       else if(s.equals("pickup")){
         if(currItem == null)
           System.out.println(">There is nothing to pick up.");
         else{
           //removes item from room and adds to inventory
           System.out.println(">You picked up the " + currItem);
           player.addInv((currItem));
           currRoom.removeItem();
         }
       }
       
       //checks current inventory
       else if(s.equals("inventory")){
         System.out.println(">Your list of items:");
         player.printInv();
       }
       
       //displays commands
       else if(s.equals("help")){
         System.out.println(">Available commands are:\n north , south , east , west , look , pickup , inventory");
       }
       
       //message for commands not listed
       else{
         System.out.println(">Invalid command");
       }
       
       //Some variables updated to reflect room changes
       Trap currTrap = currRoom.getTrap();
       currRoom = player.getRoom();
       roomName = currRoom.getName();
       
       //Checks your current location for any traps
       if(currTrap != null){
         int turnDamage = currTrap.getDamage() -  player.getDefense(); //calculates damage that player is to take
         if(turnDamage < 0) // sets to 0 if negative
           turnDamage = 0;
         System.out.println(">You take " + (turnDamage)+ 
                            " damage from the " + currTrap.getName());
         player.takeDamage(currTrap.getDamage()); // damages player accordingly
       }
       
       //Heals if in healing room and it has not been used, otherwise fails
       if(!healingUsed && currRoom.getName().equals("Healing Spring")){
         System.out.println(">You heal 10 points of health");
         player.heal(10);
         healingUsed = true;
       }
       
       //Checks if player is in the room with dragon and starts battle
       if(roomName.equals("Dragon's Lair")){
         battle(player, monster, scanBattle);
       }
       
    }
      System.out.println("Game Over.");
    }
  
  
  static Room buildWorld() {
    
    //Item variables
    Item charm = new Item("Lucky Charm" , " a small toy keychain.");
    Item sword = new Item("Sword" , " a slim steel blade.");
    Item armor = new Item("Armor" , " a suit of metal armor");
    
    //Trap variables
    Trap vines = new Trap("Vines", 1);
    Trap acid = new Trap("Acid Floor", 2);
    
    //Room variables
    Room entryWay = new Room("Entry Chamber");
    Room room1 = new Room("Gate to the Future");
    Room room2 = new Room("Dragon's Lair");
    Room room3 = new Room("Doorway to the Past");
    Room room4 = new Room("Dark Cave");
    Room room5 = new Room("Healing Spring");
    Room room6 = new Room("Jungle");
    Room room7 = new Room("Acid Room");
    Room room8 = new Room("Museum");
    
  //Entryway----------------------------------------------
    entryWay.connectNorth(room2);
    entryWay.connectEast(room3);
    entryWay.connectSouth(room6);
    entryWay.connectWest(room1);
    
    entryWay.putItem(charm);
    
  //Room 1 (Future) -----------------------------------------------
    room1.connectEast(entryWay);
    room1.connectSouth(room7);
    
  //Room 2 (Dragon's Lair)-----------------------------------------------
    room2.connectSouth(entryWay);
    
    
  //Room 3 (Past) -----------------------------------------------
    room3.connectWest(entryWay);
    room3.connectNorth(room4);
    room3.connectSouth(room5);
  
  //Room 4 (Dark Cave) -----------------------------------------------
    room4.connectSouth(room3);
    room4.putItem(sword);
    
  //Room 5 (Healing) -----------------------------------------------------------
    room5.connectNorth(room3);
    
  //Room 6 (Jungle) -------------------------------------------------------
    room6.connectNorth(entryWay);
    room6.putTrap(vines);
    
  //Room 7 (Acid)----------------------------------------------------------
    room7.connectNorth(room1);
    room7.connectSouth(room8);
    room7.putTrap(acid);
    
  //Room 8 (Museum) -------------------------------------------------------
    room8.connectNorth(room7);
    room8.putItem(armor);
    
    
    return entryWay;
  }
  
  static void printInstructions() {
    System.out.println(">Welcome to Adventure.");
     System.out.println(">To play please type in a response (type 'help' for a list of commands)");
  }
  
  
  //code for final battle sequence
  static void battle(Player p, Monster m, Scanner scan){
    System.out.println(">You are faced with the " + m.getName());
    while (p.getHealth() > 0 && m.getHealth() > 0){
       System.out.println(">Available Commands:\n fight, status , escape ");
       
       String s = scan.next();
      
       //battles the monster using the attack, damage, and health stats
       if(s.equals("fight")){
         p.attack(m);
         System.out.println(">You hit the enemy for " + p.getDamage() + " damage");
         m.attack(p);
         System.out.println(">The enemy hits you for " + (m.getDamage() - p.getDefense()) + " damage");
       }   
       
       //displayes health of the player and monster
       else if(s.equals("status")){
         System.out.println(">You currently have " + p.getHealth() + " health");
         System.out.println(">The monster has " + m.getHealth() + " health");
       }
       
       //moves back to previous room
       else if(s.equals("escape")){
        p.moveTo(p.previous()); 
        break;
       }
       
       else
         System.out.println(">Invalid command");
    
  }
    if(m.getHealth() < 0){
      System.out.println("Congratulations, you have escaped the cave and survived the Adventure.");
    }
    else if(p.getHealth() < 0){
      System.out.println("Unable to defeat the dragon you fall to the ground, defeated.");
    }
    
  }

}