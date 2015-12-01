public class Trap {
  private String name;
  private int damage;
  
  public Trap(String n, int d) { 
    name = n;
    damage = d;
  }
  
  int getDamage(){
    return damage;
  }
  
  String getName(){
    return name;
  }
}
