package net.runelite.client.plugins.testplugin;

public class RelevantFarmable {

    private String name;
    private FarmItem seed;
    private FarmItem sapling;
    private int amountOfSeeds;
    private int amountOfSaplings;
    private int levelRequired;
    private double exp;

    public RelevantFarmable(String name, FarmItem seed, FarmItem sapling, int levelRequired, double exp) {
        this.name = name;
        this.seed = seed;
        this.sapling = sapling;
        this.levelRequired = levelRequired;
        this.exp = exp;
        this.amountOfSaplings=0;
        this.amountOfSeeds=0;

    }


    @Override
    public String toString() {
        return "RelevantFarmable{" +
                "name='" + name + '\'' +
                ", seed=" + seed +
                ", sapling=" + sapling +
                ", amountOfSeeds=" + amountOfSeeds +
                ", amountOfSaplings=" + amountOfSaplings +
                ", levelRequired=" + levelRequired +
                ", exp=" + exp +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setAmountOfSeeds(int amountOfSeeds) {
        this.amountOfSeeds = amountOfSeeds;
    }

    public void setAmountOfSaplings(int amountOfSaplings) {
        this.amountOfSaplings = amountOfSaplings;
    }
}
