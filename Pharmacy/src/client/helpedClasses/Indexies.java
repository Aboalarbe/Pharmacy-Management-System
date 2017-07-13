package client.helpedClasses;

public class Indexies {
   int id;
   String name,sideEffects,effectiveMaterials,contraindications,dosage;

    public Indexies(int id, String name, String sideEffects,
                    String effectiveMaterials, String contraindications,
                    String dosage) {
        super();
        this.id = id;
        this.name = name;
        this.sideEffects = sideEffects;
        this.effectiveMaterials = effectiveMaterials;
        this.contraindications = contraindications;
        this.dosage = dosage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public String getEffectiveMaterials() {
        return effectiveMaterials;
    }

    public String getContraindications() {
        return contraindications;
    }

    public String getDosage() {
        return dosage;
    }
}
