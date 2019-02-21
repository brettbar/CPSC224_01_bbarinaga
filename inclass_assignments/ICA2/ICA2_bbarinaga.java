import java.util.*;

public class ICA2_bbarinaga {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Pet newpet = new Pet();
    System.out.print("Enter a name for the pet: ");
    newpet.setName(newpet.getName(in));

    System.out.print("Enter the type of animal for the pet: ");
    newpet.setAnimal(newpet.getAnimal(in));

    System.out.print("Enter the age of the pet (in years): ");
    newpet.setAge(newpet.getAge(in));
  }
}
