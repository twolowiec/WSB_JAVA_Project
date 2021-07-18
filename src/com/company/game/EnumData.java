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

    public enum VechicleBrands {
//        zbyt wiele danych do obrobienia częśćmarek usuniętych w obecnej wersji
//        ALFAROMEO(true, false, false),
//        ASTONMARTIN(true,false,false),
        AUDI(true,false,false,94500.0,null,"premium",null,1.5),
//        BENTLEY(true, false, false),
        BMW(true, true, false,91950.0,null,"premium", null,1.6),
//        CHEVROLET(true,false,false),
        CITROEN(true,false,true,30000.0,41750.00, "standard", 1390.0,1.2),
        DACIA(true,false,true,25000.00, 32250.00, "budget",1200.0, 0.6),
//        DODGE(true,false,false),
        FERRARI(true, false, false, 375000.0, null, "premium", null, 2.5),
        FIAT(true,false,true, 30500.0,50500.0,"budget", 1187.0,0.7),
        FORD(true,false,true,46500.0,40000.0,"standard",1500.0,0.9),
        HONDA(true, true,false,55500.0,null,"standard",null,1.3),
//        HUNDAI(true,false,true),
        INFINITI(true, false, false,74000.0,null,"premium",null,1.7),
//        IVECO(false,false,true),
//        IZERA(true, false, false),
//        JAGUAR(true, false, false),
//        JEEP(true, false, false),
//        KAMAZ(false,false,true),
//        KAWASAKI(false,true,false),
//        KIA(true,false,true),
//        LAMBORGINI(true, false, false),
//        LANCIA(true, false, fals
        MAZDA(true, false, true,47500.0,null,"standard",null,1.25),
        MERCEDES(true, false, true,630000.0,60000.0,"premium",2300.0,1.9),
        MINI(true, false, false,42500.0,null,"standard", null, 1.4),
        MITSUBISHI(true, false, true,74000.0,40000.0, "standard", 1100.0,1.3),
        NISSAN(true, false, true, 48000.0,39250.0,"standard", 680.0,1.35),
        OPEL(true, false, true,43500.0,26950.0,"budget",1323.0,0.8),
        PEUGEOT(true, false, true,29500.00,51250.0,"budget",1300.0,1.15),
        PORSCHE (true, false, false,312500.0, null,"premium", null, 1.8),
        RENAULT(true, false, true,35500.0,46750.0,"standard",1257.0,1.15),
//        ROVER (true, false, false),
        SEAT(true, false, true,35000.0,null,"standard",null,0.9),
        SKODA(true,false,true,31750.0,27450.0,"budget",560.0,0.8),
//        SUBARU(true, false, false),
//        SUZUKI(true, true, false,),
//        TESLA (true, false, false),
        TOYOTA(true, false, true,43500.0,58000.0,"standard",1100.0,1.35),
        VOLKSWAGEN(true, false, true, 65500.0,45500.0,"standard",1428.0,1.5);
//        VOLVO(true, false, true);

        boolean isCar;
        boolean isMotorcycle;
        boolean isCargo;
        Double mediumPricePersonal;
        Double mediumPriceCargo;
        String segment;
        Double cargoCapacity;
        double partsBrandMultiplier;

        VechicleBrands(boolean isCar, boolean isMotorcycle, boolean isCargo, Double mediumPricePersonal, Double mediumPriceCargo, String segment, Double cargoCapacity, double partsBrandMultiplier) {
            this.isCar = isCar;
            this.isMotorcycle = isMotorcycle;
            this.isCargo = isCargo;
            this.mediumPricePersonal = mediumPricePersonal;
            this.mediumPriceCargo = mediumPriceCargo;
            this.segment = segment;
            this.cargoCapacity = cargoCapacity;
            this.partsBrandMultiplier = partsBrandMultiplier;
        }
    }

    public enum CustomerVechicleCondition {
        OPERATIONAL(80),
        FAULTYSUSPENSION(15),
        BROKEN(5);

        int buyingVillingness;

        CustomerVechicleCondition(int buyingVillingness) {
            this.buyingVillingness = buyingVillingness;
        }
    }
}
