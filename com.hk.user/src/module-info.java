/**
 * @author : kally
 * @date : 2018/5/27 20 53
 */module com.hk.user {

      /*
      需要依赖 com.hk.address模块才能使用
       */
//     requires  com.hk.address;

     /*
      使用 transitive 关键字，可以传递 依赖。
          也就是说，别的模块如果也需要使用 com.hk.address模块中的包，可以只需要 requires com.hk.user即可
          因为 com.hk.user 也依赖了 com.hk.address，并使用了传递(transitive)依赖。
      */
     requires transitive com.hk.address;

     /*
     必须导出才能给其它模块使用相应的类
      */
     exports com.hk.user;
}