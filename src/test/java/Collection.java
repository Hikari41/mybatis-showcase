import com.cheer.mybatis.Person;
import org.junit.Test;

import java.util.*;
import java.util.Map.Entry;

public class Collection {

    @Test
    public void list() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person();
        personList.add(person);
        for (Person people : personList) {
            System.out.println(people);
        }
    }

    @Test
    public void map() {
        Map<String, String> map = new HashMap<>();
        map.put("user", "admin");
        map.put("password", "admin");
        String userValue = map.get("user");
        String passwordValue = map.get("password");
        for (Entry<String, String> entry : map.entrySet()) {
            System.out.printf("key=%s, value=%s\n",entry.getKey(),entry.getValue());
        }
    }

    @Test
    public void set() {
        Set<Person> personSet = new HashSet<>();
        Person person1 = new Person();
        person1.setId(1);
//        person1.setName("LEO");
        Person person2 = new Person();
        person2.setId(2);
        Person person3 = new Person();
        person3.setId(3);
        Person person4 = new Person();
        person4.setId(4);
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);
        for (Person element : personSet) {
            System.out.println(element + String.valueOf(element.hashCode()));
        }

    }
}
