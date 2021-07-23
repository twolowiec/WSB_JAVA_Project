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
        PREMIUM("Premium",2.5),
        STANDARD("Standard",1.4),
        BUDGET("Budget",1.0);
        String displayName;
        Double segmentPartsMultiplier;

        CarSegment(String name,double multiplier) {
            this.displayName = name;
            this.segmentPartsMultiplier = multiplier;
        }
    }

    public enum Parts {
        SUSPENSION("Zawieszenie",1.2, 1800.0),
        BREAKES("Hamulce",1.1, 800.00),
        ENGINE("Silnik",2.0, 4500.00),
        BODY("Karoseria",1.5, 2400.00),
        TRANSMISSION("Skrzynia biegów",1.5, 3200.00);
        public String namePL;
        Double repairedValueMultiplier;
        Double partsPrice;

        Parts(String namePL, double multiplier, double price) {
            this.namePL = namePL;
            this.repairedValueMultiplier = multiplier;
            this.partsPrice = price;
        }

    }

    public enum VechicleType {
        CAR(0.8),
        TRUCK(0.2);

//        MOTORCYCLE(0.5); // motocykl wykluczony (nie robimy opcji dodatkowych) ze względu na ustalenia z zajęć

        Double typeMultiplier;

        VechicleType(double multiplier) {
            this.typeMultiplier = multiplier;
        }
    }

    public enum Mechanics {
        JANUSZ("Janusz",3.0,100,0),
        MARIAN("Marian",1.1,90,0),
        ADRIAN("Adrian",0.6,80,2);

        String displayName;
        Double priceMultiplier;
        Integer efficiency;
        Integer failureChance;

        Mechanics(String name, Double priceMultiplier, Integer efficiency, Integer failureChance) {
            this.displayName = name;
            this.priceMultiplier = priceMultiplier;
            this.efficiency = efficiency;
            this.failureChance = failureChance;
        }
    }

    public enum VechicleBrands {
//        zbyt wiele danych do obrobienia, część marek usuniętych w obecnej wersji
//        ALFAROMEO(true, false, false),
//        ASTONMARTIN(true,false,false),
        AUDI(true,false,false,94500.0,null,CarSegment.PREMIUM,null,1.5),
        BMW(true, true, false,91950.0,null,CarSegment.PREMIUM, null,1.6),
//        CHEVROLET(true,false,false),
        CITROEN(true,false,true,30000.0,41750.00, CarSegment.STANDARD, 1390,1.2),
        DACIA(true,false,true,25000.00, 32250.00, CarSegment.BUDGET,1200, 0.6),
//        DODGE(true,false,false),
        FERRARI(true, false, false, 375000.0, null, CarSegment.PREMIUM, null, 2.5),
        FIAT(true,false,true, 30500.0,50500.0,CarSegment.BUDGET, 1187,0.7),
        FORD(true,false,true,46500.0,40000.0,CarSegment.STANDARD,1500,0.9),
        HONDA(true, true,false,55500.0,null,CarSegment.STANDARD,null,1.3),
//        HUNDAI(true,false,true),
        INFINITI(true, false, false,74000.0,null,CarSegment.PREMIUM,null,1.7),
//        IVECO(false,false,true),
//        IZERA(true, false, false),
//        JAGUAR(true, false, false),
//        JEEP(true, false, false),
//        KAMAZ(false,false,true),
//        KAWASAKI(false,true,false),
//        KIA(true,false,true),
//        LAMBORGINI(true, false, false),
//        LANCIA(true, false, fals
        MAZDA(true, false, false,47500.0,null,CarSegment.STANDARD,null,1.25),
        MERCEDES(true, false, true,330000.0,60000.0,CarSegment.PREMIUM,2300,1.9),
        MINI(true, false, false,42500.0,null,CarSegment.STANDARD, null, 1.4),
        MITSUBISHI(true, false, true,74000.0,40000.0, CarSegment.STANDARD, 1100,1.3),
        NISSAN(true, false, true, 48000.0,39250.0,CarSegment.STANDARD, 680,1.35),
        OPEL(true, false, true,43500.0,26950.0,CarSegment.BUDGET,1323,0.8),
        PEUGEOT(true, false, true,29500.00,51250.0,CarSegment.BUDGET,1300,1.15),
        PORSCHE (true, false, false,312500.0, null,CarSegment.PREMIUM, null, 1.8),
        RENAULT(true, false, true,35500.0,46750.0,CarSegment.STANDARD,1257,1.15),
//        ROVER (true, false, false),
        SEAT(true, false, false,35000.0,null,CarSegment.STANDARD,null,0.9),
        SKODA(true,false,true,31750.0,27450.0,CarSegment.BUDGET,560,0.8),
//        SUBARU(true, false, false),
//        SUZUKI(true, true, false,),
//        TESLA (true, false, false),
        TOYOTA(true, false, true,43500.0,58000.0,CarSegment.STANDARD,1100,1.35),
        VOLKSWAGEN(true, false, true, 65500.0,45500.0, CarSegment.STANDARD,1428,1.5);
//        VOLVO(true, false, true);

        public boolean isCar;
        boolean isMotorcycle;
        public boolean isCargo;
        Double mediumPricePersonal;
        Double mediumPriceCargo;
        public EnumData.CarSegment segment;
        public Integer cargoCapacity;
        public double partsBrandMultiplier;

        VechicleBrands(boolean isCar, boolean isMotorcycle, boolean isCargo, Double mediumPricePersonal, Double mediumPriceCargo, EnumData.CarSegment segment, Integer cargoCapacity, double partsBrandMultiplier) {
            this.isCar = isCar;
            this.isMotorcycle = isMotorcycle;
            this.isCargo = isCargo;
            this.mediumPricePersonal = mediumPricePersonal;
            this.mediumPriceCargo = mediumPriceCargo;
            this.segment = segment;
            this.cargoCapacity = cargoCapacity;
            this.partsBrandMultiplier = partsBrandMultiplier;
        }

        public String getSegment() {
            return segment.displayName;
        }
    }

    public enum Color {
        WHITE("Biały"),
        RED("Czerwony"),
        GREEN("Wyścigowa zieleń"),
        BLUE("Chabrowy metallic"),
        BROWN("Kawowy"),
        BLACK("Czarny metallic"),
        SILVER("Srebrny"),
        GREY("Szary"),
        YELLOW("Zółty"),
        PEARL("Perłowy");

        public String colorNamePL;

        Color(String colorName) {
            this.colorNamePL = colorName;
        }
    }

    public enum CustomerVechicleCondition {
        OPERATIONAL(100),
        FAULTYSUSPENSION(25),
        BROKEN(5);

        public int buyingVillingness;

        CustomerVechicleCondition(int buyingVillingness) {
            this.buyingVillingness = buyingVillingness;
        }
    }

    public enum accountOperations {
        INCOME("Uznanie"),
        OUTCOME("Obciążenie");

        String operatoinNamePL;

        accountOperations(String operatoinName) {
            this.operatoinNamePL = operatoinName;
        }
    }

    public enum vechicleHistory {
        BUY("Zakup"),
        SELL("Sprzedaż"),
        DETAILING("Mycie pojazdu"),
        REPAIR("Naprawa pojazdu"),
        TAX("Podatek");

        String namePL;

        vechicleHistory(String namePL) {
            this.namePL = namePL;
        }
    }
}
