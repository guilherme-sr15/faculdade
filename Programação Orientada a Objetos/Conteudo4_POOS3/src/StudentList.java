/*
 * @author Guilherme de Souza Rodrigues
 */

public class StudentList {
    
    private Student[] students;
    private int cont;
    
    private static StudentList list;
    
    private StudentList(){
        students = new Student[10];
    }
    
    public static StudentList getInstance(){
        if(list == null)
            list = new StudentList();
        return list;
    }
    
}
