/*
*@Author Guilherme de Souza Rodrigues
*/

public class Employee {
    String name;
    String surname;
    int age;
    
    public Employee(String name, String surname, int age){
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public float getAge() {
        return this.age;
    }
        
    public Boolean checkEquals(Employee p){
	return this.name.equals(p.name) &&
	this.surname.equals(p.surname) &&
	this.age == p.age;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s\n"
                           + "Sobrenome: %s\n"
                           + "Idade: %d", this.name, this.surname, this.age);
    }
    
}
