package Lesson_3;

public class Lesson3_3 {
    public static void main(String[] args) {
        Park myPark = new Park("Центральный парк");

        Park.Attraction attraction1 = myPark.new Attraction("Колесо обозрения", "10:00 - 20:00", 300);
        Park.Attraction attraction2 = myPark.new Attraction("Американские горки", "12:00 - 22:00", 500);
        Park.Attraction attraction3 = myPark.new Attraction("Комната страха", "18:00 - 23:00", 400);

        attraction1.printInfo();
        attraction2.printInfo();
        attraction3.printInfo();
    }
}

