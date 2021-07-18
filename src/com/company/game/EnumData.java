package com.company.game;

public class EnumData {

    public enum FirstNames {
        Dominika, Klaudia, Ewa, Katarzyna, Kinga, Marta, Iga, Mirosława, Anna, Agnieszka,
        Beata, Amelia, Jagoda, Joanna, Aleksandra, Hanna, Magdalena, Mariusz, Kryspin,
        Kazimierz, Dawid, Jacek, Jerzy, Patryk, Czesław, Dariusz, Marek, Klaudiusz, Krzysztof,
        Maksymilian, Oskar, Marcel, Mateusz, Błażej
    }

    public enum LastNames {
        Nowak, Mazur, Lis, Sikora, Walczak, Pawlak, Cieślak, Woźniak, Michalak, Krupa, Kubiak, Duda, Betke,
    }

    public enum CarSegment {
        PREMIUM(2.5),
        STANDARD(1.4),
        BUDGET(0.8);
        Double segmentPartsMultiplier;

        CarSegment(double multiplier) {
            this.segmentPartsMultiplier = multiplier;
        }
    }

    public enum Parts {
        SUSPENSION(1.2, 1800.0),
        BREAKES(1.1, 800.00),
        ENGINE(2.0, 4500.00),
        BODY(1.5, 2400.00),
        TRANSMISSION(1.5, 3200.00);
        Double repairValueMultiplier;
        Double partsPrice;

        Parts(double multiplier, double price) {
            this.repairValueMultiplier = multiplier;
            this.partsPrice = price;
        }

    }

    public enum VechicleType {
        CAR(1.0),
        TRUCK(1.3),
        MOTORCYCLE(0.5); // motocykl wykluczony (nie robimy opcji dodatkowych) ze względu na ustalenia z zajęć
        Double typeMultiplier;

        VechicleType(double multiplier) {
            this.typeMultiplier = multiplier;
        }
    }

    public enum Mechanics {
        JANUSZ(3.0,100,0),
        MARIAN(1.1,90,0),
        ADRIAN(0.6,80,2);

        Double priceMultiplier;
        Integer efficiency;
        Integer failureChance;

        Mechanics(Double priceMultiplier, Integer efficiency, Integer failureChance) {
            this.priceMultiplier = priceMultiplier;
            this.efficiency = efficiency;
            this.failureChance = failureChance;
        }
    }
}
