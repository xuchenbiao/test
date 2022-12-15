package com.itheima.controller;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Admini;
import com.itheima.domain.Car;
import com.itheima.domain.Rtotal;
import com.itheima.domain.Total;
import com.itheima.service.BookService;
import com.itheima.service.CarService;
import com.itheima.service.RtotalService;
import com.itheima.service.TotalService;
import com.itheima.util.R;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("counts")
public class TotalController {
@Autowired
    private CarService carService;
@Autowired
private TotalService totalService;
@Autowired
private BookService bookService;
@Autowired
private RtotalService rtotalService;
@GetMapping("{current}/{size}")
public R getAll(@PathVariable int current,@PathVariable int size){
    IPage<Total> page = totalService.getPage(current, size);
    if (current>page.getPages())
        page=totalService.getPage((int)page.getPages(),size);
    return new R(true,page);
}
@GetMapping("/rtotal/{current}/{size}")
public R getAllR(@PathVariable int current,@PathVariable int size){

    IPage<Rtotal> page = rtotalService.getPage(current, size);
    if (current>page.getPages())
        page=rtotalService.getPage((int)page.getPages(),size);
    return new R(true,page);
}
@GetMapping("/price")
public R getAllMoney(){
    List<Total> list =totalService.list();
    double k=0;
    for(int i=0;i<list.size();i++){
        k+=list.get(i).getTotalprice();
    }
    return new R(true,k,"操作成功");
}


  @PostMapping
    public R getTotal() {
      List<Car> list = carService.list();
   List<Total> list2=totalService.list();
  List<Rtotal> list3=rtotalService.list();
//   List<Book> list3=bookService.list();
      for (int i=0;i<list.size();i++){
          Rtotal rtotal=new Rtotal();
          rtotal.setName(list.get(i).getName());
          rtotal.setNumber(list.get(i).getNumber());
          rtotal.setPrice(list.get(i).getPrice());
          rtotal.setTotalprice(list.get(i).getTotalprice());
          Date date=new Date(System.currentTimeMillis());
          DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          String strDate = dateFormat.format(date);
          rtotal.setDate(strDate);
          rtotalService.save(rtotal);
      }
      for (int i = 0; i < list.size(); i++) {
        int k=0,o=0;
        for(int j=0;j<list2.size();j++){
            if(list2.get(j).getName().equals(list.get(i).getName())){
                k=1;
                o=j;
                break;
            }
        }
          if (k == 1) {
              double d = list2.get(o).getNumber() + list.get(i).getNumber();
              Integer ii = (int) Math.round(d);
              totalService.update(
                      ii,
                      list2.get(o).getPrice(),
                      list2.get(o).getPrice() * (list2.get(o).getNumber() + list.get(i).getNumber()),
                      list2.get(o).getName()
              );
              bookService.update(bookService.getNumberByName(list.get(i).getName()) - list.get(i).getNumber(), list.get(i).getName());
          } else {
              Total total = new Total();
              total.setName(list.get(i).getName());
              total.setPrice(list.get(i).getPrice());
              total.setNumber(list.get(i).getNumber());
              total.setTotalprice(list.get(i).getTotalprice());
              totalService.save(total);
              bookService.update(bookService.getNumberByName(list.get(i).getName()) - list.get(i).getNumber(), list.get(i).getName());
          }
      }
      totalService.deleteAll();
      return new R(true);
      }

      @DeleteMapping("/admins/{id}/{ee}")
    public R deleteById(@PathVariable Integer id,@PathVariable int ee){
          String name = totalService.getById(id).getName();
          if (ee==0){//如果传0，就是一起删除，如果传其他，就只删除学生
          totalService.removeById(id);}
          List<Rtotal> list=rtotalService.selectByName(name);
          for (int i=0;i<list.size();i++){
              rtotalService.removeById(list.get(i).getId());
          }
    return new R(true);
      }

      @DeleteMapping
    public R deleteAll(){
    rtotalService.deleteAll();
    totalService.deleteAllTotal();
    return new R(true);
      }




}

