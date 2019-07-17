package hello;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "John") String name) {
        return new Greeting(counter.getAndIncrement(), "Hello there - " + name);
    }

    @RequestMapping("/addition/{x}/{y}")
    public int addition(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @RequestMapping("/square/{x}")
    public long square(@PathVariable int x, @RequestParam int sq) {
        return (long)Math.pow(x, sq);
    }
}
