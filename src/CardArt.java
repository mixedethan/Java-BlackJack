public class CardArt {

    public static String getCardArt(String rank, String suit) {
        return  " _______\n" +
                "|" + rank + "      |\n" +
                "|       |\n" +
                "|   " + suit + "   |\n" +
                "|       |\n" +
                "|______" + rank + "|\n";
    }
}
