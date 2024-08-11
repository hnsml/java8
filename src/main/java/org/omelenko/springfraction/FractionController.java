package org.omelenko.springfraction;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fractions")
public class FractionController {

    @Autowired
    private FractionService fractionService;

    @PostMapping("/task1")
    public ResponseEntity<String> validateFraction(@RequestBody Fraction fraction) {
        if(fractionService.isValidFraction(fraction)) {
            return new ResponseEntity<>("Fraction is valid.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Fraction is invalid.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task2")
    public ResponseEntity<Fraction> reduceFraction(@RequestBody Fraction fraction) {
        if(fractionService.isValidFraction(fraction)) {
            Fraction result = fractionService.reduceFraction(fraction);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task3")
    public ResponseEntity<Fraction> addFractions(@RequestBody Fraction[] fractions) {
        if (fractions.length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fraction fraction1 = fractions[0];
        Fraction fraction2 = fractions[1];
        Fraction result = fractionService.addFractions(fraction1,fraction2);

        if(fractionService.isValidFraction(fraction1) && fractionService.isValidFraction(fraction2))
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task4")
    public ResponseEntity<Fraction> subtractFractions(@RequestBody Fraction[] fractions) {
        if (fractions.length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fraction fraction1 = fractions[0];
        Fraction fraction2 = fractions[1];
        Fraction result = fractionService.subtractFractions(fraction1,fraction2);

        if(fractionService.isValidFraction(fraction1) && fractionService.isValidFraction(fraction2))
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task5")
    public ResponseEntity<Fraction> multiplyFractions(@RequestBody Fraction[] fractions) {
        if (fractions.length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fraction fraction1 = fractions[0];
        Fraction fraction2 = fractions[1];
        Fraction result = fractionService.multiplyFractions(fraction1,fraction2);

        if(fractionService.isValidFraction(fraction1) && fractionService.isValidFraction(fraction2))
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/task6")
    public ResponseEntity<Fraction> divideFractions(@RequestBody Fraction[] fractions) {
        if (fractions.length != 2) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Fraction fraction1 = fractions[0];
        Fraction fraction2 = fractions[1];
        Fraction result = fractionService.divideFractions(fraction1,fraction2);

        if(fractionService.isValidFraction(fraction1) && fractionService.isValidFraction(fraction2))
        {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
