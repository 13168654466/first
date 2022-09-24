package com.test.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ChangedPackages;
import android.content.pm.FeatureInfo;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.SharedLibraryInfo;
import android.content.pm.Signature;
import android.content.pm.VersionedPackage;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HookPackageManager extends PackageManager {
  
    private PackageManager mBase; //用来做适配，返回其他信息
  
    public HookPackageManager(PackageManager base) {
        mBase = base;
    }
  
    @Override
    public PackageInfo getPackageInfo(String packageName, int flags)
            throws NameNotFoundException {
        if (!"ywt.android.test6".equals(packageName)) {
            //如果不是目标APK，则返回原始数据
            return mBase.getPackageInfo(packageName, flags);
        }
        PackageInfo pkgInfo = new PackageInfo();
        pkgInfo.signatures = new Signature[] {
            new Signature(new byte[] {
                //这是填写原始APK中读到的签名，用来欺骗so，很长就不贴了，后面会给出APK，反编译看即可。
            })
        };
        return pkgInfo;
    }

    @Override
    public PackageInfo getPackageInfo(@NonNull VersionedPackage versionedPackage, int i) throws NameNotFoundException {
        return null;
    }

    @Override
    public String[] currentToCanonicalPackageNames(@NonNull String[] strings) {
        return new String[0];
    }

    @Override
    public String[] canonicalToCurrentPackageNames(@NonNull String[] strings) {
        return new String[0];
    }

    @Nullable
    @Override
    public Intent getLaunchIntentForPackage(@NonNull String s) {
        return null;
    }

    @Nullable
    @Override
    public Intent getLeanbackLaunchIntentForPackage(@NonNull String s) {
        return null;
    }

    @Override
    public int[] getPackageGids(@NonNull String s) throws NameNotFoundException {
        return new int[0];
    }

    @Override
    public int[] getPackageGids(@NonNull String s, int i) throws NameNotFoundException {
        return new int[0];
    }

    @Override
    public int getPackageUid(@NonNull String s, int i) throws NameNotFoundException {
        return 0;
    }

    @Override
    public PermissionInfo getPermissionInfo(@NonNull String s, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public List<PermissionInfo> queryPermissionsByGroup(@Nullable String s, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public PermissionGroupInfo getPermissionGroupInfo(@NonNull String s, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public List<PermissionGroupInfo> getAllPermissionGroups(int i) {
        return null;
    }

    @NonNull
    @Override
    public ApplicationInfo getApplicationInfo(@NonNull String s, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public ActivityInfo getActivityInfo(@NonNull ComponentName componentName, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public ActivityInfo getReceiverInfo(@NonNull ComponentName componentName, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public ServiceInfo getServiceInfo(@NonNull ComponentName componentName, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public ProviderInfo getProviderInfo(@NonNull ComponentName componentName, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public List<PackageInfo> getInstalledPackages(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<PackageInfo> getPackagesHoldingPermissions(@NonNull String[] strings, int i) {
        return null;
    }

    @Override
    public int checkPermission(@NonNull String s, @NonNull String s1) {
        return 0;
    }

    @Override
    public boolean isPermissionRevokedByPolicy(@NonNull String s, @NonNull String s1) {
        return false;
    }

    @Override
    public boolean addPermission(@NonNull PermissionInfo permissionInfo) {
        return false;
    }

    @Override
    public boolean addPermissionAsync(@NonNull PermissionInfo permissionInfo) {
        return false;
    }

    @Override
    public void removePermission(@NonNull String s) {

    }

    @Override
    public int checkSignatures(@NonNull String s, @NonNull String s1) {
        return 0;
    }

    @Override
    public int checkSignatures(int i, int i1) {
        return 0;
    }

    @Nullable
    @Override
    public String[] getPackagesForUid(int i) {
        return new String[0];
    }

    @Nullable
    @Override
    public String getNameForUid(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ApplicationInfo> getInstalledApplications(int i) {
        return null;
    }

    @Override
    public boolean isInstantApp() {
        return false;
    }

    @Override
    public boolean isInstantApp(@NonNull String s) {
        return false;
    }

    @Override
    public int getInstantAppCookieMaxBytes() {
        return 0;
    }

    @NonNull
    @Override
    public byte[] getInstantAppCookie() {
        return new byte[0];
    }

    @Override
    public void clearInstantAppCookie() {

    }

    @Override
    public void updateInstantAppCookie(@Nullable byte[] bytes) {

    }

    @Nullable
    @Override
    public String[] getSystemSharedLibraryNames() {
        return new String[0];
    }

    @NonNull
    @Override
    public List<SharedLibraryInfo> getSharedLibraries(int i) {
        return null;
    }

    @Nullable
    @Override
    public ChangedPackages getChangedPackages(int i) {
        return null;
    }

    @NonNull
    @Override
    public FeatureInfo[] getSystemAvailableFeatures() {
        return new FeatureInfo[0];
    }

    @Override
    public boolean hasSystemFeature(@NonNull String s) {
        return false;
    }

    @Override
    public boolean hasSystemFeature(@NonNull String s, int i) {
        return false;
    }

    @Nullable
    @Override
    public ResolveInfo resolveActivity(@NonNull Intent intent, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ResolveInfo> queryIntentActivities(@NonNull Intent intent, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ResolveInfo> queryIntentActivityOptions(@Nullable ComponentName componentName, @Nullable Intent[] intents, @NonNull Intent intent, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ResolveInfo> queryBroadcastReceivers(@NonNull Intent intent, int i) {
        return null;
    }

    @Nullable
    @Override
    public ResolveInfo resolveService(@NonNull Intent intent, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ResolveInfo> queryIntentServices(@NonNull Intent intent, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ResolveInfo> queryIntentContentProviders(@NonNull Intent intent, int i) {
        return null;
    }

    @Nullable
    @Override
    public ProviderInfo resolveContentProvider(@NonNull String s, int i) {
        return null;
    }

    @NonNull
    @Override
    public List<ProviderInfo> queryContentProviders(@Nullable String s, int i, int i1) {
        return null;
    }

    @NonNull
    @Override
    public InstrumentationInfo getInstrumentationInfo(@NonNull ComponentName componentName, int i) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public List<InstrumentationInfo> queryInstrumentation(@NonNull String s, int i) {
        return null;
    }

    @Nullable
    @Override
    public Drawable getDrawable(@NonNull String s, int i, @Nullable ApplicationInfo applicationInfo) {
        return null;
    }

    @NonNull
    @Override
    public Drawable getActivityIcon(@NonNull ComponentName componentName) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public Drawable getActivityIcon(@NonNull Intent intent) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getActivityBanner(@NonNull ComponentName componentName) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getActivityBanner(@NonNull Intent intent) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public Drawable getDefaultActivityIcon() {
        return null;
    }

    @NonNull
    @Override
    public Drawable getApplicationIcon(@NonNull ApplicationInfo applicationInfo) {
        return null;
    }

    @NonNull
    @Override
    public Drawable getApplicationIcon(@NonNull String s) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getApplicationBanner(@NonNull ApplicationInfo applicationInfo) {
        return null;
    }

    @Nullable
    @Override
    public Drawable getApplicationBanner(@NonNull String s) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getActivityLogo(@NonNull ComponentName componentName) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getActivityLogo(@NonNull Intent intent) throws NameNotFoundException {
        return null;
    }

    @Nullable
    @Override
    public Drawable getApplicationLogo(@NonNull ApplicationInfo applicationInfo) {
        return null;
    }

    @Nullable
    @Override
    public Drawable getApplicationLogo(@NonNull String s) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public Drawable getUserBadgedIcon(@NonNull Drawable drawable, @NonNull UserHandle userHandle) {
        return null;
    }

    @NonNull
    @Override
    public Drawable getUserBadgedDrawableForDensity(@NonNull Drawable drawable, @NonNull UserHandle userHandle, @Nullable Rect rect, int i) {
        return null;
    }

    @NonNull
    @Override
    public CharSequence getUserBadgedLabel(@NonNull CharSequence charSequence, @NonNull UserHandle userHandle) {
        return null;
    }

    @Nullable
    @Override
    public CharSequence getText(@NonNull String s, int i, @Nullable ApplicationInfo applicationInfo) {
        return null;
    }

    @Nullable
    @Override
    public XmlResourceParser getXml(@NonNull String s, int i, @Nullable ApplicationInfo applicationInfo) {
        return null;
    }

    @NonNull
    @Override
    public CharSequence getApplicationLabel(@NonNull ApplicationInfo applicationInfo) {
        return null;
    }

    @NonNull
    @Override
    public Resources getResourcesForActivity(@NonNull ComponentName componentName) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public Resources getResourcesForApplication(@NonNull ApplicationInfo applicationInfo) throws NameNotFoundException {
        return null;
    }

    @NonNull
    @Override
    public Resources getResourcesForApplication(@NonNull String s) throws NameNotFoundException {
        return null;
    }

    @Override
    public void verifyPendingInstall(int i, int i1) {

    }

    @Override
    public void extendVerificationTimeout(int i, int i1, long l) {

    }

    @Override
    public void setInstallerPackageName(@NonNull String s, @Nullable String s1) {

    }

    @Nullable
    @Override
    public String getInstallerPackageName(@NonNull String s) {
        return null;
    }

    @Override
    public void addPackageToPreferred(@NonNull String s) {

    }

    @Override
    public void removePackageFromPreferred(@NonNull String s) {

    }

    @NonNull
    @Override
    public List<PackageInfo> getPreferredPackages(int i) {
        return null;
    }

    @Override
    public void addPreferredActivity(@NonNull IntentFilter intentFilter, int i, @Nullable ComponentName[] componentNames, @NonNull ComponentName componentName) {

    }

    @Override
    public void clearPackagePreferredActivities(@NonNull String s) {

    }

    @Override
    public int getPreferredActivities(@NonNull List<IntentFilter> list, @NonNull List<ComponentName> list1, @Nullable String s) {
        return 0;
    }

    @Override
    public void setComponentEnabledSetting(@NonNull ComponentName componentName, int i, int i1) {

    }

    @Override
    public int getComponentEnabledSetting(@NonNull ComponentName componentName) {
        return 0;
    }

    @Override
    public void setApplicationEnabledSetting(@NonNull String s, int i, int i1) {

    }

    @Override
    public int getApplicationEnabledSetting(@NonNull String s) {
        return 0;
    }

    @Override
    public boolean isSafeMode() {
        return false;
    }

    @Override
    public void setApplicationCategoryHint(@NonNull String s, int i) {

    }

    @NonNull
    @Override
    public PackageInstaller getPackageInstaller() {
        return null;
    }

    @Override
    public boolean canRequestPackageInstalls() {
        return false;
    }

    //下面还有很多需要implements的方法，太多了，就不写了，后面会给出APK，反编译看即可，只要用mBase一一调用返回即可。
}