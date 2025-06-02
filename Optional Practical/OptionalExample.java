import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {

        // 1. of()
        Optional<String> optional1 = Optional.of("rahul@gmail.com");
        System.out.println("1. of(): " + optional1);

        // 2. ofNullable()
        Optional<String> optional2 = Optional.ofNullable(null);
        System.out.println("2. ofNullable(): " + optional2);

        // 3. empty()
        Optional<String> optional3 = Optional.empty();
        System.out.println("3. empty(): " + optional3);

        // 4. isPresent()
        System.out.println("4. isPresent(): " + optional1.isPresent()); // true

        // 5. isEmpty()
        System.out.println("5. isEmpty(): " + optional2.isEmpty()); // true

        // 6. get() - risky, use only if you're sure it's present
        if (optional1.isPresent()) {
            System.out.println("6. get(): " + optional1.get());
        }

        // 7. ifPresent()
        optional1.ifPresent(value -> System.out.println("7. ifPresent(): " + value));

        // 8. ifPresentOrElse()
        optional2.ifPresentOrElse(
            val -> System.out.println("8. ifPresentOrElse(): " + val),
            () -> System.out.println("8. ifPresentOrElse(): Value is absent")
        );

        // 9. orElse()
        String result1 = optional2.orElse("Default");
        System.out.println("9. orElse(): " + result1);

        // 10. orElseGet()
        String result2 = optional2.orElseGet(() -> "Pocessed");
        System.out.println("10. orElseGet(): " + result2);

        // 11. orElseThrow()
        try {
            String result3 = optional2.orElseThrow(() -> new RuntimeException("Value not present"));
            System.out.println("11. orElseThrow(): " + result3);
        } catch (Exception e) {
            System.out.println("11. orElseThrow(): " + e.getMessage());
        }

        // 12. map()
        Optional<Integer> optionalLength = optional1.map(String::length);
        System.out.println("12. map(): " + optionalLength);

        // 13. flatMap()
        Optional<String> upper = optional1.flatMap(value -> Optional.of(value.toUpperCase()));
        System.out.println("13. flatMap(): " + upper);

        // 14. filter()
        Optional<String> filtered = optional1.filter(val -> val.startsWith("O"));
        System.out.println("14. filter(): " + filtered);

        // 15. equals()
        boolean isEqual = optional1.equals(Optional.of("OpenAI"));
        System.out.println("15. equals(): " + isEqual);

        // 16. hashCode()
        System.out.println("16. hashCode(): " + optional1.hashCode());

        // 17. toString()
        System.out.println("17. toString(): " + optional1.toString());

        // 18. Optional with chaining
        String result4 = Optional.ofNullable("Ramesh")
                .map(String::trim)
                .map(String::toUpperCase)
                .orElse("Default Value");
        System.out.println("18. Chaining map(): " + result4);
    }
}
