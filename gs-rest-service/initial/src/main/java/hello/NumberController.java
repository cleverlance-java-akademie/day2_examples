package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NumberController {

    @Autowired
    public NumberRepository numberRepository;

    @RequestMapping(path = "/numbers", method = RequestMethod.POST)
    public ResponseEntity store(@RequestParam int x) {
        if (x <= 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        numberRepository.storeNumber(x);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/numbers", method = RequestMethod.GET)
    public List<Integer> getNumbers() {
        return numberRepository.getAllNumbers();
    }

    @RequestMapping(path = "/numbers", method = RequestMethod.DELETE)
    public int delete(@RequestParam String type) {
        return numberRepository.deleteNumbers(type);
    }
}
