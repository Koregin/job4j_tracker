package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport report1 = new HtmlReport();
        String text2 = report1.generate("Report's name", "Report's body");
        System.out.println(text2);

        JSONReport report2 = new JSONReport();
        String text3 = report2.generate("Report's name", "Report's body");
        System.out.println(text3);
    }
}
