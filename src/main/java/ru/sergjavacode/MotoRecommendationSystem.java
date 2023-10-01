package ru.sergjavacode;

import java.util.List;
import java.util.Random;

public class MotoRecommendationSystem implements RecommendationSystemIntrface {
    @Override
    public void weRecommend(List<PriceAndAmountProduct> listPAAProduct) {
        int randomIndexProductForRecommendation;
        Random random = new Random();
        randomIndexProductForRecommendation = random.nextInt(listPAAProduct.size() + 1)-1;
        System.out.println("Попробуйте следующий товар отменного качества: " + listPAAProduct.get(randomIndexProductForRecommendation).getProduct().getBrand()+" "+listPAAProduct.get(randomIndexProductForRecommendation).getProduct().getNameProduct());
    }
}
