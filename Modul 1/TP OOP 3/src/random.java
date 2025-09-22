mport java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BelajarArrayListImproved {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(List.of(
                "Tio", "Haidar", "Klemen", "Jawa", "Jarot",
                "Tipen", "Camat", "Danis", "Aldian"
        ));

        System.out.println("Original list:");
        System.out.println(names);


        System.out.println("\nNama dengan awalan huruf 'A':");
        names.stream()
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);


        System.out.println("\nSorted list (Z to A):");
        List<String> sortedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortedNames);


        System.out.println("\nNama dengan panjang kurang dari 5 karakter:");
        names.stream()
                .filter(name -> name.length() < 5)
                .forEach(System.out::println);
    }
}
