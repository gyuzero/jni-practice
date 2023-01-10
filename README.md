# jni-practice

### JNI(Java Native Interface)란?
- 자바 코드가 JVM에서 동작할 때 C/C++ 또는 어셈블리어로 작성된 라이브러리를 호출하거나 반대로 호출되는 것을 가능하게 하는 인터페이스

### JNI 구현 순서
1. 자바 코드 작성
2. 자바 코드 컴파일
3. 헤더 파일 생성
4. 생성한 헤더 파일을 토대로 C/C++ 코드 작성
5. C/C++ 공유 라이브러리 생성
6. 자바 애플리케이션에 라이브러리를 포함하여 실행

### 컴파일 및 헤더 파일 생성
```shell
./make_jni_h.sh
```

### 공유 라이브러리 생성
```shell
make mac clean # macOS
make win clean # windows
make linux clean # linux
```