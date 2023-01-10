#include "com_gyuzero_GyuzeroJni.h"
#include <iostream>
#include <string>
#include <regex>

using namespace std;

JNIEXPORT jstring JNICALL Java_com_gyuzero_GyuzeroJni_nativeMaskEmail(JNIEnv *env, jobject jobj, jstring jstr) {
    const char *str = env->GetStringUTFChars(jstr, NULL); // UTF-8로 인코딩된 문자열 힙에 동적으로 할당
    string cStr(str);
    env->ReleaseStringUTFChars(jstr, str); // 힙에 할당한 널 종료 문자열 메모리 공간 해제

    if(regex_match(cStr, regex("[a-zA-Z0-9._-]{3,}@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9._-]+"))) { // 정규식 일치할 시 앞 2자리를 제외한 나머지 마스킹
        int length = cStr.find("@") - 3;
        cStr = regex_replace(cStr, regex(".(?=.{0," + to_string(length) + "}@)"), "*");
    } else { // 정규식 일치하지 않을 시 전부 마스킹
        cStr = regex_replace(cStr, regex("."), "*");
    }

    return env->NewStringUTF(cStr.c_str());
}