class Auto {
    String number;
    String mark;
    double probeg;
    double cost;
    int year;
    double volume;

    Auto(String number, String mark, double probeg, double cost, int year, double volume) {
        this.number = number;
        this.mark = mark;
        this.probeg = probeg;
        this.cost = cost;
        this.year = year;
        this.volume = volume;
    }

    String print() {
        return mark + " | " + number + " | " + probeg + " | " + cost + " | " + year + " | " + volume + "\n";
    }

    public String getNumber() {
        return number;
    }

    public String getMark() {
        return mark;
    }

    public double getVolume() {
        return volume;
    }
}
