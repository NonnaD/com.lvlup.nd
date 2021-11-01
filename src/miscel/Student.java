package miscel;

import java.lang.reflect.Field;
import java.util.*;

class Student
{
    String name;
    int id;
    String subject;
    double percentage;

    public Student(String name, int id, String subject, double percentage)
    {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
    }

    public String getSubject()
    {
        return subject;
    }

    public double getPercentage()
    {
        return percentage;
    }

    @Override
    public String toString() {
        return "miscel.Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", subject='" + subject + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
class MyCollector {


    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 11, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 11, "History", 83.7));
        studentList.add(new Student("Zevin", 11, "History", 86.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));
        studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
        studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
        studentList.add(new Student("Mitshu", 18, "History", 73.5));
        studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
        studentList.add(new Student("Harry", 20, "History", 71.9));


       // System.out.println(studentList);

        Map<String, String> dataFilter = new HashMap<>();
       dataFilter.put("id", "11");

       dataFilter.put("name", "Zevin");
        getStudents(studentList, dataFilter).forEach(System.out::println);


        getStudents(studentList, dataFilter);

        dataFilter.put("subject", "History");

        getStudents(studentList, dataFilter);
    }

    static List<Student> getStudents(List<Student> studentList, Map<String, String> dataQuery) throws NoSuchFieldException, IllegalAccessException {
        List<Student> filtered = new ArrayList<>();
        Set<String> keySet = dataQuery.keySet();

        for(Student student: studentList){
            boolean isValid = true;
            for (String key: keySet){
                if (dataQuery.get(key)!= null){
                    Field field = student.getClass().getDeclaredField(key);
                    field.setAccessible(true);
                    if (!field.get(student).toString().equals(dataQuery.get(key))){
                        isValid = false;
                    }
                }
            }
            if (isValid) filtered.add(student);
        }

        return filtered;
    }

}