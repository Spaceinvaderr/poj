
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnimalFabric 
{
    private static final HashMap<String, AnimalMaker> map = new HashMap<String, AnimalMaker> () {
        {
            put("Cat", (name)->new Cat(name));
            put("Fly", (name)->new Fly(name));
            put("Spider", (name)->new Spider(name));
            put("Walrus", (name)->new Walrus(name));
            put("Otter", (name)->new Otter(name));
            put("Parrot", (name)->new Parrot(name));
            
            
        }
    };
    
    public static Animal make(String kind, String name){
        return map.get(kind).make(name);
    }
    //*//
    public static List<String> keys()
    {
        return 
            map
            .keySet()
            .stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    }
    /*/
    public static String[] keys() {
        Set<String> srt = map.keySet();
        String[] tb = new String[map.size()];
        srt.toArray(tb);
        Arrays.sort(tb);
        return tb;
    }
    /*///
}
interface AnimalMaker{
    Animal make(String name);
}


abstract class Animal
{
    private final String name;
    public Animal(String name) { 
        this.name = name; 
    }
    protected String path() { 
        return ""; 
    }
    @Override public String toString() { 
        return path()+ name; 
    }
}

abstract class Mammal extends Animal
{
    public Mammal(String name) { 
        super(name); 
    }
    @Override protected String path() { 
        return super.path()+"Mammal : "; 
    }
}

abstract class Insect extends Animal
{
    public Insect(String name) { 
        super(name); 
    }
    @Override protected String path() { 
        return super.path()+"Insect : "; 
    }
}

abstract class Bird extends Animal
{
    public Bird(String name) { 
        super(name); 
    }
    @Override protected String path() { 
        return super.path()+"Bird : "; 
    }
}

class Walrus extends Mammal
{
     public Walrus(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Walrus{" + '}'; 
    }
}

class Spider extends Insect
{
     public Spider(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Spider{" + '}'; 
    }
}

class Parrot extends Bird
{
     public Parrot(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Parrot{" + '}'; 
    }
}

class Otter extends Mammal
{
     public Otter(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Otter{" + '}'; 
    }
}

class Cat extends Mammal
{
     public Cat(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Cat{" + '}'; 
    }
}

class Fly extends Insect
{
    public Fly(String name) { 
        super(name);
    }
    @Override public String toString() { 
        return "Fly{" + '}'; 
    }
}
