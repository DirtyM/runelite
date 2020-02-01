package net.runelite.client.plugins.testplugin;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


//This class based on the experieneItem class of the bankedexpericence plugin...

@Getter
public enum FarmItemInfo {

    //DEFAULTS
    DEFAULT("Default", 0, 0, "tree", FarmItem.DEFAULT, FarmItem.DEFAULT),

    //TREES
    OAK_TREE("Oak", 15, 481.3, "tree", FarmItem.OAK_SEED, FarmItem.OAK_SAPLING),
    WILLOW_TREE("Willow", 30, 1481.5, "tree", FarmItem.WILLOW_SEED, FarmItem.WILLOW_SAPLING),
    MAPLE_TREE("maple",45,3448.4,"tree",FarmItem.MAPLE_SEED,FarmItem.MAPLE_SAPLING),
    YEW_TREE("yew",60,7150.9,"tree",FarmItem.YEW_SEED,FarmItem.YEW_SAPLING),
    MAGIC_TREE("magic tree",75,	13913.8,"tree",FarmItem.MAGIC_SEED,FarmItem.MAGIC_SAPLING),

    //FRUIT TREES
    APPLE_TREE("apple tree",0000,	0000,"tree",FarmItem.APPLE_SEED,FarmItem.APPLE_SAPLING),
    BANANA_TREE("apple tree",0000,	0000,"tree",FarmItem.BANANA_SEED,FarmItem.BANANA_SAPLING),
    ORANGE_TREE("apple tree",0000,	0000,"tree",FarmItem.ORANGE_SEED,FarmItem.ORANGE_SAPLING),
    CURRY_TREE("apple tree",0000,	0000,"tree",FarmItem.CURRY_SEED,FarmItem.CURRY_SAPLING),
    PINEAPPLE_TREE("apple tree",0000,	0000,"tree",FarmItem.PINEAPPLE_SEED,FarmItem.PINEAPPLE_SAPLING),
    PAPAYA_TREE("apple tree",0000,	0000,"tree",FarmItem.PAPAYA_SEED,FarmItem.PAPAYA_SAPLING),
    PALM_TREE("apple tree",0000,	0000,"tree",FarmItem.PALM_SEED,FarmItem.PALM_SAPLING),
    DRAGONFRUIT_TREE("apple tree",0000,	0000,"tree",FarmItem.DRAGONFRUIT_SEED,FarmItem.DRAGONFRUIT_SAPLING),


    //OTHERS

    ;

    private final String name;
    private final int level;
    private final double xp;
    private final String type;
    private final FarmItem seed;
    private final FarmItem sapling;


    FarmItemInfo(String name, int level, double xp, String type, FarmItem seed, FarmItem sapling) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.type = type;
        this.seed = seed;
        this.sapling = sapling;
    }

    private static final Multimap<String, FarmItemInfo> TYPE_MAP = ArrayListMultimap.create();
    private static final Map<String, FarmItemInfo> ITEM_NAME_MAP = new HashMap<>();

    static {
        for (FarmItemInfo i : values()) {
            String type = i.getType();
            TYPE_MAP.put(type, i);
            ITEM_NAME_MAP.put(i.getName(), i);
        }
    }

    public static FarmItemInfo getByItemName(int itemID) {
        return ITEM_NAME_MAP.getOrDefault(itemID, FarmItemInfo.DEFAULT);
    }

    public static Collection<FarmItemInfo> getByType(String type) {
        Collection<FarmItemInfo> items = TYPE_MAP.get(type);
        if (items == null) {
            items = new ArrayList<>();
        }

        return items;
    }

    public static String getNameByID(int id) {
        //optimize this later!!! (now probably quite slow)
        for (FarmItemInfo i : values()) {
            if (i.seed.getItemID() == id || i.sapling.getItemID() == id) {
                return i.getName();
            }
        }
        return "def-name";
    }

    public static FarmableList generateFarmableList() {
        FarmableList flist = new FarmableList();

        for (FarmItemInfo i : values()) {
            flist.add(new RelevantFarmable(i.name, i.seed, i.sapling, i.level, i.xp));
        }
        return flist;
    }


}
