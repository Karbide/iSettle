package com.iSettle.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping("/test")
public class CardController {
	/*private static final Logger LOGGER = LoggerFactory.getLogger(CardController.class);

	private final CardService service;

	@Autowired
	CardController(CardService service){
		this.service = service;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Card createCard(@RequestBody @Valid Card card) {
		Card created = service.create(card);
		return created;
	}

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.GET, value = "/{cardId}")
	public Card getCardDetails(@PathVariable("cardId") String cardId) {
		return service.findById(cardId);
	}

	@Secured("ROLE_USER")
	@RequestMapping(method = RequestMethod.PUT, value = "/{cardId}")
	public Card editBook(@PathVariable("cardId") String cardId, @RequestBody @Valid Card card) {
		card.setId(cardId);
		Card updated =  service.update(card);
		return updated;
	}


	@Secured("ROLE_ADMIN")
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllCards() {
		List<Card> cards = service.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalCards", cards.size());
		response.put("cards", cards);
		return response;
	}
	
	@ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleCardNotFound(CardNotFoundException ex) {
        LOGGER.error("Handling error with message: {}", ex.getMessage());
        Map<String, Object> response = new LinkedHashMap<String, Object>();
        response.put("message", ex.getMessage());
        return response;
    }*/

   /* @Secured("ROLE_USER")
   @RequestMapping(method = RequestMethod.GET)
    public void test() {
        System.out.println("hi........");

    }*/
}