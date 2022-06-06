package hiber.service;

import hiber.dao.CarDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    CarDao carDao;
    @Transactional
    public List<User> getUserByCar(String model, int series) {
        return carDao.getUsersByCar(model, series);
    }
}
