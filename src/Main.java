import controller.Controller;
import models.*;

import java.io.File;
import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    private Main(){
        //generating fake data. User will be able to choose how many fake data
        //they want to genereated in a range from 0 to 100.
        SystemQ queue = genFakeNamesQueue(q->{
            int toDelete = q.size() - Integer
                    .parseInt(Utils
                            .input("How many fake data to generate? 1 - 100", "^(\\d?[1-9]|[1-9]0)$"));

            q.delete(toDelete);
            System.out.println(q.size() + " fake data generated.");
            Utils.pause();
            return q;
        });


        Controller.init(queue);
    }


    public static void main(String[] args) {
	// write your code here
        new Main(); // instantiating constructor
    }


    /**
     * Fake data generation
     * @param func takes a SystemQ
     * @return A reduced SystemQ
     */
    private SystemQ genFakeNamesQueue(Function<SystemQ, SystemQ> func) {
        File f = new File("./src/fakenames.txt");
        List<String> names = Utils.readFileLines(f);
        List<String> firstNameList = names.stream().map(name -> name.split(" ")[0]).collect(Collectors.toList());
        List<String> lastNameList = names.stream().map(name-> name.split(" ")[1]).collect(Collectors.toList());
        Collections.shuffle(firstNameList);
        Collections.shuffle(lastNameList);
        SystemQ q = new SystemQ();
        for (int i = 0; i < firstNameList.size(); i++) {
            Person person = Person.personFactory(
                    firstNameList.get(i),
                    lastNameList.get(i),
                    new Date(System.currentTimeMillis()),
                    Utils.generateId(6),
                    Priority.values()[new Random().nextInt(3)]
                    );
            q.add(person);
        }
        return func.apply(q);
    }
}
