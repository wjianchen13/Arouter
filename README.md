## Arouter 简单使用

![API](https://img.shields.io/badge/API-15%2B-green) ![license](https://img.shields.io/badge/License-Apache%202.0-blue)

# Arouter特点
1.能够减少各个模块间的依赖关系，达到解耦的目的

# 接入
## 1.在根目录build.gradle添加
```Groovy
apply plugin: 'com.alibaba.arouter'

buildscript {
    dependencies {
        classpath "com.alibaba:arouter-register:1.0.2"
        ...
    }
}
```
可选使用，通过 ARouter 提供的注册插件进行路由表的自动加载(power by AutoRegister)， 默认通过扫描 dex 的方式
进行加载通过 gradle 插件进行自动注册可以缩短初始化时间解决应用加固导致无法直接访问 dex 文件，初始化失败的问题，
需要注意的是，该插件必须搭配 api 1.3.0 以上版本使用！

## 2.在使用的模块build.gradle中添加配置
```Groovy
android {
    ...
    defaultConfig {
        ...

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [AROUTER_MODULE_NAME: project.getName()]
            }
        }

    }
}
```
## 3.在使用的模块bui.gradle中添加依赖
```Groovy
dependencies {
    ...
    implementation 'com.alibaba:arouter-api:1.5.0'
    annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'
}
```
## 4.初始化SDK
```Java
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) { // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();   // 打印日志
            ARouter.openDebug(); // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

}
```
## 5.使用
```Java
@Route(path = Constants.TEST_MODULE1)
public class Module1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
    }

    public void onTest(View view) {
        Go.module2().navigation();
    }
}

ARouter.getInstance().build(Constants.TEST_MODULE1).navigation()
```

# 设置混淆
```Groovy
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep public class com.alibaba.android.arouter.facade.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
# 如果使用了 byType 的方式获取 Service，需添加下面规则，保护接口
-keep interface * implements com.alibaba.android.arouter.facade.template.IProvider
# 如果使用了 单类注入，即不定义接口实现 IProvider，需添加下面规则，保护实现
-keep class * implements com.alibaba.android.arouter.facade.template.IProvider
# 如果在非Activity类中使用了@Autowired 来进行注入，需添加下面规则，防止找不到对应的 被注解类名$$ARouter$$Autowired 来进行注入
-keepnames class * {
    @com.alibaba.android.arouter.facade.annotation.Autowired <fields>;
}
```

# 注意问题
1.使用Arouter都模块都需要2和3的配置<br/>
2.关于分组的使用，同一个分组不能用于多个模块，但是一个模块可以使用多个不一样的分组<br/>
3.在开发的时候出现别的模块使用了Arouter，会导致其他模块不能使用的情况，检查模块的分组是否和其他模块的名称重复<br/>
例如分组是/test/xxx,模块名称other/test/...,引入了其他模块的名称也叫test，这时Arouter会出现加载不到对应的类的问题。
















