package com.android.acedori.tipcalc.fragments;

import com.android.acedori.tipcalc.models.TipRecord;

/**
 * Created by acedori on 09/06/2016.
 */
public interface TipHistoryListFragmentListener {
    void addToList(TipRecord record);
    void clearList();
}
