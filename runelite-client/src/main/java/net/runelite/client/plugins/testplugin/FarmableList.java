package net.runelite.client.plugins.testplugin;

        import java.util.ArrayList;

public class FarmableList extends ArrayList<RelevantFarmable> {


    public void addFarmItemToList(FarmItem item, int quantity){

        String name = FarmItemInfo.getNameByID(item.getItemID());
        for(RelevantFarmable rf : this){
            if(rf.getName().equals(name)){
                if (item.getStage().equals("seed")){
                    rf.setAmountOfSeeds(quantity);
                }
                if (item.getStage().equals("sapling")){
                    rf.setAmountOfSaplings(quantity);
                }
            }
        }

    }


    @Override
    public String toString() {
        String result="";
        for(RelevantFarmable rf : this){
            result=result+rf.toString()+"\n";

        }
        return result;
    }
}
