# webflux-vuejs-demo

[Vue.js を Spring WebFlux でホストする際のプロジェクト構成を考える](https://mikan.github.io/2018/07/28/desigining-project-layout-of-vuejs-that-serving-on-spring-webflux/)で紹介したサンプルコード (vue create 版) です。Quasar Framework 版は [webflux-quasar-demo](https://github.com/mikan/webflux-quasar-demo) をご覧ください。

### Project setup

```
./gradlew npm_install
```

### Compiles and hot-reloads for development

```
./gradlew npm_run_serve
```

### Compiles and minifies for production

```
./gradlew npm_run_build
```

### Lints and fixes files

```
./gradlew npm_run_lint
```

### Serves by WebFlux

```
./gradlew npm_run_build bootRun
```

### Builds a JAR file

```
./gradlew npm_run_build build
```
