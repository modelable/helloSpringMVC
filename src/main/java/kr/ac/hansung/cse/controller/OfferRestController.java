package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.exception.OfferNotFoundException;
import kr.ac.hansung.cse.model.ErrorResponse;
import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController // @Controller + @ResponseBody를 조합
@RequestMapping("/api/offers")
public class OfferRestController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/{id}") // "/api/offers/{id}", GET
    public ResponseEntity<Offer> getOffer(@PathVariable int id) {
        Offer offer = offerService.getOfferById(id);
        if (offer == null) {
            throw new OfferNotFoundException(id);
        }
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @GetMapping // "/api/offers", GET
    public ResponseEntity<List<Offer>> getOffers() {
        List<Offer> offers = offerService.getAllOffers();
        if (offers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // offers는 내용이 없을 수도 있다(정상).
        }
        return new ResponseEntity<>(offers, HttpStatus.OK);
    }

    @PostMapping // "/api/offers", POST
    public ResponseEntity<Void> createOffer(@RequestBody Offer offer) {
        offerService.insertOffer(offer);

        HttpHeaders headers = new HttpHeaders();

        //url 생성
        UriComponents uriComponents = UriComponentsBuilder
                .fromPath("api/offers/{id}") // {id} = offer.getId()
                .buildAndExpand(offer.getId())
                .encode();
        URI locationUri = uriComponents.toUri();
        headers.setLocation(locationUri);

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}") // "/api/offers/{id}", PUT + JSON을 객체에 저장
    public ResponseEntity<Offer> updateOffer(@PathVariable int id, @RequestBody Offer offer) {

        Offer currentOffer = offerService.getOfferById(id);
        if (currentOffer == null)
            throw new OfferNotFoundException(id);

        currentOffer.setName(offer.getName());
        currentOffer.setEmail(offer.getEmail());
        currentOffer.setText(offer.getText());

        offerService.updateOffer(currentOffer);

        return new ResponseEntity<>(currentOffer, HttpStatus.OK); // 수정된 결과를 보여줌(currentOffer)
    }

    @DeleteMapping("/{id}") // "/api/offers/{id}", DELETE
    public ResponseEntity<Void> deleteOffer(@PathVariable int id) {
        Offer currentOffer = offerService.getOfferById(id);
        if (currentOffer == null)
            throw new OfferNotFoundException(id);

        offerService.deleteOfferById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
