/*
*@Author Guilherme de Souza Rodrigues
*/

public class EmployeeList {
    private Employee[] list;
    private EmployeeList search;
    int cont;
    
    public EmployeeList(int size){
        list = new Employee[size];
    }

    public Employee[] getList() {
        return list;
    }
    
    public boolean addEmployee(Employee p){
        if(cont < list.length && p != null){
            int pos = searchEmployee(p);
            if(pos == -1){
                list[cont++] = p;
                return true; 
            }
        }
        return false;
    }
    
    public boolean removeEmployee(String name){
        for(int i=0;i<cont;){
            if(list[i].getName().equals(name)){
                for(int j=i;j<cont;j++)
                    list[j]=list[j+1];
            }else{
                i++;
            }
            cont--;
            return true;
        }
        return false;
    }

    private int searchEmployee(Employee p){
        for (int i = 0; i < cont; i++){
            boolean found;
            found = list[i].checkEquals(p);
            if (found)
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder data;
        data = new StringBuilder();
        for(int i=0;i<cont;i++){
            data.append(list[i]);
            data.append("\n\n");
        }
        return data.toString();
    }
}