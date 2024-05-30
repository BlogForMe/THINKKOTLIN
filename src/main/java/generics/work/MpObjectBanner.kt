package com.tngd.uikitsdk.view.bar.generics.work

import generics.extendsuper.Fruit1

object MpObjectBanner {
    var callBack: MPBannerHelperCallBack? = null

    fun refrash(callBack: MPBannerHelperCallBack) {
        val arrayList = ArrayList<Fruit1>()
        callBack.refreshMPBannerView(arrayList)
    }
}

interface MPBannerHelperCallBack {
    fun funFirst()
    fun refreshMPBannerView(launchableItem: List<Fruit1>)
}