import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Deck {
	
    private static final String JSONFILEPATH = "resources/deck_data_json.json";
    private static final boolean ENABLE_DATA_OUTPUT = false;
	
    private Card[] arrayOfCards;
    
    public Deck() {}
	
    public Deck(JSONArray allCards) {
       	//create an array of all JSON objects
    	arrayOfCards = new Card[allCards.size()];
       	
       Iterator<?> iterator = allCards.iterator();
       int counter = 0;
       while(iterator.hasNext() && counter < allCards.size()) {
       	//try {
	      // 	for(int i = 0; i < allCards.size(); i++) {
	       		
	       	    JSONObject currentJson = (JSONObject)iterator.next(); 
	       	    String suite = currentJson.get("suite").toString();
	       	    String value = currentJson.get("value").toString();
	       	    int int_value = (int)Double.parseDouble(currentJson.get("int_value").toString());
	       	    String card_id = currentJson.get("card_id").toString();
	       	    int card_id_num = (int)Double.parseDouble(currentJson.get("card_id_num").toString());
	       	    
	       	    //creating Card object for each card in deck
	       	    Card currentCard = new Card(suite, value, int_value, card_id, card_id_num);
	       	    arrayOfCards[counter++] = currentCard;
       }
    }
    
    /* Name: getArrayOfCards()
       Type: Card[]
       Parameters: None
       Description: Returns arrayOfCards (2D Array)
    */
    public Card[] getArrayOfCards() {
    	return arrayOfCards;
    }
    
    public void printAllCards() {
    	for(Card card : arrayOfCards) 
    		System.out.println(card.getCardId());
    }
    
    public static void main(String []args) {
		JSONParser jsonParser = new JSONParser();
		
		try {
	
			// --------------------
			// parse the JSON file
			FileReader fileReader = new FileReader(JSONFILEPATH);
	
			JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
	
			JSONArray allCards = (JSONArray) jsonObject.get("cards");
	
			System.out.println("Parsing JSON file...");
			Deck deckObject = new Deck(allCards);
	
			// display unsorted array of songs
			System.out.println("Completed parsing JSON file.");
			
			deckObject.printAllCards();
			
		} 
		catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
		catch (IOException e) {	
			e.printStackTrace();  
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		

    }
}
