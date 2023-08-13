package com.a.api;

import com.a.common.wrapper.ErrorHandler;
import com.a.model.domain.Car;
import com.a.model.service.CarService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/car")
@Scope("singleton")
public class CarAPI {
    private final CarService carService;

    public CarAPI(CarService carService) {
        this.carService = carService;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> onException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorHandler.getError(e));
    }
    @GetMapping("/saveCar.do")
    public ResponseEntity<Object> saveCar(@ModelAttribute Car car) {
        if (car.getPersonId() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(carService.saveCar(car), HttpStatus.OK);
        }
    }
    @GetMapping("/findCarsByPersonId")
    public ResponseEntity<Object> findCarsByPersonId(String personId) {
        return new ResponseEntity<>(carService.findCarsByPersonId(Long.parseLong(personId)), HttpStatus.OK);
    }
}
