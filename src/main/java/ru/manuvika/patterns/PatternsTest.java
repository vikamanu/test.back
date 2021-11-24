package ru.manuvika.patterns;
import ru.manuvika.patterns.adapter.MyCustomList;
import ru.manuvika.patterns.adapter.MyList;
import ru.manuvika.patterns.builder.Person;
import ru.manuvika.patterns.builder.User;
import ru.manuvika.patterns.fabric.ButtonFabric;
import ru.manuvika.patterns.fabric.WinButtonFabric;
import ru.manuvika.patterns.proxy.Calculator;
import ru.manuvika.patterns.proxy.Summator;
import ru.manuvika.patterns.proxy.SummatorWithLogProxy;
import ru.manuvika.patterns.singleton.Network;

public class PatternsTest {
    public static void main(String[] args) {
        Network network = Network.getInstance();
        ButtonFabric winFabric = new WinButtonFabric();
        winFabric.createButton();

        Person person = Person.builder()
                .setAge(15)
                .setName("Ivan")
                .setSurname("Ivanov")
                .build();

        User user = User.builder()
                .age(12)
                .name("Ivan")
                .surname("Ivanov")
                .build();

        MyList list = new MyCustomList();
        list.add(12);

        Calculator calculator = new Summator();
        Calculator proxy = new SummatorWithLogProxy();

        calculator.calculate();
        proxy.calculate();

        Runnable r1 = () -> System.out.println("Hello");
        Runnable r2 = () -> System.out.println(" World!");
    }
}
