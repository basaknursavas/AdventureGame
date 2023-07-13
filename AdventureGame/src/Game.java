import java.util.Scanner;

public class Game {
    public Player player;
    public Location location;
    private Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Adventure Game !");
        System.out.print("Please enter a name : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " Welcome !");
        System.out.println("Please select a character to start game => ");
        player.selectChar();

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("-----------------");
            System.out.println("REGIONS => " + "\n1-Safe House" + "\n2-Store");
            System.out.println("3-Cave --> Award:<Food>, be careful, the zombie may come out");
            System.out.println("4-Forest --> Award:<Firewood>, be careful, the wampire may come out");
            System.out.println("5- River --> Award:<Water>, be careful, the bear may come out");
            System.out.println("0-Exit");
            System.out.print("Choose the region you want to go to : ");
            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;

                case 2:
                    location = new ToolStore(player);
                    break;

                case 3:
                    location = new Cave(player);
                    break;

                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;

                default:
                    System.out.println("Please enter valid value");
            }
            if (location == null) {
                System.out.println("You quickly gave up on this dark and foggy island !");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }





    }

}
