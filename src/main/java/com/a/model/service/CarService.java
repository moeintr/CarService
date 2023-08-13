package com.a.model.service;

import com.a.common.exception.RollbackException;
import com.a.model.domain.Car;
import com.a.model.repository.CarRepository;
import com.a.model.repository.Crud;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class CarService {
    private final Crud<Car, Long> carCrud;
    private final CarRepository carRepository;

    public CarService(Crud<Car, Long> carCrud, CarRepository carRepository) {
        this.carCrud = carCrud;
        this.carRepository = carRepository;
    }
    @Transactional(rollbackFor = RollbackException.class)
    public Optional<Car> saveCar(Car car) {
        carCrud.insert(car);
        return Optional.ofNullable(carCrud.selectOne(Car.class, car.getCarId()));
    }
    public Optional<List<Car>> findCarsByPersonId(Long personId) {
        return Optional.ofNullable(carRepository.selectCarsByPersonId(personId));
    }
}
