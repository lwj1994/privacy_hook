package tech.echoing.archaman.transform;

/**
 * @author luwenjie on 2022/9/29 20:41:48
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Ltech/echoing/archaman/transform/PrivacyTransformer;", "Lcom/didiglobal/booster/transform/asm/ClassTransformer;", "()V", "logger", "Ljava/io/PrintWriter;", "name", "", "getName", "()Ljava/lang/String;", "whiteList", "", "onPostTransform", "", "context", "Lcom/didiglobal/booster/transform/TransformContext;", "onPreTransform", "transform", "Lorg/objectweb/asm/tree/ClassNode;", "klass", "Companion"})
@com.google.auto.service.AutoService(value = {com.didiglobal.booster.transform.asm.ClassTransformer.class})
public final class PrivacyTransformer implements com.didiglobal.booster.transform.asm.ClassTransformer {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = "transform-privacy";
    private java.io.PrintWriter logger;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> whiteList = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "AppPrivacyTransformer";
    @org.jetbrains.annotations.NotNull
    public static final tech.echoing.archaman.transform.PrivacyTransformer.Companion Companion = null;
    
    public PrivacyTransformer() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return null;
    }
    
    @java.lang.Override
    public void onPreTransform(@org.jetbrains.annotations.NotNull
    com.didiglobal.booster.transform.TransformContext context) {
    }
    
    @java.lang.Override
    public void onPostTransform(@org.jetbrains.annotations.NotNull
    com.didiglobal.booster.transform.TransformContext context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public org.objectweb.asm.tree.ClassNode transform(@org.jetbrains.annotations.NotNull
    com.didiglobal.booster.transform.TransformContext context, @org.jetbrains.annotations.NotNull
    org.objectweb.asm.tree.ClassNode klass) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.io.File getReport(@org.jetbrains.annotations.NotNull
    com.didiglobal.booster.transform.TransformContext context, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.io.File getReportDir(@org.jetbrains.annotations.NotNull
    com.didiglobal.booster.transform.TransformContext context) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Ltech/echoing/archaman/transform/PrivacyTransformer$Companion;", "", "()V", "TAG", "", "transform"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}