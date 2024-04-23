package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers);

        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {

        model.addAttribute("offer", new Offer());

        return "createoffer"; // 비어 있는 offer이 전달된다.
    }

    //@RequestMapping(value = "/docreate", method = RequestMethod.POST)
    @PostMapping("/docreate")
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("== Form data does not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for (ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer"; // 재입력을 받기 위함, 입력된 내용이 저장된 offer이 전달된다.
        }

        // Controller -> Service 호출 -> Dao 호출
        offerService.insert(offer);

        return "offercreated";
    }
}
