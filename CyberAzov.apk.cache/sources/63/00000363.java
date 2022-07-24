package com.cyber.azov2.target;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class DummyTargetProvider implements TargetProvider {
    private static final List<String> targets = new ArrayList(DummyTargetProvider$$ExternalSyntheticBackport0.m(new String[]{"https://targetone.ru", "https://targettwo.ru", "https://targetthree.ru", "https://targetfour.ru", "https://targetfive.ru", "https://targetsix.ru", "https://targetseven.ru", "https://targeteight.ru", "https://targetnine.ru", "https://targetten.ru", "https://targeteleven.ru"}));

    @Override // com.cyber.azov2.target.TargetProvider
    public List<String> provideTargets() {
        List<String> list = targets;
        Collections.shuffle(list);
        return list.subList(0, 10);
    }
}