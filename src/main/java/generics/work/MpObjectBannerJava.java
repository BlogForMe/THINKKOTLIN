package generics.work;

import generics.extendsuper.Fruit1;

import java.util.ArrayList;
import java.util.List;

public class MpObjectBannerJava {
    static MpObjectBannerJava INTANCE = new MpObjectBannerJava();

    MpObjectBannerJava getInstance() {
        return INTANCE;
    }

    public void refresh(MPBannerHelperCallBackJava callBack) {
        ArrayList<Fruit1> arrayList = new ArrayList<>();
        callBack.refreshMPBannerViewJava(arrayList);
    }

    interface MPBannerHelperCallBackJava {
        void funFirst();

        void refreshMPBannerViewJava(List<Fruit1> launchableItem);
    }
}


