package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(MEAL_ID,USER_ID);
        assertMatch(meal,MEAL);
    }

    @Test
    public void delete() {
        service.delete(MEAL_ID,USER_ID);
        assertMatch(service.getAll(USER_ID),MEAL2);
    }

    @Test(expected = NotFoundException.class)
    public void deletedNotFound() throws Exception {
        service.delete(1,USER_ID);
    }

    @Test
    public void getBetweenDateTimes() {
        List<Meal> meals = service.getBetweenDateTimes(LocalDateTime.of(2019, Month.JANUARY, 1, 6, 0),LocalDateTime.of(2019, Month.JANUARY, 1, 9, 0),USER_ID);
        assertMatch(meals,MEAL);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(USER_ID),MEAL,MEAL2);
    }

    @Test
    public void update() {
        Meal meal = service.get(MEAL_ID,USER_ID);
        Meal tempMeal = new Meal(LocalDateTime.of(2019, Month.JANUARY, 1, 7, 0), "Diner", 850);
        meal.setCalories(850);
        service.update(meal,USER_ID);
        assertMatch(service.get(MEAL_ID,USER_ID),tempMeal);
    }

    @Test
    public void create() {
        Meal meal = service.create(new Meal(LocalDateTime.of(2019, Month.JANUARY, 1, 10, 0), "Lunch", 1000),USER_ID);
        assertMatch(service.getAll(USER_ID),MEAL,MEAL2,meal);
    }
}
