package netcracker;

import java.util.*;

public class Main {

    public static void format(){
        //предполагается ввод только в формате ISO
        Scanner scan = new Scanner(System.in);
        String dat = scan.nextLine();
        //распарсивание строки на год, месяц и дату
        int year = Integer.parseInt(dat.substring(0,4));
        int month = Integer.parseInt(dat.substring(4,6));
        int day = Integer.parseInt(dat.substring(6));
        String time = scan.nextLine();
        //распарсивание строки на часы и минуты
        int hours = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(2));
        //создание экземпляра date
        Date date = new Date(year - 1900,month - 1,day,hours,minute);
        //создание экземпляра calendar
        Calendar calendar = new GregorianCalendar(year,month - 1,day,hours,minute);
    }

    public static void analysis(String first, String second){
        HashMap<Character, Integer> string1 = new HashMap<>();
        //записавание символов, встречающихся в первой строке, в hashmap со значением 1
        for(int i = 0; i < first.length(); i++){
            char c = first.charAt(i);
            string1.put(c, 1);
        }
        /*
          Записавание символов, встречающихся во второй строке, в hashmap
          Если символ был в первой строке, значение 2
          Иначе значение 3
        */
        for(int i = 0; i < second.length(); i++){
            char c = second.charAt(i);
            if (string1.containsKey(c)) {
                string1.put(c, 2);
            } else {
                string1.put(c, 3);
            }
        }
        System.out.println("Входят в первую и во вторую строку\nВ обычном порядке");
        //Берутся символы со значением 2
        for(Map.Entry<Character, Integer> entry: string1.entrySet()){
            if(entry.getValue() == 2){
                System.out.println(entry.getKey());
            }
        }
        System.out.println("В обратном порядке");
        string1.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByKey().reversed())
                .filter(item -> (item.getValue() == 2))
                .forEach((k) -> System.out.println(k.getKey()));
        System.out.println("В порядке возрастания хэш-функции");
        //Hashmap передается в дерево, которое автоматически сортирует данные по возрастанию хэш-функции
        TreeMap<Character, Integer> sorted = new TreeMap<>();
        sorted.putAll(string1);
        for(Map.Entry<Character, Integer> entry: sorted.entrySet()){
            if(entry.getValue() == 2){
                System.out.println(entry.getKey());
            }
        }
        System.out.println("Входят в первую строку и не входят во вторую\nВ обычном порядке");
        //Берутся символы со значением 1
        for(Map.Entry<Character, Integer> entry: string1.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }
        System.out.println("В обратном порядке");
        string1.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByKey().reversed())
                .filter(item -> (item.getValue() == 1))
                .forEach((k) -> System.out.println(k.getKey()));
        System.out.println("В порядке возрастания хэш-функции");
        for(Map.Entry<Character, Integer> entry: sorted.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
            }
        }
        System.out.println("Содержаться хотя бы в одной строке\nВ обычном порядке");
        //Берутся все символы
        for(Map.Entry<Character, Integer> entry: string1.entrySet()){
            System.out.println(entry.getKey());

        }
        System.out.println("В обратном порядке");
        string1.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByKey().reversed())
                .forEach((k) -> System.out.println(k.getKey()));
        System.out.println("В порядке возрастания хэш-функции");

        for(Map.Entry<Character, Integer> entry: sorted.entrySet()){
            System.out.println(entry.getKey());
        }
    }



    public static void main(String[] args) {
//        Tree<String> tr = new Tree<>("F", null);
//        tr.add("B","A","D","C","E","G","I","H");
//        System.out.println("Прямой обход");
//        tr.preorder();
//        System.out.println();
//        System.out.println("Центрированный обход");
//        tr.inorder();
//        System.out.println();
//        System.out.println("Обратный обход");
//        tr.postorder();
//        format();
//        Person pr = new Person(19,1,2001);
//        System.out.println(pr.toString());
//        System.out.println();
//        System.out.println(pr.getDate("d.MM.yy"));
//        System.out.println(pr.getDate("d MMM yyyy"));
//        System.out.println(pr.getDate("EEEE d MMMM yyyy"));
//        analysis("Привет, мир","Билл Гейтс");

    }
}
