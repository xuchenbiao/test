package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.domain.Car;
import com.itheima.domain.Total;
import com.itheima.service.BookService;
import com.itheima.service.CarService;
import com.itheima.service.TotalService;
import com.itheima.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CarService carService;
    @Autowired
    private TotalService totalService;
    @PostMapping
    public R saveCar(@RequestBody Book book) {
        List<String> list =carService.getAllName();
        int k=0;
        for(int i=0;i<list.size();i++){
            if (book.getName().equals(list.get(i))){
                k=1;
               break;
            }
        }
        System.out.println(k);

      if(k==1){

         return new R (carService.update(
                 book.getNumber()+ carService.getNumber(book.getName()),
                         book.getPrice(),
                 (book.getNumber()+ carService.getNumber(book.getName()))*book.getPrice(),
                            book.getName()));//写这个头痛
      }
     else{
        Car car=new Car();
         // Total total=new Total();
        car.setPrice( book.getPrice());
        car.setName( book.getName());
       car.setNumber(book.getNumber());
       car.setTotalprice(book.getPrice()*book.getNumber());
//       total.setNumber(car.getNumber());
//       total.setPrice(car.getPrice());
//       total.setName(car.getName());
//       total.setTotalprice(car.getTotalprice());
//       totalService.save(total);
       return  new R(carService.save(car));}
    }
    @DeleteMapping("/{id}")
    public R deleteCar(@PathVariable Integer id){
        return new R(carService.removeById(id));
    }
    @GetMapping
    public R getAll(){
        return new R(true,carService.list(),"已获取购物车全部信息");
    }

}
