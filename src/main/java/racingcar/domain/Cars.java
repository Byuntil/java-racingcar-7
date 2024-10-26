package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car : carList) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Integer> getPositions() {
        return carList.stream()
                .map(Car::getPosition)
                .toList();
    }
}