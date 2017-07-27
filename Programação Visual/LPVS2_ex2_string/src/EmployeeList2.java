/*
 * @author Guilherme de Souza Rodrigues
 */

import java.util.ArrayList;
        
public class EmployeeList2 {
    private ArrayList<Employee> list;
    
    public EmployeeList2(){
        list = new ArrayList<>();
    }
    
    public boolean addEmployee(Employee p){
        int pos = searchEmployee(p);
        if(pos == -1){
            return list.add(p);
        }
        return false;
    }
    
    private int searchEmployee(Employee p){
        for (Employee aux: list){
            boolean found;
            found = aux.checkEquals(p);
            if (found)
                return list.indexOf(aux);
        }
        return -1;
    }
  
    public boolean removeEmployee(String name){
        for(int i=0;i<list.size();){
            if(list.get(i).getName().equals(name)){
                list.remove(i);
                 return true;
            }else{
                i++;
            }
        }
        return false;
    }

@Override
    public String toString() {
        StringBuilder builder;
        builder = new StringBuilder();
        for(Employee nome: list) {
            builder.append(nome);
            builder.append("\n");
        }
        return builder.toString();
    }
}
