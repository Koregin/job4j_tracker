package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * Метод averageScore вычисляет общий средний балл.
     * @param stream учеников
     * @return Возвращает Общий средний бал
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     * @param stream учеников
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average().orElse(0D)
                ))
                .collect(Collectors.toList());
    }

    /**
     * Метод averageScoreByPupil вычисляет средний балл по всем предметам для каждого ученика.
     * @param stream учеников
     * @return Возвращает список из объекта Tuple (название предмета и средний балл)
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Map<String, Double> subjAvgScore = stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)));
        return subjAvgScore.entrySet().stream()
                .map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * Метод bestStudent - возвращает лучшего ученика
     * @param stream учеников
     * @return Возвращает объект Tuple (имя ученика и сумма балов по всем предметам)
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(),
                        pupil.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()
                ))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     * @param stream учеников
     * @return Возвращает объект Tuple (имя предмета,
     * сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> subjAvgScore = stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)));
        return subjAvgScore.entrySet().stream()
                .map(subj -> new Tuple(subj.getKey(), subj.getValue()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(null);
    }
}
