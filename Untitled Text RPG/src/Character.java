public class Character {
        // Character (Health, Stats, Stamina)

        // Stats (Dmg, Vit, Dex)
        int health = 30;

        // Dmg (Effects damage dealt)
        int dmg = 1;

        // Vit (Effects max health)

        // Dex (Effects hit chance)

        // Stamina (Effects ability to attack, ability to train, hit chance)
        int stamina = 3;

        public boolean tryAttack() {
                if (stamina !=0){
                        stamina -= 1;
                        System.out.println("stamina is at" + " " + stamina);
                        int hit = (int) (Math.random()*10);
                        return hit > 5;
                }
                System.out.println("stamina is at" + " " + stamina);
                return false;
        }

        public void recover() {
                int recoveredStamina = (int) (Math.random()*10);
                stamina += (recoveredStamina);
                System.out.println(recoveredStamina + " stamina recovered!");
                System.out.println("stamina is at" + " " + stamina);
        }

        public void hit(int dmg) {
                dmg = (int) (dmg * (Math.random()*10));
                System.out.println("Hit for " + dmg);
                health -= dmg;
        }

        public void ai() {

        }

}
