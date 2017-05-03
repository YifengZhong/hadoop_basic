import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yf_zh on 5/1/2017.
 */
public class Mapper {
    private ArrayList<Node<String,Integer>> list = new ArrayList<>();

    public ArrayList<Node<String, Integer>> getList() {
        return list;
    }

    public List<String> extract(List<String> input) {

        List<String> result = new ArrayList<>();
        for (String x : input) {
            String[] split = x.split("[ -]");
            result.addAll(Arrays.asList(split));
        }
        return result.stream()
                .filter(x->x.matches("[A-Za-z]{1,}"))
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());

    }
    public void saveMapper(List<String> result) {
        result.stream().map(x->new Node(x.toLowerCase(),1)).forEach(x->list.add(x));
    }
    public static ArrayList<Node<String,Integer>> f(List<String> input) {
        Mapper mapper = new Mapper();
        List<String> result = mapper.extract(input);
        mapper.saveMapper(result);
        return mapper.getList();
    }
    public static void main(String[] args) {
        List<String> input = FileRead.read("Data.txt");
        Reducer reducer = new Reducer(Mapper.f(input));
        reducer.reduce();
        reducer.getList().stream().forEach(x->System.out.println("(" + x.getStr() + "," + x.getValue() + ")"));
    }
}
