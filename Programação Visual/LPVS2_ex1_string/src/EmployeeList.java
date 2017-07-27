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
            list[cont++] = p;
            return true;
        }
        return false;
    }
    
    public EmployeeList searchEmployees(String sName){
        search = new EmployeeList(this.cont);
        for(int i=0;i<cont;i++){
            if(sName.equals(this.list[i].getName())){
                search.addEmployee(list[i]);
            }
        }
        return search;
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