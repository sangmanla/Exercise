import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class CardSuffle {
    private List<Card> cards = new ArrayList<Card>();
    public static void main(String[] args) {
	new CardSuffle()
		.initCard()
		.shuffleCard()
		.printCard();
    }
    
    private void printCard() {
	cards.stream().forEach(System.out::println);
    }

    private CardSuffle shuffleCard() {
	Random ran = new Random();
	IntStream.range(0, cards.size()).forEach(idx ->{
	    swapCard(idx, ran.nextInt(cards.size()));
	});
	ran.nextInt(cards.size());
	return this;
    }
    
    private void swapCard(int pos1, int pos2){
	Card temp = cards.get(pos1);
	cards.set(pos1, cards.get(pos2));
	cards.set(pos2, temp);
    }

    private CardSuffle initCard() {
	Arrays.stream(CARD_TYPE.values()).forEach(type -> {
	    IntStream.range(1, 14).forEach(num ->{
		cards.add(new Card(num, type));
	    });
	});
	return this;
    }

    private class Card{
	int num;
	CARD_TYPE type;
	
	public Card(int num , CARD_TYPE type){
	    this.num = num;
	    this.type = type;
	}
	
	@Override
	public String toString() {
	    return type.toString() + " " + num;
	}
    }
    
    private enum CARD_TYPE {SPACE, HEART, DIAMOND, CLOVER};
}