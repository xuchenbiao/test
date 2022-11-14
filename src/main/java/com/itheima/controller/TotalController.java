package com.itheima.controller;

import com.itheima.domain.Car;
import com.itheima.domain.Total;
import com.itheima.service.CarService;
import com.itheima.service.TotalService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("counts")
public class TotalController {
@Autowired
    private CarService carService;
@Autowired
private TotalService totalService;
@GetMapping
public R getAll(){
    return new R(true,totalService.list());
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
      for (int i = 0; i < list.size(); i++) {
        int k=0,o=0;
        for(int j=0;j<list2.size();j++){
            if(list2.get(j).getName().equals(list.get(i).getName())){
                k=1;
                o=j;
                break;
            }
        }

        if(k==1){
            double d=list2.get(o).getNumber()+list.get(i).getNumber();
            Integer ii=(int)Math.round(d);
            totalService.update(
                    ii,
                list2.get(o).getPrice(),
                list2.get(o).getPrice()*(list2.get(o).getNumber()+list.get(i).getNumber()) ,
                list2.get(o).getName()
            );
        }
        else{
        Total total=new Total();
        total.setName(list.get(i).getName());
        total.setPrice(list.get(i).getPrice());
        total.setNumber(list.get(i).getNumber());
        total.setTotalprice(list.get(i).getTotalprice());
        totalService.save(total);
  }
           }
      totalService.deleteAll();
      return new R(true);
      }

  }

