import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Autopark {
    ArrayList<Auto> autos;

    Autopark() {
        autos = new ArrayList<>();
    }

    void addAuto(Auto auto) {
        autos.add(auto);
    }

    String filterAutos(double minVolume, double maxVolume) {
        StringBuilder result = new StringBuilder();
        Set<String> uniqueMarks = new HashSet<>();

        for (Auto auto : autos) {
            if (uniqueMarks.contains(auto.getMark())) continue; // Уникальные марки

            if (!containsEvenDigits(auto.getNumber()) &&
                    auto.getVolume() >= minVolume && auto.getVolume() <= maxVolume) {
                uniqueMarks.add(auto.getMark());
                result.append(auto.print());
            }
        }

        return result.toString();
    }

    private boolean containsEvenDigits(String number) {
        for (char c : number.toCharArray()) {
            if (Character.isDigit(c) && (c - '0') % 2 == 0) {
                return true;
            }
        }
        return false;
    }
}
