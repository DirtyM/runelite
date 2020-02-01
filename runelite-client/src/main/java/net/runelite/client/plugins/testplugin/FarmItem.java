package net.runelite.client.plugins.testplugin;

import net.runelite.api.ItemID;

import java.util.HashMap;
import java.util.Map;

public enum FarmItem {
    //Default value if not found
    DEFAULT(0, "def-name", "def-stage", "def-type"),

    //trees
    //seeds
    OAK_SEED(ItemID.ACORN, "Acorn", "seed", "tree"),
    WILLOW_SEED(ItemID.WILLOW_SEED, "Willow Seed", "seed", "tree"),
    MAPLE_SEED(ItemID.MAPLE_SEED, "Maple Seed", "seed", "tree"),
    YEW_SEED(ItemID.YEW_SEED, "Yew Seed", "seed", "tree"),
    MAGIC_SEED(ItemID.MAGIC_SEED, "Magic Seed", "seed", "tree"),

    //sapling
    OAK_SAPLING(ItemID.OAK_SAPLING, "Oak sapling", "sapling", "tree"),
    WILLOW_SAPLING(ItemID.WILLOW_SAPLING, "Willow sapling", "sapling", "tree"),
    MAPLE_SAPLING(ItemID.MAPLE_SAPLING, "Maple sapling", "sapling", "tree"),
    YEW_SAPLING(ItemID.YEW_SAPLING, "Yew sapling", "sapling", "tree"),
    MAGIC_SAPLING(ItemID.MAGIC_SAPLING, "Magic sapling", "sapling", "tree"),


    //fruit
    //seed
    APPLE_SEED(ItemID.APPLE_TREE_SEED, "apple tree", "seed","fruit"),
    BANANA_SEED(ItemID.BANANA_TREE_SEED, "banana tree", "seed","fruit"),
    ORANGE_SEED(ItemID.ORANGE_TREE_SEED, "orange tree", "seed","fruit"),
    CURRY_SEED(ItemID.CURRY_TREE_SEED, "curry tree", "seed","fruit"),
    PINEAPPLE_SEED(ItemID.PINEAPPLE_SEED, "pineapple tree", "seed","fruit"),
    PAPAYA_SEED(ItemID.PAPAYA_TREE_SEED, "papaya tree", "seed","fruit"),
    PALM_SEED(ItemID.PALM_TREE_SEED, "palm tree", "seed","fruit"),
    DRAGONFRUIT_SEED(ItemID.DRAGONFRUIT_TREE_SEED, "dragonfruit tree", "seed","fruit"),
    //sapling
    APPLE_SAPLING(ItemID.APPLE_SAPLING, "apple tree", "sapling","fruit"),
    BANANA_SAPLING(ItemID.BANANA_SAPLING, "banana tree", "sapling","fruit"),
    ORANGE_SAPLING(ItemID.ORANGE_SAPLING, "orange tree", "sapling","fruit"),
    CURRY_SAPLING(ItemID.CURRY_SAPLING, "curry tree", "sapling","fruit"),
    PINEAPPLE_SAPLING(ItemID.PINEAPPLE_SAPLING, "pineapple tree", "sapling","fruit"),
    PAPAYA_SAPLING(ItemID.PAPAYA_SAPLING, "papaya tree", "sapling","fruit"),
    PALM_SAPLING(ItemID.PALM_SAPLING, "palm tree", "sapling","fruit"),
    DRAGONFRUIT_SAPLING(ItemID.DRAGONFRUIT_SAPLING, "dragonfruit tree", "sapling","fruit"),

    //hardwood
    //seed

    //sapling

    //other
    //seed

    //sapling




    ;

    private final int itemID;
    private final String name;
    private final String stage;
    private final String type;

    public int getItemID() {
        return itemID;
    }

    public String getStage() {
        return stage;
    }

    FarmItem(int itemID, String name, String stage, String type) {
        this.itemID = itemID;
        this.name = name;
        this.stage = stage;
        this.type = type;
    }

    private static final Map<Integer, FarmItem> ITEM_ID_MAP = new HashMap<>();

    static {
        for (FarmItem i : values()) {
            ITEM_ID_MAP.put(i.itemID, i);
        }
    }

    public static FarmItem getByItemId(int itemID) {
        return ITEM_ID_MAP.getOrDefault(itemID, FarmItem.DEFAULT);
    }


    @Override
    public String toString() {
        return "FarmItem{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", stage='" + stage + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
