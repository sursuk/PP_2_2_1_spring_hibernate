package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface CarDao {

    public List<User> getUsersByCar(String model, int series);
}
