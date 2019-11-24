package view;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    List<String> options;

    public Menu() {
        options = new ArrayList<>();

        options.add("Enqueue a person");
        options.add("Dequeue a person");
//        options.add("Delete by giving index");
        options.add("Search person");
        options.add("Delete by giving person id");
        options.add("Delete the n last in queue");
        options.add("See next person");
        options.add("See last person");
        options.add("See the whole queue");
    }

    public List<String> getOptions() {
        return options;
    }
}
