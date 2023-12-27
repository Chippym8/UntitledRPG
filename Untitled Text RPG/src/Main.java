// Waiting Scene (Time Variable, Train, Trade, Health shop, Activities, Character, Crafting, Quests and Travel, Save)
// Fight Scene \/
// Text Scene
// Camp Scene (Character)
// Menu Scene (Play button)
// Character Creation Scenes
// Difficulty Selection

//Train Screen (Dmg+, Vit+, Dex+, Stamina+)
//Trade Screen (Random items for gold)
//Health shop Screen (Could consolidate to trade screen)
//Activities Screen (Rest, Socialize)
//Character Screen (Stats, Inventory, Back)
//Crafting Screen (Recipes, Craft items, Craft Bolts, Craft Daggers, Craft Armor)
//Quests and Travel Screen (Quests Screen, Travel Screen)
//Save

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character player = new Character();
        fightScene(player);
    }

    // Waiting Scene (Time Variable, Train, Trade, Health shop, Activities, Character, Crafting, Quests and Travel, Save)
    public static void waitScene(Character player) {
        int time = 100;
        while (time > 0) {
            int choice = 0;
            switch (choice) {
                case 1:
                    //player.train();
                    break;
                case 2:
                    //player
                default:
            }
        }
    }

    // Fight Scene
    public static void fightScene(Character player) {
        Character enemy = new Character();
        Scanner kb = new Scanner(System.in);
        int choice = 0;
        while (player.health > 0 && enemy.health > 0) {

            System.out.println();
            System.out.println("Your turn");
            System.out.println("Current health = " + player.health);
            System.out.println("Current stamina = " + player.stamina);
            System.out.println("Enemy health = " + enemy.health);

            while (choice == 0) {
                System.out.println("Press 1 to deal damage");
                System.out.println("Press 2 to restore stamina");
                choice = Integer.parseInt(kb.nextLine()); // Need non-int edge case
                switch (choice) {
                    case 1:
                        if (player.tryAttack()) {
                            int dmg = player.dmg;
                            enemy.hit(dmg);
                        } else {
                            System.out.println("Miss or too tired");
                        }
                        break;
                    case 2:
                        player.recover();
                        break;
                    default:
                }
            }

            choice = 0; // reset choices
            System.out.println();
            System.out.println("Enemy turn");

            if (enemy.health > 0) {
                if (enemy.stamina == 0) {
                    enemy.recover();
                } else {
                    if (enemy.tryAttack()) {
                        int dmg = enemy.dmg;
                        player.hit(dmg);
                    } else {
                        System.out.println("Miss");
                    }
                }

            }
        }
        if (player.health > 0)
            System.out.println("You killed him, you murderer.");
        else
            System.out.println("You died.");
    }
}

/* todo
*   Create read input function
*   Create the app interface (Because this was originally suppose to be an app)*/