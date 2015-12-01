/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */
public class Monster {
  private int health;
  private String name;
  private int damage;
  
  public Monster(int health, String name, int damage) { 
    this.health = health;
    this.name = name;
    this.damage = damage;
  }
  
  /* Methods for engaging the player in battle
   * works in conjunction with the player's takeDamage and attack classes
   */
  void attack(Player target){
    target.takeDamage(damage);
  }
  
  void takeDamage(int dam){
    health -= dam;
  }
  
  int getHealth(){
   return health;
  }
  
  int getDamage(){
   return damage;
  }
  
  String getName(){
   return name; 
  }
  
}
