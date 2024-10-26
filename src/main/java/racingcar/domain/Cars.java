package racingcar.domain;

import java.util.ArrayList;
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

    public List<Car> getCarList() {
        return new ArrayList<>(carList);
    }

    public List<String> getWinners() {
        Car winner = getWinner();
        return getWinners(winner);
    }

    private Car getWinner() {
        return carList.stream().max(Car::compareTo).get();
    }

    private List<String> getWinners(Car winner) {
        return carList.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName).toList();
    }

    public boolean isEmpty() {
        return carList.isEmpty();
    }
}
