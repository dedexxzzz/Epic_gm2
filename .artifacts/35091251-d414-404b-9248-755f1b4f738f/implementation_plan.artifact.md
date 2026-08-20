# Implementation Plan - Fix "cannot find symbol variable adapter"

The user is experiencing a compilation error because the `adapter` variable is used in `MainActivity.java` without being defined or initialized. Additionally, I found a package name mismatch in `ImageAdapter.kt`.

## Proposed Changes

### [Component Name]

#### [MODIFY] [ImageAdapter.kt](file:///Users/senai/AndroidStudioProjects/EpicGmes/app/src/main/java/com/example/epicgmes/ImageAdapter.kt)
- Fix the package declaration from `com.example.epicgames` to `com.example.epicgmes` to match the project structure and other classes.

#### [MODIFY] [MainActivity.java](file:///Users/senai/AndroidStudioProjects/EpicGmes/app/src/main/java/com/example/epicgmes/MainActivity.java)
- Add necessary imports: `java.util.List` and `java.util.Arrays`.
- Redefine `imagens` and `precos` as `List<Integer>` and `List<String>` respectively using `Arrays.asList()`.
- Instantiate `ImageAdapter` with these lists.
- Set the adapter to the `ViewPager2` instance.

## Verification Plan

### Automated Tests
- Run `./gradlew :app:compileDebugJavaWithJavac` to ensure the project compiles successfully.

### Manual Verification
- None required as this is a compilation fix.
