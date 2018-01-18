
import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        System.out.println("\"Незнайка на Луне\"");
        Reader reader = new Reader("Читатель");

        Forest thisForest = new Forest();                                           // Создаем лес
        Tree tree = new Tree("дерево", 20, 30, thisForest);
        Tree tree2 = new Tree ("сосна", 25, 30, thisForest);

        Forest.ForestElf elf = thisForest.new ForestElf();                                 // Создаем в лесу тишину
        elf.makeSilence();

        Moonlighter skuperfild = new Moonlighter("Скуперфильд", 100, 100, 200);
        Flea flea = new Flea(100, 100, 300);

        skuperfild.tease(flea);                                        // Скуперфильд не в силах расправиться с ничтожным клопом. Скуперфильд пришел в бешенство.

        Shorties migo = new Shorties("Миго", 0, 0, 100);
        Shorties readerMigo = migo;
        Shorties julio = new Shorties("Жулио", 10, 10, 110);
        Shorties readerJulio = julio;
        Shorties krabs = new Shorties("Крабс", 20, 10, 115);
        Shorties readerKrabs = krabs;
        Shorties sckuperfildKrabs = krabs;

        thisForest.stepsShorties();                                     // Послышались шаги коротышек
        skuperfild.headUp();                                            // Скуперфильд поднял голову
        elf.makeSilence();
        skuperfild.seeShorties(krabs, krabs, migo, julio);              // Скуперфильд увидел 3 коротышек
                                                      // Скуперфильд почувствовал, что
                                                  // Коротышка похож на Крабса
        krabs.goForThree(tree);                                          // Коротышка скрылся за деревом
        migo.come(skuperfild);
        julio.come(skuperfild);                                         // 2 коротышки подошли к Скуперфильду
        reader.feel();                                                  // Читатель почувствовал, что
        julio.compare(readerJulio);                                           // Коротышка похож на Жулио
        migo.compare(readerMigo);                                          // Коротышка похож на Миго

        class PrCl{
            private int a = 0;
            public PrCl(int a){
                this.a = a;
            }
        }

        PrCl name = new PrCl(1);
        Class myClass = PrCl.class;

        Field privateField = PrCl.class.getDeclaredField("a");

        privateField.setAccessible(true);
        Object o = privateField.get(name);
        System.out.println(o);
        privateField.set(name, 2);
        o = privateField.get(name);
        privateField.setAccessible(false);
        System.out.println(o);
    }
}
