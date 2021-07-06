#include <cstring>
#include <cinttypes>
#include <gmath.h>
#include <jni.h>
#include <string>
#include <stdio.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_dzungvu_importclib_MainActivityViewModel_stringFromJNI(JNIEnv *env, jobject thiz, jstring inJNIStr) {

    volatile unsigned val;
    for (auto exp = 0; exp < 32; ++exp) {
        val = gpower(exp);
        (void) val;  // to silence compiler warning
    }

    std::string str;
    const char nullV[] = "null";
    const char *inCStr = env->GetStringUTFChars(inJNIStr, NULL);
    if (NULL == inCStr) return env->NewStringUTF(nullV);

    char value[] = "value here ";
    str.append(value);
    str.append(inCStr);
    str.append(std::to_string(val));
    return env->NewStringUTF(str.c_str());
}