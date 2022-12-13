package com.itheima.controller;
import com.itheima.domain.Book;
import com.itheima.domain.Car;
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

       if(bookService.getNumberByName(book.getName())-book.getNumber()>=0) {

           if (k == 1) {

               return new R(carService.update(
                       book.getNumber() + carService.getNumber(book.getName()),
                       book.getPrice(),
                       (book.getNumber() + carService.getNumber(book.getName())) * book.getPrice(),
                       book.getName()));
           } else {
               Car car = new Car();
               car.setPrice(book.getPrice());
               car.setName(book.getName());
               car.setNumber(book.getNumber());
               car.setTotalprice(book.getPrice() * book.getNumber());
               return new R(carService.save(car));
           }
       }
       else return new R(false,"超出范围!");
    }
    @DeleteMapping("/{id}")
    public R deleteCar(@PathVariable Integer id){
        return new R(carService.removeById(id));
    }
    @GetMapping
    public R getAll(){
        return new R(true,carService.list(),"已获取购物车全部信息");
    }

    @GetMapping("/price")
    public R getAllMoney(){
        List<Car> list =carService.list();
        double all=0;
        for (int i=0;i<list.size();i++){
            all+=list.get(i).getTotalprice();
        }
        return new R(true,all,"已获取购物车总价");
    }

}
