package com.gyuzero;

import java.io.File;

public class GyuzeroJni {

    private static String errMsg = null;

    private static String libPath = System.getProperty("user.dir");

    private static String osName = System.getProperty("os.name").toLowerCase();

    static {
        try {
            String libName = "libGyuzeroJni";
            if (osName.contains("win")) {
                libName += ".dll";
            } else if (osName.contains("mac")) {
                libName += ".dylib";
            } else {
                libName += ".so";
            }

            try {
                libPath = libPath + File.separator + "jni" + File.separator + libName;
                System.load(libPath);
            } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                errMsg = "Loading failed from path: " + libPath;
            }
        } catch (Exception exception) {
            errMsg += exception.getMessage();
        }
    }

    public GyuzeroJni() throws GyuzeroException {
        if (errMsg != null)
            throw new GyuzeroException(errMsg);
    }

    private String checkNull(String paramString) {
        if (paramString == null)
            return "";
        return paramString;
    }

    private native String nativeMaskEmail(String email);

    public String maskEmail(String email) throws GyuzeroException {
        if (errMsg != null)
            throw new GyuzeroException(errMsg);
        email = checkNull(email);
        return nativeMaskEmail(email);
    }
}
