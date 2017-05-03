import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by yf_zh on 5/2/2017.
 */
public class Reducer {
    private ArrayList<Node<String,Integer>> mapperList = new ArrayList<>();
    private ArrayList<Node<String,Integer>> listReducer= new ArrayList<>();

    public ArrayList<Node<String, Integer>> getList() {
        return listReducer;
    }

    public Reducer(ArrayList<Node<String, Integer>> list) {
        getListFromMapper(list);
    }
    private void getListFromMapper(ArrayList<Node<String,Integer>> list) {
        if (list != null) {
            for(Node node : list) {
                mapperList.add(node.clone());
            }
        }
    }
    public void reduce() {
        ArrayList<Node<String,List<Integer>>> tempList= new ArrayList<>();
        mapperList.stream().forEach(x -> {
            boolean flag = false;
            for (Node<String,List<Integer>> n: tempList) {
                if (n.getStr().equals(x.getStr())) {
                    n.getValue().add(1);
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                List<Integer> l = new ArrayList<>();
                l.add(1);
                Node newNode = new Node(x.getStr(),l);
                tempList.add(newNode);
            }
        });
        tempList.stream().forEach(x->{
            Node<String,Integer> newNode = new Node(x.getStr(),x.getValue().size());
            listReducer.add(newNode);
        });
    }
}
