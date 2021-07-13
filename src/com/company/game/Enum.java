package com.company.game;

public enum Enum {;

    public static enum firstNames {
        Dominika, Klaudia, Ewa, Katarzyna, Kinga, Marta, Iga, Mirosława, Anna, Agnieszka,
        Beata, Amelia, Jagoda, Joanna, Aleksandra, Hanna, Magdalena, Mariusz, Kryspin,
        Kazimierz, Dawid, Jacek, Jerzy, Patryk, Czesław, Dariusz, Marek, Klaudiusz, Krzysztof,
        Maksymilian, Oskar, Marcel, Mateusz, Błażej
    }

    public static enum lastNames {
        Nowak, Mazur, Lis, Sikora, Walczak, Pawlak, Cieślak, Woźniak, Michalak, Krupa, Kubiak, Duda, Betke,
    }

    public static enum carSegment {
        premium(2.5), standart(1.4), budget(0.8);
        Double segmentPartsMultiplier;

        carSegment(double multiplier) {
            this.segmentPartsMultiplier = multiplier;
        }
    }

    public static enum parts {
        suspension(1.2), breakes(1.1), engine(2.0), body(1.5), transmission(1.5);
        Double repairValueMultiplier;

        parts(double multiplier) {
            this.repairValueMultiplier = multiplier;
        }
    }

    public static enum vechicleType {
        car(1.0), truck(1.3), motorcycle(0.5); // motocykl wykluczony (nie robimy opcji dodatkowych) ze względu na ustalenia z zajęć
        Double typeMultiplier;

        vechicleType(double multiplier) {
            this.typeMultiplier = multiplier;
        }
    }

    public static enum mechanics {
        Janusz, Marian, Adrian
    }
}
