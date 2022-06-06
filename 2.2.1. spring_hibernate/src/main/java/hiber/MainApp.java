package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("1",1)));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", new Car("2",2)));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("1",1)));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("4",4)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      CarService carService = context.getBean(CarService.class);

      List<User> usersWithTheCar = carService.getUserByCar("1",1);

      for(User user : usersWithTheCar) {
         System.out.println(user);
      }

      context.close();
   }
}
