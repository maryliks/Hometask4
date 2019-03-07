package present;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class PresentForChildren extends Ingredients {
    private List<Double> weight;
    private Map<String, Double> mapToSort;
    private Map<String, Double> mapSugar;
    private List<Double> sugar;

    public PresentForChildren(String fileName) throws IOException {
        this.mapToSort = new HashMap<String, Double>();
        this.weight = new ArrayList<>();
        this.sugar = new ArrayList<>();
        this.mapSugar = new HashMap<String, Double>();
        readIN(fileName);
//        if (this.weightNuts < 0 || this.weightSpartak < 0 || this.weightRoshen < 0 || this.weightKomunarka < 0
//                || this.sugarNuts < 0 || this.sugarSpartak < 0 || this.sugarKomunarka < 0 || this.sugarRoshen < 0) {
//            throw new WrongParameters();
//        }

    }

    public void readIN(String nameOfTheFile) throws IOException {
        Scanner sc = new Scanner(new FileInputStream(nameOfTheFile));
        try {
            while (sc.hasNext()) {
                name.add(sc.next());
                weight.add(sc.nextDouble());
                sugar.add(sc.nextDouble());

            }
        } catch (Exception e) {
            System.out.println("Error!");
            System.exit(0);
        }

    }

    public double weightOfChildrenPresent() {
        double sum = 0;
        for (Double item : weight) {
            sum += item;
        }
        return sum;
    }


    public List<Map.Entry<String, Double>> sort() {

        for (int i = 0; i < weight.size(); i++) {
            mapToSort.put(name.get(i), weight.get(i));
        }
        return mapToSort
                .entrySet()
                .stream()
                .sorted((o1, o2) -> Double.compare(o1.getValue(), o2.getValue()))
                .collect(Collectors.toList());
    }


    public void printList(List<Map.Entry<String, Double>> list) {
        for (Map.Entry<String, Double> item : list) {
            System.out.println(item);
        }
    }

    public List<Map.Entry<String, Double>> sugarInPresent() {
        for (int i = 0; i < sugar.size(); i++) {
            mapSugar.put(name.get(i), sugar.get(i));
        }
        return mapSugar
                .entrySet()
                .stream()
                .filter(stringDoubleEntry -> stringDoubleEntry.getValue() < 0.4)
                .collect(Collectors.toList());
    }


    public void output() {
        for (int i=0; i<weight.size(); i++){
            System.out.println(name.get(i)+" "+weight.get(i)+" "+sugar.get(i));
        }
    }
}
