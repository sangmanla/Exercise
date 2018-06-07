package amazon;

import java.util.Random;

/**
 * - Need to consider Joker card -> Card class inherited from generic card class and add shape and number
 * - Need to consider Factory pattern -> build interface and extend it to the class creating deck with joker or not.
 * @author sam
 *
 */
public class DeckOfCards {
	
	private Card[] deck;
	private int currentCardCount = 0;
	
	public DeckOfCards(){
		reset();
	}
	
	public void showTop(){
		System.out.println(deck[currentCardCount-1]);
	}
	
	public void pick(){
		showTop();
		currentCardCount--;
	}
	
	public void reset(){
		deck = new Card[Value.values().length * Shape.values().length];
		
		Shape[] shapes = Shape.values();
		Value[] values = Value.values();
		
		for(int i=0;i<Shape.values().length;i++){
			for(int j=0;j<Value.values().length;j++){
				deck[currentCardCount++] = new Card(shapes[i], values[j]);
			}
		}
	}
	
	/**
	 * shuffle cards for 52 times, 52 seems proper number.
	 */
	public void shuffle(){
		Random rand = new Random();
		
		for(int i=0;i<deck.length;i++){
			int a = rand.nextInt(deck.length);
			int b = rand.nextInt(deck.length);

			Card temp = deck[a];
			deck[a] = deck[b];
			deck[b] = temp;
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Card card : deck){
			sb.append(card);
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public class Card{
		private final Shape shape;
		private final Value value;
		public Card(Shape shape, Value value){
			this.shape = shape;
			this.value = value;
		}
		
		public Shape getShape(){
			return shape;
		}
		
		public Value getValue(){
			return value;
		}
		
		@Override
		public String toString() {
			return shape + "-" + value;
		}
	}
	
	private enum Shape {
		CLUB, DIAMOND, SPADE, HEART
	}

	private enum Value {
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public static void main(String[] args) {

	}
}
