package butte.emily.hrproject.controllers;

import butte.emily.hrproject.domain.TimeCard;
import butte.emily.hrproject.repository.TimeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@CrossOrigin(origins = "Http://localhost:9000")
public class TimeCardController {


    @Autowired
    TimeCardRepository timeCardRepository;

    //retrieves time cards from database
    @RequestMapping(value = "/timecards", method = RequestMethod.GET)
    public String getAllTimeCards() {
        StringBuilder builder = new StringBuilder("[");

        timeCardRepository.findAll().forEach(timeCard -> {
            builder.append(timeCard.toString());
        });
        builder.replace(builder.length() - 1, builder.length(), "]");
        return builder.toString();
    }

    // adds a time card to the database
    @RequestMapping(value = "/timecards", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String updateTimeCards(@RequestBody TimeCard request) {
        try {
            timeCardRepository.saveAndFlush(new TimeCard(request.getTimeInAsShort(), request.getTimeOutAsShort(), request.getUsername()));
        } catch (ParseException e) {
            return "{\"message\":\"Error! Time could not be parsed!\"}";
        }
        return "{\"message\":\"Success!\"}";
    }
}
