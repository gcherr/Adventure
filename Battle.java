import java.util.Scanner;
/*Adventure Game created by:
 * Glen William Herrera (gcherrer@ucsc.edu) and Carlos Penate (cpenate@ ucsc.edu)
 * Runs a simple text adventure game
 * more info in the readme file
 */
public class Battle {
  private Player player;
  private Monster monster;
  Scanner scan = new Scanner(System.in);
  
  public Battle(Player p, Monster m) { 
    while (p.getHealth() < 0 && m.getHealth() < 0){
      System.out.println(">What will you do?");
       String s = scan.next();
      
       if(s.equals("fight")){
         p.attack(m);
         p.takeDamage(m.getDamage());
         m.attack(p);
         m.takeDamage(p.getDamage());
       }
      
    }
  }
  /* ADD YOUR CODE HERE */
  
}
