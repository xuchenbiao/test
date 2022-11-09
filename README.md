# 笔记

## 脚手架文件结构

    -node_modules
    -public
        -favicon.ico: 页签图标
        -index.html : 主页面
    -src
        -assets:存放静态资源
            -logo.png 
        -compoment: 存放组件
            -HelloWorld.vue
        -App.vue :汇总所有组件
        -main,js :入口文件
    -.gitignore:git版本管制忽略的配置
    -babel.config.js: babel的配置文件(es6转es5)
    -package.json :应用包配置文件
    -package-lock.json :包版本控制文件

## 关于不同版本的vue

    1.vue.js与vue.runtime.xxx.js的区别:
        1.vue.js是完整版的Vue，包含:核心功能＋模板解析器。
        2.vue.runtime.xxx.js是运行版的Vue，只包含:核心功能;没有模板解析器。
    2因为vue.runtime.xxx.js没有模板解析器，所以不能使用template这个配置项，需要使用render函数接收到的createElement函数去指定具体内容。

## vue.config.js配置文件

    1.使用vue inspect>output.js可以查看vue脚手架的默认配置
    2.使用vue.config.js可以对脚手架进行个性化定制,详情见: https://cli.vuejs.org/zh

## ref属性

    1.被用来给元素或者子组件注册引用信息(id的代替者)
    2.应用在html标签上获取的是真实的DOM元素,应用在组件标签上是组件实例对象(vc)
    3.使用方式:
        打标识:<h1 ref='xxx'></h1> 或者<School ref='xxx'></School>
        获取: this.$refs.xxx

## 配置项props

    功能: 让组件接收外部传过来的数据
        (1).传递数据:
            <Demo name='' sex=''/>

        (2).接收数据:
            第一种方式(只接收)
            props:['name','sex']

            第二种方式(限制类型)
            props:{
                name:Number,
                sex:String
            }

            第三种方式(限制类型,限制必要性,指定默认值)
            props:{
                name:{
                    type:Number,
                    required:true,
                    default:18   //reuired和default一般不会同时出现
                }
            }
    
    备注:props是只读的,Vue底层会监测你对props的修改,如果进行了修改,就会发出警告,若业务需求确实需要修改,那么请复制props的内容到data中一份,然后去修改data中的数据

## mixin(混入)

    功能: 可以把多个组件共用的配置提取成一个混入对象
    使用方式:
        第一步定义混合,例如:{
            data(){...},
            methods:{...},
            ...
        }

        第二步使用混入,例如:
            (1).全局混入:Vue.mixin(xxx) (在main.js使用)
            (2).局部混入: mixin:['xxx'] //一定是数组

## 插件

    功能: 用于增强Vue
    本质: 包含install方法的一个对象,install的第一个参数是Vue,第二个以后的参数是使用者传递的数据.
    定义插件:
        对象.install = function (Vue,option){

                    
                // 全局过滤器
                Vue.filter(...) 

                //定义全局的自定义指令
                Vue.directive(...)

                // 定义混入
                Vue.mixin(...)


        }


    使用插件: Vue.use()

## scoped样式

    作用: 让样式在局部生效,防止不同组件间的样式名冲突
    写法: <style scoped> 
        </style>

## 总结TodoList案例

    1.组件化编码流程:
        (1).拆分静态组件: 组件要按照功能点拆分, 命名不要与html元素冲突
        (2).实现动态组件: 考虑好数据的存放位置,数据是一个组件在用还是一些组件再用:
            1)一个组件在用:放在组件自身即可.
            2)一些组件在用:放在他们共同的父组件上(<span style="color:red">状态提升 </span>)
        (3).实现交互: 从绑定事件开始
    
    2.props适用于:
        (1)父组件==>子组件 通信
        (2)子组件==>父组件 通信(要求父给子一个函数)
    
    3.使用v-model要切记:v-model 绑定的值不能是props 传过来的值,因为props是不可修改的

    4. props若传递的是对象类型的值,修改对象中的属性时Vue不会报错,但不推荐这么做

## 组件自定义事件

    1.一种组件间通信的方式,适用于:子组件==>父组件
    2.使用场景: A是父组件,B是子组件,B想传数据给A,那么就要在A中给B绑定自定义事件(事件的回调在A中)
    3.绑定自定义事件:
        1.第一种,在父组件中: <Demo @abc='test' /> 或者<Demo v-on:abc='test' />

        2.第二种,在父组件中:
            <Demo ref='demo' />
            ......
            methods:{
                test(){
                    ...
                }
            }
            mounted(){
                this.$refs.demo.$on('abc',this.test)
            }
        
        3.若想让自定义事件只触发一次,可以使用once修饰符,或者$once方法

    4.触发自定义事件: this.$emit('abc',数据)

    5.解绑自定义事件: this.$off('abc')

    6.组件上也可以绑定原生DOM事件,需要使用native修饰符.
    7.注意: 通过this.$refs.xxx.$on('abc',回调) 绑定自定义事件时,回调要么配置在methods中,要么用箭头函数,否则this的指向会出问题

## 全局事件总线(globalEventBus)

    1.一种组件间通信的方式,适用于任意组件间通信.
    2.安装全局事件总线:
        new Vue({
            ......
            beforeCreate(){
                Vue.prototype.$bus = this //安装全局事件总线,$bus就是当前应用的vm
            },
            ......
        })
    3.使用事件总线:
        1.接收数据:A组件想接收数据,则在A组件中给$bus绑定自定义事件,事件的回调留在A组件自身.
            methods(){
                demo(data){......}
            }
            ......
            mounted(){
                this.$bus.$on('xxx',this.demo)
            }
        2.提供数据:this.$bus.$emit('xxx',数据)

    4.最好在beforeDestroy钩子中,用$off去解绑当前组件所用到的事件

## 配置代理

    在vue.config.js配置具体代理规则:

        方法一: 
            module.exports={
                devServer:{
                    proxy:"http://localhost:9090"
                }
            }

            说明:
                1.优点:简单,请求是直接发给前端即可(8080)
                2.缺点:不能配置多个代理,不能灵活的控制请求是否走代理
                3.工作方式:若按照上述配置代理,当请求了前端不存在的资源时,那么该请求会转发给服务器(优先匹配前端资源)

        方法二:
            module.exports={
                    devServer:{
                        proxy:{
                            '/api':{
                                target:'http://localhost:9090',
                                changeOrigin:true,
                                pathRewrite:{'^/api':''}
                            },

                            '/api2':{
                                target:'http://localhost:5000',
                                pathRewrite:{'^/api2':''}
                            }
                        }
                    }
                }


            <!-- changeOrigin设置为true时 ,服务器的请求头中的host为: localhost:9090; 为false,host为:localhost:8080,就相当于没有开启伪装一样,默认true -->

## 路由

    1.理解:一个路由(route)就是一组映射关系,多个路由需要路由器(router)进行管理
    2.前端路由: key是路径,value是组件

### 1.基本使用

    1.安装vue-router,vue2应下载3版本以下的,vue3才能下4版本 npm i vue-router@3

    2.应用插件: Vue.use(Vuerouter)

    3.编写router配置项:
        //引入VueRouter
        import VueRouter from 'vue-router'
        //引入路由组件
        import About from '../components/About'
        import Home from '../components/Home'

        创建router实例对象,去管理一组一组的路由规则
        const router =new VueRouter({
            routes:[
                {
                    path:'/about',
                    component:About
                },
                {
                    path:'/home',
                    component:Home
                }
            ]
        })

        //暴露router
        export default router

    4.实现切换
        <router-link to='/about'></router-link>

    5.指定展示位置
        <router-view></router-view>

### 2.几个注意点

    1.路由组件通常存放在pages文件夹中,一般组件通常放在components中
    2.通过切换,"隐藏"了的路由组件,默认是被销毁掉的,需要的时候再去挂载.
    3.每个组件都有自己的$route属性,里面存储着自己的路由信息
    4.整个应用只有一个router,可以通过组件的$router属性获取到

### 3.路由的query参数

    1.传递参数
         <!-- 跳转路由并携带query参数,to字符串的写法 -->
        <!-- <router-link :to="`/about/message/detail?id=${m.id}&&title=${m.title}`">
          {{ m.title }} 
        </router-link>
       -->

         <!-- 对象写法,条理清晰 -->
         <router-link :to="{
             path:'/about/message/detail',
             query:{
                 id:m.id,
                 title:m.title
             }
         }">
          {{ m.title }} 
        </router-link>
    
    2.接收参数:
        $route.query.id
        $route.query.title

### 4.路由的params参数

    1.配置路由,并声明接收params参数
         {
            path: '/about',
            component: About,
            // 子路由
            children: [
                {
                    path: 'news',
                    component:News
                },
                {
                    path: 'message',
                    component: Message,
                    children: [
                        {
                            name:'xiaolin', //params传参必须使用
                            path: 'detail/:id/:title',  //使用占位符声明接收params参数
                            component:Detail
                        },
                    ]
                    
                }
            ]
        },
    
    2.传递参数
        to字符串写法:
    
             <router-link :to="/about/message/detail/666/你好">跳转</router-link>
        to对象写法:
                <router-link :to="{
                name:'xiaolin',
                params:{
                    id:m.id,
                    title:m.title
                }
            }">
            {{ m.title }} 
            </router-link>
            &nbsp;&nbsp;

    3.接收参数:
        $route.params.id
        $route.params.title

### 5.编程式路由导航

    1.作用:不借助<router-link>实现路由跳转,让除了转换成a标签外的其他便签也能实现跳转,让路由跳转更加灵活

    2.具体编码:
        //$router的两个API

        // 借助$router原型中的push实现导航,(本质压入栈中,指针指向栈顶)
        this.$router.push({
            name:'xiaolin',
            params"{
                id:xxx,
                title:xxx
            }
        })

        // 借助$router原型中的replace实现导航(本质将压入栈中的之前一个删除掉,再放入)
         this.$router.replace({
            name:'xiaolin',
            params"{
                id:xxx,
                title:xxx
            }
        })

### 6.缓存路由组件

    1.作用:让不展示的路由组件保持挂载,不被销毁
    2.具体编码:
         <!-- 这里的include是组件内name对应的名字 -->
        <keep-alive include="NewS">
            <router-view></router-view>
        </keep-alive>
