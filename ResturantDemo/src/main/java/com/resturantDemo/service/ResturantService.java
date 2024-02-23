package com.resturantDemo.service;

import com.resturantDemo.dto.ResturantDto;
import com.resturantDemo.entity.Resturant;
import com.resturantDemo.repository.ResturantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResturantService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResturantService.class);
    @Autowired
    private ResturantRepository resturantRepository;

    public void saveResturantDetails(Resturant resturant) {
        LOGGER.info("inside saveResturantDetails " +resturant);
        try {
            resturantRepository.save(resturant);
            LOGGER.info("resturant details saved");

        } catch (Exception e) {
            LOGGER.error("exception accured " + e.getStackTrace());
        }
    }
    public List<Resturant> findResturant() {
        return resturantRepository.findAll();
    }


    /**
     * @param id
     * @return
     */
    public Resturant findResturantById(Long id) {
        Optional<Resturant> optionalResturant = resturantRepository.findById(id);
        return optionalResturant.get();

    }
    public void deleteResturantById(Long id) {
        resturantRepository.deleteById(id);
    }

    public void updateResturantDetails(ResturantDto resturantDto) {
        Resturant resturant=findResturantById(resturantDto.getId());
        resturant.setRating(resturantDto.getRating());
        resturant.setAvgPrice(resturantDto.getAvgPrice());
        resturant.setMenu(resturantDto.getMenu());
        resturantRepository.save(resturant);
    }
    public List<Resturant> findResturantByName(String resName) {
        return resturantRepository.findName(resName);

    }

}
