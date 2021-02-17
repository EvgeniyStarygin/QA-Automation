import java.util.*;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        Map<Person, Integer> personsMap = test.parseData(fakeData());
        Map<Integer, Person> sortedPersonsMap = test.sortData(personsMap);
        test.printSortedMap(sortedPersonsMap);

        //Необходимо вывести в консоль всех лиц чей возраст меньше 30 в отсортированном виде по возрастанию возраста
        //в формате ФИО --> возраст
    }

    public Map<Person, Integer> parseData(String data) {
        Map<Person, Integer> map = new HashMap<>();
        String[] personsData = data.split("\n");
        for(String personData : personsData){
            String[] ddata = personData.split(", ");
            String[] fullName = ddata[0].split(" ");
            Person person = new Person(fullName[0], fullName[2], fullName[1]);
            map.put(person, Integer.parseInt(ddata[1]));
        }
        return map;
    }

    public Map<Integer,Person> sortData(Map<Person,Integer> map){
        Map<Integer, Person> sortedMap = new TreeMap<>();
        for (Map.Entry<Person, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 30) {
                sortedMap.put(entry.getValue(), entry.getKey());
            }
        }
        return sortedMap;
    }

    public void printSortedMap(Map<Integer,Person> map) {
        for (Map.Entry<Integer, Person> entry : map.entrySet()) {
            String familyName = entry.getValue().getFamilyName();
            String name = entry.getValue().getName();
            String middleName = entry.getValue().getMiddleName();
            Integer age = entry.getKey();
            System.out.println(String.format("%s %s %s ---> %s", familyName, name, middleName, age));
        }
    }



    public static String fakeData() {
        return "Тетерин Глеб Ярославович, 14\n" +
                "Блинов Велор Ярославович, 21\n" +
                "Щербаков Гарри Протасьевич, 33\n" +
                "Носов Альфред Фролович, 65\n" +
                "Селиверстов Лавр Геласьевич, 9\n" +
                "Агафонов Корней Геннадиевич, 24\n" +
                "Сазонов Иосиф Павлович, 34\n" +
                "Данилов Осип Федотович, 12\n" +
                "Савин Вальтер Юлианович, 45\n" +
                "Филиппов Кассиан Артемович, 64\n" +
                "\n" +
                "\n";
    }

    public static class Person {
        private final String familyName;
        private final String name;
        private final String middleName;

        public Person(String familyName, String middleName, String name) {
            this.familyName = familyName;
            this.name = name;
            this.middleName = middleName;
        }

        public String getFamilyName() {
            return familyName;
        }

        public String getName() {
            return name;
        }

        public String getMiddleName() {
            return middleName;
        }
    }
}