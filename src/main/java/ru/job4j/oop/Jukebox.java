package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        String sep = System.lineSeparator();
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже " + sep
                    + "Пешеходы по лужам, " + sep
                    + "А вода по асфальту рекой. " + sep
                    + "И не ясно прохожим " + sep
                    + "В этот день непогожий " + sep
                    + "Почему я весёлый такой." + sep
                    + sep
                    + "Ах я играю на гармошке " + sep
                    + "У прохожих на виду, " + sep
                    + "К сожаленью, день рожденья " + sep
                    + "Только раз в году.");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят." + sep
                    + "Одеяла и подушки ждут ребят." + sep
                    + "Даже сказка спать ложится," + sep
                    + "Чтобы ночью нам присниться." + sep
                    + "Ты ей пожелай:" + sep
                    + "Баю-бай.");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox greenbox = new Jukebox();
        greenbox.music(1);
        System.out.println();
        greenbox.music(2);
        System.out.println();
        greenbox.music(3);
    }
}
