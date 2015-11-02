
public class Card {
	private String suite;
	private String value;
	private int int_value;
	private String card_id;
	private int card_id_num;
	
	public Card(String suite, String value, int int_value, String card_id, int card_id_num) {
		this.suite = suite;
		this.value = value;
		this.int_value = int_value;
		this.card_id = card_id;
		this.card_id_num = card_id_num;
	}
	public String getCardId() {
		return card_id;
	}
	
	
}
