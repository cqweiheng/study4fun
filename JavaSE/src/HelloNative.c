#include "com_study15Native_HelloNative.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_study15Native_HelloNative_greeting(JNIEnv* env, jclass cl)
{
	printf("Hello Native World!\n");
}