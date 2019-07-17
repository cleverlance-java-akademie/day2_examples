package hello;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class NumberRepository {
    private final List<Integer> repo = new LinkedList<>();

    public void storeNumber(int x) {
        repo.add(x);
    }

    public List<Integer> getAllNumbers() {
        return repo;
    }

    public int deleteNumbers(String type) {
        int count = repo.size();
        if (type.equals("even")){
            repo.removeIf(i -> i % 2 == 0);
        } else {
            repo.removeIf(i -> i % 2 != 0);
        }
        return count - repo.size();
    }
}
