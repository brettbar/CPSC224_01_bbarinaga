import java.util.*;

public class Pet {


  String name;
  String animal;
  int age;


  public void setName(String name_string) {
    this.name = name_string;
  }

  public void setAnimal(String animal_string) {
    this.animal = animal_string;
  }

  public void setAge(int age_int) {
    this.age = age_int;
  }

  public String getName(Scanner jin) {
    return jin.nextLine();
  }

  public String getAnimal(Scanner jin) {
    return jin.nextLine();
  }

  public int getAge(Scanner jin) {
    return jin.nextInt();
  }


}
