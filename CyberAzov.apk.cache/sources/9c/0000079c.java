package kotlinx.coroutines;

import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class CommonPool$$ExternalSyntheticLambda1 implements Executor {
    public static final /* synthetic */ CommonPool$$ExternalSyntheticLambda1 INSTANCE = new CommonPool$$ExternalSyntheticLambda1();

    private /* synthetic */ CommonPool$$ExternalSyntheticLambda1() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        CommonPool.m1460shutdown$lambda16(runnable);
    }
}