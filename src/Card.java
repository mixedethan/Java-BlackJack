public class Card {

    public static String getCard(int cardValue) {

        String rank;
        switch (cardValue) {
            case 1:  rank = "A"; break;
            case 11: rank = "J"; break;
            case 12: rank = "Q"; break;
            case 13: rank = "K"; break;
            default: rank = String.valueOf(cardValue); break;
        }
        return rank;
    }

    public static String getSuit(int suitValue) {

        switch (suitValue) {
            case 1: return "♠"; // Spades
            case 2: return "♥"; // Hearts
            case 3: return "♣"; // Clubs
            case 4: return "♦"; // Diamonds
            default: return "?";
        }
    }
}
