CC = g++

mac:
	$(CC) -std=c++11 -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/darwin ./jni/GyuzeroJni.cpp -o ./jni/GyuzeroJni.o
	$(CC) -std=c++11 -dynamiclib -o ./jni/libGyuzeroJni.dylib ./jni/GyuzeroJni.o -lc
win:
	$(CC) -std=c++11 -c -I%JAVA_HOME%\include -I%JAVA_HOME%\include\win32 ./jni/GyuzeroJni.cpp -o ./jni/GyuzeroJni.o
	$(CC) -std=c++11 -shared -o ./jni/libGyuzeroJni.dll ./jni/GyuzeroJni.o -Wl,--add-stdcall-alias
linux:
	$(CC) -std=c++11 -c -fPIC -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux ./jni/GyuzeroJni.cpp -o ./jni/GyuzeroJni.o
	$(CC) -std=c++11 -shared -fPIC -o ./jni/libGyuzeroJni.so ./jni/GyuzeroJni.o -lc
clean:
	rm -f ./jni/*.o